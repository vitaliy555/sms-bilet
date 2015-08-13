package com.tiket.hunting.rest.cmd;

public abstract class AbstractJsonCommand extends AbstractBaseCommand {
    @Override
    public AcceptType getAcceptType() {
        return AcceptType.JSON;
    }

    @Override
    public ContentType getContentType() {
        return ContentType.JSON;
    }
}
