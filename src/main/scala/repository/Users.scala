package repository

import scalaz.Reader

/**
 *
 * @author Kazunobu Raita
 */
trait Users {

  def get(id: Int) = Reader {
    (userRepository: UserRepository) =>  userRepository.get(id)
  }

}
