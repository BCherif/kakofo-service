package com.kakofo.kakofoservice.app.services;

import com.kakofo.kakofoservice.app.entity.Corridor;
import com.kakofo.kakofoservice.app.repositories.CorridorRepository;
import com.kakofo.kakofoservice.app.repositories.PostesRepository;
import com.kakofo.kakofoservice.utils.Response;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CorridorService {
    private final PostesRepository postesRepository;
    private final CorridorRepository corridorRepository;


    public Response save(Corridor corridor){
        try {

            Corridor cor = corridorRepository.findByName(corridor.getName());
            if (cor != null) {
                return Response.error("Ce corridor existe déjà!");
            }
            corridorRepository.save(corridor);

        } catch (Exception e) {
            e.printStackTrace();
            return Response.error("Une erreur est survenue!");
        }
        return Response.success("Corridor enregistré avec succès ");

    }

    public Response update(Corridor corridor){
        try {

            Optional<Corridor> cor = corridorRepository.findById(corridor.getId());
            if (cor.get() == null) {
                return Response.error("Ce corridor n'existe pas !");
            }
            corridorRepository.saveAndFlush(corridor);

        } catch (Exception e) {
            e.printStackTrace();
            return Response.error("Une erreur est survenue!");
        }
        return Response.success("Corridor modifié avec succès ");

    }
    public Response findAll(){
        List<Corridor> corridors = new ArrayList<>();
        try {
            corridors = corridorRepository.findAll();

        } catch (Exception e) {
            e.printStackTrace();
            return Response.error("Une erreur est survenue!");
        }
        return Response.with(corridors,corridors.size() + "La liste des corridors ");

    }
}
