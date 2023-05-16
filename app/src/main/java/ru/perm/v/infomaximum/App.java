/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package ru.perm.v.infomaximum;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        System.out.println("Enter name file (JSON/CSV):");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        if (input.equals("exit")) {
            return;
        }
        ProductJsonReader reader = new ProductJsonReader();
        try {
            List<Product> products = reader.readFromFile(input);
            Stat stat = new Stat();
            List<Product> duplicates = stat.getDuplicatesByGrpAndType(products);
            System.out.println("\n------Duplicates:------");
            for (Product product : duplicates) {
                System.out.println(product);
            }
            System.out.println("\n---Weight by group:----");
            Map<String, Integer> weightByGroup = stat.getSumWegthByGroup(products);
            for (String group : weightByGroup.keySet()) {
                System.out.println(String.format("For group: %s sum weight: %s", group, weightByGroup.get(group)));
            }
            System.out.println("\n-------Min weight------");
            System.out.println(String.format("%s", stat.getMinWeight(products)));
            System.out.println("\n-------Max weight------");
            System.out.println(String.format("%s", stat.getMaxWeight(products)));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
