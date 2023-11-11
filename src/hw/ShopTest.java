package hw;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.List;

public class ShopTest {

    /*
     1. Проверить, что магазин хранит верный список продуктов (количество продуктов, состав корзины)
     2. Проверить, что магазин возвращает верный самый дорого продукт getMostExpensiveProduct
     3. Проверить, что магазин возвращает верный отсортированный по цене список продуктов
    */

    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        Product samsung = new Product();
        samsung.setCost(9700);
        samsung.setTitle("Phone samsung galaxy");

        Product apple = new Product();
        apple.setCost(11900);
        apple.setTitle("Apple iphone 6");

        Product huawei = new Product();
        huawei.setCost(8900);
        huawei.setTitle("Apple huawei p40");

        products.add(samsung);
        products.add(apple);
        products.add(huawei);

        Shop shop = new Shop();

        shop.setProducts(products);

        // Проверить, что магазин хранит верный список продуктов (количество продуктов, состав корзины)

        assertThat(products)
                .isNotEmpty()
                .hasSize(3)
                .contains(huawei, samsung, apple);

        // Проверить, что магазин возвращает верный отсортированный по цене список продуктов
        assertThat(shop.getSortedListProducts()).containsSequence(huawei, samsung, apple);


        // Проверить, что магазин возвращает верный самый дорого продукт getMostExpensiveProduct
        Product productMaxCost = shop.getMostExpensiveProduct();
        assertThat(productMaxCost.getCost()).isEqualTo(11900);

    }
}
