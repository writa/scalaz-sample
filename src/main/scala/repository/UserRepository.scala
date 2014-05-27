package repository

import scala.collection.immutable.HashMap
import scalaz._
import Scalaz._

/**
 * @author Kazunobu Raita
 */
trait UserRepository {
  def get(id: Int): Option[String]
}

class UserRepositoryImpl extends UserRepository {
  lazy val userMap = HashMap(1 -> "ui", 2 -> "ino", 3 -> "ota")

  def get(id: Int) = userMap.get(id)
}

class UserRepositoryMock extends UserRepository {
  def get(id: Int) = "mock".some
}
