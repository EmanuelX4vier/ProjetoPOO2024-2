package TestesComMovimentacao;

import GerenciaFinanceira.Interface_E_Sistema.Data;
import GerenciaFinanceira.Interface_E_Sistema.Usuario;
import GerenciaFinanceira.Movimentacao.Entrada;
import GerenciaFinanceira.Movimentacao.Saida;
import GerenciaFinanceira.Movimentacao.TipoDeMovimentacao;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Entradas_Saidas_Test {

    @Test
    public void testaEntrada_E_Saida(){
        Random random = new Random();
        List<Usuario> usuario = new ArrayList<>();
        Usuario usuario1 = new Usuario("Emanuel", 300, random.nextInt());
        Entrada entrada1 = new Entrada(TipoDeMovimentacao.RecebimentoQualquer, 300, "Agiotagem", new Data(), random.nextInt());
        Entrada entrada2 = new Entrada(TipoDeMovimentacao.RecebimentoQualquer, 200, "Agiotagem", new Data(), random.nextInt());
        usuario1.getEntradas().add(entrada1);
        usuario1.getEntradas().add(entrada2);
        assertEquals(2, usuario1.getEntradas().size());
        Saida saida1 = new Saida(TipoDeMovimentacao.Compra, 200, "Chocolate", new Data(), random.nextInt());
        usuario1.getSaidas().add(saida1);
        assertEquals(1, usuario1.getSaidas().size());
        System.out.println(usuario1.getSaldoCorrente());
        System.out.println(entrada1.getData());
        System.out.println(entrada1.getMovimentoCompleto());
        System.out.println(entrada2.getMovimentoCompleto());
        System.out.println(saida1.getMovimentoCompleto());
    }

}
