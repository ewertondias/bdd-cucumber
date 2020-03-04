package com.curso.bddcucumber.steps;

import com.curso.bddcucumber.entidades.Filme;
import com.curso.bddcucumber.entidades.NotaAluguel;
import com.curso.bddcucumber.servicos.AluguelService;
import com.curso.bddcucumber.utils.DateUtils;
import cucumber.api.PendingException;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;
import org.junit.Assert;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class AlugarFilmeSteps {

    private Filme filme;
    private AluguelService aluguelService = new AluguelService();
    private NotaAluguel notaAluguel;
    private String erro;
    private String tipoAluguel;

    @Dado("^um filme com estoque de (\\d+) unidades$")
    public void umFilmeComEstoqueDeUnidades(int arg1) throws Throwable {
        filme = new Filme();
        filme.setEstoque(arg1);
    }

    @Dado("^que o preço do aluguel seja R\\$ (\\d+)$")
    public void queOPreçoDeAluguelSejaR$(int arg1) throws Throwable {
        filme.setAluguel(arg1);
    }

    @Quando("^alugar$")
    public void alugar() throws Throwable {
        try {
            notaAluguel = aluguelService.alugar(filme, tipoAluguel);
        } catch (RuntimeException e) {
            erro = e.getMessage();
        }
    }

    @Então("^o preço do aluguel será R\\$ (\\d+)$")
    public void oPreçoDoAluguelSeráR$(int arg1) throws Throwable {
        Assert.assertEquals(arg1, notaAluguel.getPreco());
    }

    @Então("^o estoque do filme será (\\d+) unidade$")
    public void oEstoqueDoFilmeSeráUnidade(int arg1) throws Throwable {
        Assert.assertEquals(arg1, filme.getEstoque());
    }

    @Então("^não será possível por falta de estoque$")
    public void nãoSeráPossívelPorFaltaDeEstoque() throws Throwable {
        Assert.assertEquals("Filme sem estoque", erro);
    }

    @Dado("^que o tipo do aluguel seja (.*)$")
    public void queOTipoDoAluguelSejaExtendido(String tipo) throws Throwable {
        tipoAluguel = tipo;
    }

    @Então("^a data de entrega será em (\\d+) dias?$")
    public void aDataDeEntregaSeráEmDias(int arg1) throws Throwable {
        Date dataEsperada = DateUtils.obterDataDiferencaDias(arg1);
        Date dataReal = notaAluguel.getDataEntrega();

        DateFormat format = new SimpleDateFormat("dd/MM/yyyy");

        Assert.assertEquals(format.format(dataEsperada), format.format(dataReal));
    }

    @Então("^a pontuação recebida será de (\\d+) pontos$")
    public void aPontuaçãoRecebidaSeráDePontos(int arg1) throws Throwable {
        Assert.assertEquals(arg1, notaAluguel.getPontuacao());
    }

}
