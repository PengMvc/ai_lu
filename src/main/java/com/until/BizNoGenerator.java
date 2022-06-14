package com.until;

import com.common.ailuenum.APICode;
import com.define.exception.APIException;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * @Author: PengMvc
 * @Date: 2022/05/31/16:26
 */
public class BizNoGenerator {

    /**
     * SF220531183155622
     * @param orderLogisticsId
     * @return
     */
    public static String getOrderNo(Integer orderLogisticsId){
        // get order prefix
        String prefix = getPrefix(orderLogisticsId);

        SimpleDateFormat format = new SimpleDateFormat("yyMMddHHmmss");
        String nowDate = format.format(new Date());
        String retult = "";
        Random random = new Random();
        for(int i=0;i<3;i++){
            retult+=random.nextInt(10);
        }
        return  prefix+nowDate+retult;
    }

    private static String getPrefix(Integer orderLogisticsId){
        String prefix = "";
        switch (orderLogisticsId){
            case 1:
                prefix = "SF";
                break;
            case 2:
                prefix = "JD";
                break;
            case 3:
                prefix = "ZT";
                break;
            case 4:
                prefix = "ST";
                break;
            case 5:
                prefix = "YT";
                break;
            case 6:
                prefix = "YD";
                break;
            default:
                throw new APIException(APICode.NOT_SUPPORT_L0GISTICS_MODE);
        }
        return  prefix;
    }

    /**
     * get unique value for project
     * @return unique value
     */
    public static String getUniqueValue(){
        SimpleDateFormat format = new SimpleDateFormat("yyMMddHHmmss");
        String nowDate = format.format(new Date());
        String retult = "";
        Random random = new Random();
        for(int i=0;i<3;i++){
            retult+=random.nextInt(10);
        }
        return nowDate+retult;
    }
}
