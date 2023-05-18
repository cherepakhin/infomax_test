package ru.perm.v.infomaximum.parser.jsonreader;

import ru.perm.v.infomaximum.data.StatData;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Вариант создания статистики без создания List<Product>.
 * Просто обработкой строк, с ПОИСКОМ токенов и подсчетом ЗНАЧЕНИЙ токенов
 * JSON должен быть отформатирован (каждое поле в отдельной строке)
 */
public class StatByTokenReader {
    private StatData stat = new StatData();

    public StatData parseFile(String filepath) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filepath), 16384);
        String line;
        int pos = -1;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
            if (parsedIsWeightInLine(line)) {
                continue;
            }
            System.out.println("---");
        }
        return stat;
    }

    protected Boolean parsedIsWeightInLine(String line) {
        Long weight = 0L;
        boolean parsed = false;
        int pos = line.indexOf("\"weight\":");
        if (pos < 0) {
            return !parsed;
        }
        weight = Long.parseLong(line.substring(pos + 10).trim());
        if (weight.compareTo(stat.getMinWeight()) < 0) {
            stat.setMinWeight(weight);
            parsed = true;
        }
        if (weight.compareTo(stat.getMaxWeight()) > 0) {
            stat.setMaxWeight(weight);
            parsed = true;
        }
        return parsed;
    }

    public StatData getStat() {
        return stat;
    }

    public void setStat(StatData stat) {
        this.stat = stat;
    }
}
