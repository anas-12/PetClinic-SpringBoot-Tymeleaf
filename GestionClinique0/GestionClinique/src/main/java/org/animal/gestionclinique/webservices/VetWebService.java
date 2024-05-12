package org.animal.gestionclinique.webservices;

import jakarta.jws.WebMethod;
import jakarta.jws.WebService;
import lombok.AllArgsConstructor;
import org.animal.gestionclinique.entities.Medecin;
import org.animal.gestionclinique.services.VetService;

import java.util.List;

@WebService(serviceName = "vetWS")
@AllArgsConstructor
public class VetWebService {
    private VetService vetService;

    @WebMethod(operationName = "getVetList")
    public List<Medecin> getVetList() {
        return vetService.getAllMedecin();
    }

}
