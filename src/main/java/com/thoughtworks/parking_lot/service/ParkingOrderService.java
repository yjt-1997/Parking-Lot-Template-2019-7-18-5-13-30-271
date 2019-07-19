package com.thoughtworks.parking_lot.service;

import com.thoughtworks.parking_lot.dao.ParkingLotRepository;
import com.thoughtworks.parking_lot.dao.ParkingOrderRepository;
import com.thoughtworks.parking_lot.entity.ParkingLot;
import com.thoughtworks.parking_lot.entity.ParkingOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParkingOrderService {

    @Autowired
    private ParkingOrderRepository parkingOrderRepository;
    @Autowired
    private ParkingLotRepository parkingLotRepository;

    public ParkingOrder parkCar(ParkingOrder parkingOrder) throws Exception {
        ParkingLot parkingLot = parkingLotRepository.findAllByName(parkingOrder.getLotName()).get(0);
        int parkingCarCount = parkingLot.getParkingOrders().size();
        if (parkingCarCount >= parkingLot.getCapacity()) {
            throw new Exception();
        } else {
            parkingOrderRepository.save(parkingOrder);
            List<ParkingOrder> orders = parkingLot.getParkingOrders();
            orders.add(parkingOrder);
            return parkingOrder;
        }
    }

    public void fetchCar(int orderId) throws Exception {
        ParkingOrder parkingOrder = parkingOrderRepository.findById(orderId).orElse(null);
        if (parkingOrder == null) {
            throw new Exception();
        }
        ParkingLot parkingLot = parkingLotRepository.findAllByName(parkingOrder.getLotName()).get(0);
        parkingOrder.setEndTime(System.currentTimeMillis());
        parkingOrder.setOrderStatus(false);
        parkingOrderRepository.save(parkingOrder);
        List<ParkingOrder> orders = parkingLot.getParkingOrders();
        orders.remove(parkingOrder);
    }
}
