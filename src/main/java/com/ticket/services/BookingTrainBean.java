package com.ticket.services;

import com.ticket.utils.SmsTicketConstants;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.MessageFormat;

public class BookingTrainBean {

//    String getData(String fromName, String toName, String date) {
//        fetchHtml();
//        parseCookie();
//        parseToken();
//        String from = "2208001";//getStationId(fromName);
//        String to = "2218000";//getStationId(toName);
//        String json = "";
//        try {
//            URL url = new URL(SmsTicketConstants.BOOKING_TRAIN_SEARCH);
//            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//            conn.setRequestProperty("Cookie", cookie);
//            conn.setRequestProperty("GV-Token", token);
//            conn.setRequestProperty("GV-Ajax", "1");
//            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
//            conn.setRequestProperty("Referer", "http://booking.uz.gov.ua/en/");
//            conn.setRequestMethod("POST");
//            String urlParameters = MessageFormat.format("station_id_from={0}&station_id_till={1}&date_dep={2}" +
//                    "&time_dep=00:00&time_dep_till=24:00", from, to, date);
//            conn.setDoOutput(true);
//            DataOutputStream wr = new DataOutputStream(conn.getOutputStream());
//            wr.writeBytes(urlParameters);
//            wr.flush();
//            wr.close();
//            BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
//            String line;
//            while ((line = rd.readLine()) != null) {
//                json += line;
//            }
//            rd.close();
//        } catch (Exception e) {
//            error = e.getMessage();
//        }
//        return json;
//    }
}
