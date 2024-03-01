package io.flogo.builder.model.renderers;

import io.flogo.builder.model.Renderer;
import io.flogo.builder.model.lifecycle.LifecycleView;
import io.flogo.builder.model.lifecycle.ServerView;
import io.flogo.model.Lifecycle;

import java.io.*;
import java.util.HashMap;

public class LifecycleRenderer implements Renderer {
    private final ServerRenderer serverRenderer;

    public LifecycleRenderer() {
        this.serverRenderer = new ServerRenderer();
    }

    public LifecycleView render(Lifecycle lifecycle) {
        return new LifecycleView(serverRenderer.render(lifecycle.server()));
    }

    public static class ServerRenderer {
        private static final String serversFileName = "/.flogo/servers";
        private static final String[] parameters = {"ip", "port", "token"};

        public ServerView render(Lifecycle.Server server) {
            return verified(server);
        }

        private ServerView verified(Lifecycle.Server server) throws RuntimeException{
            if (!serversFile().exists()) throw new RuntimeException("Server:" + server.name() + ", does not exist");
            return read(serversFile(), server.name());
        }

        private ServerView read(File file, String serverName) {
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                return findServer(reader, serverName);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        private static ServerView findServer(BufferedReader reader, String serverName) throws IOException {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith("[server") && serverName(line).equals(serverName))
                    return serverView(reader, serverName);
            }
            return null;
        }

        private static ServerView serverView(BufferedReader reader, String serverName) throws IOException {
            HashMap<String, String> parametersMap = new HashMap<>();
            for (int i = 0; i < parameters.length; i++) {
                String[] parameter = reader.readLine().split("=");
                parametersMap.put(parameter[0].trim(), parameter[1].trim());
            }
            return new ServerView(serverName, parametersMap);
        }

        private static String serverName(String line) {
            String name = line.split(" ")[1];
            return name.substring(0, name.length() - 1);
        }

        private static File serversFile() {
            return new File(System.getProperty("user.home") + serversFileName);
        }
    }
}
