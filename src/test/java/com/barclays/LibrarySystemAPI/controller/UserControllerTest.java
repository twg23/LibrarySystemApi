package com.barclays.LibrarySystemAPI.controller;

import com.barclays.LibrarySystemAPI.model.Book;
import com.barclays.LibrarySystemAPI.model.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;
@Sql("classpath:test-data.sql")
@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@TestPropertySource(properties = {"spring.sql.init.mode=never"})
class UserControllerTest {


    @Autowired
    MockMvc mockMvc;
    ObjectMapper mapper;
    ResultActions resultActions;
    @BeforeEach
    void setUp() {
    }

    @Test
    void searchByTitle() throws Exception {

        String expectedTitle = "Mirror Mirror";
        ResultActions resultActions = this.mockMvc.perform(MockMvcRequestBuilders.get("/title")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());

        MvcResult result = resultActions.andReturn();
        String contentAsString = result.getResponse().getContentAsString();
        Book bookTitle = mapper.readValue(contentAsString, Book.class);

        assertAll("Testing from a test-data.sql file",
                () -> assertEquals(expectedTitle, bookTitle));

    }

    @Test
    void findAllBooks() {
    }

    @Test
    void searchByAuthor() {
    }

    @Test
    void searchByGenre() {
    }
}