package GerenciaFinanceira.Interface_E_Sistema;

import GerenciaFinanceira.Exceptions.UsuarioJaCadastradoException;
import GerenciaFinanceira.Exceptions.UsuarioNaoCadastradoException;
import GerenciaFinanceira.Movimentacao.Entrada;
import GerenciaFinanceira.Movimentacao.Saida;
import GerenciaFinanceira.Movimentacao.TipoDeMovimentacao;

import java.io.IOException;
import java.io.Serializable;
import java.util.*;


public class SistemaDoGerenciadorFinanceiro implements Serializable {

    private Usuario usuarioPrincipal;
    private GravadorDeDados gravador;

    //inicia o sistema
    public SistemaDoGerenciadorFinanceiro(){
        this.usuarioPrincipal = new Usuario();
        this.gravador = new GravadorDeDados();
    }

    //Cria codigo aleatório para o usuário.
    Random random = new Random();

    //Cria usuário.
    public void cadastraUsuario (String nome, double saldoCorrente) throws UsuarioJaCadastradoException {
        int codigoDoUsuario = random.nextInt();
        Usuario usuario = new Usuario(nome, saldoCorrente, codigoDoUsuario);
        this.usuarioPrincipal = usuario;
    }

    //Registra saidas e entradas de valores.
    public void registrarEntrada (int codigoDoUsuario, TipoDeMovimentacao tipo, double valor, String descricao, Data data) throws UsuarioNaoCadastradoException {
        if(usuarioPrincipal.getCodigo() == codigoDoUsuario){
            Entrada novaEntrada = new Entrada(tipo, valor, descricao, data, random.nextInt());
            List<Entrada> novaLista = new ArrayList<>(usuarioPrincipal.getEntradas());
            novaLista.add(novaEntrada);
            usuarioPrincipal.setEntradas(novaLista);
        }else{
            throw new UsuarioNaoCadastradoException("Codigo errado ou usuário não cadastrado");
        }
    }

    public void registrarSaida(int codigoDoUsuario, TipoDeMovimentacao tipo, double valor, String descricao, Data data) throws UsuarioNaoCadastradoException{
        if(usuarioPrincipal.getCodigo() == codigoDoUsuario){
            Saida novaSaida = new Saida(tipo, valor, descricao, data, random.nextInt());
            List<Saida> novaLista = new ArrayList<>(usuarioPrincipal.getSaidas());
            novaLista.add(novaSaida);
            usuarioPrincipal.setSaidas(novaLista);
        }else{
            throw new UsuarioNaoCadastradoException("Codigo errado ou usuário não cadastrado");
        }
    }

    //Operações com o saldo.
    public double saldo (){
        double saldo = usuarioPrincipal.getSaldoCorrente()+usuarioPrincipal.getValorDeTodasAsEntradas()-usuarioPrincipal.getValorDeTodasAsSaidas();
        usuarioPrincipal.setSaldoCorrente(saldo);
        return saldo;
    }

    //get's e set's.
    public String getNomeDoUsuario(){
        return usuarioPrincipal.getNome();
    }

    public int getCodigoDoUsuario() throws UsuarioNaoCadastradoException {;
        return usuarioPrincipal.getCodigo();
    }

    public List<Entrada> getEntradasDoUsuario(){
        return usuarioPrincipal.getEntradas();
    }

    public List<Saida> getSaidasDoUsuario(){
        return usuarioPrincipal.getSaidas();
    }

    public double getValorDeTodasAsEntradas(){
        double valores = 0;
        for(Entrada e: usuarioPrincipal.getEntradas()){
            valores += e.getValor();
        }
        return valores;
    }


    //Gravação e recuperação
    public void salvarDados() throws IOException {
        gravador.gravaDados(this.usuarioPrincipal);
    }

    public void recuperarDados() throws IOException {
        List<Usuario> usuariosRecuperados = new ArrayList<>(gravador.recuperaDados());
        for(Usuario u: usuariosRecuperados){
            Usuario usuario = new Usuario(u.getNome(), u.getSaldoCorrente(), u.getCodigo());
            this.usuarioPrincipal = usuario;
            this.usuarioPrincipal.setEntradas(u.getEntradas());
            this.usuarioPrincipal.setSaidas(u.getSaidas());
        }
    }
}
