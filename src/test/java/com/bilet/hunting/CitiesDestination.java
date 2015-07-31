package com.bilet.hunting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import com.google.common.base.Charsets;
import com.google.common.collect.Lists;

@RunWith(MockitoJUnitRunner.class)
public class CitiesDestination {
    @Test
    public void getCities() throws IOException {
        // System.out.println("à".getBytes("cp1251"));
        String url = "http://booking.uz.gov.ua/ru/purchase/station/äí/";
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("POST");

        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'POST' request to URL : " + url);
        System.out.println("Response Code : " + responseCode);

        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        // print result
        System.out.println(response.toString());
        //
        // System.out.println(new
        // String("\u0414\u043d\u0435\u043f\u0440\u043e\u0432\u0441\u043a\u0430\u044f".getBytes("cp1251")));
        // System.out.println(new String("Äíåïðîâñêàÿ".getBytes("ISO-8859-1"), "ISO-8859-1"));
        // byte[] cp1251s = "Äíåïðîâñêàÿ".getBytes("KOI8_R");
        // String myString = "Äíåïðîâñêàÿ";
        //
        // System.out.println("à".getBytes("UTF-8")[0]);
        // System.out.println("à".getBytes("UTF-8")[1]);
        //
        // System.out.println("á".getBytes("UTF-8")[0]);
        // System.out.println("á".getBytes("UTF-8")[1]);
        //
        // System.out.println("â".getBytes("UTF-8")[0]);
        // System.out.println("â".getBytes("UTF-8")[1]);
        //
        // System.out.println("ï".getBytes("UTF-8")[0]);
        // System.out.println("ï".getBytes("UTF-8")[1]);
        //
        // System.out.println(new String("á".getBytes("UTF-8"), "UTF-8"));

        byte firstByte = -48;

        List<CyrillicÑharacter> alphabet = Lists.newArrayList();
        for (byte secondByte = -80; secondByte <= -65; secondByte++) {
            alphabet.add(new CyrillicÑharacter(firstByte,secondByte));
        }

        for (CyrillicÑharacter cyrillicÑharacter : alphabet) {
            System.out.println(cyrillicÑharacter.getChar());
        }
    }

    class CyrillicÑharacter {
        private byte[] bytes = new byte[2];

        public CyrillicÑharacter(byte firstByte, byte secondByte) {
            this.bytes[0] = firstByte;
            this.bytes[1] = secondByte;
        }

        // TODO char ?
        public char getChar() throws UnsupportedEncodingException {
            return new String(bytes, Charsets.UTF_8).charAt(0);
        }
    }
}