package ru.perm.v.infomaximum;

import java.util.*;
import java.util.stream.Collectors;

public class StatCreatorByProducts implements IStatCreator {
    public Integer getMaxWeight(List<Product> products) {
        return Collections.max(products, Comparator.comparing(p -> p.getWeight())).getWeight();
    }

    public Integer getMinWeight(List<Product> products) {
        return Collections.min(products, Comparator.comparing(Product::getWeight)).getWeight();
    }

    public Map<String, Integer> getSumWegthByGroup(List<Product> products) {
        return products.stream().collect(Collectors.groupingBy(Product::getGrp,
                Collectors.summingInt(Product::getWeight)));
    }

    public List<Product> getDuplicatesByGrpAndType(List<Product> products) {
        Comparator<Product> comparatorByGrpAndType = Comparator
                .comparing(Product::getGrp)
                .thenComparing(Product::getType);
        List<Product> sortedProducts = products.stream()
                .sorted(comparatorByGrpAndType)
                .collect(Collectors.toList());
        String prevGrp = "";
        String prevType = "";
        Product prevProduct = new Product();
        List<Product> ret = new ArrayList<>();
        for (Product currentProduct : sortedProducts) {
            if (currentProduct.getGrp().equals(prevGrp) && currentProduct.getType().equals(prevType)) {
                ret.add(prevProduct);
                ret.add(currentProduct);
            }
            prevGrp = currentProduct.getGrp();
            prevType = currentProduct.getType();
            prevProduct = currentProduct;
        }
        return ret;
    }
}
