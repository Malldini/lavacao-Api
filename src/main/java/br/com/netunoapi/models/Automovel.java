/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.netunoapi.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Thiago Luiz
 */
@Entity
@Table(name = "automovel", schema = "public")
public class Automovel implements Serializable{
    
    @Id
    @GeneratedValue
    private UUID id;
    
    @NotNull(message ="o campo nome não pode estar vazio" )
    @Size(min = 1,message = "o campo nome está vazio")
    @Column(nullable = false)
    private String nome;
    
    @NotNull(message ="o campo marca não pode estar vazio" )
    @Size(min = 1,message = "o campo marca está vazio")
    @Column(nullable = false)
    private String marca;
    
    @Column(nullable = false)
    @NotNull(message ="o campo porta não pode estar vazio" )
    private Integer porta;    

    @NotNull(message ="o campo placa não pode estar vazio" )
    @Size(min = 7,max = 7, message = "o campo placa está vazio")
    @Column(unique = true, nullable = false)
    private String placa;

//    @ManyToMany(mappedBy = "automoveis")
//    private List<Cliente> clientes = new ArrayList<>();
//    
//    @OneToMany(cascade = CascadeType.ALL,mappedBy = "automovel")
//    private List<Agendamento>agendamento;
    
    public Automovel() {
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

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Integer getPorta() {
        return porta;
    }

    public void setPorta(Integer porta) {
        this.porta = porta;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

//    public List<Cliente> getClientes() {
//        return clientes;
//    }
//
//    public void setClientes(List<Cliente> clientes) {
//        this.clientes = clientes;
//    }

//    public List<Agendamento> getAgendamento() {
//        return agendamento;
//    }
//
//    public void setAgendamento(List<Agendamento> agendamento) {
//        this.agendamento = agendamento;
//    }
   
    
}
