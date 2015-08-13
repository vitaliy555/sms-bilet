package com.tiket.hunting.rest.cmd;

public interface Command {
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
     * The enum Accept type.
     */
    enum AcceptType {
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
    AcceptType getAcceptType();

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

    Class getResponseType();

}
