package by.library.ehandler;

import by.library.exception.MovieNotFoundException;
import by.library.exception.TicketNotFoundException;
import by.library.exception.UserNotFoundException;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        String error = "Malformed JSON request";
        return buildResponseEntity(new ApiError(HttpStatus.BAD_REQUEST, error, ex));
    }

    private ResponseEntity<Object> buildResponseEntity(ApiError apiError) {
        return new ResponseEntity<>(apiError, apiError.getStatus());
    }

    @ExceptionHandler(MovieNotFoundException.class)
    public final ResponseEntity<Object> handleMovieNotFound(MovieNotFoundException e){

        ApiError apiError = new ApiError(NOT_FOUND);

        apiError.setMessage(e.getMessage());

        return buildResponseEntity(apiError);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public final ResponseEntity<Object> handleUserNotFound(UserNotFoundException e){

        ApiError apiError = new ApiError(NOT_FOUND);

        apiError.setMessage(e.getMessage());

        return buildResponseEntity(apiError);
    }

    @ExceptionHandler(TicketNotFoundException.class)
    public final ResponseEntity<Object> handleTicketNotFound(TicketNotFoundException e){

        ApiError apiError = new ApiError(NOT_FOUND);

        apiError.setMessage(e.getMessage());

        return buildResponseEntity(apiError);
    }
}
