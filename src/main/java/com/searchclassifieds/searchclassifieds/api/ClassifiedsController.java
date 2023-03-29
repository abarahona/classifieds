package com.searchclassifieds.searchclassifieds.api;

import com.searchclassifieds.searchclassifieds.dto.Classified;
import com.searchclassifieds.searchclassifieds.service.ClassifiedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
public class ClassifiedsController {

    @Autowired
    ClassifiedService classifiedService;

    @RequestMapping(value = "/prueba", method = RequestMethod.GET)
    public Classified getById() {
        Classified classified = new Classified(1L, "peugeot 504 nafta prueba", "peugeot 504 prueba model 1982");
        System.out.println("classifeds" + classified.toString());
        classifiedService.save(classified);
        return classified;
    }

    @RequestMapping(
            value = "/item",
            method = RequestMethod.POST
    )
    public ResponseEntity<Classified> save(@RequestBody Map<String, Object> classified) {
        Classified classifiedToSave = new Classified(1L, classified.get("title").toString(), classified.get("description").toString());
        HttpStatus httpStatus = null;
        try {
            classifiedService.save(classifiedToSave);
            httpStatus = HttpStatus.CREATED;
        } catch (Exception exception) {
            httpStatus = HttpStatus.INSUFFICIENT_STORAGE;
        }


        return new ResponseEntity<>(classifiedToSave, httpStatus);
    }

    @RequestMapping(value = "/classifieds" ,method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
    public ResponseEntity<List<Classified>> getClassifieds() {
		List<Classified> classifiedList = classifiedService.getClassifieds();
        List<Classified> classifiedsResponse = new ArrayList<>();
        classifiedList.forEach((classified) -> {
            if(!classified.getTitle().equals("peugeot 504 nafta prueba")) {
                classifiedsResponse.add(classified);
            }
        });
        return new ResponseEntity<>(classifiedsResponse, HttpStatus.OK);
	}
    

}
