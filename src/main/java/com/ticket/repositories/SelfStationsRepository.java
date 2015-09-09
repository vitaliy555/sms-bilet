package com.ticket.repositories;

import com.ticket.entity.SelfStation;
import org.springframework.data.repository.CrudRepository;

import com.ticket.entity.BookingStation;

/**
 * Self Stations
 */
public interface SelfStationsRepository extends CrudRepository<SelfStation,Long> {

}
