package com.java.can.config;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tel.schich.javacan.*;

import java.io.IOException;
import java.time.Duration;

/**
 * 底盘数据采集
 *
 * @author Eugen
 */
@Slf4j
public class CanChannelServer {

    public static RawCanChannel channel;

    public static RawCanChannel collect(String canPort) {
        log.info("start collect chassis data");
        try {
            channel = CanChannels.newRawChannel();
            Duration timeout = Duration.ofSeconds(3);
            channel.bind(NetworkDevice.lookup(canPort));
            // 阻塞式数据采集方式
            channel.configureBlocking(true);
            channel.setOption(CanSocketOptions.SO_RCVTIMEO, timeout);
        } catch (Exception e) {
            log.error("collect data error.", e);
        }
        return channel;
    }

}
