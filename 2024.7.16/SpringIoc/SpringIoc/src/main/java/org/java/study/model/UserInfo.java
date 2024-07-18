package org.java.study.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * program: SpringIoc
 * <p>
 * description: 用户对象
 * <p>
 * author: xiaoxie
 * <p>
 * create: 2024-07-18 08:43
 **/
@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserInfo {
    private int id;
    private String name;
}
