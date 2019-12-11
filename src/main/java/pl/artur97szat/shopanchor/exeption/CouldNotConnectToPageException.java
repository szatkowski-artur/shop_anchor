package pl.artur97szat.shopanchor.exeption;

import lombok.NoArgsConstructor;

import java.io.IOException;

public class CouldNotConnectToPageException extends IOException {

    public CouldNotConnectToPageException(String message, Throwable cause) {
        super(message, cause);
    }

    public CouldNotConnectToPageException(String message) {
        super(message);
    }
}
