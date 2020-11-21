/**
 * @(#)QiniuProperties.java, 2020/11/21.
 * <p/>
 * Copyright 2020 Netease, Inc. All rights reserved.
 * NETEASE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.example.demo.config;

import com.qiniu.common.Zone;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Properties;

@Data
@ConfigurationProperties(prefix = "qiniu")
public class QiniuProperties {

    private String accessKey;

    private String secretKey;

    private String bucket;

    private String prefix;

    @Slf4j
    @Data
    public static class QiNiuConfig {
        private static QiNiuConfig instance = new QiNiuConfig();
        private String accessKey;
        private String secretKey;
        private String bucket;
        private Zone zone;
        private String domainOfBucket;
        private long expireInSeconds;

         QiNiuConfig() {
            Properties prop = new Properties();
            try {
                prop.load(QiNiuConfig.class.getResourceAsStream("/application.yml"));
                accessKey = prop.getProperty("qiniu.access-key");
                secretKey = prop.getProperty("qiniu.secret-key");
                bucket = prop.getProperty("qiniu.bucket");
                domainOfBucket = prop.getProperty("qiniu.domain-of-bucket");
                expireInSeconds = Long.parseLong(prop.getProperty("qiniu.expire-in-seconds"));
                String zoneName = prop.getProperty("qiniu.zone");
                if (zoneName.equals("zone0")) {
                    zone = Zone.zone0();
                } else if (zoneName.equals("zone1")) {
                    zone = Zone.zone1();
                } else if (zoneName.equals("zone2")) {
                    zone = Zone.zone2();
                } else if (zoneName.equals("zoneNa0")) {
                    zone = Zone.zoneNa0();
                } else if (zoneName.equals("zoneAs0")) {
                    zone = Zone.zoneAs0();
                } else {
                    throw new Exception("Zone对象配置错误！");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public static QiNiuConfig getInstance() {
            return instance;
        }

    }
}