import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashTable tableChaining = new HashTable(10);
        HashTable tableLinear = new HashTable(10);
        HashTable currentTable = tableChaining;

        Menu menu = new Menu(tableChaining, tableLinear, currentTable, scanner);
        menu.run();
    }
}
