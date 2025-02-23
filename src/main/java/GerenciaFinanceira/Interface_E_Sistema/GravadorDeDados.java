package GerenciaFinanceira.Interface_E_Sistema;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;

public class GravadorDeDados implements Serializable {

    private String dadosFinanceiros;

    public GravadorDeDados(){
        this.dadosFinanceiros = "dadosFinanceiros.dat";
    }

   public void gravaDados (Collection<Usuario> usuarios) throws IOException{
       ArrayList<Usuario> usuariosArrayList = new ArrayList<>(usuarios);
       try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(this.dadosFinanceiros))){
           out.writeObject(usuariosArrayList);
       }
    }

    public Collection<Usuario> recuperaDados() throws IOException{
        try(ObjectInputStream in = new ObjectInputStream(new FileInputStream(this.dadosFinanceiros))){
            Collection<Usuario> dadosRecuperados = (ArrayList<Usuario>) in.readObject();
            return dadosRecuperados;
        } catch (ClassNotFoundException | ClassCastException e) {
            throw new IOException(e);
        }
    }

}
