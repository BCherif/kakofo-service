package com.kakofo.kakofoservice.app.services;

import com.kakofo.kakofoservice.app.entity.TrafficLaws;
import com.kakofo.kakofoservice.app.repositories.TrafficLawsRepository;
import com.kakofo.kakofoservice.base.response.CResponse;
import com.kakofo.kakofoservice.utils.Constants;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Optional;

@Service
public class TrafficLawsService {
    private final TrafficLawsRepository trafficLawsRepository;
    private final UploadImageService uploadImageService;

    public TrafficLawsService(TrafficLawsRepository trafficLawsRepository, UploadImageService uploadImageService) {
        this.trafficLawsRepository = trafficLawsRepository;
        this.uploadImageService = uploadImageService;
    }


    public CResponse<TrafficLaws> saveTrafficLaws(TrafficLaws trafficLaws, MultipartFile photo) {
        try {
            trafficLaws.setPath(uploadImageService.uploadImage(photo, Constants.NEWS_DOWNLOAD_LINK));
            TrafficLaws trafficLawsSaved = trafficLawsRepository.save(trafficLaws);
            return CResponse.success(trafficLawsSaved, "Actualité enregistré");
        } catch (Exception e) {
            return CResponse.error("Une erreur est survenue!");
        }
    }

    public CResponse<Page<TrafficLaws>> getTrafficLaws(int page, int size) {
        try {
            Pageable paging = PageRequest.of(page, size);
            Page<TrafficLaws> trafficLaws = trafficLawsRepository.findAll(paging);
            return CResponse.success(trafficLaws, "Actualité enregistré");
        } catch (Exception e) {
            return CResponse.error("Une erreur est survenue!");
        }
    }

    public CResponse<TrafficLaws> updateLaws(TrafficLaws trafficLaws, MultipartFile photo) {
        try {
            Optional<TrafficLaws> trafficLawsOptional = trafficLawsRepository.findById(trafficLaws.getId());
            if (photo == null) {
                if (trafficLawsOptional.isPresent()) {
                    TrafficLaws trafficLawsUpdated = trafficLawsRepository.save(trafficLaws);
                    return CResponse.success(trafficLawsUpdated, "Code de la route enregistré");
                }
                return CResponse.error("Ce code n'existe pas !");
            }
            if (trafficLawsOptional.isPresent()) {
                trafficLaws.setPath(uploadImageService.updateImage(photo, Constants.NEWS_DOWNLOAD_LINK, trafficLawsOptional.get().getPath()));
                TrafficLaws trafficLawsUpdated = trafficLawsRepository.save(trafficLaws);
                return CResponse.success(trafficLawsUpdated, "Code de la route modifié");
            }
            return CResponse.error("Cette code n'existe pas !");

        } catch (Exception e) {
            return CResponse.error("Une erreur est survenue!");
        }
    }
}
