package TestesCom_O_Sistema;

import GerenciaFinanceira.Exceptions.UsuarioJaCadastradoException;
import GerenciaFinanceira.Exceptions.UsuarioNaoCadastradoException;
import GerenciaFinanceira.Interface_E_Sistema.Data;
import GerenciaFinanceira.Interface_E_Sistema.SistemaDoGerenciadorFinanceiro;
import GerenciaFinanceira.Movimentacao.TipoDeMovimentacao;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;


public class SistemaTest {

    @Test
    public void testeDeSistema() throws UsuarioJaCadastradoException, UsuarioNaoCadastradoException, IOException {
        SistemaDoGerenciadorFinanceiro sistema = new SistemaDoGerenciadorFinanceiro();
        //sistema.recuperarDados();
        sistema.cadastraUsuario("Emanuel", 300);
        //TestaCadastro.
        assertEquals("Emanuel", sistema.getUsuario("Emanuel").getNome());
        assertEquals(300, sistema.getUsuario("Emanuel").getSaldoCorrente());
        //Nome e saldo OK
        int codigoDoUsuario = sistema.getCodigoDoUsuario("Emanuel");
        System.out.println(codigoDoUsuario);
        assertEquals(codigoDoUsuario, sistema.getCodigoDoUsuario("Emanuel"));
        System.out.println();
        //Código OK.
        sistema.registrarEntrada(codigoDoUsuario, TipoDeMovimentacao.RecebimentoQualquer, 200, "Agiotagem", new Data());
        assertEquals(1, sistema.getUsuario("Emanuel").getEntradas().size());
        assertEquals(0, sistema.getUsuario("Emanuel").getSaidas().size());
        //Listas de entrada e saida OK.





        /*
        //Testa funções.
        System.out.println(sistema.getCodigoDoUsuario("Emanuel"));
        try{
            sistema.registrarSaida(codigoDoUsuario, TipoDeMovimentacao.RecebimentoQualquer, 200, "Agiotagem",new Data());
            System.out.println(sistema.getUsuario("Emanuel").getSaidas());
        }catch (UsuarioNaoCadastradoException e){
            e.getMessage();
        }
        //System.out.println(sistema.getUsuario("Emanuel").getSaidas());
        assertEquals(0, sistema.getUsuario("Emanuel").getSaidas().size());
        //System.out.println(sistema.getUsuario("Emanuel").getValorDeTodasAsEntradas());
        //sistema.gravarDados();
        */
    }
}
