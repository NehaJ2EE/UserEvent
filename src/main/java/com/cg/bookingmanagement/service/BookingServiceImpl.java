package com.cg.bookingmanagement.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.bookingmanagement.dao.BookingRepository;
import com.cg.bookingmanagement.exceptions.BookingIdNotFound;
import com.cg.bookingmanagement.exceptions.BookingNameNotFound;
import com.cg.bookingmanagement.exceptions.BookingStatusNotFound;
import com.cg.bookingmanagement.model.BookingEntity;

@Service
public class BookingServiceImpl implements BookingService
{
	
	@Autowired 
	private BookingRepository repo;
	
	
/*********************************************************************************************************************
	  -Method Name      : addBooking 
	  -Input Parameters : Booking
	  -Return Type      : String
	  -Creation Date    : 12-08-2020 
	  -Description      : Inserting the event information into booking database.
********************************************************************************************************************/

	@Override
	public String addBooking(BookingEntity booking) {

		BookingEntity entity = new BookingEntity();
		entity.setBookingId(booking.getBookingId());
		entity.setBookingName(booking.getBookingName());
		entity.setBookingPlace(booking.getBookingPlace());
		entity.setSpeakerId(booking.getSpeakerId());
		entity.setSpeakerName(booking.getSpeakerName());
		entity.setSpeakerContactNumber(booking.getSpeakerContactNumber());
		entity.setBookingDate(booking.getBookingDate());
		entity.setBookingStatus(booking.getBookingStatus());
		repo.saveAndFlush(entity);
		return "New booking added successfully!";
	}

/*********************************************************************************************************************
	 -Method Name      : getAllBookings 
	 -Return Type      : List
	 -Creation Date    : 12-08-2020
	 -Description      : Fetching all booking information from booking database.
********************************************************************************************************************/

	@Override
	public List<BookingEntity> getAllBookings() 
	{
		List<BookingEntity> entityList = repo.findAll();
		List<BookingEntity> bookingList = new ArrayList<>();
		for(BookingEntity entity : entityList) {
			BookingEntity booking = new BookingEntity();
			booking.setBookingId(entity.getBookingId());
			booking.setBookingName(entity.getBookingName());
			booking.setBookingPlace(entity.getBookingPlace());
			booking.setSpeakerId(entity.getSpeakerId());
			booking.setSpeakerName(entity.getSpeakerName());
			booking.setSpeakerContactNumber(entity.getSpeakerContactNumber());
			booking.setBookingDate(entity.getBookingDate());
			booking.setNoOfSeats(entity.getNoOfSeats());
			booking.setBookingStatus(entity.getBookingStatus());
			
			bookingList.add(booking);
		}
		return bookingList;
	}

/*********************************************************************************************************************
	 -Method Name      : getBookingById 
	 -Return Type      : List
	 -Creation Date    : 12-08-2020
	 -Description      : Fetching all booking information from booking database.
********************************************************************************************************************/

	
	@Override
	public BookingEntity getBookingById(long bookingId) throws BookingIdNotFound 
	{
		if(repo.existsById(bookingId)) 
		{
			return repo.findById(bookingId).get();
		}
		else 
		{
			throw new BookingIdNotFound("Booking ID not found");
		}
	}

/*********************************************************************************************************************
	 -Method Name      : getBookingBybookingStatus	 
	 -Input Parameters : bookingStatus
	 -Return Type      : List
	 -Creation Date    : 12-08-2020
	 -Description      : Fetching the event information from booking database by bookingStatus(Pending/Accepted/Rejected).
********************************************************************************************************************/
	
	@Override
	public List<BookingEntity> getBookingByBookingStatus(String bookingStatus) throws BookingStatusNotFound {
		
		List<BookingEntity> list = repo.findByBookingStatus(bookingStatus);
		if(list.isEmpty()) {
			throw new BookingStatusNotFound("No Booking found for booking status "+ bookingStatus);
		}else {
			List<BookingEntity> bookinglist = new ArrayList<>();
			for(BookingEntity entity: list) {
				BookingEntity booking = new BookingEntity();
				
				booking.setBookingId(entity.getBookingId());
				booking.setBookingName(entity.getBookingName());
				booking.setBookingPlace(entity.getBookingPlace());
				booking.setSpeakerId(entity.getSpeakerId());
				booking.setSpeakerName(entity.getSpeakerName());
				booking.setSpeakerContactNumber(entity.getSpeakerContactNumber());
				booking.setBookingDate(entity.getBookingDate());
				booking.setNoOfSeats(entity.getNoOfSeats());
				booking.setBookingStatus(entity.getBookingStatus());
				bookinglist.add(booking);
			}

			return bookinglist;
		}
	}
	
	

/*********************************************************************************************************************
	 -Method Name      : deleteBookingById	 
	 -Input Parameters : bookingId
	 -Return Type      : String
	 -Creation Date    : 12-08-2020
	 -Description      : This method is for deleting data from booking database.
********************************************************************************************************************/
	
	@Override
	public String deleteBookingById(long bookingId)throws BookingIdNotFound  {

		if(repo.existsById(bookingId)) 
		{
			repo.deleteById(bookingId);
		} 
		else
		{
			throw new BookingIdNotFound("Booking is not found given Id");
		}
		return "Deleted Sucessfully ";
		
			
	}
	

/*********************************************************************************************************************
	 -Method Name      : getBookingById 
	 -Return Type      : List
	 -Creation Date    : 12-08-2020
	 -Description      : Fetching all booking information from booking database.
********************************************************************************************************************/
	
@Override
public BookingEntity getBookingByName(String name) throws BookingNameNotFound 
{
	Optional<BookingEntity> optional = repo.findByBookingName(name);
	if(optional.isPresent()) {
		return optional.get();
	}
	else {
		throw new BookingNameNotFound("Booking name not found");
	}
}

/*********************************************************************************************************************
-Method Name      : updateBookingByStatus	 
-Input Parameters : bookingStatus
-Return Type      : List<Booking>
-Creation Date    : 12-08-2020
-Description      : Fetching the booking information from booking database by bookingStatus(Pending/Accepted/Rejected).

********************************************************************************************************************/

@Override
public void updateBookingByStatus() throws BookingStatusNotFound {
	int flag = 0;
	List<BookingEntity> bookingList = repo.findByBookingStatus("pending");
	if(bookingList.isEmpty()) {
		flag=1;
	}
	for(BookingEntity entity : bookingList) {
		String status = "";
		if ((entity.getNoOfSeats()) >= 200) {
			status = "Accepted";
		} else {
			status = "Rejected";
		}
		entity.setBookingStatus(status);
		repo.save(entity);
	}
		
	if (flag == 0)
		throw new BookingStatusNotFound(
				"All pending bookings has been successfully accepted or rejected");
	else
		throw new BookingStatusNotFound("No record found for booking status");	
}
	
}

