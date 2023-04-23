#language:pt

@login
Funcionalidade: Login Trade Map
  Eu como um usuario do site Trade Map
  Quero validar o login de acesso do site
  Para poder dar segurança aos usuarios

  Contexto:
    Dado que eu esteja na tela de home

  Cenario: Validar login invalido
    Quando preencher os dados com o login invalido
      | login                        | senha      |
      | viniciusferreira483@gmai.com | 123456vnk@ |
    Entao validar mensagem de login invalido

  Cenario: Validar login valido com email
    Quando preencher os dados com o login valido
      | login                        | senha      |
      | vinicius@gmail.com           | 123456vnk@K |
    Entao validar mensagem de login valido

  Cenario: Validar login valido com telefone
    Quando preencher os dados com o login valido
      | login                        | senha      |
      | 11992407853                  | 123456vnk@K |
    Entao validar mensagem de login valido

  Cenario: Validar login valido com cpf
    Quando preencher os dados com o login valido
      | login                        | senha      |
      | 93797893000                  | 123456vnk@K|
    Entao validar mensagem de login valido


