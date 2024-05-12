package org.animal.gestionclinique.server;
import jakarta.jws.WebMethod;
import jakarta.jws.WebService;
import jakarta.xml.ws.Endpoint;
import org.animal.gestionclinique.entities.Medecin;
import org.animal.gestionclinique.services.VetService;
import org.animal.gestionclinique.webservices.VetWebService;
import org.springframework.data.domain.Page;
/*
import java.util.List;
@WebService
public class ServerWS {

    public static void main(String[] args) {
        String url = "http://localhost:8088/";

        VetService vetService = new VetService() {
            @Override
            public Medecin saveMedecin(Medecin medecin) {
                return null;
            }

            @Override
            public Medecin updateMedecin(Medecin medecin) {
                return null;
            }

            @Override
            public void deleteMedecin(Long id) {

            }

            @Override
            public void deleteAllMedecin() {

            }

            @Override
            public Medecin getMedecinById(Long id) {
                return null;
            }

            @Override
            @WebMethod
            public List<Medecin> getAllMedecin() {
                return vetService.getAllMedecin();
            }

            @Override
            public Page<Medecin> getAllProprietairesByPage(int page, int size) {
                return null;
            }
        };

        Endpoint.publish(url,new VetWebService(vetService));
    }
}*/
