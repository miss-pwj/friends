package com.lcl.converter;

import org.springframework.web.bind.WebDataBinder;

import java.beans.PropertyEditorSupport;

/**
 * @author lcl
 * @date 2019/11/5 11:18
 * @Description 类型转换器
 *
 */

//数据绑定器，将String绑定到int类型
public class NumberFormatUtil extends PropertyEditorSupport {
    public static void registerFloatFormat (WebDataBinder binder) {
        binder.registerCustomEditor(Float.TYPE, new CustomerFloatEditor());
    }

    private static class CustomerFloatEditor extends PropertyEditorSupport{
        public String getAsText() {
            Float d = (Float) getValue();
            return d.toString();
        }

        public void setAsText(String str) {
            if(str == null ||  str.trim().equals("")  )
                setValue(0f);
            else
                setValue(Float.parseFloat(str));
        }
    }
}

