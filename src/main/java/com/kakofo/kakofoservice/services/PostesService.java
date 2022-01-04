package com.kakofo.kakofoservice.services;

import com.kakofo.kakofoservice.app.entity.PoliceStation;
import com.kakofo.kakofoservice.repositories.PostesRepository;
import com.kakofo.kakofoservice.utils.Response;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PostesService {
    private final PostesRepository postesRepository;


    public Response save(PoliceStation policeStation){
        try {

            PoliceStation ps = postesRepository.findByName(policeStation.getName());
            if (ps != null) {
                return Response.error("Ce poste existe déjà!");
            }
            postesRepository.save(policeStation);

        } catch (Exception e) {
            e.printStackTrace();
            return Response.error("Une erreur est survenue!");
        }
        return Response.success("Poste enregistré avec succès ");

    }

    public Response update(PoliceStation policeStation){
        try {

            Optional<PoliceStation> ps = postesRepository.findById(policeStation.getId());
            if (ps.get() == null) {
                return Response.error("Ce poste n'existe pas !");
            }
            postesRepository.saveAndFlush(policeStation);

        } catch (Exception e) {
            e.printStackTrace();
            return Response.error("Une erreur est survenue!");
        }
        return Response.success("Poste modifié avec succès ");

    }
    public Response findAll(){
        List<PoliceStation> policeStations = new ArrayList<>();
        try {
            policeStations = postesRepository.findAll();

        } catch (Exception e) {
            e.printStackTrace();
            return Response.error("Une erreur est survenue!");
        }
        return Response.with(policeStations,policeStations.size() + "La liste des Postes ");

    }
}
