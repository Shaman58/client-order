package com.shmonin.clientorder.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.shmonin.clientorder.dto.ClientDto;
import com.shmonin.clientorder.exception.EntityNotFoundException;
import com.shmonin.clientorder.exception.ExceptionData;
import com.shmonin.clientorder.model.Client;
import java.util.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;

import static com.shmonin.clientorder.exception.ExceptionMessage.CLIENT;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@TestPropertySource("classpath:integration-test.properties")
@SpringBootTest
@AutoConfigureMockMvc
@Sql(scripts = {"classpath:schema.sql", "classpath:sql-data.sql"})
class ClientControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        objectMapper = new ObjectMapper();
    }

    @Test
    void givenClientAllGetRequest_whenFindAll_thenReturnedJsonWithAllClients() throws Exception {
        var clients = new ArrayList<>();
        var client1 = new ClientDto();
        client1.setName("person1");
        client1.setPhoneNumber(111111);
        client1.setTaxpayerIdentificationNumber(123456789);
        client1.setSettlement("settlement1");
        client1.setRegionCode(1);
        client1.setStreet("street1");
        client1.setHouseNumber(1);
        client1.setBuildingNumber(1);
        client1.setRoomNumber(1);
        var client2 = new ClientDto();
        client2.setName("person2");
        client2.setPhoneNumber(222222);
        client2.setTaxpayerIdentificationNumber(987654321);
        client2.setSettlement("settlement2");
        client2.setRegionCode(2);
        client2.setStreet("street2");
        client2.setHouseNumber(2);
        client2.setBuildingNumber(2);
        client2.setRoomNumber(2);
        var client3 = new ClientDto();
        client3.setName("person3");
        client3.setPhoneNumber(333333);
        client3.setTaxpayerIdentificationNumber(123454321);
        client3.setSettlement("settlement3");
        client3.setRegionCode(3);
        client3.setStreet("street3");
        client3.setHouseNumber(3);
        client3.setBuildingNumber(3);
        client3.setRoomNumber(3);
        clients.add(client1);
        clients.add(client2);
        clients.add(client3);
        var expected = objectMapper.writeValueAsString(clients);

        this.mockMvc.perform(get("/client/all"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(expected));
    }

    @Test
    void givenClientIdGetRequest_whenFindById_thenReturnedJsonWithCurrentClient() throws Exception {
        var client = new ClientDto();
        client.setName("person1");
        client.setPhoneNumber(111111);
        client.setTaxpayerIdentificationNumber(123456789);
        client.setSettlement("settlement1");
        client.setRegionCode(1);
        client.setStreet("street1");
        client.setHouseNumber(1);
        client.setBuildingNumber(1);
        client.setRoomNumber(1);
        var expected = objectMapper.writeValueAsString(client);

        this.mockMvc.perform(get("/client/1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(expected));
    }

    @Test
    void givenWrongClientIdGetRequest_whenFindById_thenReturnedJsonWithErrorMessage() throws Exception {
        var expected = objectMapper.writeValueAsString(new ExceptionData(
                new EntityNotFoundException(CLIENT.getMessage(10L)).getMessage()
        ));

        this.mockMvc.perform(get("/client/10"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(expected));
    }

    @Test
    void givenClientPutRequestWithJson_whenSave_thenReturnedTheSameJson() throws Exception {
        var client = new Client();
        client.setName("person4");
        client.setPhoneNumber(444444);
        client.setTaxpayerIdentificationNumber(123412345);
        client.setSettlement("settlement4");
        client.setRegionCode(4);
        client.setStreet("street4");
        client.setHouseNumber(4);
        client.setBuildingNumber(4);
        client.setRoomNumber(4);
        var expected = objectMapper.writeValueAsString(client);

        this.mockMvc.perform(put("/client")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(expected))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(expected));
    }
}