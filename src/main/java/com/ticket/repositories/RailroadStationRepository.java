package com.ticket.repositories;

import com.ticket.entity.RailroadStation;
import org.springframework.data.repository.CrudRepository;

/**
 * Railroad stations repository
 */
public interface RailroadStationRepository extends CrudRepository<RailroadStation,Long> {

}
