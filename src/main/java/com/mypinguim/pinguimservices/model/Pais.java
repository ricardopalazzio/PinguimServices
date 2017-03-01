package com.mypinguim.pinguimservices.model;

import com.mypinguim.pinguimservices.model.audit.AuditListener;
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
import org.hibernate.envers.RevisionEntity;
import org.hibernate.envers.RevisionNumber;
import org.hibernate.envers.RevisionTimestamp;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="pais")
@XmlRootElement
@Audited
public class Pais
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  @Column(name="id_pais")
  private Long idPais;

  @Column(name="nome", length=60)
  @NotEmpty
  private String nome;
 
  @Column(name="sigla", length=30)
  @NotEmpty
  private String sigla;
 
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
  
  public static long getSerialVersionUID()
  {
    return 1L;
  }
  
  public Long getIdPais()
  {
    return this.idPais;
  }
  
  public String getNome()
  {
    return this.nome;
  }
  
  public String getSigla()
  {
    return this.sigla;
  }
  
  public Date getDataAlteracao()
  {
    return this.dataAlteracao;
  }
  
  public Date getDataInclusao()
  {
    return this.dataInclusao;
  }

    public void setIdPais(Long idPais) {
        this.idPais = idPais;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public void setDataAlteracao(Date dataAlteracao) {
        this.dataAlteracao = dataAlteracao;
    }

    public void setDataInclusao(Date dataInclusao) {
        this.dataInclusao = dataInclusao;
    }
  

  public int hashCode()
  {
    int hash = 3;
    hash = 79 * hash + Objects.hashCode(this.idPais);
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
    Pais other = (Pais)obj;
    if (!Objects.equals(this.idPais, other.idPais)) {
      return false;
    }
    return true;
  }
}
