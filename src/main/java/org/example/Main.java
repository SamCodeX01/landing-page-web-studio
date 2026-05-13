package org.example;

import org.example.model.Formulario;
import org.example.repository.FormularioRepository;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello, World!");

        FormularioRepository repository = new FormularioRepository();

        //Criando  um formulario
        Formulario formulario = new Formulario();
        formulario.setNome("Samuel");
        formulario.setEmail();
        formulario.setTelefone();
        formulario.setTipoDeServico();
        formulario.setMensagem();

        //Salvando um formulario
        repository.salvar(formulario);
        System.out.println("Formulario salvo com ID: " + formulario.getId());

        //Buscar formulario

    }
}