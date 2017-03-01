package com.mypinguim.pinguimservices.model;

import com.mypinguim.pinguimservices.enumerated.SituacaoEnum;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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

@Entity
@Table(name="forma_pagamento")
@XmlRootElement
public class FormaPagamento
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  @Column(name="id_forma_pagamento")
  private Long idFormaPagamento;
  @Column(name="nome", length=20, nullable=false)
  private String nome;
  @Column(name="situacao", nullable=false)
  @Enumerated(EnumType.STRING)
  private SituacaoEnum situacao;
  @Column(name="icon", length=20, nullable=false)
  private String icon;
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
  
  public FormaPagamento()
  {
    this.situacao = SituacaoEnum.A;
  }
  
  public Long getIdFormaPagamento()
  {
    return this.idFormaPagamento;
  }
  
  public void setIdFormaPagamento(Long idFormaPagamento)
  {
    this.idFormaPagamento = idFormaPagamento;
  }
  
  public String getNome()
  {
    return this.nome;
  }
  
  public void setNome(String nome)
  {
    this.nome = nome;
  }
  
  public SituacaoEnum getSituacao()
  {
    return this.situacao;
  }
  
  public void setSituacao(SituacaoEnum situacao)
  {
    this.situacao = situacao;
  }
  
  public String getIcon()
  {
    return this.icon;
  }
  
  public void setIcon(String icon)
  {
    this.icon = icon;
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
    hash = 41 * hash + Objects.hashCode(this.idFormaPagamento);
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
    FormaPagamento other = (FormaPagamento)obj;
    if (!Objects.equals(this.idFormaPagamento, other.idFormaPagamento)) {
      return false;
    }
    return true;
  }
}
