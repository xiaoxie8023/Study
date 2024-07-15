package org.example.springmvctext;

import lombok.Data;

/**
 * program: SpringMvcText
 * <p>
 * description: 留言版类
 * <p>
 * author: xiaoxie
 * <p>
 * create: 2024-07-15 12:30
 **/
@Data
public class MessageInfo {
    public String from;
    public String to;
    public String say;
}
