package com.mypinguim.pinguimservices.enumerated;

public enum ClienteSituacaoEnum {
    A("Ativo"),
    I("Inativo"),
    B("Bloqueado"),
    N("Negativado"),
    E("Em estudo"),
    V("Vip");
    
    private String situacao;

    public String getSituacao() {
        return this.situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    private ClienteSituacaoEnum(String situacao) {
        this.situacao = situacao;
    }
}