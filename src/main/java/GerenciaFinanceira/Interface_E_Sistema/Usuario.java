package GerenciaFinanceira.Interface_E_Sistema;

import java.util.ArrayList;
import java.util.Objects;
import GerenciaFinanceira.Movimentacao.Entrada;
import GerenciaFinanceira.Movimentacao.Saida;

import java.util.List;

public class Usuario {

    private String nome;
    private double saldoCorrente;
    private int codigo;
    private List<Entrada> entradas;
    private List<Saida> saidas;

    //Criação o usuário.
    public Usuario(String nome, double saldoCorrente, int codigoDoUsuario){
        this.nome=nome;
        this.saldoCorrente=saldoCorrente;
        this.codigo = codigoDoUsuario;
        this.entradas=new ArrayList<>();
        this.saidas=new ArrayList<>();
    }

    public Usuario(){
        this.nome = "Sem nome";
        this.saldoCorrente = 0;
        this.codigo = 0;
        this.entradas = new ArrayList<>();
        this.saidas = new ArrayList<>();
    }

    //get's e set's.
    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCodigo() {
        return this.codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public double getSaldoCorrente() {
        return this.saldoCorrente;
    }

    public void setSaldoCorrente(double saldoCorrente) {
        this.saldoCorrente = saldoCorrente;
    }

    public List<Entrada> getEntradas() {
        return this.entradas;
    }

    public void setEntradas(List<Entrada> entradas) {
        this.entradas = entradas;
    }

    public List<Saida> getSaidas() {
        return this.saidas;
    }

    public void setSaidas(List<Saida> saidas) {
        this.saidas = saidas;
    }

    public double getValorDeTodasAsEntradas(){
        double todasAsEntradas = 0;
        for(Entrada e: this.entradas){
           todasAsEntradas += e.getValor();
        }
        return todasAsEntradas;
    }

    public double getValorDeTodasAsSaidas(){
        double todasAsSaidas = 0;
        for(Saida e: this.saidas){
            todasAsSaidas += e.getValor();
        }
        return todasAsSaidas;
    }

    //equals, hashCode e toString.


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return Double.compare(saldoCorrente, usuario.saldoCorrente) == 0 && codigo == usuario.codigo && Objects.equals(nome, usuario.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, saldoCorrente, codigo);
    }
}
