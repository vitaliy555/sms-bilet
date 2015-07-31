package com.bilet.hunting.rest;

import com.google.common.base.Optional;

public class ResponceImpl implements  Responce {
    @Override
    public boolean isSuccess() {
        return false;
    }

    @Override
    public int getStatus() {
        return 0;
    }

    @Override
    public Optional getEntity() {
        return null;
    }
}
