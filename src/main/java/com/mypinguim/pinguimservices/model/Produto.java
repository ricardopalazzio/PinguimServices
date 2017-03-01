package com.mypinguim.pinguimservices.model;

import com.mypinguim.pinguimservices.enumerated.TipoAgrupamentoComplementoEnum;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.hibernate.validator.constraints.NotEmpty;


@Entity
@Table(name="produto")
@XmlRootElement
public class Produto
implements Serializable {
    private static final long serialVersionUID = 1;
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id_produto")
    private Long idProduto;
    
    @Column(name="nome", length=150, nullable=false)
    @NotEmpty
    private String nome;
    
    @Column(name="tag", length=2000)
    private String tag;
    
    @Column(name="valor_padrao")
    @NotNull
    private Double valorPadrao = 0.0;
    
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="id_grupo", foreignKey=@ForeignKey(name="produto_grupo_fk"))
    private GrupoProduto grupo;
    
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="id_vendedor", foreignKey=@ForeignKey(name="produto_vendedor_fk"))
    @NotNull
    private Vendedor vendedor;
    
    @Column(name="ingredientes")
    private String ingredientes;
    
    @XmlTransient
    @OneToMany(cascade={CascadeType.ALL}, mappedBy="produto")
    private List<ProdutoComplemento> listacomplementos = new ArrayList<ProdutoComplemento>();
   
    @Transient
    private List<ProdutoComplemento> listaComplementoPadrao = new ArrayList<ProdutoComplemento>();
   
    @Transient
    private List<ProdutoComplemento> listaComplementoAdicional = new ArrayList<ProdutoComplemento>();
   
    @Transient
    private LinkedHashMap<String, List<ProdutoComplemento>> mapComplementosOpcionais = new LinkedHashMap();
   
    @XmlTransient
    @Temporal(value=TemporalType.TIMESTAMP)
    @Column(name="data_alteracao")
    @NotNull
    private Date dataAlteracao;
    
    @XmlTransient
    @Temporal(value=TemporalType.TIMESTAMP)
    @Column(name="data_inclusao")
    @NotNull
    private Date dataInclusao;

    @PrePersist
    public void prePersist() {
        this.dataInclusao = new Date();
        this.dataAlteracao = new Date();
    }

    @PreUpdate
    public void preUpdate() {
        this.dataAlteracao = new Date();
    }

    public void carregaComplementos() throws Exception {
        try {
            if (this.getListacomplementos() != null && !this.getListacomplementos().isEmpty()) {
                this.getListaComplementoPadrao().clear();
                this.getListaComplementoAdicional().clear();
                this.getMapComplementosOpcionais().clear();
                this.getListacomplementos().forEach(pc -> {
                    if (pc.getTipoAgrupamentoComplemento().equals((Object)TipoAgrupamentoComplementoEnum.PADRAO)) {
                        this.getListaComplementoPadrao().add(pc);
                    } else if (pc.getTipoAgrupamentoComplemento().equals((Object)TipoAgrupamentoComplementoEnum.ADICIONAL)) {
                        this.getListaComplementoAdicional().add(pc);
                    } else {
                        List<ProdutoComplemento> complementos = this.getMapComplementosOpcionais().get(pc.getTipoAgrupamentoComplemento().getNome());
                        if (complementos == null) {
                            complementos = new ArrayList<ProdutoComplemento>();
                        }
                        complementos.add(pc);
                        this.getMapComplementosOpcionais().put(pc.getTipoAgrupamentoComplemento().getNome(), complementos);
                    }
                }
                );
            }
        }
        catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public Long getIdProduto() {
        return this.idProduto;
    }

    public void setIdProduto(Long idProduto) {
        this.idProduto = idProduto;
    }

    public String getTag() {
        return this.tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public Double getValorPadrao() {
        return this.valorPadrao;
    }

    public void setValorPadrao(Double valorPadrao) {
        this.valorPadrao = valorPadrao;
    }

    public GrupoProduto getGrupo() {
        return this.grupo;
    }

    public void setGrupo(GrupoProduto grupo) {
        this.grupo = grupo;
    }

    public Vendedor getVendedor() {
        return this.vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    public Date getDataAlteracao() {
        return this.dataAlteracao;
    }

    public void setDataAlteracao(Date dataAlteracao) {
        this.dataAlteracao = dataAlteracao;
    }

    public Date getDataInclusao() {
        return this.dataInclusao;
    }

    public void setDataInclusao(Date dataInclusao) {
        this.dataInclusao = dataInclusao;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<ProdutoComplemento> getListacomplementos() {
        return this.listacomplementos;
    }

    public void setListacomplementos(List<ProdutoComplemento> listacomplementos) {
        this.listacomplementos = listacomplementos;
    }

    public List<ProdutoComplemento> getListaComplementoPadrao() {
        return this.listaComplementoPadrao;
    }

    public void setListaComplementoPadrao(List<ProdutoComplemento> listaComplementoPadrao) {
        this.listaComplementoPadrao = listaComplementoPadrao;
    }

    public List<ProdutoComplemento> getListaComplementoAdicional() {
        return this.listaComplementoAdicional;
    }

    public void setListaComplementoAdicional(List<ProdutoComplemento> listaComplementoAdicional) {
        this.listaComplementoAdicional = listaComplementoAdicional;
    }

    public String getIngredientes() {
        return this.ingredientes;
    }

    public void setIngredientes(String ingredientes) {
        this.ingredientes = ingredientes;
    }

    public LinkedHashMap<String, List<ProdutoComplemento>> getMapComplementosOpcionais() {
        return this.mapComplementosOpcionais;
    }

    public void setMapComplementosOpcionais(LinkedHashMap<String, List<ProdutoComplemento>> mapComplementosOpcionais) {
        this.mapComplementosOpcionais = mapComplementosOpcionais;
    }

    public int hashCode() {
        int hash = 5;
        hash = 13 * hash + Objects.hashCode(this.idProduto);
        return hash;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (this.getClass() != obj.getClass()) {
            return false;
        }
        Produto other = (Produto)obj;
        if (!Objects.equals(this.idProduto, other.idProduto)) {
            return false;
        }
        return true;
    }
}