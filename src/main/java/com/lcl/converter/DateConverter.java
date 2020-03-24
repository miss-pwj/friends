package com.lcl.converter;




import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author lcl
 * @date 2019/11/5 15:15
 * @Description
 */

//全局进行String 到 日期格式的转换
public class DateConverter implements Converter<String,Date> {
    private String pattern="yyyy-MM-dd";

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    @Override
    public Date convert(String source) {
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        Date d = null;

        try {
            if(source!=null&&!source.equals(""))    //排空
            d = format.parse(source);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return d;
    }
}
