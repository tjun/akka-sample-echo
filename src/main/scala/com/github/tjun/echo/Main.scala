import akka.actor.{Props, ActorSystem}
import com.github.tjun.echo.Server

object Main {
  def main(args: Array[String]): Unit = {
    val actorSystem = ActorSystem.create
    actorSystem.actorOf(Props(new Server(9876)))
  }
}