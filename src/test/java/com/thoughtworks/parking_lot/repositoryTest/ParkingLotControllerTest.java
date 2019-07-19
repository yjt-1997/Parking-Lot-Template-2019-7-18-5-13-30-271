package com.thoughtworks.parking_lot.repositoryTest;

import com.thoughtworks.parking_lot.dao.ParkingLotRepository;
import com.thoughtworks.parking_lot.entity.ParkingLot;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.*;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

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

    @Test
    void should_delete_parking_lot() {
        ParkingLot parkingLot = new ParkingLot();
        parkingLot.setName("TestSave");

        parkingLotRepository.save(parkingLot);
        ParkingLot fetchLot = parkingLotRepository.findAllByName("TestSave").get(0);
        parkingLotRepository.delete(fetchLot);
        List<ParkingLot> after = parkingLotRepository.findAllByName("TestSave");
        ParkingLot afterDeleteLot = after.size() > 0 ? after.get(0) : null;

        assertNotNull(fetchLot);
        assertNull(afterDeleteLot);
    }

    @Test
    void should_list_parking_lots() {
        ParkingLot parkingLot1 = new ParkingLot("P001", 100, "香洲区");
        ParkingLot parkingLot2 = new ParkingLot("P002", 100, "香洲区");
        ParkingLot parkingLot3 = new ParkingLot("P003", 100, "香洲区");
        ParkingLot parkingLot4 = new ParkingLot("P004", 100, "香洲区");

        parkingLotRepository.saveAll(Arrays.asList(parkingLot1, parkingLot2, parkingLot3, parkingLot4));
        List<ParkingLot> fetchLots = parkingLotRepository.findAll(PageRequest.of(0, 2)).getContent();

        assertNotNull(fetchLots);
        assertEquals(fetchLots.size(), 2);
    }
}
