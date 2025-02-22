package edu.upc.dsa;

import io.swagger.jaxrs.config.BeanConfig;
import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.grizzly.http.server.StaticHttpHandler;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import java.io.IOException;
import java.net.URI;

public class Main {
    public static final String BASE_URI = "http://localhost:8080/dsaApp/";

    public static HttpServer startServer() {
        final ResourceConfig rc = new ResourceConfig().packages("edu.upc.dsa.services");

        rc.register(io.swagger.jaxrs.listing.ApiListingResource.class);
        rc.register(io.swagger.jaxrs.listing.SwaggerSerializers.class);

        BeanConfig beanConfig = new BeanConfig();
        beanConfig.setHost("localhost:8080");
        beanConfig.setBasePath("/dsaApp");
        beanConfig.setContact("support@example.com");
        beanConfig.setDescription("REST API for Tracks Manager");
        beanConfig.setLicenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html");
        beanConfig.setResourcePackage("edu.upc.dsa.services");
        beanConfig.setTermsOfServiceUrl("http://www.example.com/resources/eula");
        beanConfig.setTitle("REST API");
        beanConfig.setVersion("1.0.0");
        beanConfig.setScan(true);

        return GrizzlyHttpServerFactory.createHttpServer(URI.create(BASE_URI), rc);
    }

    public static void main(String[] args) throws IOException {
        final HttpServer server = startServer();

        StaticHttpHandler staticHttpHandler = new StaticHttpHandler("./public/");
        server.getServerConfiguration().addHttpHandler(staticHttpHandler, "/");

        System.out.println(String.format("Jersey app started with WADL available at "
                + "%sapplication.wadl\nHit enter to stop it...", BASE_URI));

        System.in.read();
        server.stop();
    }
}