/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mypinguim.pinguimservices.enumerated;

/**
 *
 * @author ricar
 */
public enum PedidoSituacaoEnum {
    
    NOVO ("Novo"),
    RECEBIDO ("Recebido"),
    PRODUCAO ("Em produção"),
    ENTREGA ("Saiu para entrega"),
    FINALIZADO ("Pedido entregue"),
    CANCELADO  ("Pedido cancelado");
    
    private String descricao;

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    private PedidoSituacaoEnum(String descricao) {
        this.descricao = descricao;
    }
    
    
    
}
