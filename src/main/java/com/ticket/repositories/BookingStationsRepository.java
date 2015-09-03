package com.ticket.repositories;

import com.ticket.entity.BookingStation;
import org.springframework.data.repository.CrudRepository;

/**
 * Stations from booking
 */
public interface BookingStationsRepository extends CrudRepository<BookingStation,Long> {

}
