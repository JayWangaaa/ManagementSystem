package com.hqu.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Message {
    private Integer id;
    private String name;
    private String link;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}
