package com.linebot.airtable;

import com.linebot.airtable.entity.Log;
import com.tryadhawk.airtable.SyncTable;
import com.tryadhawk.airtable.v0.Record;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
@Slf4j
public class AirTableService {

    private final SyncTable<Log> logTable;

    public AirTableService(SyncTable<Log> logTable) {
        this.logTable = logTable;
    }

    public Record<Log> create(Log log) {

        return logTable.create(log);
    }

    public List<Record<Log>> getAll(){
        return logTable.select();
    }

//    public void deleteAll(){
//        logTable.delete();
//    }
}
