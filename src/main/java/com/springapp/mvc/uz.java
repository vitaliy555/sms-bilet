package com.springapp.mvc;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class uz {

    static String html   = "";
    static String cookie = "";
    static String token  = "";
    static String error  = "";

    static Map<String, List<String>> headers = null;

    static void fetchHtml() {
        try {
            URL url = new URL("http://booking.uz.gov.ua/");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            headers = conn.getHeaderFields();
            String line;
            while ((line = rd.readLine()) != null) {
                html += line;
            }
            rd.close();
        } catch (Exception e) {
            error = e.getMessage();
        }
    }

    static void parseCookie() {
        List<String> cookies = headers.get("Set-Cookie");
        for (String current_cookie : cookies) {
            if (current_cookie.startsWith("_gv_sessid")) {
                cookie = current_cookie;
                break;
            }
        }
    }

    static void parseToken() {
        String adapter = "var token;localStorage={setItem:function(key, value){if(key==='gv-token')token=value}};";
        Pattern pattern = Pattern.compile("\\$\\$_=.*~\\[\\];.*\"\"\\)\\(\\)\\)\\(\\);");
        Matcher matcher = pattern.matcher(html);
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

    static String getStationId(String name) {
        String json = "";
        try {
            URL url = new URL("http://booking.uz.gov.ua/en/purchase/station/" + name + "/");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = rd.readLine()) != null) {
                json += line;
            }
            rd.close();
        } catch (Exception e) {
            error = e.getMessage();
        }
        ScriptEngineManager factory = new ScriptEngineManager();
        ScriptEngine engine = factory.getEngineByName("JavaScript");
        engine.put("json", json);
        try {
            engine.eval("var station_id = JSON.parse(json).value[0].station_id");
        } catch (ScriptException e) {
            error = e.getMessage();
        }
        return engine.get("station_id").toString();
    }

    static String getData(String fromName, String toName, String date) {
        fetchHtml();
        parseCookie();
        parseToken();
        String from = "2208001";//getStationId(fromName);
        String to = "2218000";//getStationId(toName);
        String json = "";
        try {
            URL url = new URL("http://booking.uz.gov.ua/en/purchase/search/");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestProperty("Cookie", cookie);
            conn.setRequestProperty("GV-Token", token);
            conn.setRequestProperty("GV-Ajax", "1");
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            conn.setRequestProperty("Referer", "http://booking.uz.gov.ua/en/");
            conn.setRequestMethod("POST");
            String urlParameters = MessageFormat.format("station_id_from={0}&station_id_till={1}&date_dep={2}" +
                    "&time_dep=00:00&time_dep_till=24:00", from, to, date);
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

    static String getData(String fromName, String toName) {
        return getData(fromName, toName, new SimpleDateFormat("MM.dd.yyyy").format(new Date()));
    }

    public static void main(String[] args) {


        if (args.length < 2) {
            System.out.println("ќнлайн резервуванн€ та придбанн€ квиткiв - ”крзал≥зниц€");
            System.out.println("¬ведите: <start_station> <end_station> [MM.DD.YYYY]");
//            System.exit(1);
        }
        String data;
        if (args.length > 2)
            data = getData(args[0], args[1], args[2]);
        else
//            data = getData(args[0], args[1]);
        data = getData("ќдесса", "Ћьвов");
        System.out.println(data);
    }


}