package org.example;

import org.example.model.Formulario;
import org.example.dao.FormularioDao;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello, World!");

        FormularioDao formularioDao = new FormularioDao();

        //Criando um formulario
        Formulario formulario = new Formulario();
        formulario.setNome("Samuel");
        formulario.setEmail("sam@gmail.com");
        formulario.setTelefone("11999999999");
        formulario.setTipoDeServico(TipoDeServico.Ecommerce);
        formulario.setMensagem("Gostaria de realizar um orçamento.");

        //Salvando um formulario
        formularioDao.salvar(formulario);
        System.out.println("Formulario salvo com ID: " + formulario.getId());

        //Buscar formulario



    }
}