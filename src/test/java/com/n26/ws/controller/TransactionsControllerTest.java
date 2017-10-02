package com.n26.ws.controller;

import com.n26.ws.controllers.TransactionsController;
import com.n26.ws.domains.ImmutableTransaction;
import com.n26.ws.domains.Transaction;
import com.n26.ws.exceptions.InvalidTimestampException;
import com.n26.ws.services.StatisticsService;
import com.n26.ws.validation.WithinLastMinuteValidator;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyZeroInteractions;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@WebMvcTest(TransactionsController.class)
public class TransactionsControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private StatisticsService statisticsService;


    @Before
    public void setUp() throws Exception {
        WithinLastMinuteValidator.CURRENT_MILLIS = () -> 1478192204000L;
    }

    @Test
    public void shouldAcceptValidRequest() throws Exception {
        mvc.perform(post("/transactions")
                            .contentType("application/json")
                            .content("{\"amount\": 12.3,\"timestamp\": 1478192204000}"))
                .andExpect(status().isCreated())
                .andExpect(content().bytes(new byte[0]));

       verify(statisticsService).record(ImmutableTransaction.of(12.3, 1478192204000L));
    }

    @Test
    public void shouldValidateRequest() throws Exception {
        mvc.perform(post("/transactions")
                            .contentType("application/json")
                            .content("{\"timestamp\": 0}"))
                .andExpect(status().isNoContent())
                .andExpect(content().bytes(new byte[0]));

        verifyZeroInteractions(statisticsService);
    }

    @Test
    public void shouldHandleInvalidTimestampException() throws Exception {
        doThrow(new InvalidTimestampException(""))
                .when(statisticsService).record(any(Transaction.class));

        mvc.perform(post("/transactions")
                            .contentType("application/json")
                            .content("{\"amount\": 12.3,\"timestamp\": 1478192204000}"))
                .andExpect(status().isNoContent())
                .andExpect(content().bytes(new byte[0]));
    }
}