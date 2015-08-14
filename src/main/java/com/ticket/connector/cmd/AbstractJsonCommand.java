package com.ticket.connector.cmd;

import javax.ws.rs.core.MediaType;

public abstract class AbstractJsonCommand extends AbstractBaseCommand {
    @Override
    public String getAcceptType() {
        return MediaType.APPLICATION_JSON;
    }

    @Override
    public ContentType getContentType() {
        return ContentType.JSON;
    }
}
