package com.curso.bddcucumber.config;

import io.cucumber.core.api.TypeRegistry;
import io.cucumber.core.api.TypeRegistryConfigurer;
import io.cucumber.cucumberexpressions.ParameterType;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class RegistryCucumber implements TypeRegistryConfigurer {

    @Override
    public Locale locale() {
        return Locale.ENGLISH;
    }

    @Override
    public void configureTypeRegistry(TypeRegistry typeRegistry) {
        typeRegistry.defineParameterType(
            new ParameterType<>("data", ".*", Date.class, (String s) -> {
                DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                try {
                    Date retorno = format.parse(s);
                    return retorno;
                } catch (ParseException e) {
                    e.printStackTrace();
                    return null;
                }
            })
        );
    }

}
