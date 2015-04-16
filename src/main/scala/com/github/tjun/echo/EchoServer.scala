package com.github.tjun.echo

import java.net.InetSocketAddress

import akka.actor.{Props, Actor}
import akka.io.{IO, Tcp}

/**
 * Created by tjun on 4/15/15.
 */
class EchoServer(port: Int) extends Actor {
  import Tcp._
  import context.system

  IO(Tcp) ! Bind(self, new InetSocketAddress("0.0.0.0", port))

  def receive = {
    case b @ Bound(localAddress) =>
      println(localAddress)

    case CommandFailed(_: Bind) => context stop self

    case c @ Connected(remote, local) =>
      println(s"connected from ($remote) to ($local)")
      val handler = context.actorOf(Props[EchoHandler])
      val connection = sender()
      connection ! Register(handler)
  }
}
