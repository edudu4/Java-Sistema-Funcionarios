package sistema.entidades;

public class Cargo {
	//Atributos
    private int id; 
    private String nome;

    //M�todos P�blicos
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    @Override
    public String toString() {
        return this.nome;
    }    
}
