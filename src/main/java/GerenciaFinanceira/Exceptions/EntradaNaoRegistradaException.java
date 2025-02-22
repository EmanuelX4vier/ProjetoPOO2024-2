package GerenciaFinanceira.Exceptions;

import GerenciaFinanceira.Movimentacao.Entrada;

public class EntradaNaoRegistradaException extends Exception {
    public EntradaNaoRegistradaException(String message) {
        super(message);
    }
    public EntradaNaoRegistradaException(){
        super();
    }
}
