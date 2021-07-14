package com.java.can.config;

import lombok.extern.slf4j.Slf4j;
import tel.schich.javacan.CanFrame;
import tel.schich.javacan.RawCanChannel;
import java.io.IOException;

/**
 * description :
 *
 * @author : qiDing
 * date: 2021-07-14 14:38
 */
@Slf4j
public class CanDataHandler {

    @SuppressWarnings("all")
    public static   void start() {
        RawCanChannel can0 = CanChannelServer.collect("can0");
        new Thread(() -> {
            CanFrame read;
            try {
                while (true) {
                    read = can0.read();
                    log.info("读取到数据为{}", read);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }

}
