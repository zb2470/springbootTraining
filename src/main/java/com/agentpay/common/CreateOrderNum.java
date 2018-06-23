package com.agentpay.common;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CreateOrderNum {
    private CreateOrderNum() {
    }
    private static CreateOrderNum createOrderNum;
    public static synchronized CreateOrderNum GetInstance() {
        if (createOrderNum == null) {
            createOrderNum = new CreateOrderNum();
            num=0;
            SimpleDateFormat df = new SimpleDateFormat(DATE_YYYYMMDDHHMMS);
            date= df.format(System.currentTimeMillis());
        }
        return createOrderNum;
    }

    private static String DATE_YYYYMMDDHHMMS="yyyyMMddhhmmss";
    private static String SUPPLY_0="%09d";
    private static Integer num;
    private static String date;

    public synchronized String GetSerialNo() {

        String datetime = "1";
        SimpleDateFormat df = new SimpleDateFormat(DATE_YYYYMMDDHHMMS);
        datetime= df.format(System.currentTimeMillis());
        if (datetime == date) {
            num++;
        } else {
            date = datetime;
            num = 1;
        }
        return date +String.format(SUPPLY_0, num);
    }
}
