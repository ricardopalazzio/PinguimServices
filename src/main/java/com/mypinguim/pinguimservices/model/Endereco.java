package com.mypinguim.pinguimservices.model;

import com.mypinguim.pinguimservices.enumerated.TipoEnderecoEnum;
import com.mypinguim.pinguimservices.enumerated.TipoLogradouroEnum;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
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
@Table(name="endereco")
@XmlRootElement
@Audited
public class Endereco
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  @Column(name="id_endereco")
  private Long idEndereco;
 
  @Column(name="endereco", length=200, nullable=false)
  @NotEmpty
  private String endereco;
  
  @Column(name="bairro", length=30, nullable=false)
  private String bairro;
  
  @ManyToOne
  @JoinColumn(name="id_cidade", foreignKey=@ForeignKey(name="endereco_cidade_fk"), nullable=false)
  private Cidade cidade;
  
  @Column(name="cep", length=10)
  @NotEmpty
  private String cep;
  
  @Column(name="latitude")
  private Double latitude;
  
  @Column(name="longitude")
  private Double longitude;
  
  public Endereco()
  {
    this.cidade = new Cidade();
  }
  
  @Column(name="pesquisa_endereco")
  private Boolean pesquisaEndereco = Boolean.valueOf(true);
 
  @Column(name="endereco_numero", length=11)
  private String numero;
  
  @Column(name="endereco_complemento", length=30)
  private String complemento;
  
  @Enumerated(EnumType.ORDINAL)
  @Column(name="tipo_logradouro")
  private TipoLogradouroEnum tipoLogradouro;
 
  @Enumerated(EnumType.ORDINAL)
  @Column(name="tipo_endereco")
  private TipoEnderecoEnum tipoEndereco;
 
  @Column(name="referencia", length=300)
  private String referencia;
 
  @ManyToOne(fetch=FetchType.LAZY)
  @JoinColumn(name="id_vendedor", foreignKey=@ForeignKey(name="telefone_vendedor_fk"))
  private Vendedor vendedor;
  
  @ManyToOne(fetch=FetchType.LAZY)
  @JoinColumn(name="id_cliente", foreignKey=@ForeignKey(name="telefone_cliente_fk"))
  private Cliente cliente;
  
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
  
  public Long getIdEndereco()
  {
    return this.idEndereco;
  }
  
  public void setIdEndereco(Long idEndereco)
  {
    this.idEndereco = idEndereco;
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
  
  public String getEndereco()
  {
    return this.endereco;
  }
  
  public void setEndereco(String endereco)
  {
    this.endereco = endereco;
  }
  
  public String getBairro()
  {
    return this.bairro;
  }
  
  public void setBairro(String bairro)
  {
    this.bairro = bairro;
  }
  
  public Cidade getCidade()
  {
    return this.cidade;
  }
  
  public void setCidade(Cidade cidade)
  {
    this.cidade = cidade;
  }
  
  public String getCep()
  {
    return this.cep;
  }
  
  public void setCep(String cep)
  {
    this.cep = cep;
  }
  
  public Double getLatitude()
  {
    return this.latitude;
  }
  
  public void setLatitude(Double latitude)
  {
    this.latitude = latitude;
  }
  
  public Double getLongitude()
  {
    return this.longitude;
  }
  
  public void setLongitude(Double longitude)
  {
    this.longitude = longitude;
  }
  
  public Boolean getPesquisaEndereco()
  {
    return this.pesquisaEndereco;
  }
  
  public void setPesquisaEndereco(Boolean pesquisaEndereco)
  {
    this.pesquisaEndereco = pesquisaEndereco;
  }
  
  public String getNumero()
  {
    return this.numero;
  }
  
  public void setNumero(String numero)
  {
    this.numero = numero;
  }
  
  public String getComplemento()
  {
    return this.complemento;
  }
  
  public void setComplemento(String complemento)
  {
    this.complemento = complemento;
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
  
  public TipoLogradouroEnum getTipoLogradouro()
  {
    return this.tipoLogradouro;
  }
  
  public void setTipoLogradouro(TipoLogradouroEnum tipoLogradouro)
  {
    this.tipoLogradouro = tipoLogradouro;
  }
  
  public TipoEnderecoEnum getTipoEndereco()
  {
    return this.tipoEndereco;
  }
  
  public void setTipoEndereco(TipoEnderecoEnum tipoEndereco)
  {
    this.tipoEndereco = tipoEndereco;
  }
  
  public String getReferencia()
  {
    return this.referencia;
  }
  
  public void setReferencia(String referencia)
  {
    this.referencia = referencia;
  }
  
  public int hashCode()
  {
    int hash = 7;
    hash = 13 * hash + Objects.hashCode(this.idEndereco);
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
    Endereco other = (Endereco)obj;
    if (!Objects.equals(this.idEndereco, other.idEndereco)) {
      return false;
    }
    return true;
  }
}
