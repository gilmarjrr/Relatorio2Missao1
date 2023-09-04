/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cadastropoo;
import java.io.IOException;
import java.io.Serializable;
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
        try {
            // Repositório de Pessoas Físicas
            PessoaFisicaRepo repo1 = new PessoaFisicaRepo();

            // Adicionar duas pessoas físicas
            repo1.inserir(new PessoaFisica(1, "Ana", "11111111111", 25));
            repo1.inserir(new PessoaFisica(2, "Carlos", "22222222222", 52));

            // Persistir dados em um arquivo
            repo1.persistir("pessoas_fisicas.dat");

            // Recuperar dados em outro repositório
            PessoaFisicaRepo repo2 = new PessoaFisicaRepo();
            repo2.recuperar("pessoas_fisicas.dat");

            // Exibir dados de todas as pessoas físicas recuperadas
            System.out.println("Dados de Pessoas Físicas armazenados.");
            System.out.println("Dados de Pessoas Físicas recuperados.");
            for (PessoaFisica pessoa : repo2.obterTodos()) {
                pessoa.exibir();
            }

            // Repositório de Pessoas Jurídicas
            PessoaJuridicaRepo repo3 = new PessoaJuridicaRepo();

            // Adicionar duas pessoas jurídicas
            repo3.inserir(new PessoaJuridica(3, "XPTO Sales", "33333333333"));
            repo3.inserir(new PessoaJuridica(4, "XPTO Solutions", "44444444444"));

            // Persistir dados em um arquivo
            repo3.persistir("pessoas_juridicas.dat");

            // Recuperar dados em outro repositório
            PessoaJuridicaRepo repo4 = new PessoaJuridicaRepo();
            repo4.recuperar("pessoas_juridicas.dat");

            // Exibir dados de todas as pessoas jurídicas recuperadas
            System.out.println("Dados de Pessoas Jurídicas armazenados.");
            System.out.println("Dados de Pessoas Jurídicas recuperados.");
            for (PessoaJuridica pessoa : repo4.obterTodos()) {
                pessoa.exibir();
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    }
    

