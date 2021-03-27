package com.linebot.airtable.table;

import com.linebot.airtable.entity.Log;
import com.tryadhawk.airtable.Airtable;
import com.tryadhawk.airtable.SyncTable;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class LogTable {

    private final Airtable airtable;

    public LogTable(Airtable airtable){
        this.airtable = airtable;
    }

    @Bean
    public SyncTable<Log> logSyncTable(){
        return airtable.buildSyncTable("appfl57y6H0tshiaY", "Log_test copy", Log.class);

    }

}
