package com.hqu.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Food {
    private Integer id;
    private String name;
    private String location;
    private String introduction;
    private String score;
    private String picture;
}
