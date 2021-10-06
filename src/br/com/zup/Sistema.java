package br.com.zup;

import java.util.Scanner;

public class Sistema {

    private static Scanner capturarDados(String mensagem) {
        System.out.println(mensagem);
        return new Scanner(System.in);
    }

    public static void menu() {
        System.out.println("Sistema de gestão de imoveis da Evellyin! \n" +
                "Digite 1 - Para cadastrar um imóvel. \n" +
                "Digite 2 - Para exibir os imóveis cadastrados. \n" +
                "Digite 3 - Para remover um usuário. \n" +
                "Digite 4 - Para sair.");
    }

    public static Morador cadastrarMoradores() {
        String nome = capturarDados("Digite o nome do morador: ").nextLine();
        String cpf = capturarDados("Digite o cpf do morador: ").nextLine();
        String telefone = capturarDados("Digite o telefone morador: ").nextLine();
        double renda = capturarDados("Digite o salario do morador: ").nextDouble();
        String email = capturarDados("Digite o email do morador:").nextLine();

        Morador morador = new Morador(nome, cpf, telefone, renda, email);
        return morador;
    }

    public static Funcionario cadastrarFuncionario() {
        String nome = capturarDados("Digite nome do funcionario responsavel: ").nextLine();
        String cpf = capturarDados("Digite o cpf do funcionario responsavel: ").nextLine();
        String ctps = capturarDados("Digite a carteira de trabalho do funcionario responsavel: ").nextLine();

        Funcionario funcionario = new Funcionario(nome, cpf, ctps);
        return funcionario;
    }

    public static Imovel cadastrarImovel() {
        String endereco = capturarDados("Digite seu endereço: ").nextLine();
        double valorAluguel = capturarDados("Digite o valor do aluguel: ").nextDouble();

        Imovel imovel = new Imovel(endereco, valorAluguel);
        return imovel;
    }

    private static boolean validarCpfExistente(Imobiliaria imobiliaria, Morador morador) {
        for (Imovel imovelReferencia : imobiliaria.getImoveis()) {
            for (Morador moradorReferencia : imovelReferencia.getMoradores()) {
                if (moradorReferencia.getCpf().equalsIgnoreCase(morador.getCpf())) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean validarEmailExistente(Imobiliaria imobiliaria, Morador morador){
        for (Imovel imovelReferencia : imobiliaria.getImoveis()){
            for (Morador moradorReferencia : imovelReferencia.getMoradores()){
                if (moradorReferencia.getEmail().equalsIgnoreCase(morador.getEmail())){
                    return true;
                }
            }
        }
        return false;
    }

    public static void cadastrarListaDeMoradores(Imobiliaria imobiliaria, Imovel imovel) {
        int qtdMoradores = capturarDados("Digite a quantidade de moradores: ").nextInt();
        int contador = 0;
        while(contador < qtdMoradores){
            Morador morador = cadastrarMoradores();

            if (validarCpfExistente(imobiliaria, morador)) {
                System.out.println("Este morador já possuí um CPF cadastrado.");
            } else if (validarEmailExistente(imobiliaria, morador)){
                System.out.println("Este morador já possuí um email cadastrado.");
            }else if(morador.getEmail().contains("@")){
                imovel.adicionarMorador(morador);
                contador++;
            }else{
                System.out.println("Email inválido.");
            }
        }
    }

    public static String removerMoradorPorCpf(Imobiliaria imobiliaria){
        String cpf = capturarDados("Digite o CPF do morador a ser removido.").nextLine();

            for (Imovel percorrerImoveis : imobiliaria.getImoveis()) {
                for (Morador percorrerMoradores : percorrerImoveis.getMoradores()) {
                    if (percorrerMoradores.getCpf().equals(cpf)) {
                        percorrerImoveis.getMoradores().remove(percorrerMoradores);
                        return "Morador removido com sucesso.";
                    }
                }
            }
        return "Morador não cadastrado no sistema.";
    }

    public static void executar(){
        boolean menu = true;
        Imobiliaria imobiliaria = new Imobiliaria();

        while (menu){

            menu();
            int opcao = capturarDados("Digite a opção desejada: ").nextInt();

            if (opcao == 1) {
                Imovel imovel = cadastrarImovel();
                imobiliaria.adicionarImovel(imovel);
                Funcionario funcionario = cadastrarFuncionario();
                imovel.setFuncionarioResponsavel(funcionario);
                cadastrarListaDeMoradores(imobiliaria, imovel);

            }else if (opcao == 2) {

                System.out.println(imobiliaria);

            }else if (opcao == 3) {

                String statusDeRemocao = removerMoradorPorCpf(imobiliaria);
                System.out.println(statusDeRemocao);

            }else if (opcao == 4) {

                System.out.println("Obrigada e volte sempre");
                menu = false;

            }
        }
    }
}