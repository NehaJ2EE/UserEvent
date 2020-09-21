/****************************************************************************************************************************
- File Name        : BookingService Interface
- Author           : Neha Kumari
- Creation Date    : 13-08-2020
- Description      : This is an interface where all the controller class methods define.
****************************************************************************************************************************/

package com.cg.bookingmanagement.service;

import java.util.List;

import com.cg.bookingmanagement.exceptions.BookingIdNotFound;
import com.cg.bookingmanagement.exceptions.BookingNameNotFound;
import com.cg.bookingmanagement.exceptions.BookingStatusNotFound;
import com.cg.bookingmanagement.model.BookingEntity;

public interface BookingService 
{

	public String addBooking(BookingEntity booking);
	
	public List<BookingEntity> getAllBookings();
	
	public BookingEntity getBookingById(long bookingId) throws BookingIdNotFound;
	
	public BookingEntity getBookingByName(String name) throws BookingNameNotFound;
	
	public List<BookingEntity> getBookingByBookingStatus(String bookingStatus) throws BookingStatusNotFound;
	
	public String deleteBookingById(long bookingID) throws BookingIdNotFound;
	
	public void updateBookingByStatus()throws BookingStatusNotFound;
	
	
}
