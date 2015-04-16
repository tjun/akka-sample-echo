import akka.actor.{Props, ActorSystem}
import com.github.tjun.echo.EchoServer

object Main {
  def main(args: Array[String]): Unit = {
    val actorSystem = ActorSystem.create
    actorSystem.actorOf(Props(new EchoServer(9876)))
  }
}