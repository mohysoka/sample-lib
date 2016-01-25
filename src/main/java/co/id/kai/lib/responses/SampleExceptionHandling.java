package co.id.kai.lib.responses;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.expression.ParseException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpMediaTypeException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.HttpClientErrorException;

@ControllerAdvice
public class SampleExceptionHandling {

 protected Logger logger;

 public SampleExceptionHandling() {
  logger = LoggerFactory.getLogger(getClass());
 }
 
 @ResponseBody
    public ResponseEntity<?> handleUnauthenticationException(Exception e) {
        return errorResponse("9", HttpStatus.BAD_REQUEST,"Unauthenticated");
    }
 
 @ExceptionHandler({DataIntegrityViolationException.class, SQLIntegrityConstraintViolationException.class})
 @ResponseBody
    public ResponseEntity<?> handleConflictException(Exception e) {
        return errorResponse("3", HttpStatus.CONFLICT,"Integrity Conflict");
    }

 @ExceptionHandler({ SQLException.class, DataAccessException.class, RuntimeException.class })
 @ResponseBody
    public ResponseEntity<?> handleSQLException(Exception e) {
        return errorResponse("4", HttpStatus.INTERNAL_SERVER_ERROR,"Data Error");
    }
 
 @ExceptionHandler({ IOException.class, ParseException.class,MethodArgumentNotValidException.class,HttpMediaTypeException.class,HttpMediaTypeNotSupportedException.class, JsonParseException.class, JsonMappingException.class,HttpClientErrorException.class })
 @ResponseBody
    public ResponseEntity<?> handleParseException(Exception e) {
        return errorResponse("5", HttpStatus.BAD_REQUEST,"IO /  Parse Error");
    }
 
 @ExceptionHandler({ InvalidKeyException.class, NoSuchAlgorithmException.class })
 @ResponseBody
    public ResponseEntity<?> handleHashException(Exception e) {
        return errorResponse("6", HttpStatus.LOCKED,"Hash Error");
    }
 
    @ExceptionHandler({ Exception.class })
    @ResponseBody
    public ResponseEntity<?> handleAnyException(Exception e) {
        return errorResponse("99", HttpStatus.INTERNAL_SERVER_ERROR,"internal server error");
    }
   
    protected ResponseEntity<ResponseResource> errorResponse(String err_code,
            HttpStatus status,String msg) {
            return response(new ResponseResource(err_code, msg), status);
        
    }

    protected <T> ResponseEntity<T> response(T body, HttpStatus status) {
        return new ResponseEntity<T>(body, new HttpHeaders(), status);
    }
}
	
