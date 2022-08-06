package com.jsmodabackend.config;

import com.jsmodabackend.enums.Sex;
import com.jsmodabackend.enums.Status;
import com.jsmodabackend.model.Category;
import com.jsmodabackend.model.Order;
import com.jsmodabackend.model.OrderItem;
import com.jsmodabackend.model.Product;
import com.jsmodabackend.repository.CategoryRepository;
import com.jsmodabackend.repository.OrderItemRepository;
import com.jsmodabackend.repository.OrderRepository;
import com.jsmodabackend.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import java.time.Instant;
import java.util.List;

@Configuration
@RequiredArgsConstructor
public class Seeding implements CommandLineRunner {

    private final ProductRepository productRepository;

    private final CategoryRepository categoryRepository;

    private final OrderRepository orderRepository;

    private final OrderItemRepository orderItemRepository;

    @Override
    public void run(String... args) throws Exception {
        productRepository.deleteAll();
        categoryRepository.deleteAll();
        orderRepository.deleteAll();
        orderItemRepository.deleteAll();

        Category camisaMasculina = new Category("Camisa Masculina", Sex.MALE, null);
        Category saia = new Category("Saia", Sex.FEMALE, null);
        categoryRepository.saveAll(List.of(camisaMasculina, saia));

        Product camisaGolaPolo = Product.builder()
                .name("Gola Polo")
                .buyingPrice(25.00)
                .sellingPrice(40.0)
                .stock(8)
                .build();
        camisaGolaPolo.setCategory(camisaMasculina);

        Product saiaJeans = Product.builder()
                .name("Saia Jeans Comum")
                .buyingPrice(40.00)
                .sellingPrice(50.00)
                .stock(10)
                .build();
        saiaJeans.setCategory(saia);
        Product saidaDeBanho = Product.builder()
                .name("Saida de Banho Jonhson")
                .buyingPrice(18.30)
                .sellingPrice(27.80)
                .stock(15)
                .build();
        saidaDeBanho.setCategory(saia);
        saiaJeans = productRepository.save(saiaJeans);
        saidaDeBanho = productRepository.save(saidaDeBanho);
        camisaGolaPolo = productRepository.save(camisaGolaPolo);

        Order order1 = new Order(0.00, 0.00, Status.OPENED, null);
        orderRepository.save(order1);

        OrderItem orderItem1 = new OrderItem(camisaGolaPolo.getName(), 2, camisaGolaPolo.getSellingPrice(), order1, camisaGolaPolo);
        OrderItem orderItem2 = new OrderItem(saiaJeans.getName(), 2, saiaJeans.getSellingPrice(), order1, saiaJeans);
        OrderItem orderItem3 = new OrderItem(saidaDeBanho.getName(), 2, saidaDeBanho.getSellingPrice(), order1, saidaDeBanho);

        orderItemRepository.saveAll(List.of(orderItem1, orderItem2, orderItem3));

    }
}
