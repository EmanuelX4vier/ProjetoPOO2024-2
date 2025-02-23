package GerenciaFinanceira;

import GerenciaFinanceira.Exceptions.UsuarioJaCadastradoException;
import GerenciaFinanceira.Exceptions.UsuarioNaoCadastradoException;
import GerenciaFinanceira.Interface_E_Sistema.Data;
import GerenciaFinanceira.Interface_E_Sistema.SistemaDoGerenciadorFinanceiro;
import GerenciaFinanceira.Movimentacao.TipoDeMovimentacao;

import javax.swing.*;
import java.io.IOException;


public class ProgramaGerenciadorFinanceiro {
    public static void main (String [] args) throws IOException, UsuarioNaoCadastradoException {
        //Iniciar sistema.
        SistemaDoGerenciadorFinanceiro sistema = new SistemaDoGerenciadorFinanceiro();
        try{
            sistema.recuperarDados();
        } catch (IOException e) {
            e.getStackTrace();
        }
        //Iniciar menu.
        boolean continuar = true;
        int whil = JOptionPane.showConfirmDialog(null, "Você já foi cadastrado?");
        if (whil == 1) {
            while (continuar) {
                JOptionPane.showMessageDialog(null, "Olá usuário, vamos nos cadastrar.");
                String nome = JOptionPane.showInputDialog(null, "Me diga seu nome:");
                double saldoCorrente = Double.parseDouble(JOptionPane.showInputDialog(null, "Me diga o saldo de sua conta corrente."));
                try {
                    sistema.cadastraUsuario(nome, saldoCorrente);
                    JOptionPane.showMessageDialog(null, "Cadastro feito com sucesso. Aqui está seu código para que possa fazer aplicações no programa:");
                    JOptionPane.showMessageDialog(null, sistema.getCodigoDoUsuario(nome));
                } catch (UsuarioJaCadastradoException e) {
                    e.getMessage();
                } catch (UsuarioNaoCadastradoException e) {
                    throw new RuntimeException(e);
                }
            }
        }else{
            JOptionPane.showMessageDialog(null, "Bem vindo de volta");
            JOptionPane.showMessageDialog(null, sistema.getUsuario("Emanuel").getNome());
            JOptionPane.showMessageDialog(null, sistema.getUsuario("Emanuel").getCodigo());
            int codigo = sistema.getCodigoDoUsuario("Emanuel");
            JOptionPane.showMessageDialog(null, codigo);
            JOptionPane.showMessageDialog(null, sistema.getUsuario("Emanuel").getSaldoCorrente());
            try{
                sistema.registrarEntrada(codigo, TipoDeMovimentacao.RecebimentoQualquer, 200, "Agiotagem", new Data(1,12,2004));
                JOptionPane.showMessageDialog(null, "registrado com sucesso.");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

            JOptionPane.showMessageDialog(null, sistema.getUsuario("Emanuel").getEntradas());
        }
    }
}
