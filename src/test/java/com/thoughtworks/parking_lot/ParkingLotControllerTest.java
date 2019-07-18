package com.thoughtworks.parking_lot;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.thoughtworks.parking_lot.controller.ParkingLotController;
import com.thoughtworks.parking_lot.entity.ParkingLot;
import com.thoughtworks.parking_lot.service.ParkingLotService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(ParkingLotController.class)
public class ParkingLotControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private ParkingLotService parkingLotService;

    @Test
    void should_save_parking_lot() throws Exception {
        ParkingLot parkingLot = new ParkingLot("P001", 100, "香洲区");

        when(parkingLotService.save(ArgumentMatchers.any())).thenReturn(parkingLot);
        mvc.perform(post("/parkinglots")
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(new ObjectMapper().writeValueAsString(parkingLot)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.name", is("P001")));
    }

    @Test
    void should_delte_parking_lot_given_parking_lot_name() throws Exception {
        ParkingLot parkingLot = new ParkingLot("P001", 100, "香洲区");

        mvc.perform(delete("/parkinglots/P001"))
                .andExpect(status().isOk());
        verify(parkingLotService).deleteByName("P001");
    }

    @Test
    void should_list_parking_lots() throws Exception {
        ParkingLot parkingLot = new ParkingLot("P001", 100, "香洲区");

        when(parkingLotService.list()).thenReturn(Arrays.asList(parkingLot, parkingLot, parkingLot));

        mvc.perform(get("/parkinglots"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(3)));
    }
}
