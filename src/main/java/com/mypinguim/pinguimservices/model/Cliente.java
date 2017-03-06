package com.mypinguim.pinguimservices.model;

import com.mypinguim.pinguimservices.enumerated.ClienteSituacaoEnum;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.hibernate.envers.Audited;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="cliente")
@XmlRootElement
@Audited
public class Cliente
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  @Id
  @Column(name="id_cliente")
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Long idCliente;
  @Column(name="nome_fantasia", length=250)
  @NotEmpty
  private String nomeFantasia;
  @Column(name="cpf_cnpj", length=18)
  @NotEmpty
  private String cpfCnpj;
  @Column(name="rg_ie", length=25)
  @NotEmpty
  private String rgIe;
  @OneToMany
  @PrimaryKeyJoinColumn
  private List<Telefone> telefones = new ArrayList();
  @OneToMany
  @PrimaryKeyJoinColumn
  private List<Endereco> enderecos = new ArrayList();
  @Enumerated(EnumType.STRING)
  @Column(name="situacao")
  private ClienteSituacaoEnum situacao;
  @Column(name="email", length=150)
  private String email;
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
  
  public Long getIdCliente()
  {
    return this.idCliente;
  }
  
  public void setIdCliente(Long idCliente)
  {
    this.idCliente = idCliente;
  }
  
  public String getNomeFantasia()
  {
    return this.nomeFantasia;
  }
  
  public void setNomeFantasia(String nomeFantasia)
  {
    this.nomeFantasia = nomeFantasia;
  }
  
  public String getCpfCnpj()
  {
    return this.cpfCnpj;
  }
  
  public void setCpfCnpj(String cpfCnpj)
  {
    this.cpfCnpj = cpfCnpj;
  }
  
  public String getRgIe()
  {
    return this.rgIe;
  }
  
  public void setRgIe(String rgIe)
  {
    this.rgIe = rgIe;
  }
  
  public List<Telefone> getTelefones()
  {
    return this.telefones;
  }
  
  public void setTelefones(List<Telefone> telefones)
  {
    this.telefones = telefones;
  }
  
  public List<Endereco> getEnderecos()
  {
    return this.enderecos;
  }
  
  public void setEnderecos(List<Endereco> enderecos)
  {
    this.enderecos = enderecos;
  }
  
  public ClienteSituacaoEnum getSituacao()
  {
    return this.situacao;
  }
  
  public void setSituacao(ClienteSituacaoEnum situacao)
  {
    this.situacao = situacao;
  }
  
  public String getEmail()
  {
    return this.email;
  }
  
  public void setEmail(String email)
  {
    this.email = email;
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
    hash = 97 * hash + Objects.hashCode(this.idCliente);
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
    Cliente other = (Cliente)obj;
    if (!Objects.equals(this.idCliente, other.idCliente)) {
      return false;
    }
    return true;
  }
}
