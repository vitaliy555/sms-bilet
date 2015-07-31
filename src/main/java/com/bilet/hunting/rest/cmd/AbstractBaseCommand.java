package com.bilet.hunting.rest.cmd;

abstract class AbstractBaseCommand implements Command {
    private Method method;
    private String path;

    @Override
    public Method getMethod() {
        return method;
    }

    public void setMethod(Method method) {
        this.method = method;
    }

    @Override
    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
