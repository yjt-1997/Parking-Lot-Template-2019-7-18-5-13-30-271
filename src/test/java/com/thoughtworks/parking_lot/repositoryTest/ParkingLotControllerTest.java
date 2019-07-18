package com.thoughtworks.parking_lot.repositoryTest;

import com.thoughtworks.parking_lot.dao.ParkingLotRepository;
import com.thoughtworks.parking_lot.entity.ParkingLot;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
@ExtendWith(SpringExtension.class)
public class ParkingLotControllerTest {

    @Autowired
    private ParkingLotRepository parkingLotRepository;

    @Test
    void should_save_parking_lot() {
        ParkingLot parkingLot = new ParkingLot();
        parkingLot.setName("TestSave");

        parkingLotRepository.save(parkingLot);
        ParkingLot fetchLot = parkingLotRepository.findAllByName("TestSave").get(0);
        
        assertNotNull(fetchLot);
    }
}
