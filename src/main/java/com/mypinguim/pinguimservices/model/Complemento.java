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
@Table(name="complemento")
@XmlRootElement
@Audited
public class Complemento
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  @Column(name="id_complemento")
  private Long idComplemento;
  @Column(name="nome")
  @NotNull
  @Size(max=60)
  @NotEmpty
  private String nome;
  @Column(name="valor_adiciona")
  @NotNull
  private Double valorAdiciona;
  @Column(name="valor_remover")
  @NotNull
  private Double valorRemover;
  @ManyToOne
  @JoinColumn(name="id_vendedor", foreignKey=@ForeignKey(name="comp_vendor_fk"))
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
  
  public Complemento()
  {
    this.valorAdiciona = Double.valueOf(0.0D);
    this.valorRemover = Double.valueOf(0.0D);
  }
  
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
  
  public Long getIdComplemento()
  {
    return this.idComplemento;
  }
  
  public void setIdComplemento(Long idComplemento)
  {
    this.idComplemento = idComplemento;
  }
  
  public String getNome()
  {
    return this.nome;
  }
  
  public void setNome(String nome)
  {
    this.nome = nome;
  }
  
  public Double getValorAdiciona()
  {
    return this.valorAdiciona;
  }
  
  public void setValorAdiciona(Double valorAdiciona)
  {
    this.valorAdiciona = valorAdiciona;
  }
  
  public Double getValorRemover()
  {
    return this.valorRemover;
  }
  
  public void setValorRemover(Double valorRemover)
  {
    this.valorRemover = valorRemover;
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
    hash = 97 * hash + Objects.hashCode(this.idComplemento);
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
    Complemento other = (Complemento)obj;
    if (!Objects.equals(this.idComplemento, other.idComplemento)) {
      return false;
    }
    return true;
  }
}
