package shop.infrastructure.domain.exception;

/**
 * Created by Witu on 24.04.2017.
 */
public class WrongConfirmPasswordException extends RuntimeException {
    public WrongConfirmPasswordException() {
        super("Confirmation password do not match actual password");
    }
}
