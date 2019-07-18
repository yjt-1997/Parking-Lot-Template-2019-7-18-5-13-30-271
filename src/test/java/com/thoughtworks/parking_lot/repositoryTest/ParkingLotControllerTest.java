package com.thoughtworks.parking_lot.repositoryTest;

import com.thoughtworks.parking_lot.dao.ParkingLotRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@DataJpaTest
@ExtendWith(SpringExtension.class)
public class ParkingLotControllerTest {

    @Autowired
    private ParkingLotRepository parkingLotRepository;

    @Test
    void should_save_parking_lot() {

    }
}
