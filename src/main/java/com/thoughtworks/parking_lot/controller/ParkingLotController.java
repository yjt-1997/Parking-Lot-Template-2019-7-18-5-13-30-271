package com.thoughtworks.parking_lot.controller;

import com.thoughtworks.parking_lot.entity.ParkingLot;
import com.thoughtworks.parking_lot.service.ParkingLotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ParkingLotController {

    @Autowired
    private ParkingLotService parkingLotService;

    @PostMapping("/parkinglots")
    public ResponseEntity<ParkingLot> save(@RequestBody ParkingLot parkingLot) {
        return ResponseEntity.status(HttpStatus.CREATED).body(parkingLotService.save(parkingLot));
    }

    @DeleteMapping("/parkinglots/{name}")
    public void deleteByName(@PathVariable String name){
        parkingLotService.deleteByName(name);
    }
}
