package com.thoughtworks.parking_lot.service;

import com.thoughtworks.parking_lot.dao.ParkingLotRepository;
import com.thoughtworks.parking_lot.entity.ParkingLot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParkingLotService {

    @Autowired
    private ParkingLotRepository parkingLotRepository;

    public ParkingLot save(ParkingLot parkingLot) {
        return parkingLotRepository.save(parkingLot);
    }

    public void delete(ParkingLot parkingLot) {
        parkingLotRepository.delete(parkingLot);
    }

    /**
     * 还未实现分页，等待修改
     *
     * @return
     */
    public List<ParkingLot> list(int page) {
        return parkingLotRepository.findAll(PageRequest.of(page, 15)).getContent();
    }

    public ParkingLot findByName(String name) {
        List<ParkingLot> findResult = parkingLotRepository.findAllByName(name);
        return findResult == null ? null : findResult.get(0);
    }

    public ParkingLot update(ParkingLot parkingLot) {
        return parkingLotRepository.save(parkingLot);
    }

    public void fetchCar(String carNumber) {

    }
}
