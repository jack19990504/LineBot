package com.linebot.airtable.entity;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@ToString
public class Log {
    private String user;
    private String text;
    private String time;
    private String returnSucceed;
}
