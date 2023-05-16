package ru.perm.v.infomaximum;

import java.util.Map;

public class Report {
    StatData statData = new StatData();

    public Report(StatData statData) {
        this.statData = statData;
    }

    public void print() {
        System.out.println("\n------Duplicates:------");
        for (Product product : statData.getDuplicates()) {
            System.out.println(product);
        }

        System.out.println("\n---Weight by group:----");
        Map<String, Integer> weightByGroup = statData.getSumWegthByGroup();
        for (String group : weightByGroup.keySet()) {
            System.out.println(String.format("For group: %s sum weight: %s", group, weightByGroup.get(group)));
        }
        System.out.println("\n-------Min weight------");
        System.out.println(String.format("%s", statData.getMinWeight()));
        System.out.println("\n-------Max weight------");
        System.out.println(String.format("%s", statData.getMaxWeight()));


    }
}
