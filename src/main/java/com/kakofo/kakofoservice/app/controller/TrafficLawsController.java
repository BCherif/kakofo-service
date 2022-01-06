package com.kakofo.kakofoservice.app.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kakofo.kakofoservice.app.entity.TrafficLaws;
import com.kakofo.kakofoservice.app.services.TrafficLawsService;
import com.kakofo.kakofoservice.base.response.CResponse;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/traffic-laws")
public class TrafficLawsController {
    private final TrafficLawsService trafficLawsService;

    public TrafficLawsController(TrafficLawsService trafficLawsService) {
        this.trafficLawsService = trafficLawsService;
    }


    @PostMapping("/save")
    public CResponse<TrafficLaws> saveTrafficLaws(@RequestParam("news") String newString,
                                    @RequestParam("photo") MultipartFile photo) throws JsonProcessingException {
        TrafficLaws news = new ObjectMapper().readValue(newString, TrafficLaws.class);
        return trafficLawsService.saveTrafficLaws(news, photo);
    }

    @PostMapping("/update")
    public CResponse<TrafficLaws> updateTrafficLaws(@RequestParam("news") String newString,
                                      @RequestParam("photo") MultipartFile photo) throws JsonProcessingException {
        TrafficLaws news = new ObjectMapper().readValue(newString, TrafficLaws.class);
        return trafficLawsService.updateLaws(news, photo);
    }
    @PostMapping("/liste-pagination")
    public CResponse<Page<TrafficLaws>>getTrafficLawsByPage(@RequestParam("page") int page,
                                              @RequestParam("size") int size) {
        return trafficLawsService.getTrafficLaws(page, size);
    }
}
