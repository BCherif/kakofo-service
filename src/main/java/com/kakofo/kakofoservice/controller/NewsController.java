package com.kakofo.kakofoservice.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kakofo.kakofoservice.app.entity.News;
import com.kakofo.kakofoservice.base.response.CResponse;
import com.kakofo.kakofoservice.services.NewService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

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
}
