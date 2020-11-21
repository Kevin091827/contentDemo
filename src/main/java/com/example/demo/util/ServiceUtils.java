/**
 * @(#)ServiceUtils.java, 2020/11/18.
 * <p/>
 * Copyright 2020 Netease, Inc. All rights reserved.
 * NETEASE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.example.demo.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

@Slf4j
public class ServiceUtils {

    /**
     * 取出身份证中的年龄，判断是否大于18岁
     *
     * @param cardId
     * @return
     */
    public static boolean checkAge(String cardId) {
        if (StringUtils.isEmpty(cardId)) {
            log.error("[op:checkAge] carId is empty str");
            return false;
        }
        String year = cardId.substring(6, 10);
        return Integer.parseInt(year) > 18;
    }

    public static void main(String[] args) {
        System.out.println(checkAge("4407811998"));
    }
}
