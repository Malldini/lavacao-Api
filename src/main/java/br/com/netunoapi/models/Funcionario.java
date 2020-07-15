/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.netunoapi.models;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Thiago Luiz
 */
@Entity
@Table(name = "funcionario", schema = "public")
public class Funcionario implements Serializable {
    
    @Id
    @GeneratedValue
    private UUID id;
    
    @NotNull(message ="o campo nome não pode estar vazio" )
    @Size(min = 1,message = "o campo nome está vazio")
    @Column(nullable = false)
    private String nome;
    
    @Size(min = 10,max = 14, message = "o o telefone informado está incorreto")
    @NotNull(message ="o campo telefone não pode estar vazio" )
    @Column(nullable = false, unique = true)
    private String tel;
    
    @NotNull(message ="o campo cpf não pode estar vazio" )
    @Size(min = 11,max = 14, message = "o Campo cpf deve possuir 14 caracteres")
    @Column(nullable = false, unique = true)
    private String cpf;
    
//    @OneToMany(cascade = CascadeType.ALL,mappedBy = "funcionario")
//    
//    private List<Agendamento> agendamento;

    public Funcionario() {
    }    
    
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

//    public List<Agendamento> getAgendamento() {
//        return agendamento;
//    }
//
//    public void setAgendamento(List<Agendamento> agendamento) {
//        this.agendamento = agendamento;
//    }
    
    
}
