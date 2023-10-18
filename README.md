
# Tabela Hash com Tratamento de Colisões
Este é um projeto desenvolvido para a disciplina de Estrutura de Dados. O objetivo deste projeto é implementar uma tabela hash que utiliza dois métodos de tratamento de colisões: encadeamento (chaining) e sondagem linear. A tabela hash é uma estrutura de dados eficiente para armazenar e recuperar informações com base em uma chave.

## O que é uma Tabela Hash?
Uma tabela hash é uma estrutura de dados que permite o armazenamento eficiente de pares chave-valor. Ela é construída em torno de uma função de hash que mapeia chaves para índices em uma tabela. Isso permite que a busca, inserção e remoção de elementos sejam realizadas em tempo constante (em média), tornando-a uma escolha comum para muitos problemas de busca e indexação.

## Métodos de Tratamento de Colisões
Neste projeto, foram implementados dois métodos de tratamento de colisões:

**Encadeamento (Chaining)**: Quando ocorre uma colisão (duas chaves são mapeadas para o mesmo índice), os elementos são armazenados em uma lista encadeada associada àquele índice.

**Sondagem Linear (Linear Probing)**: Quando ocorre uma colisão, a tabela é sondada linearmente (a partir do índice em conflito) até encontrar um local vazio para armazenar o elemento.

## Estrutura do Código
O código é composto por várias classes:

* **Main**: A classe principal que inicia o programa e cria as tabelas hash.

* **Menu**: Gerencia a interação com o usuário, permitindo a inserção, busca, remoção e alteração do método de tratamento de colisões.

* **HashTable**: Implementa a tabela hash, incluindo os métodos de inserção, busca e remoção, bem como a mudança dinâmica de tamanho quando a tabela está muito cheia.

* **HashNode**: Representa um nó na tabela hash, armazenando uma chave e um valor.

## Uso do Programa
O programa oferece as seguintes opções:

1. **Inserir elemento**: Permite inserir um par chave-valor na tabela hash.
2. **Buscar elemento por valor**: Procura um valor na tabela hash.
3. **Remover elemento por valor**: Remove um elemento da tabela hash com base em seu valor.
4. **Teste de eficiência em busca (Encadeamento)**: Mede o tempo de busca em uma tabela hash com tratamento de colisões por encadeamento.
5. **Teste de eficiência em busca (Linear)**: Mede o tempo de busca em uma tabela hash com tratamento de colisões por sondagem linear.
6. **Alternar método de tratamento de colisões**: Altera o método de tratamento de colisões entre encadeamento e sondagem linear.
7. **Imprimir tabela**: Exibe o conteúdo da tabela hash.
8. **Sair**: Encerra o programa.

## Observações:
O programa apresenta tempos de busca em milissegundos, mas eles podem não refletir uma medida precisa da eficiência.

O projeto pode ser aprimorado com a implementação de tratamentos de colisões adicionais, como sondagem quadrática ou hash duplo.

## Contribuindo
Contribuições são bem-vindas! Se você encontrar um erro ou tiver alguma melhoria, sinta-se à vontade para abrir uma issue ou enviar um pull request.

### Autor
**Irvanlei de Abreu**