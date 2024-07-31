package org.example.springmvctext;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * program: SpringMvcText
 * <p>
 * description: 留言板
 * <p>
 * author: xiaoxie
 * <p>
 * create: 2024-07-15 10:33
 **/
@RestController
@RequestMapping("/message")
public class MessageController {
    public List<MessageInfo> messageInfos = new ArrayList<MessageInfo>();
    @RequestMapping("/publish")
    public boolean publish (@RequestBody MessageInfo messageInfo) {
        //打印日志
        System.out.println("发表留言成功");
        messageInfos.add(messageInfo);
        return true;
    }
    @RequestMapping("/getList")
    public List<MessageInfo> getList () {
        return messageInfos;
    }
}
