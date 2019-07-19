package com.thoughtworks.parking_lot.controller;

import com.thoughtworks.parking_lot.entity.ParkingOrder;
import com.thoughtworks.parking_lot.service.ParkingOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ParkingOrderController {

    @Autowired
    private ParkingOrderService parkingOrderService;

    @PostMapping("/orders")
    public ResponseEntity<ParkingOrder> parkCar(@RequestBody ParkingOrder parkingOrder) throws Exception {
        return ResponseEntity.status(HttpStatus.CREATED).body(parkingOrderService.parkCar(parkingOrder));
    }

    @PutMapping("/orders/{id}")
    public void fetchCar(@PathVariable int orderId) throws Exception {
        parkingOrderService.fetchCar(orderId);
    }
}
