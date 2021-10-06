package br.com.zup;

public class Morador extends Pessoa{
    private String telefone;
    private double renda;
    private String email;


    public Morador(String nome, String cpf, String telefone, double renda, String email) {
        super(nome, cpf);
        this.telefone = telefone;
        this.renda = renda;
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public double getRenda() {
        return renda;
    }

    public void setRenda(double renda) {
        this.renda = renda;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        StringBuilder retorno = new StringBuilder();
        retorno.append(super.toString());
        retorno.append("\n Telefone: " +telefone);
        retorno.append("\n Renda do morador: R$"+renda);
        return retorno.toString();
    }
}