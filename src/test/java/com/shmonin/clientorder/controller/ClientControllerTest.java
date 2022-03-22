package com.shmonin.clientorder.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@TestPropertySource("classpath:integration-test.properties")
@SpringBootTest
@AutoConfigureMockMvc
@Sql(scripts = {"classpath:schema.sql", "classpath:sql-data.sql"})
class ClientControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void findAll() throws Exception {
        this.mockMvc.perform(get("/client/all"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json("[{\"name\":\"person1\",\"phoneNumber\":111111,\"taxpayerIdentificationNumber\":123456789,\"regionCode\":1,\"settlement\":\"settlement1\",\"street\":\"street1\",\"houseNumber\":1,\"buildingNumber\":1,\"roomNumber\":1},{\"name\":\"person2\",\"phoneNumber\":222222,\"taxpayerIdentificationNumber\":987654321,\"regionCode\":2,\"settlement\":\"settlement2\",\"street\":\"street2\",\"houseNumber\":2,\"buildingNumber\":2,\"roomNumber\":2},{\"name\":\"person3\",\"phoneNumber\":333333,\"taxpayerIdentificationNumber\":123454321,\"regionCode\":3,\"settlement\":\"settlement3\",\"street\":\"street3\",\"houseNumber\":3,\"buildingNumber\":3,\"roomNumber\":3}]"));
    }

    @Test
    void findById() {
    }

    @Test
    void save() {
    }

    @Test
    void deleteById() {
    }
}