package com.springbootangular.main.controllers.util;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class BigDecimalConverter {
    public BigDecimal converter(String value){
        if(value != null){
            value = value.replace(".","").replace(",",".");
            return new BigDecimal(value);
        }
        return null;
    }
}
