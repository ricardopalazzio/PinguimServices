package com.mypinguim.pinguimservices.enumerated;

public enum TipoAgrupamentoComplementoEnum
{
  PADRAO(1, "Padrao"), 
  ADICIONAL(2, "Adicionais"),  
  OPCIONAL(3, "Opcionais");
  
  private int tipo;
  private String descricao;
  
  public int getTipo()
  {
    return this.tipo;
  }
  
  public void setTipo(int tipo)
  {
    this.tipo = tipo;
  }
  
  public String getDescricao()
  {
    return this.descricao;
  }
  
  public void setDescricao(String descricao)
  {
    this.descricao = descricao;
  }
  
  private TipoAgrupamentoComplementoEnum(int tipo, String descricao)
  {
    this.tipo = tipo;
    this.descricao = descricao;
  }
}
