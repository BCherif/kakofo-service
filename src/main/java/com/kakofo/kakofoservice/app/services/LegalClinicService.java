package com.kakofo.kakofoservice.app.services;

import com.kakofo.kakofoservice.app.entity.LegalClinic;
import com.kakofo.kakofoservice.app.repositories.LegalClinicRepository;
import com.kakofo.kakofoservice.utils.Response;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class LegalClinicService {
    private final LegalClinicRepository legalClinicRepository;


    public Response save(LegalClinic legalClinic){
        try {

            LegalClinic lc = legalClinicRepository.findByName(legalClinic.getName());
            if (lc != null) {
                return Response.error("Cette clinique existe déjà!");
            }
            legalClinicRepository.save(legalClinic);

        } catch (Exception e) {
            e.printStackTrace();
            return Response.error("Une erreur est survenue!");
        }
        return Response.success("Poste enregistré avec succès ");

    }

//    public Response update(LegalClinic legalClinic){
//        try {
//
//            Optional<PoliceStation> ps = postesRepository.findById(policeStation.getId());
//            if (ps.get() == null) {
//                return Response.error("Ce poste n'existe pas !");
//            }
//            postesRepository.saveAndFlush(policeStation);
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            return Response.error("Une erreur est survenue!");
//        }
//        return Response.success("Poste modifié avec succès ");
//
//    }
//    public Response findAll(){
//        List<PoliceStation> policeStations = new ArrayList<>();
//        try {
//            policeStations = postesRepository.findAll();
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            return Response.error("Une erreur est survenue!");
//        }
//        return Response.with(policeStations,policeStations.size() + "La liste des Postes ");
//
//    }
}
