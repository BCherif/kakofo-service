package com.kakofo.kakofoservice.app.services;


import com.kakofo.kakofoservice.app.entity.News;
import com.kakofo.kakofoservice.app.repositories.NewRepository;
import com.kakofo.kakofoservice.base.response.CResponse;
import com.kakofo.kakofoservice.utils.Constants;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Optional;

@Service
public class NewService {
    private final NewRepository newRepository;
    private final UploadImageService uploadImageService;

    public NewService(NewRepository newRepository, UploadImageService uploadImageService) {
        this.newRepository = newRepository;
        this.uploadImageService = uploadImageService;
    }

   public CResponse<News> saveNews(News news, MultipartFile photo) {
        try {
            news.setPath(uploadImageService.uploadImage(photo, Constants.NEWS_DOWNLOAD_LINK));
            News newsSaved = newRepository.save(news);
            return CResponse.success(newsSaved, "Actualité enregistré");
        } catch (Exception e) {
            return CResponse.error("Une erreur est survenue!");
        }
   }

    public CResponse<Page<News>> getNews(int page, int size) {
      try {
          Pageable paging = PageRequest.of(page, size);
          Page<News> news = newRepository.findAll(paging);
          return CResponse.success(news, "Actualité enregistré");
      } catch (Exception e) {
          return CResponse.error("Une erreur est survenue!");
      }
    }

    public CResponse<News> update(News news, MultipartFile photo) {
        try {
            Optional<News> newsOptional = newRepository.findById(news.getId());
            if (newsOptional.isPresent()) {
                news.setPath(uploadImageService.updateImage(photo, Constants.NEWS_DOWNLOAD_LINK, newsOptional.get().getPath()));
                News newsUpdated = newRepository.save(news);
                return CResponse.success(newsUpdated, "Actualité enregistré");
            }
            return CResponse.error("Cette actualité n'existe pas !");

        } catch (Exception e) {
            return CResponse.error("Une erreur est survenue!");
        }
    }

    public CResponse<News> simpleUpdate(News news) {
        try {
            Optional<News> newsOptional = newRepository.findById(news.getId());
            if (newsOptional.isPresent()) {
                News newsUpdated = newRepository.save(news);
                return CResponse.success(newsUpdated, "Actualité enregistré");
            }
            return CResponse.error("Cette actualité n'existe pas !");

        } catch (Exception e) {
            return CResponse.error("Une erreur est survenue!");
        }
    }
}
