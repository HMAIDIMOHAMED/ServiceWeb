package hmaidi.webservice.Config;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.glassfish.jersey.moxy.xml.MoxyXmlFeature;


@Component
@Primary
public class JerseyConfig extends ResourceConfig {
    public JerseyConfig() {
        packages("hmaidi.webservice.Service");
        register(MoxyXmlFeature.class);
        register(CompteListMessageBodyWriter.class);
    }
}