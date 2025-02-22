package TestesCom_O_Sistema;

import GerenciaFinanceira.Exceptions.UsuarioJaCadastradoException;
import GerenciaFinanceira.Exceptions.UsuarioNaoCadastradoException;
import GerenciaFinanceira.Interface_E_Sistema.SistemaDoGerenciadorFinanceiro;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class SistemaTest {

    @Test
    public void testeDeSistema() throws UsuarioJaCadastradoException, UsuarioNaoCadastradoException {
        SistemaDoGerenciadorFinanceiro sistema = new SistemaDoGerenciadorFinanceiro();
        //TestaCadastro.
        sistema.cadastraUsuario("Emanuel", 300);
        assertEquals("Emanuel", sistema.getUsuario("Emanuel").getNome());
        assertEquals(300, sistema.getUsuario("Emanuel").getSaldoCorrente());
        //Nome e saldo OK
        int codigoDoUsuario = sistema.getCodigoDoUsuario("Emanuel");
        System.out.println(codigoDoUsuario);
        assertEquals(codigoDoUsuario, sistema.getCodigoDoUsuario("Emanuel"));
        //Código OK.
        assertEquals(0, sistema.getUsuario("Emanuel").getEntradas().size());
        assertEquals(0, sistema.getUsuario("Emanuel").getSaidas().size());
        //Listas de entrada e saida OK.

        //Testa funções.

    }
}
