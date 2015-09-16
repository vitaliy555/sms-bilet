package com.ticket.services;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.MessageFormat;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import com.google.common.collect.Maps;
import com.ticket.config.connector.TicketClient;
import com.ticket.config.connector.cmd.custom_cmd.SearchAvailableTrainsCmd;
import com.ticket.config.connector.cmd.custom_cmd.SearchUZStationsCmd;
import com.ticket.utils.SmsTicketConstants;

public class BookingSearchTrainService {
    public static final String BOOKING_URL = "http://booking.uz.gov.ua/";
    private String htmlPage;
    private String cookie = "";
    private String token = "";
    private String error = "";
    private final Map<String, List<String>> headers = Maps.newHashMap();

    public String getData(String fromId, String toId, String date) {
        fetchHtml();
        parseCookie();
        parseToken();
        String json = "";
/*****try it, instead of  block try{}catch(){}****/
        new TicketClient().execute(new SearchAvailableTrainsCmd(getProperties()));
/*************************************************************************/
        try {
            URL url = new URL("");//SmsTicketConstants.BOOKING_TRAIN_SEARCH);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestProperty("Cookie", cookie);
            conn.setRequestProperty("GV-Token", token);
            conn.setRequestProperty("GV-Ajax", "1");
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            conn.setRequestProperty("Referer", "http://booking.uz.gov.ua/en/");
            conn.setRequestMethod("POST");
            String urlParameters = MessageFormat.format("station_id_from={0}&station_id_till={1}&date_dep={2}"
                    + "&time_dep=00:00&time_dep_till=24:00", fromId, toId, date);
            conn.setDoOutput(true);
            DataOutputStream wr = new DataOutputStream(conn.getOutputStream());
            wr.writeBytes(urlParameters);
            wr.flush();
            wr.close();
            BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = rd.readLine()) != null) {
                json += line;
            }
            rd.close();
        } catch (Exception e) {
            error = e.getMessage();
        }
        return json;
    }

    private void fetchHtml() {
        try {
            final URL url = new URL(BOOKING_URL);
            final HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            final BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            headers.putAll(conn.getHeaderFields());
            String line;
            while ((line = rd.readLine()) != null) {
                htmlPage += line;
            }
            rd.close();
        } catch (Exception e) {
            error = e.getMessage();
        }
    }

    private void parseCookie() {
        List<String> cookies = headers.get("Set-Cookie");
        for (String current_cookie : cookies) {
            if (current_cookie.startsWith("_gv_sessid")) {
                cookie = current_cookie;
                break;
            }
        }
    }

    private void parseToken() {
        String adapter = "var token;localStorage={setItem:function(key, value){if(key==='gv-token')token=value}};";
        Pattern pattern = Pattern.compile("\\$\\$_=.*~\\[\\];.*\"\"\\)\\(\\)\\)\\(\\);");
        Matcher matcher = pattern.matcher(htmlPage);
        if (matcher.find()) {
            String obfuscated = matcher.group(0);
            ScriptEngineManager factory = new ScriptEngineManager();
            ScriptEngine engine = factory.getEngineByName("JavaScript");
            try {
                engine.eval(adapter + obfuscated);
            } catch (ScriptException e) {
                error = e.getMessage();
            }
            token = engine.get("token").toString();
        }
    }

    private Map<String, Object> getProperties() {
        final Map<String, Object> properties = Maps.newHashMap();
        properties.put("Cookie", cookie);
        properties.put("GV-Token", token);
        properties.put("GV-Ajax", "1");
        properties.put("Content-Type", "application/x-www-form-urlencoded");
        properties.put("Referer", "http://booking.uz.gov.ua/en/");
        return properties;
    }
}
