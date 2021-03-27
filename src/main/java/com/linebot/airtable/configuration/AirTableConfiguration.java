package com.linebot.airtable.configuration;

import com.linebot.airtable.entity.Log;
import com.tryadhawk.airtable.Airtable;
import com.tryadhawk.airtable.AsyncTable;
import com.tryadhawk.airtable.Configuration;
import com.tryadhawk.airtable.SyncTable;
import org.springframework.context.annotation.Bean;

@org.springframework.context.annotation.Configuration
public class AirTableConfiguration {


    @Bean
    public Airtable getAirTableBase(){
        Airtable airtable = Airtable.builder()
                .config(Configuration.builder().apiKey("keycPi0WBRNXVMtiW").build())
                .build();
        return airtable;
    }



}
