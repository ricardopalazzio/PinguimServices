package com.mypinguim.pinguimservices.enumerated;

public enum TipoLogradouroEnum
{
  APTO("apto."), 
  RUA("rua"), 
  TRAVESSA("travessa"),  
  CODOMINIO("condomínio");
  
  private String nome;
  
  public String getNome()
  {
    return this.nome;
  }
  
  public void setNome(String nome)
  {
    this.nome = nome;
  }
  
  private TipoLogradouroEnum(String nome)
  {
    this.nome = nome;
  }
}
