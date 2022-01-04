package com.kakofo.kakofoservice.services;

import com.kakofo.kakofoservice.app.entity.PoliceStation;
import com.kakofo.kakofoservice.repositories.PostesRepository;
import com.kakofo.kakofoservice.utils.Response;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PostesService {
    private final PostesRepository postesRepository;


    public Response save(PoliceStation policeStation){
        try {

//            Optional<AffectionCandidatParti> candidatPartiOptional = affectionCandidatPartiRepository.findById(id);
//            if (candidatPartiOptional.isPresent()) {
//                return Response.success(affectionCandidatPartiRepository.save(affectionCandidatParti), "Modifier avec succes!");
//            } else {
//                return Response.error("Cet Objet n'existe pas!");
//            }
            return Response.error("Une erreur est survenue!");

        } catch (Exception e) {
            e.printStackTrace();
            return Response.error("Une erreur est survenue!");
        }
    }
}
