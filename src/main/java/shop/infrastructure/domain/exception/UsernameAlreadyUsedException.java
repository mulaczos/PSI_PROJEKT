package shop.infrastructure.domain.exception;

public class UsernameAlreadyUsedException extends RuntimeException {
    public UsernameAlreadyUsedException(String username) {
        super("Username " + username + " already in use.");
    }
}
