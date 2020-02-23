package com.evbox.chargingschedule.resources;

import com.evbox.chargingschedule.business.IChargingSessionBusiness;
import com.evbox.chargingschedule.dto.input.ChargingSessionDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest
public class ChargingSessionResourceTest {


    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private IChargingSessionBusiness business;

    @Test
    public void putChargingSession() throws Exception {
        ChargingSessionDTO chargingSessionDTO = new ChargingSessionDTO("2019.01.01T15.10.18"," EVB-1");

        mockMvc.perform(put("/chargingSession")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(chargingSessionDTO)))
                .andExpect(status().isOk());
    }

    @Test
    public void countChargingSessionInLastMinuteByStation() throws Exception {
        ChargingSessionDTO chargingSessionDTO = new ChargingSessionDTO("2019.01.01T15.10.18"," EVB-1");
        given(business.countChargingSessionInLastMinuteByStation(chargingSessionDTO.getStation())).willReturn(0);
         mockMvc.perform(get("/summary?station=" + chargingSessionDTO.getStation()))
        .andExpect(status().isOk())
                .andExpect(content().json("{'count' : 0}"));
    }
}