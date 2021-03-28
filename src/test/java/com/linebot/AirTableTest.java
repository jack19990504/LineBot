package com.linebot;

import com.linebot.airtable.AirTableService;
import com.linebot.airtable.entity.Log;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@Slf4j
public class AirTableTest {

    @Autowired
    private AirTableService airTableService;

    @Autowired
    private MockMvc mockMvc;

    int size = 0;

    @Before
    public void init(){
        size = airTableService.getAll().size();
        log.info("size = " + size);
    }

    @Test
    public void contextLoads() {
    }

    @Test
    public void postLog() throws Exception {
        var requestBuilder = MockMvcRequestBuilders.post("/test");

        var log = prepareLog("jack", "mvc test");

        mockMvc.perform(requestBuilder)
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").hasJsonPath())
                .andExpect(jsonPath("$.fields.user").value(log.getUser()))
                .andExpect(jsonPath("$.fields.text").value(log.getText()));
    }

    @Test
    public void getLogList() throws Exception {
        var requestBuilder = MockMvcRequestBuilders.get("/test");

        mockMvc.perform(requestBuilder)
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$",hasSize(size)));
    }


    private Log prepareLog(String user, String text){
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        return new Log(user, text, now.format(formatter), "Yes");
    }

}
