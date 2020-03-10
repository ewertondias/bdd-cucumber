package com.curso.bddcucumber.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/inserir_conta.feature",
        // features = "src/test/resources/features/", // Rodar todas features
        glue = { "com.curso.bddcucumber.steps", "com.curso.bddcucumber.config"},
//      tags = "@tipo1",   // Executa somente esta tag
        tags = "not @ignore", // Ignora os cenários com esta tag // Na atualização do cucumber não usa mais ~ usa not
//      tags = {"@tipo1, @tipo2"}, // Executa os cenários que contém as tags tipo1 E tipo2
//      tags = {"@tipo1, @tipo2"}, // Executa os cenários que contém as tags tipo1 OU tipo2
        plugin = {"pretty", "html:target/report-html", "json:target/report.json"},
        monochrome = false,
        snippets = SnippetType.CAMELCASE,
        dryRun = false, // Verifica todos os cenários sem parar no passo que quebrou
        strict = false
)
public class RunnerTest {

}

