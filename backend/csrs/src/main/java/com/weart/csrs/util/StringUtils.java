package com.weart.csrs.util;

public class StringUtils {
    public static String extractFileNameFromFilePath(String filePath) {
        int startIndex = filePath.lastIndexOf("profile");
        return filePath.substring(startIndex);
    }
}
