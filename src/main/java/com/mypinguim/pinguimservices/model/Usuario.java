package com.mypinguim.pinguimservices.model;

import com.mypinguim.pinguimservices.enumerated.SituacaoEnum;
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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.hibernate.envers.Audited;

@Entity
@Table(name="usuario")
@XmlRootElement
@Audited
public class Usuario
  implements Serializable, Comparable<Usuario>
{
  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  @Column(name="id_usuario")
  private Long idUsuario;
  @Column(name="usuario", nullable=false)
  private String usuario;
  @Column(name="senha", nullable=false)
  private String senha;
  @Column(name="ultimo_acesso")
  @Temporal(TemporalType.TIMESTAMP)
  private Date ultimoAcesso;
  @Column(name="sessao")
  private String sessao;
  @Enumerated(EnumType.STRING)
  @Column(name="situacao")
  private SituacaoEnum situacao;
  @ManyToOne
  @JoinColumn(name="id_vendedor", foreignKey=@ForeignKey(name="usuario_vendedor_fk"))
  private Vendedor vendedor;
  @ManyToOne
  @JoinColumn(name="id_cliente", foreignKey=@ForeignKey(name="usuario_cliente_fk"))
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
  
  public Usuario()
  {
    this.situacao = SituacaoEnum.A;
  }
  
  public Long getIdUsuario()
  {
    return this.idUsuario;
  }
  
  public void setIdUsuario(Long idUsuario)
  {
    this.idUsuario = idUsuario;
  }
  
  public String getUsuario()
  {
    return this.usuario;
  }
  
  public void setUsuario(String usuario)
  {
    this.usuario = usuario;
  }
  
  public String getSenha()
  {
    return this.senha;
  }
  
  public void setSenha(String senha)
  {
    this.senha = senha;
  }
  
  public Date getUltimoAcesso()
  {
    return this.ultimoAcesso;
  }
  
  public void setUltimoAcesso(Date ultimoAcesso)
  {
    this.ultimoAcesso = ultimoAcesso;
  }
  
  public String getSessao()
  {
    return this.sessao;
  }
  
  public void setSessao(String sessao)
  {
    this.sessao = sessao;
  }
  
  public SituacaoEnum getSituacao()
  {
    return this.situacao;
  }
  
  public void setSituacao(SituacaoEnum situacao)
  {
    this.situacao = situacao;
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
  
  public Cliente getCliente()
  {
    return this.cliente;
  }
  
  public void setCliente(Cliente cliente)
  {
    this.cliente = cliente;
  }
  
  public int hashCode()
  {
    int hash = 7;
    hash = 37 * hash + Objects.hashCode(this.idUsuario);
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
    Usuario other = (Usuario)obj;
    if (!Objects.equals(this.idUsuario, other.idUsuario)) {
      return false;
    }
    return true;
  }
  
  public String toString()
  {
    return this.usuario;
  }
  
  public int compareTo(Usuario usu)
  {
    return this.usuario.compareTo(usu.getUsuario());
  }
}
