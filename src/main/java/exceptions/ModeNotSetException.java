package exceptions;

import enums.Mode;

public class ModeNotSetException extends RuntimeException {

    public ModeNotSetException(Mode mode) {
        super(String.format("%s cannot be set for the browser!", mode));
    }
}
