package hmaidi.webservice.Service;

import hmaidi.webservice.Entities.Compte;
import hmaidi.webservice.Repository.CompteRepository;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;


@Component
@Path("/banque")
public class CompteRestJAXRSAPI {

    @Autowired
    private CompteRepository compteRepository;

    @Path("/compte")
    @GET
    @Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
    public List<Compte> listComptes() {
        return compteRepository.findAll();
    }


    @Path("/comptes/{id}")
    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Compte getCompte(@PathParam("id") Long id){
        return compteRepository.findById(id).orElse(null);
    }

    @Path("/comptes")
    @POST
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Compte createCompte(Compte compte){
        return compteRepository.save(compte);
    }

    @Path("/comptes/{id}")
    @PUT
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Compte updateCompte(@PathParam("id") Long id, Compte compte){
        Compte c1 = compteRepository.findById(id).orElse(null);
        if(c1 != null){
            c1.setSolde(compte.getSolde());
            c1.setTypeCompte(compte.getTypeCompte());
            c1.setDateCreation(compte.getDateCreation());
            return compteRepository.save(c1);
        }
        return null;
    }

    @Path("/comptes/{id}")
    @DELETE
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public void deleteCompte(@PathParam("id") Long id){
        compteRepository.deleteById(id);
    }

}
