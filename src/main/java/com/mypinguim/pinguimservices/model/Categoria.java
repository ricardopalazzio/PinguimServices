package com.mypinguim.pinguimservices.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.hibernate.envers.Audited;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="categoria")
@XmlRootElement
@Audited
public class Categoria
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  @Column(name="id_categoria")
  private Long idCategoria;
  @Column(name="nome", length=60)
  @NotEmpty
  @NotNull
  private String nome;
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
  
  public Long getIdCategoria()
  {
    return this.idCategoria;
  }
  
  public void setIdCategoria(Long idCategoria)
  {
    this.idCategoria = idCategoria;
  }
  
  public String getNome()
  {
    return this.nome;
  }
  
  public void setNome(String nome)
  {
    this.nome = nome;
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
    int hash = 5;
    hash = 89 * hash + Objects.hashCode(this.idCategoria);
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
    Categoria other = (Categoria)obj;
    if (!Objects.equals(this.idCategoria, other.idCategoria)) {
      return false;
    }
    return true;
  }
}
