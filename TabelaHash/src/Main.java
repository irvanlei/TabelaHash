import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashTable tableChaining = new HashTable(10);
        HashTable tableLinear = new HashTable(10);
        HashTable currentTable = tableChaining;

        while (true) {
            System.out.println("Escolha uma opção:");
            System.out.println("1. Inserir elemento");
            System.out.println("2. Buscar elemento por valor");
            System.out.println("3. Remover elemento por valor");
            System.out.println("4. Teste de eficiência em busca (Encadeiamento)");
            System.out.println("5. Teste de eficiência em busca (Linear)");
            System.out.println("6. Alternar método de tratamento de colisões");
            System.out.println("7. Sair");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Digite a chave (inteiro):");
                    int key = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Digite o valor:");
                    String value = scanner.nextLine();
                    currentTable.insert(key, value);
                    break;

                case 2:
                    System.out.println("Digite o valor a ser buscado:");
                    String searchValue = scanner.nextLine();
                    currentTable.searchByValue(searchValue);
                    break;


                case 3:
                    System.out.println("Digite o valor a ser removido:");
                    String removeValue = scanner.nextLine();
                    currentTable.deleteByValue(removeValue);
                    break;


                case 4:
                    // Teste de eficiência em busca (Chaining)
                    long startTimeEfficiencyChaining = System.currentTimeMillis();
                    for (int i = 0; i < 1000; i++) {
                        tableChaining.search("ChaveInexistente");
                    }
                    long endTimeEfficiencyChaining = System.currentTimeMillis();
                    System.out.println("Tempo de teste de eficiência em busca (Encadeiamento): " + (endTimeEfficiencyChaining - startTimeEfficiencyChaining) + " ms");
                    break;

                case 5:
                    // Teste de eficiência em busca (Linear)
                    long startTimeEfficiencyLinear = System.currentTimeMillis();
                    for (int i = 0; i < 1000; i++) {
                        tableLinear.search("ChaveInexistente");
                    }
                    long endTimeEfficiencyLinear = System.currentTimeMillis();
                    System.out.println("Tempo de teste de eficiência em busca (Linear): " + (endTimeEfficiencyLinear - startTimeEfficiencyLinear) + " ms");
                    break;

                case 6:
                    if (currentTable == tableChaining) {
                        currentTable = tableLinear;
                        System.out.println("Método de tratamento de colisões alterado para Linear.");
                    } else {
                        currentTable = tableChaining;
                        System.out.println("Método de tratamento de colisões alterado para Encadeamento aberto.");
                    }
                    break;

                case 7:
                    System.out.println("Encerrando o programa.");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}
