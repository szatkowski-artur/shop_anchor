package pl.artur97szat.shopanchor.exeption;

public class ShopNotSupportedException extends Exception {

    public ShopNotSupportedException(String message, Throwable cause) {
        super(message, cause);
    }

    public ShopNotSupportedException(String message) {
        super(message);
    }
}
