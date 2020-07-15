
package br.com.netunoapi.models;

import java.io.Serializable;
import java.util.Date;

import java.util.UUID;
import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "agenda", schema = "public")
public class Agenda implements Serializable {
    
    @Id
    @GeneratedValue
    private UUID id;
    
//    @ManyToOne
    @NotNull(message ="o campo Funcionario não pode estar vazio" )
    private Funcionario funcionario;
    
//    @ManyToOne
    @NotNull(message ="o campo Automovel não pode estar vazio" )
    private Automovel automovel;
    
//    @ManyToOne
    @NotNull(message ="o campo Cliente não pode estar vazio" )
    private Cliente cliente;
    
//    @ManyToOne
    @NotNull(message ="o campo Pacote não pode estar vazio" )
    private Pacote pacote;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date data;
    
    public Agenda(){
        
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    
    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public Automovel getAutomovel() {
        return automovel;
    }

    public void setAutomovel(Automovel automovel) {
        this.automovel = automovel;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Pacote getPacote() {
        return pacote;
    }

    public void setPacote(Pacote pacote) {
        this.pacote = pacote;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
    
}
