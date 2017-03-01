package com.mypinguim.pinguimservices.enumerated;

public enum SituacaoEnum
{
  A("Ativo"),  
  I("Inativo"),  
  T("Transicao"), 
  Z("Processamento");
  
  private String situacao;
  
  private SituacaoEnum(String situacao)
  {
    this.situacao = situacao;
  }
  
  public String getSituacao()
  {
    return this.situacao;
  }
  
  public void setSituacao(String situacao)
  {
    this.situacao = situacao;
  }
}
