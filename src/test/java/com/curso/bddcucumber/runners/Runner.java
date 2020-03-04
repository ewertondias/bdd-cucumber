package com.curso.bddcucumber.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/alugar_filme.feature",
        glue = "com.curso.bddcucumber.steps",
//      tags = "@tipo1",   // Executa somente esta tag
//      tags = "~@ignore", // Ignora os cenários com esta tag
//      tags = {"@tipo1, @tipo2"}, // Executa os cenários que contém as tags tipo1 E tipo2
//      tags = {"@tipo1, @tipo2"}, // Executa os cenários que contém as tags tipo1 OU tipo2
        plugin = "pretty",
        monochrome = false,
        snippets = SnippetType.CAMELCASE,
        dryRun = false,
        strict = false
)
public class Runner {

}

