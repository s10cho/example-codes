package com.spring.sample.accessing.jpa.data.rest;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.spring.sample.accessing.jpa.data.rest.person.repository.PersonRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;


@SpringBootTest
@AutoConfigureMockMvc
class AccessingDataRestApplicationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private PersonRepository personRepository;

    @BeforeEach
    public void deleteAllBeforeTests() {
        personRepository.deleteAll();
    }

    @Test
    void shouldReturnRepositoryIndex() throws Exception {

        mockMvc.perform(get("/")).andDo(print()).andExpect(status().isOk()).andExpect(
            jsonPath("$._links.people").exists());
    }

    @Test
    void shouldCreateEntity() throws Exception {

        mockMvc.perform(post("/people").content(
            "{\"firstName\": \"Frodo\", \"lastName\":\"Baggins\"}")).andExpect(
            status().isCreated()).andExpect(
            header().string("Location", containsString("people/")));
    }

    @Test
    void shouldRetrieveEntity() throws Exception {

        MvcResult mvcResult = mockMvc.perform(post("/people").content(
            "{\"firstName\": \"Frodo\", \"lastName\":\"Baggins\"}")).andExpect(
            status().isCreated()).andReturn();

        String location = mvcResult.getResponse().getHeader("Location");
        mockMvc.perform(get(location)).andExpect(status().isOk()).andExpect(
            jsonPath("$.firstName").value("Frodo")).andExpect(
            jsonPath("$.lastName").value("Baggins"));
    }

    @Test
    void shouldQueryEntity() throws Exception {

        mockMvc.perform(post("/people").content(
            "{ \"firstName\": \"Frodo\", \"lastName\":\"Baggins\"}")).andExpect(
            status().isCreated());

        mockMvc.perform(
            get("/people/search/findByLastName?name={name}", "Baggins")).andExpect(
            status().isOk()).andExpect(
            jsonPath("$._embedded.people[0].firstName").value(
                "Frodo"));
    }

    @Test
    void shouldUpdateEntity() throws Exception {

        MvcResult mvcResult = mockMvc.perform(post("/people").content(
            "{\"firstName\": \"Frodo\", \"lastName\":\"Baggins\"}")).andExpect(
            status().isCreated()).andReturn();

        String location = mvcResult.getResponse().getHeader("Location");

        mockMvc.perform(put(location).content(
            "{\"firstName\": \"Bilbo\", \"lastName\":\"Baggins\"}")).andExpect(
            status().isNoContent());

        mockMvc.perform(get(location)).andExpect(status().isOk()).andExpect(
            jsonPath("$.firstName").value("Bilbo")).andExpect(
            jsonPath("$.lastName").value("Baggins"));
    }

    @Test
    void shouldPartiallyUpdateEntity() throws Exception {

        MvcResult mvcResult = mockMvc.perform(post("/people").content(
            "{\"firstName\": \"Frodo\", \"lastName\":\"Baggins\"}")).andExpect(
            status().isCreated()).andReturn();

        String location = mvcResult.getResponse().getHeader("Location");

        mockMvc.perform(
            patch(location).content("{\"firstName\": \"Bilbo Jr.\"}")).andExpect(
            status().isNoContent());

        mockMvc.perform(get(location)).andExpect(status().isOk()).andExpect(
            jsonPath("$.firstName").value("Bilbo Jr.")).andExpect(
            jsonPath("$.lastName").value("Baggins"));
    }

    @Test
    void shouldDeleteEntity() throws Exception {

        MvcResult mvcResult = mockMvc.perform(post("/people").content(
            "{ \"firstName\": \"Bilbo\", \"lastName\":\"Baggins\"}")).andExpect(
            status().isCreated()).andReturn();

        String location = mvcResult.getResponse().getHeader("Location");
        mockMvc.perform(delete(location)).andExpect(status().isNoContent());

        mockMvc.perform(get(location)).andExpect(status().isNotFound());
    }
}
