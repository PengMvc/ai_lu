package com.until;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * @Author: PengMvc
 * @Date: 2022/05/31/16:26
 */
public class BizNoGenerator {

    public static String getOrderNo(){
        SimpleDateFormat format = new SimpleDateFormat("yyMMddHHmmss");
        String nowDate = format.format(new Date());
        String retult = "";
        Random random = new Random();
        for(int i=0;i<3;i++){
            retult+=random.nextInt(10);
        }
        return  nowDate+retult;
    }
}
