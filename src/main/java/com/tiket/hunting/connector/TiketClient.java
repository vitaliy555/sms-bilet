package com.tiket.hunting.connector;

import javax.ws.rs.core.MediaType;

import com.owlike.genson.ext.jaxrs.GensonJsonConverter;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.tiket.hunting.dto.Stations;
import com.tiket.hunting.rest.cmd.Command;

public class TiketClient {

    private final static ClientConfig clientConfig = new DefaultClientConfig(GensonJsonConverter.class);
    private final Client client = Client.create(clientConfig);
    private final WebResource webResource;
    private final Command.Method method;

    public TiketClient(final Command command) {
        webResource = client.resource(command.getPath());//"http://booking.uz.gov.ua/purchase/station/ly/"
        //TODO refactoring hardcore
        webResource.accept(MediaType.APPLICATION_JSON);
        method = command.getMethod();
    }

    public T execute(final Command<T> command){
        if (method.equals(Command.Method.GET)){
            return (T) webResource.get(command.getResponseType());
        }
        return null;
    }


//    WebResource webResource = client.resource("http://booking.uz.gov.ua/purchase/station/ly/");
    // you can map it to a pojo, no need to have a string or map
    Stations pojo = webResource.accept(MediaType.APPLICATION_JSON).get(Stations.class);
    String json = "{\"value\":[{\"title\":\"\\u0414\\u043d\\u0456\\u043f\\u0440\\u043e\\u0431\\u0443\\u0434 2\",\"station_id\":2210831},{\"title\":\"\\u0414\\u043d\\u0456\\u043f\\u0440\\u043e\\u0432\\u0441\\u044c\\u043a\\u0430\",\"station_id\":2208327},{\"title\":\"\\u0414\\u043d\\u0456\\u043f\\u0440\\u043e\\u0432\\u0441\\u044c\\u043a\\u0430\",\"station_id\":2210278},{\"title\":\"\\u0414\\u043d\\u0456\\u043f\\u0440\\u043e\\u0434\\u0437\\u0435\\u0440\\u0436\\u0438\\u043d\\u0441\\u044c\\u043a\",\"station_id\":2210650},{\"title\":\"\\u0414\\u043d\\u0456\\u043f\\u0440\\u043e\\u0434\\u0437\\u0435\\u0440\\u0436\\u0438\\u043d\\u0441\\u044c\\u043a \\u041b\\u0456\\u0432\",\"station_id\":2210970},{\"title\":\"\\u0414\\u043d\\u0456\\u043f\\u0440\\u043e\\u0434\\u0437\\u0435\\u0440\\u0436\\u0438\\u043d\\u0441\\u044c\\u043a-\\u041f\\u0430\\u0441.\",\"station_id\":2210720},{\"title\":\"\\u0414\\u043d\\u0456\\u043f\\u0440\\u043e\\u043f\\u0435\\u0442\\u0440\\u043e\\u0432\\u0441\\u044c\\u043a \\u0413\\u043e\\u043b\\u043e\\u0432\\u043d\\u0438\\u0439\",\"station_id\":2210700},{\"title\":\"\\u0414\\u043d\\u0456\\u043f\\u0440\\u043e\\u043f\\u0435\\u0442\\u0440\\u043e\\u0432\\u0441\\u044c\\u043a \\u041e\\u0434\\u0431\",\"station_id\":2210739},{\"title\":\"\\u0414\\u043d\\u0456\\u043f\\u0440\\u043e\\u043f\\u0435\\u0442\\u0440\\u043e\\u0432\\u0441\\u044c\\u043a \\u041f\\u0456\\u0432\\u0434\\u0435\\u043d\\u043d\\u0438\\u0439\",\"station_id\":2210701},{\"title\":\"\\u0414\\u043d\\u0456\\u043f\\u0440\\u043e\\u0440\\u0443\\u0434\\u043d\\u0435\",\"station_id\":2210200},{\"title\":\"\\u0414\\u043d\\u0456\\u0441\\u0442\\u0435\\u0440\",\"station_id\":2200236},{\"title\":\"\\u0414\\u043d\\u043e\",\"station_id\":2004570}],\"error\":null,\"data\":{\"req_text\":[\"ly\",\"\\u0434\\u043d\"]}}";
    Stations object = genson.deserialize(json, Stations.class);
    System.out.println("ok");
}
