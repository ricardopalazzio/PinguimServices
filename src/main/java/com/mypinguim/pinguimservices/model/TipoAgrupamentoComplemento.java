package com.mypinguim.pinguimservices.model;

import com.mypinguim.pinguimservices.enumerated.TipoAgrupamentoComplementoEnum;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="tipo_agrupamento_complemento")
@Audited
public class TipoAgrupamentoComplemento
  implements Serializable
{
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  @Column(name="id_tipo_agrupamento_complemento")
  private Long idTipoAgrupamentoComplemento;
  @Column(name="nome")
  @NotEmpty
  private String nome;
  @Enumerated(EnumType.ORDINAL)
  @Column(name="tipo", nullable=false)
  private TipoAgrupamentoComplementoEnum tipoAgrupamentocomplemento;
  @ManyToOne
  @JoinColumn(name="id_vendedor", foreignKey=@ForeignKey(name="tp_comp_vendor_fk"))
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
  
  public Vendedor getVendedor()
  {
    return this.vendedor;
  }
  
  public void setVendedor(Vendedor vendedor)
  {
    this.vendedor = vendedor;
  }
  
  public Long getIdTipoAgrupamentoComplemento()
  {
    return this.idTipoAgrupamentoComplemento;
  }
  
  public void setIdTipoAgrupamentoComplemento(Long idTipoAgrupamentoComplemento)
  {
    this.idTipoAgrupamentoComplemento = idTipoAgrupamentoComplemento;
  }
  
  public TipoAgrupamentoComplementoEnum getTipoAgrupamentocomplemento()
  {
    return this.tipoAgrupamentocomplemento;
  }
  
  public void setTipoAgrupamentocomplemento(TipoAgrupamentoComplementoEnum tipoAgrupamentocomplemento)
  {
    this.tipoAgrupamentocomplemento = tipoAgrupamentocomplemento;
  }
  
  public int hashCode()
  {
    int hash = 3;
    hash = 17 * hash + Objects.hashCode(this.idTipoAgrupamentoComplemento);
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
    TipoAgrupamentoComplemento other = (TipoAgrupamentoComplemento)obj;
    if (!Objects.equals(this.idTipoAgrupamentoComplemento, other.idTipoAgrupamentoComplemento)) {
      return false;
    }
    return true;
  }
}
