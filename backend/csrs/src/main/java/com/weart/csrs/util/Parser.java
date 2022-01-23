package com.weart.csrs.util;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Parser {
    public static int[] parsingDate(String auctionDate) {
        StringTokenizer st = new StringTokenizer(auctionDate, "-");
        List<Integer> dateInformations = new ArrayList<>();
        while (st.hasMoreTokens()) {
            dateInformations.add(Integer.parseInt(st.nextToken()));
        }
        return dateInformations.stream()
                .mapToInt(i -> i)
                .toArray();
    }

    public static String convertStringDate(int[] auctionEndDate) {
        StringBuilder stringBuilder = new StringBuilder("?");
        for (int i = 4; i >= 0 ; i--) {
            stringBuilder.append(" ").append(auctionEndDate[i]);
        }
        return stringBuilder.toString();
    }
}
