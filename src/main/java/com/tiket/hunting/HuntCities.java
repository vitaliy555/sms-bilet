package com.tiket.hunting;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Collection;


import com.tiket.hunting.dto.Stations;
import com.tiket.hunting.model.CyrillicChar;
import com.google.common.collect.Lists;
import com.google.gson.Gson;
import com.owlike.genson.Genson;
import com.owlike.genson.ext.jaxrs.GensonJsonConverter;
import com.owlike.genson.ext.jsr353.JSR353Bundle;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

import javax.ws.rs.core.MediaType;

public class HuntCities {
    static Gson gson = new Gson();

    public static void main(String[] args) throws IOException {
        // String json = "{\"value\":[{\"station_id\":\"id1\",\"title\":\"title\"}]}";
        Genson genson = new Genson.Builder().with(new JSR353Bundle()).create();
        // Stations stations = new Stations();
        // final Stations.StationNameAndID stationNameAndID = new Stations.StationNameAndID();
        // stationNameAndID.setTitle("title");
        // stationNameAndID.setStation_id("id1");
        // final Stations.StationNameAndID stationNameAndID2 = new Stations.StationNameAndID();
        // stationNameAndID2.setTitle("title2");
        // stationNameAndID2.setStation_id("id2");
        // stations.setValue( new
        // ArrayList<Stations.StationNameAndID>(){{add(stationNameAndID);add(stationNameAndID2);}});
        // String serialize = genson.serialize(stations);
        // System.out.println(serialize);
        ClientConfig cfg = new DefaultClientConfig(GensonJsonConverter.class);
        Client client = Client.create(cfg);
        WebResource webResource = client.resource("http://booking.uz.gov.ua/purchase/station/ly/");
        // you can map it to a pojo, no need to have a string or map
        Stations pojo = webResource.accept(MediaType.APPLICATION_JSON).get(Stations.class);
        String json = "{\"value\":[{\"title\":\"\\u0414\\u043d\\u0456\\u043f\\u0440\\u043e\\u0431\\u0443\\u0434 2\",\"station_id\":2210831},{\"title\":\"\\u0414\\u043d\\u0456\\u043f\\u0440\\u043e\\u0432\\u0441\\u044c\\u043a\\u0430\",\"station_id\":2208327},{\"title\":\"\\u0414\\u043d\\u0456\\u043f\\u0440\\u043e\\u0432\\u0441\\u044c\\u043a\\u0430\",\"station_id\":2210278},{\"title\":\"\\u0414\\u043d\\u0456\\u043f\\u0440\\u043e\\u0434\\u0437\\u0435\\u0440\\u0436\\u0438\\u043d\\u0441\\u044c\\u043a\",\"station_id\":2210650},{\"title\":\"\\u0414\\u043d\\u0456\\u043f\\u0440\\u043e\\u0434\\u0437\\u0435\\u0440\\u0436\\u0438\\u043d\\u0441\\u044c\\u043a \\u041b\\u0456\\u0432\",\"station_id\":2210970},{\"title\":\"\\u0414\\u043d\\u0456\\u043f\\u0440\\u043e\\u0434\\u0437\\u0435\\u0440\\u0436\\u0438\\u043d\\u0441\\u044c\\u043a-\\u041f\\u0430\\u0441.\",\"station_id\":2210720},{\"title\":\"\\u0414\\u043d\\u0456\\u043f\\u0440\\u043e\\u043f\\u0435\\u0442\\u0440\\u043e\\u0432\\u0441\\u044c\\u043a \\u0413\\u043e\\u043b\\u043e\\u0432\\u043d\\u0438\\u0439\",\"station_id\":2210700},{\"title\":\"\\u0414\\u043d\\u0456\\u043f\\u0440\\u043e\\u043f\\u0435\\u0442\\u0440\\u043e\\u0432\\u0441\\u044c\\u043a \\u041e\\u0434\\u0431\",\"station_id\":2210739},{\"title\":\"\\u0414\\u043d\\u0456\\u043f\\u0440\\u043e\\u043f\\u0435\\u0442\\u0440\\u043e\\u0432\\u0441\\u044c\\u043a \\u041f\\u0456\\u0432\\u0434\\u0435\\u043d\\u043d\\u0438\\u0439\",\"station_id\":2210701},{\"title\":\"\\u0414\\u043d\\u0456\\u043f\\u0440\\u043e\\u0440\\u0443\\u0434\\u043d\\u0435\",\"station_id\":2210200},{\"title\":\"\\u0414\\u043d\\u0456\\u0441\\u0442\\u0435\\u0440\",\"station_id\":2200236},{\"title\":\"\\u0414\\u043d\\u043e\",\"station_id\":2004570}],\"error\":null,\"data\":{\"req_text\":[\"ly\",\"\\u0434\\u043d\"]}}";
        Stations object = genson.deserialize(json, Stations.class);
        System.out.println("ok");

        // ClientConfig cfg = new DefaultClientConfig(GensonJsonConverter.class);
        // Client client = Client.create(cfg);
        // WebResource webResource =
        // client.resource("http://booking.uz.gov.ua/purchase/station/ly/");
        //
        // // you can map it to a pojo, no need to have a string or map
        // Stations pojo = webResource.accept(MediaType.APPLICATION_JSON).get(Stations.class);

        // NOT BED VAR
        // ClientConfig config = new DefaultClientConfig();
        // Client client = Client.create(config);
        // WebResource service = client.resource("http://booking.uz.gov.ua/purchase/station/ly/");
        // String result = service.accept(MediaType.APPLICATION_JSON).get(String.class);
        // List resultList = gson.fromJson(result, List.class);
        // System.out.println(result);

        // Collection<String> charCombinations = getCharCombinations(getAlphabet());
        // for (String s : charCombinations) {
        // System.out.println(s);
        // }
        // System.out.println("SIZE :" + charCombinations.size());
        //
        // List<Stations> stations = Lists.newArrayList();
        // for (String charCombination : charCombinations) {
        // RestHelper restHelper = new RestHelper(new StationsCommand(charCombination));
        // stations.add(gson.fromJson(restHelper.execute(), Stations.class));
        // }
        // // TODO transformations
    }

    private static Collection<CyrillicChar> getAlphabet() {
        Collection<CyrillicChar> alphabet = Lists.newArrayList();
        // alphabet from À to Ï
        byte firstByte = -48;
        for (byte secondByte = -80; secondByte <= -65; secondByte++) {
            alphabet.add(new CyrillicChar(firstByte, secondByte));
        }
        // alphabet from Ï to ß
        firstByte = -47;
        for (byte secondByte = -128; secondByte <= -113; secondByte++) {
            alphabet.add(new CyrillicChar(firstByte, secondByte));
        }
        return alphabet;
    }

    private static Collection<String> getCharCombinations(Collection<CyrillicChar> chars)
            throws UnsupportedEncodingException {
        Collection<String> resultCombinations = Lists.newArrayList();
        for (CyrillicChar cyrillicChar : chars) {
            for (CyrillicChar aChar : chars) {
                resultCombinations.add(new String(new char[] { cyrillicChar.getChar(), aChar.getChar() }));
            }
        }
        return resultCombinations;
    }
}
