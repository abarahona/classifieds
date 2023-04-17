package com.searchclassifieds.searchclassifieds.controller;

import com.searchclassifieds.searchclassifieds.model.Classified;
import com.searchclassifieds.searchclassifieds.service.ClassifiedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

@RestController
public class ClassifiedsController {

    @Autowired
    ClassifiedService classifiedService;

    @RequestMapping(value = "/prueba", method = RequestMethod.GET)
    public Classified getById() {
        Classified classified = new Classified(1, "peugeot 504 nafta prueba", "peugeot 504 prueba model 1982", new BigDecimal(10000));
        System.out.println("classifeds" + classified.toString());
        classifiedService.save(classified);
        return classified;
    }

    @RequestMapping(value = "/item",method = RequestMethod.POST)
    public ResponseEntity<Classified> save(@RequestBody Map<String, Object> classified) {
        Classified classifiedToSave = new Classified(1, classified.get("title").toString(), classified.get("description").toString(), new BigDecimal(20000));
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
        return new ResponseEntity<>(classifiedList, HttpStatus.OK);
	}

    @RequestMapping(value = "/classifieds/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    ResponseEntity<Classified> getClassifiedById(@PathVariable Integer id) {
        Classified classified = classifiedService.getClassifiedById(id);
        System.out.println(classified.toString());
        return new ResponseEntity<>(classified, HttpStatus.OK);
    }

@RequestMapping(value = "/debug" ,method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
        @ResponseBody
    public ResponseEntity<List<Classified>> debug() {
        String multilines = "En el campo \n \n las espinas \n y en el centro de tu";
        List<String> lines = multilines.lines()
                .filter(line -> !line.isBlank())
                .map(String::strip)
                .collect(Collectors.toList());
        /*
        List<Classified> classifiedList = classifiedService.getClassifieds();
        List<Classified> classifiedsResponse = new ArrayList<>();

        BigDecimal totalPrice = classifiedList.stream()
                .map(item -> item.getPrice())
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        System.out.println("Total Price classifieds: " + totalPrice);

        Classified classifiedfound = classifiedList.stream()
                .filter(classified -> classified.getTitle().equals("peugeot 504 nafta prueba")).findAny().orElse(null);
        //classifiedList.forEach((classified) -> { classifiedsResponse.add(classified); });
        if(!Objects.isNull(classifiedfound)) classifiedsResponse.add(classifiedfound);
        return new ResponseEntity<>(classifiedsResponse, HttpStatus.OK);
        */
        return null;
    }



}
