/****************************************************************************************************************************
- File Name        : BookingController Class
- Author           : Neha Kumari
- Creation Date    : 10-06-2020
- Description      : This is an end point controller to accept and reject event bookings.
****************************************************************************************************************************/
package com.cg.bookingmanagement.controller;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.bookingmanagement.exceptions.BookingIdNotFound;
import com.cg.bookingmanagement.exceptions.BookingNameNotFound;
import com.cg.bookingmanagement.exceptions.BookingStatusNotFound;
import com.cg.bookingmanagement.model.BookingEntity;
import com.cg.bookingmanagement.service.BookingService;

@RestController
@RequestMapping("/booking")
@CrossOrigin
public class BookingController 
{
	@Autowired
	private BookingService bookingService;

/****************************************************************************************************************************
	  - Method Name : addBooking 
	  - Input Parameters : booking
	  - Return type :ResponseEntity<String> 
	  - Author : Neha Kumari 
	  - Creation Date : 10-08-2020
	  - Description : Inserting the booking information into Booking database
	  - End-point : http://localhost:9091/booking/addBooking 
****************************************************************************************************************************/
	@PostMapping("/addBooking")
	public String addBooking(@Valid @RequestBody BookingEntity booking) {
		return bookingService.addBooking(booking);

	}

	/****************************************************************************************************************************
	  - Method Name : getAllBookings 
	  - Input Parameters : bookingId 
	  - Return type : List<Booking> 
	  - Author : Neha Kumari 
	  - Creation Date : 10-06-2020 
	  - Description : Fetching the event information from Booking database by bookingStatus(Pending/Accepted/Rejected). 
	  - End-point : http://localhost:9091/booking/getAllBookings 
	 ****************************************************************************************************************************/
	@GetMapping("/getAllBookings")
	public List<BookingEntity> getAllBookings() {
		return bookingService.getAllBookings();
	}

	/****************************************************************************************************************************
	 * - Method Name : getBookingById - Input Parameters : BookingDto bookingId - -
	 * Return type : Booking - Description : To get Booking Detail by Id from
	 * database - End-point : http://localhost:9091/booking/bookingdetailsbyId
	 ****************************************************************************************************************************/

	@GetMapping("/bookingdetailsbyId/{bookingId}")
	public BookingEntity getBookingById(@PathVariable("bookingId") @Min(1000) @Max(2000) int bookingId)
			throws BookingIdNotFound {
		return bookingService.getBookingById(bookingId);
	}

	/****************************************************************************************************************************
	 * - Method Name : getBookingByName - Input Parameters : BookingDto bookingId -
	 * Return type : ResponseEntity<Booking> - Description : To get Booking By Name
	 * -End-point : http://localhost:9091/booking/fetchbookingByname
	 ****************************************************************************************************************************/
	
	@GetMapping("/fetchbookingByname/{name}")
	public ResponseEntity<BookingEntity> getBookingByName(@PathVariable("name") String name) throws BookingNameNotFound {
		return new ResponseEntity<>(bookingService.getBookingByName(name), HttpStatus.ACCEPTED);
	}

	/****************************************************************************************************************************
	 * - Method Name : getBookingByBookingStatus - Input Parameters : bookingStatus
	 * - Return type : List<Booking> - Author : Neha Kumari - Creation Date :
	 * 10-06-2020 - Description : Fetching the booking information from Booking
	 * database by bookingStatus(Pending/Accepted/Rejected). - End Point
	 * :http://localhost:9091/booking/getBooking''ByBookingStatus/Pending
	 * 
	 ****************************************************************************************************************************/

	@GetMapping("/getBookingByBookingStatus/{bookingStatus}")
	public List<BookingEntity> getBookingByBookingStatus(@PathVariable("bookingStatus") String bookingStatus)
			throws BookingStatusNotFound{

		return bookingService.getBookingByBookingStatus(bookingStatus);
	}

	/****************************************************************************************************************************
	 * - Method Name : updateBookingByStatus - Return type : void - Author : Neha
	 * Kumari - Creation Date : 11-08-2020 - Description : Updating all booking
	 * status as Accepted or Rejected by checking seats in event. - End Point :
	 * http://localhost:9091/booking/updateBookingByStatus/Pending
	 * 
	 ****************************************************************************************************************************/
	@PutMapping("/updateBookingByStatus/{bookingStatus}")
	public void updateBookingByStatus() throws BookingStatusNotFound {
		bookingService.updateBookingByStatus();
	}

/****************************************************************************************************************************
	  - Method Name      : deleteBookingById 
	  - Input Parameters : bookingId 
	  - Return type      : ResponseEntity<String> 
	  - Author           : Neha Kumari 
	  - Creation Date    : 11-08-2020 
	  - Description      : deleting bookings by bookingId. 
	  - End Point        :  http://localhost:9091/booking/deleteBookingById
 ****************************************************************************************************************************/

	@DeleteMapping("/deleteBookingById/{bookingId}")
	public ResponseEntity<String> deleteBookingById(@PathVariable("bookingId") long bookingId)
			throws BookingIdNotFound{
		return ResponseEntity.ok(bookingService.deleteBookingById(bookingId));

	}

}
