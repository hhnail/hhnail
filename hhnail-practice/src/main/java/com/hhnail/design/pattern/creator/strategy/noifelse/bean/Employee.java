package com.hhnail.design.pattern.creator.strategy.noifelse.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.junit.Test;

/**
 * @author Hhnail
 * @version 1.0
 * @description: TODO
 * @date 2023/1/21 10:40
 */

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

    private Long id;
    private String name;
    private Integer level;

}
