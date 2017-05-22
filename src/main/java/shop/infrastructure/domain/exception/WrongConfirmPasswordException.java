package shop.infrastructure.domain.exception;

public class WrongConfirmPasswordException extends RuntimeException {
    public WrongConfirmPasswordException() {
        super("Confirmation password do not match actual password");
    }
}
