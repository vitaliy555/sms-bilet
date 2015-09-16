package com.ticket.config.connector.cmd;

import java.util.Map;

import javax.ws.rs.core.Cookie;

abstract class AbstractBaseCommand<T> implements Command {
    private Method method;
    private String path;
    private Class<T> responseType;
    private Cookie cookie;
    private Map<String, Object> properties;

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

    public Class<T> getResponseType() {
        return responseType;
    }

    public void setResponseType(Class<T> responseType) {
        this.responseType = responseType;
    }

    @Override
    public Cookie getCookie() {
        return null;
    }

    public void setCookie(Cookie cookie) {
        this.cookie = cookie;
    }

    @Override
    public Map<String, Object> getProperties() {
        return properties;
    }

    public void setProperties(Map<String, Object> properties) {
        this.properties = properties;
    }
}
