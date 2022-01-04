package com.kakofo.kakofoservice.services;


import com.kakofo.kakofoservice.app.entity.News;
import com.kakofo.kakofoservice.base.response.CResponse;
import com.kakofo.kakofoservice.repositories.NewRepository;
import com.kakofo.kakofoservice.utils.Constants;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

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
}
