/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mypinguim.pinguimservices.model;

import com.mypinguim.pinguimservices.enumerated.PedidoSituacaoEnum;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.hibernate.envers.Audited;
import org.hibernate.envers.NotAudited;
import org.hibernate.envers.RelationTargetAuditMode;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author ricar
 */
@Entity
@Table(name = "pedido")
@XmlRootElement
@Audited
public class Pedido  implements Serializable{
    
    @Id
    @Column(name = "id_pedido")
    @org.hibernate.annotations.Type(type="pg-uuid")
    private UUID id;
    
    
    @ManyToOne
    @JoinColumn(name = "id_cliente" , foreignKey = @ForeignKey(name = "pedido_cliente_fk"))
    @Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
    private Cliente cliente;
    
    @ManyToOne
    @JoinColumn(name = "id_vendedor" , foreignKey = @ForeignKey(name = "pedido_vendedor_fk"))
    @Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
    private Vendedor vendedor;
    
    // Campos de endereco  para entrega
    @Column(name = "latitude")
    @NotAudited
    private Double latitude;
            
    @Column(name ="longitude")
    @NotAudited
    private Double longitude;
    
    @Column(name="numero")
    @NotEmpty
    @NotAudited
    private String numero;
    
    @Column(name="logradouro")
    @NotEmpty
    @NotAudited
    private String logradouro;
    
    @Column(name = "bairro")
    @NotEmpty
    @NotAudited
    private String bairro;
    
    @ManyToOne
    @JoinColumn(name = "id_cidade" , foreignKey = @ForeignKey(name = "pedido_cidade_fk"))
    @NotNull
    @Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
    private Cidade cidade;
    
    // valores e pagamento
    @Column(name = "valor_total")
    @NotNull
    @DecimalMin("0.01")
    @NotAudited
    private Double valorTotal;
 
    @Column(name="valor_troco")
    @NotAudited
    private Double valorTroco;
    
    @ManyToOne
    @JoinColumn(name = "id_forma_pagamento" , foreignKey = @ForeignKey(name = "pedido_formaPgto_fk"))
    @NotNull
    @Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
    private FormaPagamento formaPagamento;
    
    //adicionais 
    @Enumerated(EnumType.ORDINAL)
    @Column(name = "situacao")
    @NotNull
    private PedidoSituacaoEnum situacao;
            

    @XmlTransient
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="data_inclusao")
    @NotNull
    @NotAudited
    private Date dataInclusao;
    
    @XmlTransient
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="data_alteracao")
    @NotNull
    private Date dataAlteracao;

    @PrePersist
    public void prePersist()
    {
      this.dataInclusao = new Date();
      this.dataAlteracao  = new Date();
    }

    @PreUpdate
    public void  preUpdate(){
        this.dataAlteracao  = new Date();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Double getValorTroco() {
        return valorTroco;
    }

    public void setValorTroco(Double valorTroco) {
        this.valorTroco = valorTroco;
    }

    public FormaPagamento getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(FormaPagamento formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public PedidoSituacaoEnum getSituacao() {
        return situacao;
    }

    public void setSituacao(PedidoSituacaoEnum situacao) {
        this.situacao = situacao;
    }

    public Date getDataInclusao() {
        return dataInclusao;
    }

    public void setDataInclusao(Date dataInclusao) {
        this.dataInclusao = dataInclusao;
    }

    public Date getDataAlteracao() {
        return dataAlteracao;
    }

    public void setDataAlteracao(Date dataAlteracao) {
        this.dataAlteracao = dataAlteracao;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Pedido other = (Pedido) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    
}
