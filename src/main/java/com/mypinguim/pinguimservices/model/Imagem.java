package com.mypinguim.pinguimservices.model;

import com.mypinguim.pinguimservices.enumerated.ImagemCodEnum;
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

@Entity
@Table(name="imagem")
@XmlRootElement
public class Imagem
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  @Column(name="id_imagem")
  private Long idImagem;
  @Column(name="descricao")
  private String descricao;
  @Column(name="nome_arquivo", nullable=false)
  private String nomeArquivo;
  @Column(name="hash")
  private String hash;
  @Column(name="sequencia")
  private Integer sequencia = Integer.valueOf(0);
  @Column(name="codigo")
  @Enumerated(EnumType.STRING)
  private ImagemCodEnum codigo;
  @ManyToOne(fetch=FetchType.LAZY)
  @JoinColumn(name="id_vendedor", foreignKey=@ForeignKey(name="img_vendedor_fk"))
  private Vendedor vendedor;
  @ManyToOne(fetch=FetchType.LAZY)
  @JoinColumn(name="id_cliente", foreignKey=@ForeignKey(name="img_cliente_fk"))
  private Cliente cliente;
  @ManyToOne(fetch=FetchType.LAZY)
  @JoinColumn(name="id_produto", foreignKey=@ForeignKey(name="img_produto_fk"))
  private Produto produto;
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
  
  public Long getIdImagem()
  {
    return this.idImagem;
  }
  
  public void setIdImagem(Long idImagem)
  {
    this.idImagem = idImagem;
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
  
  public Produto getProduto()
  {
    return this.produto;
  }
  
  public void setProduto(Produto produto)
  {
    this.produto = produto;
  }
  
  public String getDescricao()
  {
    return this.descricao;
  }
  
  public void setDescricao(String descricao)
  {
    this.descricao = descricao;
  }
  
  public String getNomeArquivo()
  {
    return this.nomeArquivo;
  }
  
  public void setNomeArquivo(String nomeArquivo)
  {
    this.nomeArquivo = nomeArquivo;
  }
  
  public Integer getSequencia()
  {
    return this.sequencia;
  }
  
  public void setSequencia(Integer sequencia)
  {
    this.sequencia = sequencia;
  }
  
  public ImagemCodEnum getCodigo()
  {
    return this.codigo;
  }
  
  public void setCodigo(ImagemCodEnum codigo)
  {
    this.codigo = codigo;
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
  
  public String getHash()
  {
    return this.hash;
  }
  
  public void setHash(String hash)
  {
    this.hash = hash;
  }
  
  public int hashCode()
  {
    int hash = 7;
    hash = 67 * hash + Objects.hashCode(this.idImagem);
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
    Imagem other = (Imagem)obj;
    if (!Objects.equals(this.idImagem, other.idImagem)) {
      return false;
    }
    return true;
  }
}
