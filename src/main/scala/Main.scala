import cats.effect.IOApp
import cats.effect.ExitCode
import cats.effect.IO
import tofu.Delay
import tofu.logging.Logging

object Main extends IOApp:

  given Delay[IO] with
    def delay[A](a: => A): IO[A] = IO.delay(a)

  val logging = Logging.Make.plain[IO].byName("App")

  override def run(args: List[String]): IO[ExitCode] =
    for _ <- logging.info("Starting app")
    yield ExitCode.Success
