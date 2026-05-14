package org.example.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.example.TipoDeServico;

@Entity
@Table(name = "formularios")
public class Formulario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Nome é obrigatório")
    @Size(min = 3, max = 100, message = "Nome deve ter entre 3 e 100 caracteres")
    private String nome;

    @NotBlank(message = "Email é obrigatório")
    @Email(message = "Email deve ser válido")
    private String email;

    @NotBlank(message = "Telefone é obrigatório")
    @Size(min = 10, max = 11, message = "Telefone deve ter 10 ou 11 dígitos")
    private String telefone;

    @Enumerated(EnumType.STRING)//mostra o nome ao invés do índice
    private TipoDeServico tipoDeServico;

    @Size(max = 500, message = "Não pode exceder 500 caracteres")
    private String mensagem; // (campo texto, 3 linhas) – "Descreva sua ideia ou necessidade"

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public TipoDeServico getTipoDeServico() {
        return tipoDeServico;
    }

    public void setTipoDeServico(TipoDeServico tipoDeServico) {
        this.tipoDeServico = tipoDeServico;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
}


