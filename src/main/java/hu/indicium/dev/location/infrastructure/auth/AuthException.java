package hu.indicium.dev.location.infrastructure.auth;

public class AuthException extends RuntimeException {
    public AuthException(String name, Exception e) {
        super("Could not create user for " + name + ". Reason: " + e.getMessage());
    }
}
