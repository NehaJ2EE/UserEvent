package com.cg.bookingmanagement.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.bookingmanagement.model.BookingEntity;

@Repository
public interface BookingRepository extends JpaRepository<BookingEntity, Long>
{
   public List<BookingEntity> findByBookingStatus(String bookingStatus);
   
   public Optional<BookingEntity> findByBookingName(String bookingName);
   
}
