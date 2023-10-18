import java.util.LinkedList;

class HashTable {
    private int capacity;
    private LinkedList<HashNode>[] table;
    private double loadThreshold = 0.7;
    private int currentSize = 0;

    public HashTable(int capacity) {
        this.capacity = capacity;
        table = new LinkedList[capacity];
    }

    private int hashChaining(int key) {
        return key % capacity;
    }

    private int hashLinear(int key, int attempt) {
        return (hashChaining(key) + attempt) % capacity;
    }

    public void insert(int key, String value) {
        if ((double) currentSize / capacity >= loadThreshold) {
            resize();
        }

        int indexChaining = hashChaining(key);
        int indexLinear = indexChaining;
        HashNode newNode = new HashNode(key, value);

        // Inserção com tratamento de colisões por encadeamento aberto
        if (table[indexChaining] == null) {
            table[indexChaining] = new LinkedList<>();
        }
        table[indexChaining].add(newNode);
        currentSize++;

        // Inserção com tratamento de colisões por sondagem linear
        int attempt = 1;
        while (table[indexLinear] != null) {
            indexLinear = hashLinear(key, attempt);
            attempt++;
        }
        if (table[indexLinear] == null) {
            table[indexLinear] = new LinkedList<>();
        }
        table[indexLinear].add(newNode);
    }

    public String search(String value) {
        String resultChaining = searchByValueChaining(value);
        String resultLinear = searchByValueLinear(value);

        System.out.println("Resultado da busca (Encadeiamento): " + resultChaining);
        System.out.println("Tempo de busca (Encadeiamento): 0 ms");

        System.out.println("Resultado da busca (Linear): " + resultLinear);
        System.out.println("Tempo de busca (Linear): 0 ms");

        return resultChaining;
    }

    public String searchByValueChaining(String value) {
        // Busca com tratamento de colisões por encadeamento aberto
        for (LinkedList<HashNode> chain : table) {
            if (chain != null) {
                for (HashNode node : chain) {
                    if (node.value.equals(value)) {
                        return node.value;
                    }
                }
            }
        }
        return null;
    }

    public String searchByValueLinear(String value) {
        // Busca com tratamento de colisões por sondagem linear
        for (int indexLinear = 0; indexLinear < capacity; indexLinear++) {
            if (table[indexLinear] != null) {
                for (HashNode node : table[indexLinear]) {
                    if (node.value.equals(value)) {
                        return node.value;
                    }
                }
            }
        }
        return null;
    }

    public String searchByValue(String value) {
        long startTimeChaining = System.nanoTime();
        String resultChaining = searchByValueChaining(value);
        long endTimeChaining = System.nanoTime();

        long startTimeLinear = System.nanoTime();
        String resultLinear = searchByValueLinear(value);
        long endTimeLinear = System.nanoTime();

        if (resultChaining != null) {
            System.out.println("Resultado da busca (Encadeiamento): " + resultChaining);
            System.out.println("Tempo de busca (Encadeiamento): " + String.format("%.8f", (endTimeChaining - startTimeChaining) / 1e6) + " ms");
        } else {
            System.out.println("Elemento não encontrado (Encadeiamento).");
        }

        if (resultLinear != null) {
            System.out.println("Resultado da busca (Linear): " + resultLinear);
            System.out.println("Tempo de busca (Linear): " + String.format("%.8f", (endTimeLinear - startTimeLinear) / 1e6) + " ms");
        } else {
            System.out.println("Elemento não encontrado (Linear).");
        }

        return resultChaining;
    }



    public String deleteByValue(String value) {
        String resultChaining = deleteByValueChaining(value);
        String resultLinear = deleteByValueLinear(value);

        if (resultChaining != null) {
            System.out.println("Elemento removido com sucesso (Encadeiamento): " + resultChaining);
        } else {
            System.out.println("Elemento não encontrado (Encadeiamento).");
        }

        if (resultLinear != null) {
            System.out.println("Elemento removido com sucesso (Linear): " + resultLinear);
        } else {
            System.out.println("Elemento não encontrado (Linear).");
        }

        return resultChaining;
    }

    public String deleteByValueChaining(String value) {
        // Remoção com tratamento de colisões por encadeamento aberto
        for (int index = 0; index < capacity; index++) {
            LinkedList<HashNode> chain = table[index];
            if (chain != null) {
                HashNode previous = null;
                for (HashNode node : chain) {
                    if (node.value.equals(value)) {
                        if (previous == null) {
                            chain.remove(node);
                        } else {
                            previous.next = node.next;
                        }
                        currentSize--;
                        return node.value;
                    }
                    previous = node;
                }
            }
        }
        return null;
    }

    public String deleteByValueLinear(String value) {
        // Remoção com tratamento de colisões por sondagem linear
        for (int indexLinear = 0; indexLinear < capacity; indexLinear++) {
            LinkedList<HashNode> chain = table[indexLinear];
            if (chain != null) {
                HashNode previous = null;
                for (HashNode node : chain) {
                    if (node.value.equals(value)) {
                        if (previous == null) {
                            chain.remove(node);
                        } else {
                            previous.next = node.next;
                        }
                        currentSize--;
                        return node.value;
                    }
                    previous = node;
                }
            }
        }
        return null;
    }

    private void resize() {
        int newCapacity = 2 * capacity;
        LinkedList<HashNode>[] newTable = new LinkedList[newCapacity];
        for (LinkedList<HashNode> chain : table) {
            if (chain != null) {
                for (HashNode node : chain) {
                    int key = node.key;
                    int index = hashChaining(key);
                    if (newTable[index] == null) {
                        newTable[index] = new LinkedList<>();
                    }
                    newTable[index].add(node);
                }
            }
        }
        table = newTable;
        capacity = newCapacity;
    }
}
