package com.barclays.LibrarySystemAPI.controller;

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
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;
@Sql("classpath:test-data.sql")
@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@TestPropertySource(properties = {"spring.sql.init.mode=never"})
class MovieTestWithMockHttpRequest {

    @Autowired
    MockMvc mockMvc;
    ObjectMapper mapper;
    ResultActions resultActions;

    @BeforeEach
    void setUp() {
    }

    @Test
    void searchMovieByTitle() {

        ResultActions resultActions = this.mockMvc.perform(MockMvcRequestBuilders.get("/people/{id}", personId)
                        .contentType(MediaType.APPLICATION_JSON) //specify the content type of the request
                        .accept(MediaType.APPLICATION_JSON)) //specify the  expected content type of the response.
                .andExpect(MockMvcResultMatchers.status().isOk()); //asserts that the HTTP response status is OK (200).
    }

    @Test
    void searchMovieByAuthorContaining() {
    }

    @Test
    void searchMovieByGenre() {
    }

    @Test
    void findAllMovies() {
    }
}