package com.utils.common;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;


import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * MesUtils class
 *
 * @author yh
 * @date 2020/12/29
 */
public class MesUtils {
    /**
     * 生成随机数
     *
     * @return
     */
    public static BigDecimal randomNumber() {
        long time = (new Date()).getTime();
        Random rand = new Random();
        return BigDecimal.valueOf(time * 100 + rand.nextInt(100));
    }

    /**
     * traceId前缀
     *
     * @return
     */
    public static String traceId() {
        String time = LocalDateTime.ofInstant(new Date().toInstant(),
                ZoneId.systemDefault()).format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
        Random rand = new Random();
        return String.format("%s%04d", time, rand.nextInt(10000));
    }

    /**
     * traceId ip
     *
     * @return
     */
    public static String traceIp() {
        String ip = getIp();
        String[] ips = ip.split("\\.");
        if (ips.length == 4) {
            return String.format("%03d%03d%03d%03d", Integer.parseInt(ips[0]), Integer.parseInt(ips[1])
                    , Integer.parseInt(ips[2]), Integer.parseInt(ips[3]));
        } else {
            return "";
        }
    }

    /**
     * 获取ip地址
     *
     * @return
     */
    public static String getIp() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
        String remoteAddr = request.getRemoteAddr();
        String forwarded = request.getHeader("X-Forwarded-For");
        String realIp = request.getHeader("X-Real-IP");
        String ip = null;
        if (realIp == null) {
            if (forwarded == null) {
                ip = remoteAddr;
            } else {
                ip = forwarded.split(",")[0];
            }
        } else {
            if (realIp.equals(forwarded)) {
                ip = realIp;
            } else {
                if (forwarded != null) {
                    forwarded = forwarded.split(",")[0];
                }
                ip = forwarded;
            }
        }

        return ip;
    }

    /**
     * 对象元素驼峰转下划线，返回属性和值对应的map
     */
    public static Map<String, String> camel2Under(Object object) {
        Pattern humpPattern = Pattern.compile("[A-Z]");
        Map<String, String> map = new HashMap<>();
        Class cls = object.getClass();
        // modify at [8/28/2020] by yanghao: 支持获取所有的父类方法(原本只能获取当前类的方法)
        List<Method> methodList = new ArrayList<>();
        while (cls != null) {
            methodList.addAll(new ArrayList<>(Arrays.asList(cls.getDeclaredMethods())));
            cls = cls.getSuperclass();
        }
        if (methodList.size() > 0) {
            List<Method> getMethods = methodList.stream().filter(m -> m.getName().startsWith("get")).collect(Collectors.toList());
            if (!getMethods.isEmpty()) {
                getMethods.forEach(method -> {
                    Object invokeValue = null;
                    try {
                        String name = method.getName();
                        Matcher matcher = humpPattern.matcher(name.replace("get", ""));
                        StringBuffer sb = new StringBuffer();
                        while (matcher.find()) {
                            matcher.appendReplacement(sb, "_" + matcher.group(0).toLowerCase());
                        }
                        matcher.appendTail(sb);
                        invokeValue = method.invoke(object);
                        ExcelUtils.convertInvokeValue(invokeValue);
                        if (invokeValue != null) {
                            map.put(sb.toString().startsWith("_") ? sb.toString().substring(1) : sb.toString(), String.valueOf(invokeValue));
                        }
                    } catch (Exception e) {
                        return;
                    }
                });
            }
        }
        return map;
    }

    /**
     * 将MAP对象转为LinkedHashMap
     *
     * @param map
     * @return
     */
    public static LinkedHashMap mapConversionLinkedHashMap(Map map) {
        LinkedHashMap returnMap = new LinkedHashMap();
        Iterator iterator = map.keySet().iterator();
        while (iterator.hasNext()) {
            Object objKey = iterator.next();
            Object objValue = map.get(objKey);
            returnMap.put(objKey, objValue);
        }
        return returnMap;
    }

    /**
     * 将String 按照分隔符 转为List
     *
     * @param parameter
     * @param separator
     */
    public static List<String> formatConverter(String parameter, String separator) {
        if (StringUtils.isNotBlank(parameter)) {
            return Arrays.stream(parameter.split(separator))
                    .filter(StringUtils::isNotBlank)
                    .collect(Collectors.toList());
        }
        return new ArrayList<>();
    }
}
