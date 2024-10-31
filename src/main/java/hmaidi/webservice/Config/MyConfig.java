package hmaidi.webservice.Config;

import hmaidi.webservice.Service.CompteRestJAXRSAPI;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfig {
    @Bean
    public ResourceConfig resourceConfig(){
        ResourceConfig jerseyServlet = new ResourceConfig();
        jerseyServlet.register(CompteRestJAXRSAPI.class);
        return jerseyServlet;
    }
}
