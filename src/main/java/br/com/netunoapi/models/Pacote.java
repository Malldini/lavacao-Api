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
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Thiago Luiz
 */
@Entity
@Table(name = "pacote", schema = "public")
public class Pacote implements Serializable{
    
    @Id
    @GeneratedValue
    private UUID id;
    
    @NotNull(message = "o campo nome não pode estar vazio")
    @Size(min = 1,message = "o campo nome está vazio")
    @Column(nullable = false, unique = true)
    private String nome;
    
    @NotNull(message = "o campo preco não pode estar vazio")
    @Min(0)
    @Column(nullable = false)
    private Float preco;
//    
//    @OneToMany(cascade = CascadeType.ALL,mappedBy = "pacote")
//   
//    private List<Agendamento>agendamento;

    public Pacote() {
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

    public Float getPreco() {
        return preco;
    }

    public void setPreco(Float preco) {
        this.preco = preco;
    }

//    public List<Agendamento> getAgendamento() {
//        return agendamento;
//    }
//
//    public void setAgendamento(List<Agendamento> agendamento) {
//        this.agendamento = agendamento;
//    }
    
    
}
