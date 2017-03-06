package com.mypinguim.pinguimservices.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlTransient;
import org.hibernate.envers.Audited;

@Entity
@Table(name="produto_complemento", uniqueConstraints={@javax.persistence.UniqueConstraint(columnNames={"id_produto", "id_complemento", "id_tipo_agrupamento_complemento"})})
@Audited
public class ProdutoComplemento
  implements Serializable
{
  @Id
  @Column(name="id_produto_complemento")
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Long idProdutoComplemento;
  @ManyToOne
  @JoinColumn(name="id_produto", nullable=false, foreignKey=@ForeignKey(name="pc_produto_fk"))
  private Produto produto;
  @ManyToOne
  @JoinColumn(name="id_complemento", nullable=false, foreignKey=@ForeignKey(name="pc_complemento_fk"))
  private Complemento complemento;
  @Column(name="quantidade", nullable=false)
  private Integer quantidade;
  @Column(name="quantidade_limite", nullable=false)
  private Integer quantidadeLimite;
  
  public ProdutoComplemento()
  {
    this.complemento = new Complemento();
    
    this.quantidade = Integer.valueOf(1);
    
    this.quantidadeLimite = Integer.valueOf(0);
  }
  
  @Column(name="sequencia", nullable=false)
  private Integer sequencia = Integer.valueOf(0);
  @ManyToOne
  @JoinColumn(name="id_tipo_agrupamento_complemento", foreignKey=@ForeignKey(name="pc_tipoAgrupamentoComplemento_fk"))
  @NotNull
  private TipoAgrupamentoComplemento tipoAgrupamentoComplemento;
  @XmlTransient
  @Temporal(TemporalType.TIMESTAMP)
  @Column(name="data_alteracao")
  @NotNull
  private Date dataAlteracao;
  @XmlTransient
  @Temporal(TemporalType.TIMESTAMP)
  @Column(name="data_inclusao")
  @NotNull
  private Date dataInclusao;
  
  @PrePersist
  public void prePersist()
  {
    this.dataInclusao = new Date();
    this.dataAlteracao = new Date();
  }
  
  @PreUpdate
  public void preUpdate()
  {
    this.dataAlteracao = new Date();
  }
  
  public Long getIdProdutoComplemento()
  {
    return this.idProdutoComplemento;
  }
  
  public void setIdProdutoComplemento(Long idProdutoComplemento)
  {
    this.idProdutoComplemento = idProdutoComplemento;
  }
  
  public Produto getProduto()
  {
    return this.produto;
  }
  
  public void setProduto(Produto produto)
  {
    this.produto = produto;
  }
  
  public Complemento getComplemento()
  {
    return this.complemento;
  }
  
  public void setComplemento(Complemento complemento)
  {
    this.complemento = complemento;
  }
  
  public Integer getQuantidade()
  {
    return this.quantidade;
  }
  
  public void setQuantidade(Integer quantidade)
  {
    this.quantidade = quantidade;
  }
  
  public Integer getQuantidadeLimite()
  {
    return this.quantidadeLimite;
  }
  
  public void setQuantidadeLimite(Integer quantidadeLimite)
  {
    this.quantidadeLimite = quantidadeLimite;
  }
  
  public Integer getSequencia()
  {
    return this.sequencia;
  }
  
  public void setSequencia(Integer sequencia)
  {
    this.sequencia = sequencia;
  }
  
  public TipoAgrupamentoComplemento getTipoAgrupamentoComplemento()
  {
    return this.tipoAgrupamentoComplemento;
  }
  
  public void setTipoAgrupamentoComplemento(TipoAgrupamentoComplemento tipoAgrupamentoComplemento)
  {
    this.tipoAgrupamentoComplemento = tipoAgrupamentoComplemento;
  }
  
  public Date getDataAlteracao()
  {
    return this.dataAlteracao;
  }
  
  public void setDataAlteracao(Date dataAlteracao)
  {
    this.dataAlteracao = dataAlteracao;
  }
  
  public Date getDataInclusao()
  {
    return this.dataInclusao;
  }
  
  public void setDataInclusao(Date dataInclusao)
  {
    this.dataInclusao = dataInclusao;
  }
  
  public int hashCode()
  {
    int hash = 3;
    hash = 83 * hash + Objects.hashCode(this.idProdutoComplemento);
    return hash;
  }
  
  public boolean equals(Object obj)
  {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    ProdutoComplemento other = (ProdutoComplemento)obj;
    if (!Objects.equals(this.idProdutoComplemento, other.idProdutoComplemento)) {
      return false;
    }
    return true;
  }
}
