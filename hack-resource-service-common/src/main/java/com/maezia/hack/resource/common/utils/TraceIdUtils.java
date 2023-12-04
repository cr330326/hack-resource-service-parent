package com.maezia.hack.resource.common.utils;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;

/**
 * @author : ChenRan
 * @date ： 2022/9/20 21:04
 * Description ：TraceIdUtils
 * project ：vwasp-greyservice-service-parent
 * dep : TT-32
 * company: MA
 */
@Slf4j
public final class TraceIdUtils {

    private TraceIdUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static String getTraceId() {
        try {
            return MDC.get("TraceId");
        } catch (Exception var1) {
            log.info("ignore exception. e = {}", var1.getMessage());
            return "";
        }
    }

    public static void clear() {
        try {
            MDC.clear();
        } catch (Exception var1) {
            log.info("ignore exception. e = {}", var1.getMessage());
        }

    }
}
