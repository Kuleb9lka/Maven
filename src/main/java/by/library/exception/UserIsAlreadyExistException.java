package by.library.exception;

public class UserIsAlreadyExistException extends RuntimeException{
    public UserIsAlreadyExistException() {
    }

    public UserIsAlreadyExistException(String message) {
        super(message);
    }
}
