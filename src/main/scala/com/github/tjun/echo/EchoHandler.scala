package com.github.tjun.echo

import akka.actor.Actor
import akka.io.Tcp


/**
 * Created by tjun on 4/15/15.
 */
class EchoHandler extends Actor {
  import Tcp._
  def receive = {
    case Received(data) =>
      println(s"received: $data")
      sender() ! Write(data)

    case PeerClosed =>
      println("closed")
      context stop self
  }
}
