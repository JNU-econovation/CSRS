package com.weart.csrs.util;

import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

public class StringUtils {
    public static String extractFileNameFromFilePath(String filePath) {
        int startIndex = filePath.lastIndexOf("profile");
        String fileName = filePath.substring(startIndex);
        return decodeString(fileName);
    }

    public static String decodeString(String encodeString) {
        return URLDecoder.decode(encodeString, StandardCharsets.UTF_8);
    }
}
