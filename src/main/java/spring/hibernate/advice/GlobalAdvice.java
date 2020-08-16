package spring.hibernate.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import spring.hibernate.entity.ErrorMessage;

@ControllerAdvice
public class GlobalAdvice 
{
	
	@ExceptionHandler
	public ResponseEntity<ErrorMessage> handleException(Exception exec)
	{
		ErrorMessage error = new ErrorMessage(HttpStatus.NOT_FOUND.value(),
				exec.getMessage(),
				System.currentTimeMillis());

		return new ResponseEntity<>(error , HttpStatus.NOT_FOUND);
	}
}
