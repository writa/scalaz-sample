import repository._
import scalaz._
import Scalaz._

/**
 * @author Kazunobu Raita
 */
object Boot {

  def main(args: Array[String]) {
    val f = Kleisli[({type F[+a] = String \/ a})#F, String, String] {
      x => (x + "1").right
    }

    val g = Kleisli[({type F[+a] = String \/ a})#F, String, String] {
      x => (x + "2").left
    }

    val z = Kleisli[({type F[+a] = String \/ a})#F, String, String] {
      x => (x + "3").right
    }

    val result = (f >=> g >=> z) run "hello"
    println(result)
  }

}

class Boot extends Users with RepositoryComponent {

  val user = get(10)(userRepository) | "empty"

  println(user)
}
