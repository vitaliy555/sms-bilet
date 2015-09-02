package com.ticket.repositories;

import org.springframework.data.repository.CrudRepository;

import com.ticket.entity.Train;

/**
 * Route repository
 */
public interface TrainRepository extends CrudRepository<Train, Long> {

}
