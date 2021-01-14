package br.com.itauchallenge.itauchallengeapi.shared;
import lombok.AllArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import java.util.List;

@AllArgsConstructor
@RestControllerAdvice
public class ValidationErrorsHandler {
    private final MessageSource messageSource;
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ValidationErrorsOutputDto handleValidationError(MethodArgumentNotValidException exception) {
        List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();
        ValidationErrorsOutputDto validationErrors = new ValidationErrorsOutputDto();
        fieldErrors.forEach(error -> {
            String errorMessage = this.getErrorMessage(error);
            validationErrors.addFieldError(error.getField(), errorMessage);
        });
        return validationErrors;
    }
    private String getErrorMessage(ObjectError error) {
        return this.messageSource.getMessage(error, LocaleContextHolder.getLocale());
    }
}