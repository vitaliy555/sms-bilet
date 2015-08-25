package com.ticket.config.connector.cmd;

public interface Command<T> {
    /**
     * The enum Method.
     */
    enum Method {
        /**
         * The GET.
         */
        GET,
        /**
         * The POST.
         */
        POST,
        /**
         * The PUT.
         */
        PUT,
        /**
         * The DELETE.
         */
        DELETE
    }

    /**
     * The enum Content type.
     */
    enum ContentType {
        /**
         * The FORM_URL_ENCODED.
         */
        FORM_URL_ENCODED,
        /**
         * The XML.
         */
        XML,
        /**
         * The JSON.
         */
        JSON
    }
    /**
     * Gets accept type
     * @return the accept type
     */
    String getAcceptType();

    /**
     * Gets content type.
     *
     * @return the content type
     */
    ContentType getContentType();

    /**
     * Gets method.
     *
     * @return the method
     */
    Method getMethod();

    /**
     * Gets path.
     *
     * @return the path
     */
    String getPath();

    Class<T> getResponseType();

}
