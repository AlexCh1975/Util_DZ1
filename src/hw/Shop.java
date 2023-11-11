package hw;

import java.util.Comparator;
import java.util.List;

public class Shop {
    private List<Product> products;

    // Геттеры, сеттеры:
    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    /**
     * @return отсортированный по возрастанию и цене список продуктов
     */
    public List<Product> getSortedListProducts() {
        this.products.sort(Comparator.comparingLong((Product::getCost)));
        return this.products;
    }

    /**
     * @return самый дорогой продукт
     */
    public Product getMostExpensiveProduct() {
        Product productMaxCost = null;
        for (Product product: products){
            if (productMaxCost == null || product.getCost() > productMaxCost.getCost()){
                productMaxCost = product;
            }
        }
        return productMaxCost;
    }

}
