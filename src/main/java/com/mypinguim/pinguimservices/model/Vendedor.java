package com.mypinguim.pinguimservices.model;

import com.mypinguim.pinguimservices.enumerated.VendedorSituacaoEnum;
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
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="vendedor", uniqueConstraints={@javax.persistence.UniqueConstraint(columnNames={"cpf_cnpj"})})
@XmlRootElement
public class Vendedor
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  @Id
  @Column(name="id_vendedor")
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Long idVendedor;
  @Column(name="nome_fantasia", length=250)
  @NotEmpty
  private String nomeFantasia;
  @Column(name="razao_social", length=150)
  @NotEmpty
  private String razaoSocial;
  @Column(name="cpf_cnpj", length=18)
  @NotEmpty
  private String cpfCnpj;
  @Column(name="rg_ie", length=25)
  @NotEmpty
  private String rgIe;
  @Column(name="email", length=150)
  private String email;
  @Column(name="email_nfe", length=150)
  private String emailNfe;
  @Enumerated(EnumType.STRING)
  @Column(name="situacao")
  private VendedorSituacaoEnum situacao;
  @Column(name="tags")
  private String tags;
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
  @OneToMany
  @PrimaryKeyJoinColumn
  private List<Telefone> telefones = new ArrayList();
  @OneToMany
  @PrimaryKeyJoinColumn
  private List<Endereco> enderecos = new ArrayList();
  
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
  
  public Long getIdVendedor()
  {
    return this.idVendedor;
  }
  
  public void setIdVendedor(Long idVendedor)
  {
    this.idVendedor = idVendedor;
  }
  
  public String getNomeFantasia()
  {
    return this.nomeFantasia;
  }
  
  public void setNomeFantasia(String nomeFantasia)
  {
    this.nomeFantasia = nomeFantasia;
  }
  
  public String getRazaoSocial()
  {
    return this.razaoSocial;
  }
  
  public void setRazaoSocial(String razaoSocial)
  {
    this.razaoSocial = razaoSocial;
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
  
  public String getEmail()
  {
    return this.email;
  }
  
  public void setEmail(String email)
  {
    this.email = email;
  }
  
  public String getEmailNfe()
  {
    return this.emailNfe;
  }
  
  public void setEmailNfe(String emailNfe)
  {
    this.emailNfe = emailNfe;
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
  
  public VendedorSituacaoEnum getSituacao()
  {
    return this.situacao;
  }
  
  public void setSituacao(VendedorSituacaoEnum situacao)
  {
    this.situacao = situacao;
  }
  
  public String getTags()
  {
    return this.tags;
  }
  
  public void setTags(String tags)
  {
    this.tags = tags;
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
    hash = 43 * hash + Objects.hashCode(this.idVendedor);
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
    Vendedor other = (Vendedor)obj;
    if (!Objects.equals(this.idVendedor, other.idVendedor)) {
      return false;
    }
    return true;
  }
}
