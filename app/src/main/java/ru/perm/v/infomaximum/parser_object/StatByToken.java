package ru.perm.v.infomaximum.parser_object;

import ru.perm.v.infomaximum.data.StatData;

/**
 *
 * Вариант создания статистики без создания List<Product>.
 * Просто обработкой строк, с подсчетом значений токенов
 */
public class StatByToken {
    public StatData getStat(String filepath) {
        StatData stat = new StatData();
        return stat;
    }

}
