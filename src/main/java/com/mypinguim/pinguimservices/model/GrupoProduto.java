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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name="grupo_produto")
@XmlRootElement
public class GrupoProduto
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  @Column(name="id_grupo_produto")
  private Long idGrupoProduto;
  @Column(name="nome", length=60, nullable=false)
  private String nome;
  @ManyToOne
  @JoinColumn(name="id_vendedor", foreignKey=@ForeignKey(name="gp_vendor_fk"))
  @NotNull
  private Vendedor vendedor;
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
  
  public Long getIdGrupoProduto()
  {
    return this.idGrupoProduto;
  }
  
  public void setIdGrupoProduto(Long idGrupoProduto)
  {
    this.idGrupoProduto = idGrupoProduto;
  }
  
  public String getNome()
  {
    return this.nome;
  }
  
  public void setNome(String nome)
  {
    this.nome = nome;
  }
  
  public Vendedor getVendedor()
  {
    return this.vendedor;
  }
  
  public void setVendedor(Vendedor vendedor)
  {
    this.vendedor = vendedor;
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
    int hash = 7;
    hash = 53 * hash + Objects.hashCode(this.idGrupoProduto);
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
    GrupoProduto other = (GrupoProduto)obj;
    if (!Objects.equals(this.idGrupoProduto, other.idGrupoProduto)) {
      return false;
    }
    return true;
  }
}
