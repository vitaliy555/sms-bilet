package com.ticket.repositories;

import com.ticket.entity.UZStation;
import org.springframework.data.repository.CrudRepository;

import com.ticket.entity.BookingStation;

/**
 * Stations from UZ
 */
public interface UZStationsRepository extends CrudRepository<UZStation,Long> {

}
