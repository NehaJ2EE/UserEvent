/**************************************************************************************************************************
- File Name        : BookingExceptionController Class
- Author           : Neha Kumari
- Creation Date    : 13-08-2020
- Description      : This is an exception controller which handles the exception for bookings.
****************************************************************************************************************************/
package com.cg.bookingmanagement.exceptions;

import java.util.HashMap;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class BookingExceptionController {

	/****************************************************************************************************************************
	 - Method Name : handleException 
	 - Input Parameters : BookingIdNotFound
	 - Return type : String 
	 - Author : Neha Kumari 
	 - Creation Date : 13-08-2020 -
	 - Description : This method will return message when loan status will not found during fetching /updating by bookingStatus.
	 ****************************************************************************************************************************/
	@ExceptionHandler(BookingIdNotFound.class)
	public String handleException(BookingIdNotFound e) {
		return e.getMessage();
	}
	/****************************************************************************************************************************
	 - Method Name : handleException 
	 - Input Parameters : BookingNameNotFound
	 - Return type : String 
	 - Author : Neha Kumari 
	 - Creation Date : 13-08-2020 -
	 - Description : This method will return message when loan status will not found during fetching /updating by bookingStatus.
	 ****************************************************************************************************************************/
	@ExceptionHandler(BookingNameNotFound.class)
	public String handleException(BookingNameNotFound e) {
		return e.getMessage();
	}
	/****************************************************************************************************************************
	 - Method Name : handleException 
	 - Input Parameters : BookingStatusNotFound
	 - Return type : String 
	 - Author : Neha Kumari 
	 - Creation Date : 13-08-2020 -
	 - Description : This method will return message when loan status will not found during fetching /updating by bookingStatus.
	 ****************************************************************************************************************************/
	@ExceptionHandler(BookingStatusNotFound.class)
	public String handleException(BookingStatusNotFound e) {
		return e.getMessage();
	}
	
	/****************************************************************************************************************************
	 * - Method Name : handleMethodArgumentNotValid - Input Parameters :
	 * MethodArgumentNotValidException - Return type : String - Author : Neha Kumari
	 * - Creation Date : 13-08-2020 - Description : This predefined method will
	 * return message for all the non-functional validation for booking class
	 * fields.
	 ****************************************************************************************************************************/

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
		Map<String, String> errors = new HashMap<>();
		ex.getBindingResult().getFieldErrors()
				.forEach(error -> errors.put(error.getField(), error.getDefaultMessage()));
		return errors;
	}
}