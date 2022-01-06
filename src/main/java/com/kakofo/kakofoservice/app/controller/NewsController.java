package com.kakofo.kakofoservice.app.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kakofo.kakofoservice.app.entity.News;
import com.kakofo.kakofoservice.base.response.CResponse;
import com.kakofo.kakofoservice.app.services.NewService;
import com.kakofo.kakofoservice.utils.Constants;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
@RequestMapping("/news")
public class NewsController {
    private final NewService newService;

    public NewsController(NewService newService) {
        this.newService = newService;
    }

    @PostMapping("/save")
    public CResponse<News> saveNews(@RequestParam("news") String newString,
                                    @RequestParam("photo") MultipartFile photo) throws JsonProcessingException {
        News news = new ObjectMapper().readValue(newString, News.class);
        return newService.saveNews(news, photo);
    }

    @PostMapping("/update")
    public CResponse<News> updateNews(@RequestParam("news") String newString,
                                    @RequestParam(value = "photo") MultipartFile photo) throws JsonProcessingException {
        News news = new ObjectMapper().readValue(newString, News.class);
        return newService.update(news, photo);
    }

    @PostMapping("/simple-update")
    public CResponse<News> simpleUpdateNews(@RequestBody News news) throws JsonProcessingException {
        return newService.simpleUpdate(news);
    }
    @PostMapping("/liste-pagination")
    public CResponse<Page<News>>getNewsByPage(@RequestParam("page") int page,
                                                   @RequestParam("size") int size) {
        return newService.getNews(page, size);
    }
    @ResponseBody
    @GetMapping("/download/{photo}")
    public ResponseEntity<ByteArrayResource> getImage(@PathVariable("photo") String photo) {
        String path = Constants.NEWS_DOWNLOAD_LINK;
        try {
            Path fileName = Paths.get(path, photo);
            byte[] buffer = Files.readAllBytes(fileName);
            ByteArrayResource byteArrayResource = new ByteArrayResource(buffer);
            return ResponseEntity.ok()
                    .contentLength(buffer.length)
                    .contentType(MediaType.parseMediaType("image/png"))
                    .body(byteArrayResource);
        } catch (Exception e) {
            // TODO: handle exception
        }
        return ResponseEntity.badRequest().build();
    }
}
