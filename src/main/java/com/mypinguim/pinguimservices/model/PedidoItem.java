/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mypinguim.pinguimservices.model;

import com.mypinguim.pinguimservices.enumerated.TipoAgrupamentoComplementoEnum;
import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import org.hibernate.envers.NotAudited;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author ricar
 */
@Entity
@Table(name = "pedido_item")
@XmlRootElement
public class PedidoItem  implements Serializable{
    
    @Id
    @Column(name = "id_pedido_item")
    @org.hibernate.annotations.Type(type="pg-uuid")
    private UUID id;
    
    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "id_pedido" , foreignKey = @ForeignKey(name = "pedidoitem_pedido_fk"))
    @NotNull
    @NotAudited
    private Pedido pedido;
    
    @Column(name = "sequencia")
    @NotNull
    private Integer sequencia;
    
    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "id_produto" , foreignKey = @ForeignKey(name="pedItem_produto_fk"))
    @NotNull
    private Produto produto;
    
    @Column(name = "produto_nome")
    @NotEmpty
    private String produtoNome;
    
    @Column(name = "produto_valor_total")
    @NotNull
    private Double produtoValorTotal;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_complemento" , foreignKey = @ForeignKey(name="pedItem_complemento_fk"))
    @NotNull
    private Complemento complemento;
    
    @Column(name= "complemento_nome")
    @NotEmpty
    private String complementoNome;
    
    @Column(name = "complemento_valor")
    @NotNull
    private Double complementoValor;
    
    @Column(name = "complemento_valor_adiciona")
    @NotNull
    private Double complementoValorAdiciona;
    
    @Column(name = "complemento_valor_remove")
    @NotNull
    private Double complementoValorRemove;
    
    @Column(name = "agrupamento_complemento_descricao")
    @NotNull
    private String tpAgrupamentoCompDescricao;

    @Enumerated(EnumType.ORDINAL)
    @Column(name="tipo_agrupamento_complemento" )
    private TipoAgrupamentoComplementoEnum tipoAgrupamentoComplemento;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Integer getSequencia() {
        return sequencia;
    }

    public void setSequencia(Integer sequencia) {
        this.sequencia = sequencia;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public String getProdutoNome() {
        return produtoNome;
    }

    public void setProdutoNome(String produtoNome) {
        this.produtoNome = produtoNome;
    }

    public Double getProdutoValorTotal() {
        return produtoValorTotal;
    }

    public void setProdutoValorTotal(Double produtoValorTotal) {
        this.produtoValorTotal = produtoValorTotal;
    }

    public Complemento getComplemento() {
        return complemento;
    }

    public void setComplemento(Complemento complemento) {
        this.complemento = complemento;
    }

    public String getComplementoNome() {
        return complementoNome;
    }

    public void setComplementoNome(String complementoNome) {
        this.complementoNome = complementoNome;
    }

    public Double getComplementoValor() {
        return complementoValor;
    }

    public void setComplementoValor(Double complementoValor) {
        this.complementoValor = complementoValor;
    }

    public Double getComplementoValorAdiciona() {
        return complementoValorAdiciona;
    }

    public void setComplementoValorAdiciona(Double complementoValorAdiciona) {
        this.complementoValorAdiciona = complementoValorAdiciona;
    }

    public Double getComplementoValorRemove() {
        return complementoValorRemove;
    }

    public void setComplementoValorRemove(Double complementoValorRemove) {
        this.complementoValorRemove = complementoValorRemove;
    }

    public String getTpAgrupamentoCompDescricao() {
        return tpAgrupamentoCompDescricao;
    }

    public void setTpAgrupamentoCompDescricao(String tpAgrupamentoCompDescricao) {
        this.tpAgrupamentoCompDescricao = tpAgrupamentoCompDescricao;
    }

    public TipoAgrupamentoComplementoEnum getTipoAgrupamentoComplemento() {
        return tipoAgrupamentoComplemento;
    }

    public void setTipoAgrupamentoComplemento(TipoAgrupamentoComplementoEnum tipoAgrupamentoComplemento) {
        this.tipoAgrupamentoComplemento = tipoAgrupamentoComplemento;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.id);
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
        final PedidoItem other = (PedidoItem) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    

    
}
