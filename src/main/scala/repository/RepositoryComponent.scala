package repository

/**
 * @author Kazunobu Raita
 */
trait RepositoryComponent {

  val userRepository: UserRepository = new UserRepositoryImpl

}

