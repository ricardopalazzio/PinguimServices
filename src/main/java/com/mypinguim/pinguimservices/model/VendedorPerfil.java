package com.mypinguim.pinguimservices.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.hibernate.annotations.Cascade;

@Entity
@Table(name="vendor_perfil")
@XmlRootElement
public class VendedorPerfil
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  @Id
  @Column(name="id_vendor_perfil")
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Long idVendorPerfil;
  @OneToOne(optional=false, cascade={javax.persistence.CascadeType.MERGE})
  @JoinColumn(name="id_vendedor", nullable=false, foreignKey=@ForeignKey(name="vendorPerf_vendedor_fk"))
  private Vendedor vendedor;
  @Column(name="func_segunda")
  private Boolean funcSegunda = Boolean.valueOf(false);
  @Column(name="segunda_hora_ini")
  private String segHoraIni;
  @Column(name="segunda_hora_fim")
  private String segHoraFim;
  @Column(name="func_terca")
  private Boolean funcTerca = Boolean.valueOf(false);
  @Column(name="terca_hora_ini")
  private String tercaHoraIni;
  @Column(name="terca_hora_fim")
  private String tercaHoraFim;
  @Column(name="func_quarta")
  private Boolean funcQuarta = Boolean.valueOf(false);
  @Column(name="quarta_hora_ini")
  private String quarHoraIni;
  @Column(name="quarta_hora_fim")
  private String quarHoraFim;
  @Column(name="func_quinta")
  private Boolean funcQuinta = Boolean.valueOf(false);
  @Column(name="quinta_hora_ini")
  private String quintaHoraIni;
  @Column(name="quinta_hora_fim")
  private String quintaHoraFim;
  @Column(name="func_sexta")
  private Boolean funcSexta = Boolean.valueOf(false);
  @Column(name="sexta_hora_ini")
  private String sextaHoraIni;
  @Column(name="sexta_hora_fim")
  private String sextaHoraFim;
  @Column(name="func_sabado")
  private Boolean funcSabado = Boolean.valueOf(false);
  @Column(name="sabado_hora_ini")
  private String sabadoHoraIni;
  @Column(name="sabado_hora_fim")
  private String sabadoHoraFim;
  @Column(name="func_domingo")
  private Boolean funcDomingo = Boolean.valueOf(false);
  @Column(name="domingo_hora_ini")
  private String domingoHoraIni;
  @Column(name="domingo_hora_fim")
  private String domingoHoraFim;
  @Column(name="func_feriado")
  private Boolean funcFeriado = Boolean.valueOf(false);
  @Column(name="feriado_hora_ini")
  private String feriadoHoraIni;
  @Column(name="feriado_hora_fim")
  private String feriadoHoraFim;
  @Column(name="fechado")
  private Boolean fechado = Boolean.valueOf(true);
  @ManyToMany
  @JoinTable(name="vendor_perfil_cidade_entrega", joinColumns={@JoinColumn(name="id_vendor_perfil")}, inverseJoinColumns={@JoinColumn(name="id_cidade")})
  @Cascade({org.hibernate.annotations.CascadeType.ALL})
  private List<Cidade> listaCidadesEntrega = new ArrayList();
  @ManyToMany
  @JoinTable(name="vendor_perfil_forma_pagamento", joinColumns={@JoinColumn(name="id_vendor_perfil", foreignKey=@ForeignKey(name="vendedor_perfil_fp_fk"))}, inverseJoinColumns={@JoinColumn(name="id_forma_pagamento", foreignKey=@ForeignKey(name="vendedor_perfil_fp_fp_fk"))})
  @Cascade({org.hibernate.annotations.CascadeType.ALL})
  private List<FormaPagamento> listaFormaPagamentos = new ArrayList();
  @Column(name="valor_entrega_default")
  @NotNull
  private Double valorEntregaDefault;
  @Column(name="n_cobra_entrega_apartir_valor")
  @NotNull
  private Double nCobraEntregaApValor;
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
  
  public VendedorPerfil()
  {
    this.valorEntregaDefault = Double.valueOf(0.0D);
    this.nCobraEntregaApValor = Double.valueOf(0.0D);
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
  
  public Long getIdVendorPerfil()
  {
    return this.idVendorPerfil;
  }
  
  public void setIdVendorPerfil(Long idVendorPerfil)
  {
    this.idVendorPerfil = idVendorPerfil;
  }
  
  public Vendedor getVendedor()
  {
    return this.vendedor;
  }
  
  public void setVendedor(Vendedor vendedor)
  {
    this.vendedor = vendedor;
  }
  
  public Boolean getFuncSegunda()
  {
    return this.funcSegunda;
  }
  
  public void setFuncSegunda(Boolean funcSegunda)
  {
    this.funcSegunda = funcSegunda;
  }
  
  public String getSegHoraIni()
  {
    return this.segHoraIni;
  }
  
  public void setSegHoraIni(String segHoraIni)
  {
    this.segHoraIni = segHoraIni;
  }
  
  public String getSegHoraFim()
  {
    return this.segHoraFim;
  }
  
  public void setSegHoraFim(String segHoraFim)
  {
    this.segHoraFim = segHoraFim;
  }
  
  public Boolean getFuncTerca()
  {
    return this.funcTerca;
  }
  
  public void setFuncTerca(Boolean funcTerca)
  {
    this.funcTerca = funcTerca;
  }
  
  public String getTercaHoraIni()
  {
    return this.tercaHoraIni;
  }
  
  public void setTercaHoraIni(String tercaHoraIni)
  {
    this.tercaHoraIni = tercaHoraIni;
  }
  
  public String getTercaHoraFim()
  {
    return this.tercaHoraFim;
  }
  
  public void setTercaHoraFim(String tercaHoraFim)
  {
    this.tercaHoraFim = tercaHoraFim;
  }
  
  public Boolean getFuncQuarta()
  {
    return this.funcQuarta;
  }
  
  public void setFuncQuarta(Boolean funcQuarta)
  {
    this.funcQuarta = funcQuarta;
  }
  
  public String getQuarHoraIni()
  {
    return this.quarHoraIni;
  }
  
  public void setQuarHoraIni(String quarHoraIni)
  {
    this.quarHoraIni = quarHoraIni;
  }
  
  public String getQuarHoraFim()
  {
    return this.quarHoraFim;
  }
  
  public void setQuarHoraFim(String quarHoraFim)
  {
    this.quarHoraFim = quarHoraFim;
  }
  
  public Boolean getFuncQuinta()
  {
    return this.funcQuinta;
  }
  
  public void setFuncQuinta(Boolean funcQuinta)
  {
    this.funcQuinta = funcQuinta;
  }
  
  public String getQuintaHoraIni()
  {
    return this.quintaHoraIni;
  }
  
  public void setQuintaHoraIni(String quintaHoraIni)
  {
    this.quintaHoraIni = quintaHoraIni;
  }
  
  public String getQuintaHoraFim()
  {
    return this.quintaHoraFim;
  }
  
  public void setQuintaHoraFim(String quintaHoraFim)
  {
    this.quintaHoraFim = quintaHoraFim;
  }
  
  public Boolean getFuncSexta()
  {
    return this.funcSexta;
  }
  
  public void setFuncSexta(Boolean funcSexta)
  {
    this.funcSexta = funcSexta;
  }
  
  public String getSextaHoraIni()
  {
    return this.sextaHoraIni;
  }
  
  public void setSextaHoraIni(String sextaHoraIni)
  {
    this.sextaHoraIni = sextaHoraIni;
  }
  
  public String getSextaHoraFim()
  {
    return this.sextaHoraFim;
  }
  
  public void setSextaHoraFim(String sextaHoraFim)
  {
    this.sextaHoraFim = sextaHoraFim;
  }
  
  public Boolean getFuncSabado()
  {
    return this.funcSabado;
  }
  
  public void setFuncSabado(Boolean funcSabado)
  {
    this.funcSabado = funcSabado;
  }
  
  public String getSabadoHoraIni()
  {
    return this.sabadoHoraIni;
  }
  
  public void setSabadoHoraIni(String sabadoHoraIni)
  {
    this.sabadoHoraIni = sabadoHoraIni;
  }
  
  public String getSabadoHoraFim()
  {
    return this.sabadoHoraFim;
  }
  
  public void setSabadoHoraFim(String sabadoHoraFim)
  {
    this.sabadoHoraFim = sabadoHoraFim;
  }
  
  public Boolean getFuncDomingo()
  {
    return this.funcDomingo;
  }
  
  public void setFuncDomingo(Boolean funcDomingo)
  {
    this.funcDomingo = funcDomingo;
  }
  
  public String getDomingoHoraIni()
  {
    return this.domingoHoraIni;
  }
  
  public void setDomingoHoraIni(String domingoHoraIni)
  {
    this.domingoHoraIni = domingoHoraIni;
  }
  
  public String getDomingoHoraFim()
  {
    return this.domingoHoraFim;
  }
  
  public void setDomingoHoraFim(String domingoHoraFim)
  {
    this.domingoHoraFim = domingoHoraFim;
  }
  
  public Boolean getFuncFeriado()
  {
    return this.funcFeriado;
  }
  
  public void setFuncFeriado(Boolean funcFeriado)
  {
    this.funcFeriado = funcFeriado;
  }
  
  public String getFeriadoHoraIni()
  {
    return this.feriadoHoraIni;
  }
  
  public void setFeriadoHoraIni(String feriadoHoraIni)
  {
    this.feriadoHoraIni = feriadoHoraIni;
  }
  
  public String getFeriadoHoraFim()
  {
    return this.feriadoHoraFim;
  }
  
  public void setFeriadoHoraFim(String feriadoHoraFim)
  {
    this.feriadoHoraFim = feriadoHoraFim;
  }
  
  public Boolean getFechado()
  {
    return this.fechado;
  }
  
  public void setFechado(Boolean fechado)
  {
    this.fechado = fechado;
  }
  
  public List<Cidade> getListaCidadesEntrega()
  {
    return this.listaCidadesEntrega;
  }
  
  public void setListaCidadesEntrega(List<Cidade> listaCidadesEntrega)
  {
    this.listaCidadesEntrega = listaCidadesEntrega;
  }
  
  public List<FormaPagamento> getListaFormaPagamentos()
  {
    return this.listaFormaPagamentos;
  }
  
  public void setListaFormaPagamentos(List<FormaPagamento> listaFormaPagamentos)
  {
    this.listaFormaPagamentos = listaFormaPagamentos;
  }
  
  public Double getValorEntregaDefault()
  {
    return this.valorEntregaDefault;
  }
  
  public void setValorEntregaDefault(Double valorEntregaDefault)
  {
    this.valorEntregaDefault = valorEntregaDefault;
  }
  
  public Double getnCobraEntregaApValor()
  {
    return this.nCobraEntregaApValor;
  }
  
  public void setnCobraEntregaApValor(Double nCobraEntregaApValor)
  {
    this.nCobraEntregaApValor = nCobraEntregaApValor;
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
    hash = 13 * hash + Objects.hashCode(this.idVendorPerfil);
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
    VendedorPerfil other = (VendedorPerfil)obj;
    if (!Objects.equals(this.idVendorPerfil, other.idVendorPerfil)) {
      return false;
    }
    return true;
  }
}
