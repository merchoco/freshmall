package com.kxmall.market.core.config.sms;

import com.kxmall.market.core.notify.QCloudSMSClient;
import com.kxmall.market.core.notify.AliyunSMSClient;
import com.kxmall.market.core.notify.MockSMSClient;
import com.kxmall.market.core.notify.SMSClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by admin on 2020/11/26.
 */
@Configuration
public class SMSConfig {

    @Value("${sms.enable}")
    private String enable;

    @Bean
    public SMSClient smsClient() {
        if ("qcloud".equals(enable)) {
            return new QCloudSMSClient();
        } else if ("aliyun".equals(enable)) {
            return new AliyunSMSClient();
        } else if ("mock".equals(enable)) {
            return new MockSMSClient();
        } else {
            return new MockSMSClient();
        }
    }
}
