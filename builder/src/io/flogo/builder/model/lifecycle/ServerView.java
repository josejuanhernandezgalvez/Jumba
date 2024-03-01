package io.flogo.builder.model.lifecycle;

import java.util.HashMap;

public class ServerView {
    public final String name;
    public final String ip;
    public final String port;
    public final String token;

    public ServerView(String name, String ip, String port, String token) {
        this.name = name;
        this.ip = ip;
        this.port = port;
        this.token = token;
    }


    public ServerView(String name, HashMap<String, String> parametersMap) {
        this.name = name;
        this.ip = parametersMap.get("ip");
        this.port = parametersMap.get("port");
        this.token = parametersMap.get("token");
    }
}
