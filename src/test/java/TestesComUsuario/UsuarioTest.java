package TestesComUsuario;

import GerenciaFinanceira.Interface_E_Sistema.Usuario;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class UsuarioTest {

    @Test
    public void testaCadastroDoUsuario(){
        Random random = new Random();
        int codigoUsuario1 = random.nextInt();
        System.out.println(codigoUsuario1);
        List<Usuario> usuarios = new ArrayList<>();
        Usuario usuario1 = new Usuario("Emanuel", -386.69, codigoUsuario1);
        usuarios.add(usuario1);//Random funcionando.
        assertEquals("Emanuel", usuario1.getNome());
        assertEquals(-386.69, usuario1.getSaldoCorrente());
        assertEquals(codigoUsuario1, codigoUsuario1);
        //Todas as 3 informações foram registradas corretamente
    }
}
