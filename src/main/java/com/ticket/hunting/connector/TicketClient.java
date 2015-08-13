package com.ticket.hunting.connector;

import javax.ws.rs.core.MediaType;

import com.owlike.genson.ext.jaxrs.GensonJsonConverter;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import static com.ticket.hunting.rest.cmd.Command.Method.*;
import com.ticket.hunting.rest.cmd.Command;

public class TicketClient {

    private final static ClientConfig clientConfig = new DefaultClientConfig(GensonJsonConverter.class);
    //TODO check maybe it can be static
    private final Client client = Client.create(clientConfig);

    public <T> T execute(final Command<T> command) {
        WebResource webResource = client.resource(command.getPath());//"http://booking.uz.gov.ua/purchase/station/ly/"
        //TODO refactoring hardcore
        webResource.accept(MediaType.APPLICATION_JSON);
        if (command.getMethod().equals(GET)) {
            return (T) webResource.get(command.getResponseType());
        }
        // go to normal answer
        return null;
    }
}
