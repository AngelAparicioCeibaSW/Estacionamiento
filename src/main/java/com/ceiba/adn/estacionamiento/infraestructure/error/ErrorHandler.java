package com.ceiba.adn.estacionamiento.infraestructure.error;

import java.util.concurrent.ConcurrentHashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.ceiba.adn.estacionamiento.domain.exception.ArgumentException;
import com.ceiba.adn.estacionamiento.domain.exception.FullParkingException;
import com.ceiba.adn.estacionamiento.domain.exception.IncomeNotAllowedException;
import com.ceiba.adn.estacionamiento.domain.exception.InvalidVehicleTypeException;
import com.ceiba.adn.estacionamiento.domain.exception.VehicleInParkingException;
import com.ceiba.adn.estacionamiento.domain.exception.VehicleNotInParkingException;

@ControllerAdvice
public class ErrorHandler extends ResponseEntityExceptionHandler {

	private static final Logger LOGGER = LoggerFactory.getLogger(ErrorHandler.class);

	private static final String MESSAGE_ALL_ERROR = "Ocurrió un error favor contactar al administrador.";

	private static final ConcurrentHashMap<String, Integer> ERRORS = new ConcurrentHashMap<>();

	public ErrorHandler() {
		ERRORS.put(ArgumentException.class.getSimpleName(), HttpStatus.BAD_REQUEST.value());
		ERRORS.put(FullParkingException.class.getSimpleName(), HttpStatus.FORBIDDEN.value());
		ERRORS.put(IncomeNotAllowedException.class.getSimpleName(), HttpStatus.NOT_ACCEPTABLE.value());
		ERRORS.put(VehicleInParkingException.class.getSimpleName(), HttpStatus.NOT_ACCEPTABLE.value());
		ERRORS.put(InvalidVehicleTypeException.class.getSimpleName(), HttpStatus.BAD_REQUEST.value());
		ERRORS.put(VehicleNotInParkingException.class.getSimpleName(), HttpStatus.NOT_FOUND.value());
	}

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Error> handleAllExceptions(Exception exception) {
		ResponseEntity<Error> response;

		String exceptionName = exception.getClass().getSimpleName();
		String message = exception.getMessage();

		Integer code = ERRORS.get(exceptionName);

		if (code == null) {
			LOGGER.error(exceptionName, message);
			Error error = new Error(exceptionName, MESSAGE_ALL_ERROR);
			response = new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
		} else {
			Error error = new Error(exceptionName, message);
			response = new ResponseEntity<>(error, HttpStatus.valueOf(code));
		}

		return response;
	}
}