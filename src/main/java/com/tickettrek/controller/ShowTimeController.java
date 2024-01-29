package com.tickettrek.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tickettrek.dtos.ShowTimeDTO;
import com.tickettrek.mapper.ShowtimeMapper;
import com.tickettrek.module.ShowTime;
import com.tickettrek.services.ShowTimeService;

@RestController
@RequestMapping("/api/showtimes")
public class ShowTimeController {

    @Autowired
    private ShowTimeService showTimeService;
    @Autowired
    private ShowtimeMapper showtimeMapper;
    

    // Create a new ShowTime
    @PostMapping("/create")
    public ResponseEntity<ShowTimeDTO> createShowTime(@RequestBody ShowTimeDTO showTimeDTO) {
        ShowTime createdShowTime = showTimeService.createShowTime(showtimeMapper.toModule(showTimeDTO));
        ShowTimeDTO createdShowTimeDTO = showtimeMapper.toDTO(createdShowTime);
        return new ResponseEntity<>(createdShowTimeDTO, HttpStatus.CREATED);
    }

    // Update an existing ShowTime by ID
    @PutMapping("/{id}")
    public ResponseEntity<ShowTime> updateShowTime(@PathVariable Integer id, @RequestBody ShowTime showTime) {
        ShowTime updatedShowTime = showTimeService.update(id, showTime);
        if (updatedShowTime != null) {
            return new ResponseEntity<>(updatedShowTime, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Get a ShowTime by ID
    @GetMapping("/{id}")
    public ResponseEntity<ShowTime> getShowTimeById(@PathVariable Integer id) {
        ShowTime showTime = showTimeService.getShowTimeById(id);
        if (showTime != null) {
            return new ResponseEntity<>(showTime, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Get all ShowTimes
    @GetMapping
    public ResponseEntity<List<ShowTime>> getAllShowTimes() {
        List<ShowTime> showTimes = showTimeService.getAllShowTime();
        return new ResponseEntity<>(showTimes, HttpStatus.OK);
    }
}