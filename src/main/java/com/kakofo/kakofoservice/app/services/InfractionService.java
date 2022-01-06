package com.kakofo.kakofoservice.app.services;

import com.kakofo.kakofoservice.app.entity.Infraction;
import com.kakofo.kakofoservice.app.repositories.InfractionRepository;
import com.kakofo.kakofoservice.base.response.CResponse;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static com.kakofo.kakofoservice.utils.Utils.getDefaultPageable;

@Service
@AllArgsConstructor
public class InfractionService {

    private final InfractionRepository infractionRepository;

    public Page<Infraction> findAll(Pageable pageable) {
        return infractionRepository.findAll(getDefaultPageable(pageable));
    }

    public CResponse<Infraction> create(Infraction infraction) {
        try {
            return CResponse.success(infractionRepository.save(infraction), "Ajouter avec succès !");
        } catch (Exception e) {
            e.printStackTrace();
            return CResponse.error("Une erreur est survenue!");
        }
    }

    public CResponse<Infraction> update(Long id, Infraction infraction) {
        try {
            Optional<Infraction> optionalBureauVote = infractionRepository.findById(id);
            if (optionalBureauVote.isPresent()) {
                boolean isExist = infractionRepository.distinctByIdAndExistByLabel(infraction.getId(), infraction.getLabel()).isEmpty();
                if (!isExist) {
                    return CResponse.error("Cette infraction existe déjà");
                }
                return CResponse.success(infractionRepository.save(infraction), "Modifier avec succes!");
            } else {
                return CResponse.error("Cet Objet n'existe pas!");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return CResponse.error("Une erreur est survenue!");
        }
    }

}
