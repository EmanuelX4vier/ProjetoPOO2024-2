package GerenciaFinanceira;

import GerenciaFinanceira.Exceptions.UsuarioJaCadastradoException;
import GerenciaFinanceira.Exceptions.UsuarioNaoCadastradoException;
import GerenciaFinanceira.Interface_E_Sistema.SistemaDoGerenciadorFinanceiro;

import javax.swing.*;


public class ProgramaGerenciadorFinanceiro {
    public static void main (String [] args){
        //Iniciar sistema.
        SistemaDoGerenciadorFinanceiro sistema = new SistemaDoGerenciadorFinanceiro();

        //Iniciar menu.
        boolean continuar = true;
        while(continuar){
            JOptionPane.showMessageDialog(null, "Olá usuário, vamos nos cadastrar.");
            String nome = JOptionPane.showInputDialog(null, "Me diga seu nome:");
            double saldoCorrente = Double.parseDouble(JOptionPane.showInputDialog(null, "Me diga o saldo de sua conta corrente."));
            try{
                sistema.cadastraUsuario(nome, saldoCorrente);
                JOptionPane.showMessageDialog(null, "Cadastro feito com sucesso. Aqui está seu código para que possa fazer aplicações no programa:");
                JOptionPane.showMessageDialog(null, sistema.getCodigoDoUsuario(nome));
            } catch (UsuarioJaCadastradoException e) {
                e.getMessage();
            } catch (UsuarioNaoCadastradoException e) {
                throw new RuntimeException(e);
            }

        }


    }
}
