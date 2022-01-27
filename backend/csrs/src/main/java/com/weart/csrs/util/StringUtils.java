package com.weart.csrs.util;

import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class StringUtils {
    public static String extractFileNameFromFilePath(String filePath) {
        int startIndex = filePath.lastIndexOf("profile");
        String fileName = filePath.substring(startIndex);
        return decodeString(fileName);
    }

    public static String decodeString(String encodeString) {
        return URLDecoder.decode(encodeString, StandardCharsets.UTF_8);
    }

    public static String expressPrice(Long price) {
        DecimalFormat decimalFormat = new DecimalFormat("###,###");
        return decimalFormat.format(price);
    }

    public static LocalDate parseDate(String date) {
        String[] split = date.split("-");
        return LocalDate.of(Integer.parseInt(split[0]), Integer.parseInt(split[1]), Integer.parseInt(split[2]));
    }

}
