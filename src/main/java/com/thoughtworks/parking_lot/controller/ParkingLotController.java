package com.thoughtworks.parking_lot.controller;

import com.thoughtworks.parking_lot.entity.ParkingLot;
import com.thoughtworks.parking_lot.service.ParkingLotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ParkingLotController {

    @Autowired
    private ParkingLotService parkingLotService;

    @PostMapping("/parkinglots")
    public ResponseEntity<ParkingLot> save(@RequestBody ParkingLot parkingLot) {
        return ResponseEntity.status(HttpStatus.CREATED).body(parkingLotService.save(parkingLot));
    }

    @DeleteMapping("/parkinglots/{name}")
    public void deleteByName(@PathVariable String name) {
        parkingLotService.deleteByName(name);
    }

    @GetMapping("/parkinglots")
    public ResponseEntity<List<ParkingLot>> list() {
        return ResponseEntity.status(HttpStatus.OK).body(parkingLotService.list());
    }

    @GetMapping("/parkinglots/{name}")
    public ResponseEntity<ParkingLot> findByName(@PathVariable String name) {
        return ResponseEntity.status(HttpStatus.OK).body(parkingLotService.findByName(name));
    }

    @PutMapping("/parkinglots")
    public ResponseEntity<ParkingLot> update(@RequestBody ParkingLot parkingLot) {
        return ResponseEntity.status(HttpStatus.OK).body(parkingLotService.update(parkingLot));
    }
}
