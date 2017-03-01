package com.mypinguim.pinguimservices.enumerated;

public enum VendedorSituacaoEnum
{
  A("Ativo"), 
  I("Inativo"),
  B("Bloqueado");
  
  private String situacao;
  
  public String getSituacao()
  {
    return this.situacao;
  }
  
  public void setSituacao(String situacao)
  {
    this.situacao = situacao;
  }
  
  private VendedorSituacaoEnum(String situacao)
  {
    this.situacao = situacao;
  }
}
