package shop.infrastructure.domain.exception;

/**
 * Created by Witu on 20.04.2017.
 */
public class UsernameAlreadyUsedException extends RuntimeException {
    public UsernameAlreadyUsedException(String username) {
        super("Username " + username + " already in use.");
    }
}
