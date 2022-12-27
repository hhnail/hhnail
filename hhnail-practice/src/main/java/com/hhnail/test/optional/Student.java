package com.hhnail.test.optional;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
public class Student {

    private Long id;
    private String name;
    private Integer age;

}