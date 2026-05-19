package org.example;

import org.example.FormulariosUI.FormularioUI;
import org.example.model.Formulario;
import org.example.dao.FormularioDao;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello, World!");
        Scanner scanner = new Scanner(System.in);
        FormularioDao formularioDao = new FormularioDao();
        Formulario formulario = new Formulario();

        while(true){
            System.out.print("""
                    xxxxxxxxxxxxxxxxxxxxxxxxxxxx
                    ----------------------------
                    1 - Cadastrar e Salvar
                    2 - Atualizar
                    3 - Deletar
                    4 - Lista
                    5 - Fechar Programa \n
                    *Digite a sua opção aqui:  """);

            int op = scanner.nextInt();
            scanner.nextLine(); // consome a quebra de linha após o número
            System.out.println("Você escolheu a opção: " + op + "\n");

            switch(op){
                case 1 -> {
                        formulario = FormularioUI.capturarDados(scanner); //formulario vai receber o objeto que o método capturarDados retornou.
                        formularioDao.salvar(formulario);
                        System.out.println("Formulário salvo com ID: " + formulario.getId());
                }
                case 2 -> {
                    System.out.println("*** Digite os seus dados a serem atualizados ***");
                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();
                    formulario.setNome(nome);

                    System.out.println("Telefone: ");
                    String telefone = scanner.nextLine();
                    formulario.setTelefone(telefone);

                    System.out.println("Email: ");
                    String email = scanner.nextLine();

                    System.out.println("Mensagem: ");
                    String mensagem = scanner.nextLine();
                    formulario.setMensagem(mensagem);
                    formularioDao.atualizar(formulario);
                    System.out.println("-----------------------------------------");
                }
                case 3 -> {
                    formularioDao.deletar(formulario);
                }
                case 4 -> {
                   List<Formulario> lista = formularioDao.listarTodos();
                   if(lista.isEmpty()){
                       System.out.println("Nenhum formulário cadastrado! ");
                   }
                   for(Formulario f: lista){
                       System.out.println("ID: " + f.getId());
                       System.out.println("Nome: " + f.getNome());
                       System.out.println("Telefone: " + f.getTelefone());
                       System.out.println("Email: " + f.getEmail());
                       System.out.println("Mensagem: " + f.getMensagem());
                       System.out.println("-----------------------------------------");
                   }
                }
                case 5 ->{
                    System.out.println("Encerrando programa...");
                    scanner.close();
                    return;
                }
                default -> System.out.println("Opção Inválida!");

            }

        }

    }


}