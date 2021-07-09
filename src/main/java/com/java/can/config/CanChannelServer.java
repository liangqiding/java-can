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
@Service
@Slf4j
public class CanChannelServer {

    public static RawCanChannel channel;

    public void collect() {
        log.info("start collect chassis data");
        try {
            channel = CanChannels.newRawChannel();
            Duration timeout = Duration.ofSeconds(3);
            channel.bind(NetworkDevice.lookup("can0"));
            // 阻塞式数据采集方式
            channel.configureBlocking(true);
            channel.setOption(CanSocketOptions.SO_RCVTIMEO, timeout);
            CanFrame output;
            while (true) {
                output = channel.read();
                int base = output.getBase();
                int id = output.getId();
                int rawId = output.getRawId();
                int size = output.getSize();
                log.info("base{},id{},rawId{},size{}", base, id, rawId, size);
                log.info("读取到数据{}", output);
                // 线程停止10ms
                Thread.sleep(500);
            }
        } catch (IOException e) {
            log.error("collect data error.", e);
        } catch (InterruptedException e) {
            log.error("thread error", e);
        }
    }

}
