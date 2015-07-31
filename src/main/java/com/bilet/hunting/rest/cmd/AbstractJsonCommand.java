package com.bilet.hunting.rest.cmd;

abstract class AbstractJsonCommand extends AbstractBaseCommand {
    @Override
    public AcceptType getAcceptType() {
        return AcceptType.JSON;
    }

    @Override
    public ContentType getContentType() {
        return ContentType.JSON;
    }
}
