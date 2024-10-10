package exceptions;

public class ModeNotConfiguredException extends RuntimeException {

    public ModeNotConfiguredException() {
        super("Mode cannot be configured.");
    }
}
