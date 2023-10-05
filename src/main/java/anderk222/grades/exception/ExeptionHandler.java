package anderk222.grades.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import anderk222.grades.dto.Response;
import anderk222.grades.dto.ResponseEnum;

@ControllerAdvice
public class ExeptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Response> handleResourceNotFound(ResourceNotFoundException ex) {

        ex.printStackTrace();

        return ResponseEntity.ok(Response.resEnum(ResponseEnum.NOT_FOUND));

    }

    @ExceptionHandler(JsonSchemaValidationException.class)
    @ResponseStatus(code = HttpStatus.OK)
    public ResponseEntity<Response> handleJsonSchemaValidationException(JsonSchemaValidationException ex) {


        Response response = Response.resEnum(ResponseEnum.BAD_REQUEST).msgUsuario(ex.getReason());

        return ResponseEntity.ok(response);

    } 

    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(code = HttpStatus.OK)
    public ResponseEntity<Response> handleRuntimeException(RuntimeException ex) {

        ex.printStackTrace();

        return ResponseEntity.ok(Response.resEnum(ResponseEnum.INTERNAL_ERROR));

    }

}