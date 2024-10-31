package hmaidi.webservice;

import hmaidi.webservice.Entities.Compte;
import hmaidi.webservice.Enum.TypeCompte;
import hmaidi.webservice.Repository.CompteRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class WebServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner start(CompteRepository compteRepository){
        return args -> {
            compteRepository.save(new Compte(null,Math.random()*9000,new Date(), TypeCompte.EPARGNE));
            compteRepository.save(new Compte(null,Math.random()*9000,new Date(), TypeCompte.COURANT));
            compteRepository.save(new Compte(null,Math.random()*9000,new Date(), TypeCompte.EPARGNE));

            compteRepository.findAll().forEach(c->{
                System.out.println(c.toString());
            });
        };
    }
}
