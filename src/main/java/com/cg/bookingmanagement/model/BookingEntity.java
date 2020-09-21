/****************************************************************************************************************************
- File Name        : BookingEntity Class
- Author           : Neha Kumari
- Creation Date    : 10-08-2020
- Description      : This is an entity class for Booking .
****************************************************************************************************************************/

package com.cg.bookingmanagement.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Booking")
public class BookingEntity
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="booking_id")
	private long bookingId;
	
	@Column(name="booking_name")
	private String bookingName;
	
	@Column(name = "booking_place")
	private String bookingPlace;
	
	@Column(name = "speaker_id")
	private long speakerId;
	
	@Column(name = "speaker_name")
	private String speakerName;
	
	@Column(name = "speaker_contactno")
	private long speakerContactNumber ;
	
	@Column(name = "booking_date")
	private Date bookingDate;
	
	@Column(name = "seats")
	private long noOfSeats;
	
	@Column(name = "booking_status")
	public String bookingStatus;
	
	
/****************************************************************************************************************************          
	- Description      : Generating constructor for BookingEntity class.
****************************************************************************************************************************/	
	
	public BookingEntity() 
	{
		super();
	}


	public BookingEntity(long bookingId, String bookingName, String bookingPlace, long speakerId, String speakerName,long 		speakerContactNumber, Date bookingDate, long noOfSeats, String bookingStatus) 
	{
		super();
		this.bookingId = bookingId;
		this.bookingName = bookingName;
		this.bookingPlace = bookingPlace;
		this.speakerId = speakerId;
		this.speakerName = speakerName;
		this.speakerContactNumber = speakerContactNumber;
		this.bookingDate = bookingDate;
		this.noOfSeats = noOfSeats;
		this.bookingStatus = bookingStatus;
	}
	
/****************************************************************************************************************************          
    - Description      : Generating Getters and Setters for the Booking database columns.
****************************************************************************************************************************/

	
	public long getBookingId() 
	{
		return bookingId;
	}


	public void setBookingId(long bookingId) 
	{
		this.bookingId = bookingId;
	}


	public String getBookingName() 
	{
		return bookingName;
	}


	public void setBookingName(String bookingName) 
	{
		this.bookingName = bookingName;
	}


	public String getBookingPlace() 
	{
		return bookingPlace;
	}


	public void setBookingPlace(String bookingPlace)
	{
		this.bookingPlace = bookingPlace;
	}


	public long getSpeakerId()
	{
		return speakerId;
	}


	public void setSpeakerId(long speakerId) 
	{
		this.speakerId = speakerId;
	}


	public String getSpeakerName() 
	{
		return speakerName;
	}


	public void setSpeakerName(String speakerName) 
	{
		this.speakerName = speakerName;
	}


	public long getSpeakerContactNumber()
	{
		return speakerContactNumber;
	}


	public void setSpeakerContactNumber(long speakerContactNumber) 
	{
		this.speakerContactNumber = speakerContactNumber;
	}


	public Date getBookingDate()
	{
		return bookingDate;
	}


	public void setBookingDate(Date bookingDate) 
	{
		this.bookingDate = bookingDate;
	}


	public long getNoOfSeats() 
	{
		return noOfSeats;
	}


	public void setNoOfSeats(long noOfSeats) 
	{
		this.noOfSeats = noOfSeats;
	}


	public String getBookingStatus() 
	{
		return bookingStatus;
	}


	public void setBookingStatus(String bookingStatus) 
	{
		this.bookingStatus = bookingStatus;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}