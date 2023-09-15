/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cadastropoo;
import java.io.IOException;
import java.io.Serializable;
import java.util.Scanner;
import model.*;

/**
 *
 * @author JC
 */
public class CadastroPOO {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner scanner = new Scanner(System.in);
        PessoaFisicaRepo repoPessoaFisica = new PessoaFisicaRepo();
        PessoaJuridicaRepo repoPessoaJuridica = new PessoaJuridicaRepo();

        int opcao;

        do {
            System.out.println("Menu de Opções:");
            System.out.println("1 - Incluir Pessoa");
            System.out.println("2 - Alterar Pessoa");
            System.out.println("3 - Excluir Pessoa");
            System.out.println("4 - Buscar pelo ID");
            System.out.println("5 - Exibir Todos");
            System.out.println("6 - Persistir Todos");
            System.out.println("7 - Recuperar Dados");
            System.out.println("0 - Finalizar Programa");

            System.out.print("Digite a opção desejada: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("F - Pessoa Fisica  | J - Pessoa Juridica ");
                    char tipoInclusao = scanner.next().charAt(0);

                    if (tipoInclusao == 'F') {
                        // Incluir Pessoa Física
                        System.out.print("Digite o ID da pessoa: ");
                        int idFisica = scanner.nextInt();
                        System.out.print("Informe o nome: ");
                        String nomeFisica = scanner.next();
                        System.out.print("Informe o CPF: ");
                        String cpf = scanner.next();
                        System.out.print("Informe a idade: ");
                        int idade = scanner.nextInt();
                        repoPessoaFisica.inserir(new PessoaFisica(idFisica, nomeFisica, cpf, idade));
                        System.out.println("Pessoa Física incluída com sucesso!");
                    } else if (tipoInclusao == 'J') {
                        // Incluir Pessoa Jurídica
                        System.out.print("Informe o ID: ");
                        int idJuridica = scanner.nextInt();
                        System.out.print("Informe a razão social: ");
                        String razaoSocial = scanner.next();
                        System.out.print("Informe o CNPJ: ");
                        String cnpj = scanner.next();
                        repoPessoaJuridica.inserir(new PessoaJuridica(idJuridica, razaoSocial, cnpj));
                        System.out.println("Pessoa Jurídica incluída com sucesso!");
                    } else {
                        System.out.println("Tipo de Pessoa inválido. Use 'F' para Pessoa Física ou 'J' para Pessoa Jurídica.");
                    }
                    break;

                case 2:
                    System.out.print("Escolha o tipo (F para Pessoa Física, J para Pessoa Jurídica): ");
                    char tipoAlteracao = scanner.next().charAt(0);
                    System.out.print("Informe o ID da Pessoa a ser alterada: ");
                    int idAlterar = scanner.nextInt();

                    if (tipoAlteracao == 'F') {
                        // Alterar Pessoa Física
                        PessoaFisica pessoaFisica = repoPessoaFisica.obter(idAlterar);
                        if (pessoaFisica != null) {
                            System.out.println("Dados atuais da Pessoa Física:");
                            pessoaFisica.exibir();

                            System.out.print("Informe o novo nome: ");
                            String novoNome = scanner.next();
                            System.out.print("Informe o novo CPF: ");
                            String novoCpf = scanner.next();
                            System.out.print("Informe a nova idade: ");
                            int novaIdade = scanner.nextInt();

                            pessoaFisica.setNome(novoNome);
                            pessoaFisica.setCpf(novoCpf);
                            pessoaFisica.setIdade(novaIdade);

                            System.out.println("Pessoa Física alterada com sucesso!");
                        } else {
                            System.out.println("Pessoa Física não encontrada.");
                        }
                    } else if (tipoAlteracao == 'J') {
                        // Alterar Pessoa Jurídica
                        PessoaJuridica pessoaJuridica = repoPessoaJuridica.obter(idAlterar);
                        if (pessoaJuridica != null) {
                            System.out.println("Dados atuais da Pessoa Jurídica:");
                            pessoaJuridica.exibir();

                            System.out.print("Informe a nova razão social: ");
                            String novaRazaoSocial = scanner.next();
                            System.out.print("Informe o novo CNPJ: ");
                            String novoCnpj = scanner.next();

                            pessoaJuridica.setRazaoSocial(novaRazaoSocial);
                            pessoaJuridica.setCnpj(novoCnpj);

                            System.out.println("Pessoa Jurídica alterada com sucesso!");
                        } else {
                            System.out.println("Pessoa Jurídica não encontrada.");
                        }
                    } else {
                        System.out.println("Tipo de Pessoa inválido. Use 'F' para Pessoa Física ou 'J' para Pessoa Jurídica.");
                    }
                    break;

                case 3:
                    System.out.print("Escolha o tipo (F para Pessoa Física, J para Pessoa Jurídica): ");
                    char tipoExclusao = scanner.next().charAt(0);
                    System.out.print("Informe o ID da Pessoa a ser excluída: ");
                    int idExcluir = scanner.nextInt();

                    if (tipoExclusao == 'F') {
                        // Excluir Pessoa Física
                        repoPessoaFisica.excluir(idExcluir);
                        System.out.println("Pessoa Física excluída com sucesso!");
                    } else if (tipoExclusao == 'J') {
                        // Excluir Pessoa Jurídica
                        repoPessoaJuridica.excluir(idExcluir);
                        System.out.println("Pessoa Jurídica excluída com sucesso!");
                    } else {
                        System.out.println("Tipo de Pessoa inválido. Use 'F' para Pessoa Física ou 'J' para Pessoa Jurídica.");
                    }
                    break;

                case 4:
                    System.out.print("Escolha o tipo (F para Pessoa Física, J para Pessoa Jurídica): ");
                    char tipoObtencao = scanner.next().charAt(0);
                    System.out.print("Informe o ID da Pessoa a ser obtida: ");
                    int idObter = scanner.nextInt();

                    if (tipoObtencao == 'F') {
                        // Obter e Exibir Pessoa Física
                        PessoaFisica pessoaFisica = repoPessoaFisica.obter(idObter);
                        if (pessoaFisica != null) {
                            System.out.println("Dados da Pessoa Física:");
                            pessoaFisica.exibir();
                        } else {
                            System.out.println("Pessoa Física não encontrada.");
                        }
                    } else if (tipoObtencao == 'J') {
                        // Obter e Exibir Pessoa Jurídica
                        PessoaJuridica pessoaJuridica = repoPessoaJuridica.obter(idObter);
                        if (pessoaJuridica != null) {
                            System.out.println("Dados da Pessoa Jurídica:");
                            pessoaJuridica.exibir();
                        } else {
                            System.out.println("Pessoa Jurídica não encontrada.");
                        }
                    } else {
                        System.out.println("Tipo de Pessoa inválido. Use 'F' para Pessoa Física ou 'J' para Pessoa Jurídica.");
                    }
                    break;

                case 5:
                    System.out.print("Escolha o tipo (F para Pessoa Física, J para Pessoa Jurídica): ");
                    char tipoListagem = scanner.next().charAt(0);

                    if (tipoListagem == 'F') {
                        // Listar Todas as Pessoas Físicas
                        System.out.println("Dados de Pessoas Físicas:");
                        for (PessoaFisica pessoa : repoPessoaFisica.obterTodos()) {
                            pessoa.exibir();
                        }
                    } else if (tipoListagem == 'J') {
                        // Listar Todas as Pessoas Jurídicas
                        System.out.println("Dados de Pessoas Jurídicas:");
                        for (PessoaJuridica pessoa : repoPessoaJuridica.obterTodos()) {
                            pessoa.exibir();
                        }
                    } else {
                        System.out.println("Tipo de Pessoa inválido. Use 'F' para Pessoa Física ou 'J' para Pessoa Jurídica.");
                    }
                    break;

                case 6:
                     System.out.print("Informe o prefixo dos arquivos: ");
                    String prefixo = scanner.next();

                    try {
                        repoPessoaFisica.persistir(prefixo + ".fisica.bin");
                        repoPessoaJuridica.persistir(prefixo + ".juridica.bin");
                        System.out.println("Dados salvos com sucesso!");
                    } catch (IOException e) {
                        System.err.println("Erro ao salvar os dados: " + e.getMessage());
                    }
                    break;

                case 7:           
                    System.out.print("Informe o prefixo dos arquivos: ");
                    String prefixoRecuperar = scanner.next();

                    try {
                        repoPessoaFisica.recuperar(prefixoRecuperar + ".fisica.bin");
                        repoPessoaJuridica.recuperar(prefixoRecuperar + ".juridica.bin");
                        System.out.println("Dados recuperados com sucesso!");
                    } catch (IOException | ClassNotFoundException e) {
                        System.err.println("Erro ao recuperar os dados: " + e.getMessage());
                    }
                    break;

                case 0:
                    System.out.println("Encerrando o programa.");
                    System.exit(0);

                default:
                    System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
            }
        } while (opcao != 0);
    }
}
    

