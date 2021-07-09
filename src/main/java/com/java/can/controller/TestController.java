package com.java.can.controller;

import com.java.can.config.CanChannelServer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tel.schich.javacan.CanFrame;

import java.io.IOException;

/**
 * description :
 *
 * @author : qiDing
 * date: 2021-07-08 17:02
 */
@RestController
@Slf4j
public class TestController {

    @RequestMapping("send")
    public String send(String msg) throws IOException {
        log.info("--------------send msg----------------------");
        if (CanChannelServer.channel != null && CanChannelServer.channel.isOpen()) {
            // int id, byte flags, byte[] data
            byte[] data = new byte[8];
            data[0] = 0X01;
            int canId = 0X02;
            CanFrame canFrame = CanFrame.create(canId, (byte) 0,data );
            CanChannelServer.channel.write(canFrame);
            return "发送成功";
        }
        return "发送失败";
    }
}
