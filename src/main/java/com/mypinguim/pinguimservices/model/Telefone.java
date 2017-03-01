package com.mypinguim.pinguimservices.model;

import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="telefone")
@XmlRootElement
public class Telefone
{
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  @Column(name="id_telefone")
  private Long idTelefone;
  @Column(name="ddi")
  @NotEmpty
  private Integer ddi;
  @Column(name="ddd")
  @NotEmpty
  private Integer ddd;
  @Column(name="numero")
  @NotEmpty
  private Integer numero;
  @OneToOne(fetch=FetchType.LAZY)
  @PrimaryKeyJoinColumn
  private TipoTelefone tipoTelefone;
  @ManyToOne(fetch=FetchType.LAZY)
  @JoinColumn(name="id_vendedor", foreignKey=@ForeignKey(name="telefone_vendedor_fk"))
  private Vendedor vendedor;
  @ManyToOne(fetch=FetchType.LAZY)
  @JoinColumn(name="id_cliente", foreignKey=@ForeignKey(name="telefone_cliente_fk"))
  private Cliente cliente;
  @XmlTransient
  @Temporal(TemporalType.TIMESTAMP)
  @Column(name="data_inclusao")
  @NotNull
  private Date dataInclusao;
  @XmlTransient
  @Temporal(TemporalType.TIMESTAMP)
  @Column(name="data_alteracao")
  @NotNull
  private Date dataAlteracao;
  
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
  
  public Integer getDdi()
  {
    return this.ddi;
  }
  
  public void setDdi(Integer ddi)
  {
    this.ddi = ddi;
  }
  
  public Integer getDdd()
  {
    return this.ddd;
  }
  
  public void setDdd(Integer ddd)
  {
    this.ddd = ddd;
  }
  
  public Integer getNumero()
  {
    return this.numero;
  }
  
  public void setNumero(Integer numero)
  {
    this.numero = numero;
  }
  
  public TipoTelefone getTipoTelefone()
  {
    return this.tipoTelefone;
  }
  
  public void setTipoTelefone(TipoTelefone tipoTelefone)
  {
    this.tipoTelefone = tipoTelefone;
  }
  
  public Date getDataInclusao()
  {
    return this.dataInclusao;
  }
  
  public void setDataInclusao(Date dataInclusao)
  {
    this.dataInclusao = dataInclusao;
  }
  
  public Date getDataAlteracao()
  {
    return this.dataAlteracao;
  }
  
  public void setDataAlteracao(Date dataAlteracao)
  {
    this.dataAlteracao = dataAlteracao;
  }
  
  public Vendedor getVendedor()
  {
    return this.vendedor;
  }
  
  public void setVendedor(Vendedor vendedor)
  {
    this.vendedor = vendedor;
  }
  
  public Cliente getCliente()
  {
    return this.cliente;
  }
  
  public void setCliente(Cliente cliente)
  {
    this.cliente = cliente;
  }

    public Long getIdTelefone() {
        return idTelefone;
    }

    public void setIdTelefone(Long idTelefone) {
        this.idTelefone = idTelefone;
    }
  
  public int hashCode()
  {
    int hash = 7;
    hash = 13 * hash + Objects.hashCode(this.idTelefone);
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
    Telefone other = (Telefone)obj;
    if (!Objects.equals(this.idTelefone, other.idTelefone)) {
      return false;
    }
    return true;
  }
}
