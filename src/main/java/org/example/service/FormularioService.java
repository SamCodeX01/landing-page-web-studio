package org.example.service;

import org.example.dao.FormularioDao;
import org.example.model.Formulario;

//Service = regras de negócio + validações + chamar o DAO
public class FormularioService {

    //Essa injeção de Dependencia está criando um "espaço" na memória para guardar uma referência para um objeto do tipo FormularioDao.
    // O Service precisa do DAO para funcionar, mas não vai criá-lo ele mesmo.
    private FormularioDao formularioDao;

    public FormularioService(FormularioDao formularioDao){//Construtor que recebe a dependência: Este é o ponto chave! O Service está dizendo: "Quem quiser me criar, precisa me fornecer um FormularioDao pronto".
        //this.formularioDao = new FormularioDao(); // O SERVICE cria a dependência (ACOPLAMENTO FORTE) Problema: O Service está preso ao FormularioDao. Se quiser testar com um DAO falso (mock) ou mudar a implementação, não consegue.
        this.formularioDao = formularioDao;//O Service não se preocupa em como criar o DAO, só em usar o DAO que recebeu.

        //Resumo: O Service guarda o DAO que recebeu para usar depois.
    }

    // Validações de negócio antes de salvar
    public void salvar(Formulario formulario){
        validarFormulario(formulario);
        // Usa o DAO que foi injetado
        formularioDao.salvar(formulario);
    }

    // Validações de regra de negócio
    private void validarFormulario(Formulario formulario) {


        // Validação de email único (exemplo)
        // Você pode implementar verificações adicionais aqui

        // Validação de telefone (formato brasileiro)
        // Se o tipo de serviço for "Não_sei", a mensagem é obrigatória

        // Limpeza de dados (trim)
    }
}


/*Problemas no seu CRUD atual:
Case 2 (atualizar): Você está atualizando o objeto formulario que pode estar nulo ou com ID errado. Precisa buscar primeiro pelo ID.

Case 3 (deletar): Mesmo problema - você não define qual formulário deletar.

Falta método buscarPorId no DAO:

Preencha o Service com as regras de negócio e ajuste o Main para usá-lo.


         */