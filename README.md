## FT_Coin: Sistema de Apuração de Ganhos e Perdas em Carteira de Moedas

Projeto desenvolvido para a disciplina de Sistemas de Informação (SI300) na UNICAMP - Faculdade de Ciências Aplicadas.

## Arquitetura do Projeto
O sistema adota o padrão **MVC (Model-View-Controller)** e persistência em memória via padrões **DAO (Data Access Object)**:
* `model`: Classes de entidade (`Carteira`, `Movimentacao`, `Cotacao`, `TipoOperacao`).
* `dao`: Interfaces e implementações em memória (`CarteiraMemoryDAO`, `MovimentacaoMemoryDAO`).
* `controller`: Regras de negócio e cálculos de saldo (`GerenciadorInvestimento`).
* `view`: Interface CLI interativa com suporte a cores ANSI (`MenuCLI`, `RelatoriosView`).

## Como Executar a Aplicação

1. **Compilar os arquivos:**
   ```bash
   javac -d bin src/br/unicamp/ftcoin/model/*.java src/br/unicamp/ftcoin/dao/*.java src/br/unicamp/ftcoin/controller/*.java src/br/unicamp/ftcoin/view/*.java
   