package br.com.zup;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Imobiliaria {
    private List <Imovel> imoveis = new ArrayList<>();

    public void adicionarImovel(Imovel imovel){
        imoveis.add(imovel);
    }

    public List<Imovel> getImoveis() {
        return imoveis;
    }

    public void setImoveis(List<Imovel> imoveis) {
        this.imoveis = imoveis;
    }

    @Override
    public String toString() {
        StringBuilder retorno = new StringBuilder();
        retorno.append("Quantidade de imoveis: " +imoveis.size());
        retorno.append("Imoveis: ");
        retorno.append("\n " +imoveis);
        return retorno.toString();
    }
}