package com.bilet.hunting.rest;

import com.google.common.base.Optional;

public interface Responce<T> {
    /**
     * Is success.
     *
     * @return the boolean
     */
    boolean isSuccess();

    /**
     * Gets status.
     *
     * @return the status
     */
    int getStatus();
    /**
     * Read response entity
     * @return return entity when possible or null
     */
    Optional<T> getEntity();
}
