package com.ticket.repositories;

import com.ticket.entity.SelfStation;

import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Parameter;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

public class CustomRepositoryImpl implements CustomRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public static final String QUERY_FIND_COMMON_STATIONS = "SELECT u.uz_id, u.uz_title, b.booking_id, b.booking_title  FROM uzstation u , bookingstation b where u.uz_title=b.booking_title";

    // TODO maybe has auto converter or parametrization !!!!
    @Override
    public Collection<Object[]> findCommonStations() {
        Query nativeQuery = entityManager.createNativeQuery(QUERY_FIND_COMMON_STATIONS);
        return nativeQuery.getResultList();
    }
}
