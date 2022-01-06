package com.kakofo.kakofoservice.app.services;

import com.kakofo.kakofoservice.app.entity.Division;
import com.kakofo.kakofoservice.app.entity.Locality;
import com.kakofo.kakofoservice.app.entity.PoliceStation;
import com.kakofo.kakofoservice.app.entity.TypePoste;
import com.kakofo.kakofoservice.app.repositories.DivisionRepository;
import com.kakofo.kakofoservice.app.repositories.LocalityRepository;
import com.kakofo.kakofoservice.app.repositories.PostesRepository;
import com.kakofo.kakofoservice.app.repositories.TypePostesRepository;
import com.kakofo.kakofoservice.utils.Response;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class LocalityService {
    private final LocalityRepository localityRepository;
    private final DivisionRepository divisionRepository;


    public Response getLocalityByDivision(Long id){
        List<Locality> divisions = new ArrayList<>();
        try {

            divisions = localityRepository.getLocalitiesByDivision(id);

        } catch (Exception e) {
            e.printStackTrace();
            return Response.error("Une erreur est survenue!");
        }
        return Response.with(divisions,"Liste des localités ");

    }

      public Response getAllDivision(){
        List<Division> divisions = new ArrayList<>();
        try {

            divisions = divisionRepository.findAll();

        } catch (Exception e) {
            e.printStackTrace();
            return Response.error("Une erreur est survenue!");
        }
        return Response.with(divisions,"Liste des localités ");

    }

    public Response getLocalityByLocalitySup(Long id){
        try {



        } catch (Exception e) {
            e.printStackTrace();
            return Response.error("Une erreur est survenue!");
        }
        return Response.success("Type Poste enregistré avec succès ");

    }


}
