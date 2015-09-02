package com.ticket.repositories;

import com.ticket.entity.Station;
import org.springframework.data.repository.CrudRepository;

/**
 * Railroad stations repository
 */
public interface RailroadStationRepository extends CrudRepository<Station,Long> {

}
