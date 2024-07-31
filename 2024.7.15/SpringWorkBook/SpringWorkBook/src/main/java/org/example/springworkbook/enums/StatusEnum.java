package org.example.springworkbook.enums;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
public enum StatusEnum {
    INVALID(0,"无效图书"),
    ALLOW(1,"可借阅"),
    FORBID(2,"不可借阅");

    @Getter
    private int code;
    @Getter
    private String statusName;
}
