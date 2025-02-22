package GerenciaFinanceira.Interface_E_Sistema;

import GerenciaFinanceira.Exceptions.UsuarioJaCadastradoException;
import GerenciaFinanceira.Exceptions.UsuarioNaoCadastradoException;
import GerenciaFinanceira.Movimentacao.Entrada;
import GerenciaFinanceira.Movimentacao.Saida;
import GerenciaFinanceira.Movimentacao.TipoDeMovimentacao;

import java.util.*;


public class SistemaDoGerenciadorFinanceiro {

    private Map<Integer, Usuario> usuarios;

    //inicia o sistema
    public SistemaDoGerenciadorFinanceiro(){
        this.usuarios = new HashMap<>();
    }

    //Cria codigo aleatório para o usuário.
    Random random = new Random();

    //Cria usuário.
    public void cadastraUsuario (String nome, double saldoCorrente) throws UsuarioJaCadastradoException{
        int codigoDoUsuario = random.nextInt();
        Usuario usuario = new Usuario(nome, saldoCorrente, codigoDoUsuario);
        this.usuarios.put(codigoDoUsuario, usuario);
    }

    //Registra saidas e entradas de valores.
    public void registrarEntrada (int codigoDoUsuario, TipoDeMovimentacao tipo, double valor, String descricao, Data data, int codigoDeMovimentacao) throws UsuarioNaoCadastradoException {
        if(this.usuarios.containsValue(codigoDoUsuario)){
            Entrada novaEntrada = new Entrada(tipo, valor, descricao, data, random.nextInt());
            for(Usuario u: this.usuarios.values()){
               u.getEntradas().add(novaEntrada);
            }
        }else{
            throw new UsuarioNaoCadastradoException ("Código de usuário incorreto ou não existe");
        }
    }
     public void registrarSaida(int codigoDoUsuario, TipoDeMovimentacao tipo, double valor, String descricao, Data data, int codigoDeMovimentacao) throws UsuarioNaoCadastradoException{
        if(this.usuarios.containsValue(codigoDoUsuario)){
            Saida novaSaida = new Saida(tipo, valor, descricao, data, random.nextInt());
            for(Usuario u: this.usuarios.values()){
                u.getSaidas().add(novaSaida);
            }
        }
     }

     //Operações com o saldo.
     public double saldo (){
        double saldo = 0;
        for(Usuario u:this.usuarios.values()){
           double saldoCorrente = u.getSaldoCorrente();
           double valorDasEntradas = u.getValorDeTodasAsEntradas();
           double valorDasSaidas = u.getValorDeTodasAsSaidas();
           saldo = saldoCorrente + valorDasEntradas - valorDasSaidas;
        }
        return saldo;
     }

    public Usuario getUsuario (String nome) throws UsuarioNaoCadastradoException{
        Usuario usuario = new Usuario();
        for(Usuario u:this.usuarios.values()){
            if(u.getNome().equalsIgnoreCase(nome)) {
                Usuario usuarioEncontrado = new Usuario(u.getNome(), u.getSaldoCorrente(), u.getCodigo());
                usuario = usuarioEncontrado;
            }else{
                throw new UsuarioNaoCadastradoException("Usuário não encontrado.");
            }
        }
        return usuario;
    }

    public int getCodigoDoUsuario(String nome) throws UsuarioNaoCadastradoException {
        int codigoEncontrado = 0;
        for(Usuario u:this.usuarios.values()){
            if(u.getNome().equalsIgnoreCase(nome)){
                codigoEncontrado=u.getCodigo();
            }else{
                throw new UsuarioNaoCadastradoException("Usuario não encontrado");
            }
        }
        return codigoEncontrado;
    }
}
