# Exemplo inicial da feature com contexto e sem esquema

# language: pt
Funcionalidade: Cadastro de contas
  Como um usuário
  Gostaria de cadastrar contas
  Para que eu possa distribuir meu dinheiro de uma forma mais organizada

  # Background
  Contexto:
    Dado que estou acessando a aplicação
    Quando informo o usuário "ewertondsdias@gmail.com"
    E a senha "123456"
    E seleciono entrar
    Então visualizo a página inicial
    Quando seleciono Contas
    E seleciono Adicionar

  Cenário: Deve inserir uma conta com sucesso
    E informo a conta "Conta de Teste"
    E seleciono Salvar
    Então a conta é inserida com sucesso

  Cenário: Não deve inserir uma conta sem nome
    E seleciono Salvar
    Então sou notificado que o nome da conta é obrigatório

  Cenário: Não deve inserir uma conta com nome já existente
    E informo a conta "Conta mesmo nome"
    E seleciono Salvar
    Então sou notificado que já existe uma conta com esse nome