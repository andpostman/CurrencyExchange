package com.andpostman.currencyexchange.controller;

import com.andpostman.currencyexchange.service.CurrencyServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CurrencyController.class)
@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
@DisplayName("Операции контроллера с exchange rate")
class CurrencyControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private CurrencyServiceImpl service;

//    @Test
//    @DisplayName("Проверка получения BestExchangeRate from object")
//    void whenSendBodyAsObject_thenReturns200() throws Exception{
//        BestExchangeRate employee = new BestExchangeRate("USD","RUB");
//        employee.setBestSaleRate(new ArrayList<>());
//        employee.setBestPurchaseRate(new ArrayList<>());
//        mockMvc.perform(post("/exchangeCurrencyRate")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(objectMapper.writeValueAsString(employee)))
//                .andExpect(status().isOk());
//    }

    @Test
    @DisplayName("Проверка получения BestExchangeRate from curl")
    void whenSendValuesAsCurlBody_thenReturns200() throws Exception {
        mockMvc.perform(post("/exchange")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"baseCurrency\": \"USD\",\"targetCurrency\": \"RUB\"}"))
                .andExpect(status().isOk());
    }
}
