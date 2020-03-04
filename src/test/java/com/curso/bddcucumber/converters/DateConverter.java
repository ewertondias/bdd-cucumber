package com.curso.bddcucumber.converters;

import cucumber.api.Transformer;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateConverter extends Transformer<Date> {

    @Override
    public Date transform(String s) {
        DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        try {
            Date retorno = format.parse(s);
            return retorno;
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

}
