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
import org.hibernate.envers.Audited;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="cidade")
@XmlRootElement
@Audited
public class Cidade
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  @Column(name="id_cidade")
  private Long idCidade;
  @Column(name="nome", length=60)
  @NotNull
  @NotEmpty
  private String nome;
  @Column(name="cod_ibge")
  private Integer codigoIBGE;
  @ManyToOne
  @NotNull
  @JoinColumn(name="id_estado", foreignKey=@ForeignKey(name="cidade_estado_fk"))
  private Estado estado;
  @Column(name="cep_basico")
  private String cepBasico;
  @Column(name="ddd")
  private String ddd;
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
  
  public Long getIdCidade()
  {
    return this.idCidade;
  }
  
  public void setIdCidade(Long idCidade)
  {
    this.idCidade = idCidade;
  }
  
  public String getNome()
  {
    return this.nome;
  }
  
  public void setNome(String nome)
  {
    this.nome = nome;
  }
  
  public Estado getEstado()
  {
    return this.estado;
  }
  
  public void setEstado(Estado estado)
  {
    this.estado = estado;
  }
  
  public String getCepBasico()
  {
    return this.cepBasico;
  }
  
  public void setCepBasico(String cepBasico)
  {
    this.cepBasico = cepBasico;
  }
  
  public String getDdd()
  {
    return this.ddd;
  }
  
  public void setDdd(String ddd)
  {
    this.ddd = ddd;
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
  
  public Integer getCodigoIBGE()
  {
    return this.codigoIBGE;
  }
  
  public void setCodigoIBGE(Integer codigoIBGE)
  {
    this.codigoIBGE = codigoIBGE;
  }
  
  public int hashCode()
  {
    int hash = 7;
    hash = 89 * hash + Objects.hashCode(this.idCidade);
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
    Cidade other = (Cidade)obj;
    if (!Objects.equals(this.idCidade, other.idCidade)) {
      return false;
    }
    return true;
  }
}
