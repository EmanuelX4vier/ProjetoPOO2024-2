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
        assertEquals("Emanuel", sistema.getNomeDoUsuario());
        assertEquals(300, sistema.saldo());
        //Nome e saldo OK
        int codigoDoUsuario = sistema.getCodigoDoUsuario();
        System.out.println(codigoDoUsuario);
        assertEquals(codigoDoUsuario, sistema.getCodigoDoUsuario());
        //Código OK.
        sistema.registrarEntrada(codigoDoUsuario, TipoDeMovimentacao.RecebimentoQualquer, 200, "Agiotagem", new Data());
        assertEquals(1, sistema.getEntradasDoUsuario().size());
        assertEquals(0, sistema.getSaidasDoUsuario().size());
        //Listas de entrada e saida OK.



        //Testa funções.
        System.out.println(sistema.getCodigoDoUsuario());
        try{
            sistema.registrarSaida(codigoDoUsuario, TipoDeMovimentacao.RecebimentoQualquer, 400, "Agiotagem outra",new Data());
            System.out.println(sistema.getSaidasDoUsuario());
        }catch (UsuarioNaoCadastradoException e){
            e.getMessage();
        }
        assertEquals(1, sistema.getSaidasDoUsuario().size());
        System.out.println(sistema.getValorDeTodasAsEntradas());
        sistema.salvarDados();

    }
}
