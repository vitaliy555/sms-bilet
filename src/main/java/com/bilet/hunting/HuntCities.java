package com.bilet.hunting;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Collection;

import com.bilet.hunting.dto.Stations;
import com.bilet.hunting.model.CyrillicChar;
import com.google.common.collect.Lists;
import com.google.gson.Gson;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

import javax.ws.rs.core.MediaType;

public class HuntCities {
    static Gson gson = new Gson();

    public static void main(String[] args) throws IOException {

        ClientConfig config = new DefaultClientConfig();
        Client client = Client.create(config);
        WebResource service = client.resource("http://booking.uz.gov.ua/purchase/station/ly/");
        Stations result = service.type(MediaType.APPLICATION_JSON_TYPE).accept(MediaType.APPLICATION_JSON).get(Stations.class);
        System.out.println(result);
//        Collection<String> charCombinations = getCharCombinations(getAlphabet());
//        for (String s : charCombinations) {
//            System.out.println(s);
//        }
//        System.out.println("SIZE :" + charCombinations.size());
//
//        List<Stations> stations = Lists.newArrayList();
//        for (String charCombination : charCombinations) {
//            RestHelper restHelper = new RestHelper(new StationsCommand(charCombination));
//            stations.add(gson.fromJson(restHelper.execute(), Stations.class));
//        }
//        // TODO transformations
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
