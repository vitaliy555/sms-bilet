package com.ticket.connector;

import javax.ws.rs.core.MediaType;

import com.owlike.genson.ext.jaxrs.GensonJsonConverter;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import static com.ticket.connector.cmd.Command.Method.*;
import com.ticket.connector.cmd.Command;

public class TicketClient {

    private final static ClientConfig clientConfig = new DefaultClientConfig(GensonJsonConverter.class);
    //TODO check maybe it can be static
    private final Client client = Client.create(clientConfig);

    public <T> T execute(final Command<T> command) {
        WebResource webResource = client.resource(command.getPath());//"http://booking.uz.gov.ua/purchase/station/ly/"
        webResource.accept(command.getAcceptType());
        if (command.getMethod().equals(GET)) {
            return (T) webResource.get(command.getResponseType());
        }
        //TODO go to normal answer
        return null;
    }
}
