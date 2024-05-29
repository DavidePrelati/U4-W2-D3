import entities.Customer;
import entities.Order;
import entities.Product;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        Product product1 = new Product("Harry Potter 1", "Books", 104.00);
        Product product2 = new Product("Harry Potter 2", "Books", 70.00);
        Product product3 = new Product("Biberon", "Baby", 35.00);
        Product product4 = new Product("Dragon Ball BT3 ", "Boys", 70.00);


        Customer customer1 = new Customer("Franco", 2);
        Customer customer2 = new Customer("Giovanni", 1);
        Customer customer3 = new Customer("Alfredo", 3);


        Order order1 = new Order("Ordine1", LocalDate.of(2024, 2, 15), LocalDate.of(2024, 2, 20), Arrays.asList(product1, product3), customer1);
        Order order2 = new Order("Ordine2", LocalDate.of(2024, 3, 5), LocalDate.of(2024, 3, 10), Arrays.asList(product2, product4), customer2);
        Order order3 = new Order("Ordine3", LocalDate.of(2023, 2, 25), LocalDate.of(2023, 3, 1), Arrays.asList(product1), customer3);
        List<Product> products = Arrays.asList(product1, product2, product3, product4);
        List<Order> orders = Arrays.asList(order1, order2, order3);


        System.out.println("\n\n---------------------------------------Esercizio 1----------------------------\n");
        List<Product> costoMagBooks = prodottiCatBooks(products);
        System.out.println("Categoria Books con costo maggiore di 100: ");
        costoMagBooks.forEach(System.out::println);


        System.out.println("\n\n----------------------------------------Esercizio 2---------------------------");
        List<Order> ordiniBaby = ordiniBabyProduct(orders);
        System.out.println("\nOrdini dei Baby products: ");
        ordiniBaby.forEach(System.out::println);


        System.out.println("\n\n------------------------------------Esercizio 3-------------------------------");
        List<Product> scontoBoys = scontoBoysProduct(products);
        System.out.println("\nSconto della categoria Boy: ");
        scontoBoys.forEach(System.out::println);


    }

    public static List<Product> prodottiCatBooks(List<Product> products) {
        return products.stream()
                .filter(product -> "Books".equals(product.getCategory()) && product.getPrice() > 100)
                .collect(Collectors.toList());
    }

    public static List<Order> ordiniBabyProduct(List<Order> orders) {
        return orders.stream()
                .filter(order -> order.getProducts().stream().anyMatch(product -> "Baby".equals(product.getCategory())))
                .collect(Collectors.toList());
    }

    public static List<Product> scontoBoysProduct(List<Product> products) {
        return products.stream()
                .filter(product -> "Boys".equals(product.getCategory()))
                .map(product -> {
                    product.setPrice(product.getPrice() * 0.9);
                    return product;
                })
                .collect(Collectors.toList());
    }


}