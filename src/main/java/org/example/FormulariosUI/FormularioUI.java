package org.example.FormulariosUI;

import org.example.TipoDeServico;
import org.example.dao.FormularioDao;
import org.example.model.Formulario;

import java.util.Scanner;

public class FormularioUI {
    public static Formulario capturarDados(Scanner scanner){

        FormularioDao formularioDao = new FormularioDao();
        Formulario formulario = new Formulario();

        System.out.print("Digite seu nome: ");
        String nome = scanner.nextLine();
        formulario.setNome(nome);

        System.out.print("Digite o seu email: ");
        String email = scanner.next();
        formulario.setEmail(email);

        System.out.print("Digite seu telefone: ");
        String telefone = scanner.next();
        formulario.setTelefone(telefone);

        System.out.print("Escolha o tipo de serviço: ( Institucional,\n" +
                "    LandingPage,\n" +
                "    Ecommerce,\n" +
                "    Sistema,\n" +
                "    Aplicativo,\n" +
                "    Não_sei;),\n" +
                "Digite aqui: ");
        String tipoServico = scanner.next();
        TipoDeServico tipo = TipoDeServico.valueOf(tipoServico);
        formulario.setTipoDeServico(tipo);

        System.out.print("Digite uma mensagem: ");
        String mensagem = scanner.next();
        formulario.setMensagem(mensagem);

        scanner.nextLine(); // limpa o buffer após o next() para próxima leitura de linha
        return formulario;
    }
}
