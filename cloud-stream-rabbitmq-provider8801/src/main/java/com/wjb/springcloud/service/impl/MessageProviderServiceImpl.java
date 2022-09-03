package com.wjb.springcloud.service.impl;

import com.wjb.springcloud.service.MessageProviderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * <b><code>MessageProviderServiceImpl</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2022/9/4 0:24.
 *
 * @author Arjun
 * @version 1.0.0
 * @since springcloud
 */
@Slf4j
@EnableBinding(Source.class)
public class MessageProviderServiceImpl implements MessageProviderService {

    @Resource
    private MessageChannel output;
    @Override
    public String send() {
        String s = UUID.randomUUID().toString();
        output.send(MessageBuilder.withPayload(s).build());
        log.info("serial:{}",s);
        return null;
    }
}
