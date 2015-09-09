package com.ticket.repositories;


import com.ticket.entity.SelfStation;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.Collection;

/**
 * CustomRepository designed for custom native SQL queries
 */
@NoRepositoryBean
public interface CustomRepository {

    Collection<Object[]> findCommonStations();
}
