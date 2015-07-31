package com.bilet.hunting.rest;

import com.bilet.hunting.rest.cmd.Command;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class RestHelper {
    private Command command;

    public RestHelper(Command command) {
        this.command = command;
    }

    public String execute() throws IOException {
        URL url = new URL(command.getPath());
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod(command.getMethod().name());

        StringBuffer response = new StringBuffer();
        try (BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()))) {
            String inputLine;

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }

        }
        return response.toString();
    }
}
