package com.cg.bookingmanagement.exceptions;

public class BookingStatusNotFound extends Exception {

	private static final long serialVersionUID = 1L;
	final String msg;

	public BookingStatusNotFound(String msg) {
		super();
		this.msg = msg;
	}

	@Override
	public String getMessage() {
		return msg;
	}

}
