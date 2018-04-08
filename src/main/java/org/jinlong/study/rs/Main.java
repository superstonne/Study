package org.jinlong.study.rs;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import java.io.IOException;
import java.net.URI;

public class Main {
    public static final String BASE_URI = "http://localhost:8080/myapp";

    public static HttpServer startServer() {
        final ResourceConfig rc = new ResourceConfig().packages("org.jinlong.study.rs");
        return GrizzlyHttpServerFactory.createHttpServer(URI.create(BASE_URI), rc);
    }

    public static void main(String[] args) throws IOException {
        final HttpServer server = startServer();
        System.out.println("Jersey app started with WADL available at " +
                "%application.wadl\nHit enter to stop it..." + BASE_URI);
        System.in.read();
        server.shutdown();
    }
}
