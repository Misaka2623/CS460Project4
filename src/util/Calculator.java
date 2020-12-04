package util;

import bean.Product;

import java.util.Map;

public class Calculator {
    /**
     * calculate the total price by a map (key: product, value: amount).
     *
     * @param map      a map (key: product, value: amount)
     * @param discount {@code true} if the discount should be applied; {@code false} otherwise.
     * @return the calculated total price.
     */
    public static double calculateTotalPrice(Map<Product, Integer> map, boolean discount) {
        return map.entrySet().stream().mapToDouble(kv ->
                (kv.getKey().getRetailPrice() - (discount ? kv.getKey().getMembershipDiscount() : 0)) * kv.getValue())
                .sum();
    }
}
