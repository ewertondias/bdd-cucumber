package com.curso.bddcucumber.steps;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;

public class InserirContasSteps {

    private WebDriver driver;

    @Dado("^que estou acessando a aplicação$")
    public void queEstouAcessandoAAplicação() throws Throwable {
        System.setProperty("webdriver.chrome.driver", "/Users/ewertondias/Documents/Drivers/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://srbarriga.herokuapp.com");
    }

    @Quando("^informo o usuário \"([^\"]*)\"$")
    public void informoOUsuário(String arg1) throws Throwable {
        driver.findElement(By.id("email"))
            .sendKeys(arg1);
    }

    @Quando("^a senha \"([^\"]*)\"$")
    public void aSenha(String arg1) throws Throwable {
        driver.findElement(By.id("senha"))
            .sendKeys(arg1);
    }

    @Quando("^seleciono entrar$")
    public void selecionoEntrar() throws Throwable {
        driver.findElement(By.tagName("button"))
            .click();
    }

    @Então("^visualizo a página inicial$")
    public void visualizoAPáginaInicial() throws Throwable {
        String texto = driver.findElement(By.xpath("//div[@class='alert alert-success']"))
            .getText();

        Assert.assertEquals("Bem vindo, ewerton!", texto);
    }

    @Quando("^seleciono Contas$")
    public void selecionoContas() throws Throwable {
        driver.findElement(By.linkText("Contas"))
            .click();
    }

    @Quando("^seleciono Adicionar$")
    public void selecionoAdicionar() throws Throwable {
        driver.findElement(By.linkText("Adicionar"))
            .click();
    }

    @Quando("^informo a conta \"([^\"]*)\"$")
    public void informoAConta(String arg1) throws Throwable {
        driver.findElement(By.id("nome"))
            .sendKeys(arg1);
    }

    @Quando("^seleciono Salvar$")
    public void selecionoSalvar() throws Throwable {
        driver.findElement(By.tagName("button"))
            .click();
    }

    @Então("^a conta é inserida com sucesso$")
    public void aContaÉInseridaComSucesso() throws Throwable {
        String texto = driver.findElement(By.xpath("//div[@class='alert alert-success']"))
            .getText();

        Assert.assertEquals("Conta adicionada com sucesso!", texto);
    }

    @Então("^sou notificado que o nome da conta é obrigatório$")
    public void souNotificadoQueONomeDaContaÉObrigatório() throws Throwable {
        String texto = driver.findElement(By.xpath("//div[@class='alert alert-danger']"))
            .getText();

        Assert.assertEquals("Informe o nome da conta", texto);
    }

    @Então("^sou notificado que já existe uma conta com esse nome$")
    public void souNotificadoQueJáExisteUmaContaComEsseNome() throws Throwable {
        String texto = driver.findElement(By.xpath("//div[@class='alert alert-danger']"))
            .getText();

        Assert.assertEquals("Já existe uma conta com esse nome!", texto);
    }

    @Então("^recebo a mensagem \"([^\"]*)\"$")
    public void receboAMensagem(String arg1) throws Throwable {
        String texto = driver.findElement(By.xpath("//div[starts-with(@class, 'alert alert-')]"))
            .getText();

        Assert.assertEquals(arg1, texto);
    }

    /**
     * Hooks
     */
    @After(order = 1)
    // @After(order = 1, value = {"~@unitários"}) // Faz com que esse Hook não execute nos cenários que estiverem com a tag @unitários
    public void screenshot(Scenario cenario) throws IOException {
        File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file, new File("target/screenshot/" + cenario.getId() + ".jpg"));
    }

    @After(order = 0)
    public void fecharBrowser() {
        driver.quit();
    }

}
