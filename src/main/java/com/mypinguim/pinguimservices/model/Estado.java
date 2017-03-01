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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.hibernate.envers.Audited;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="estado", uniqueConstraints={@javax.persistence.UniqueConstraint(columnNames={"sigla", "id_pais"})})
@XmlRootElement
@Audited
public class Estado
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  @Column(name="id_estado")
  private Long idEstado;
 
  @Column(name="nome", length=60)
  @Size(max=90)
  @NotNull
  @NotEmpty
  private String nome;
 
  @Column(name="sigla", length=10, nullable=false)
  @NotEmpty
  private String sigla;
  
  @Column(name="cod_ibge")
  private Integer codigoIBGE;
  
  @ManyToOne
  @NotNull
  @JoinColumn(name="id_pais", foreignKey=@ForeignKey(name="estado_pais_fk"))
  private Pais pais;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }
 
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
  
  public String getNome()
  {
    return this.nome;
  }
  
  public void setNome(String nome)
  {
    this.nome = nome;
  }
  
  public String getSigla()
  {
    return this.sigla;
  }
  
  public void setSigla(String sigla)
  {
    this.sigla = sigla;
  }
  
  public Pais getPais()
  {
    return this.pais;
  }
  
  public void setPais(Pais pais)
  {
    this.pais = pais;
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
  
  public Long getIdEstado()
  {
    return this.idEstado;
  }
  
  public void setIdEstado(Long idEstado)
  {
    this.idEstado = idEstado;
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
    int hash = 3;
    hash = 23 * hash + Objects.hashCode(this.idEstado);
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
    Estado other = (Estado)obj;
    if (!Objects.equals(this.idEstado, other.idEstado)) {
      return false;
    }
    return true;
  }
}
