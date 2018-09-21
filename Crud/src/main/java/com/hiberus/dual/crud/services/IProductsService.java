package com.hiberus.dual.crud.services;

import java.util.ArrayList;
import java.util.Arrays;

import com.hiberus.dual.crud.models.Product;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * IProducts
 */
public interface IProductsService {
        // Atts
        ArrayList<Product> PRODUCTS = new ArrayList<Product>(
                Arrays.asList(
                        new Product[] {
                                new Product(1, "Leche", 2.87F, 1, "No description"),
                                new Product(2, "Arroz", 0.61F, 1, "No description"),
                                new Product(3, "Maizena", 1.27F, 7, "No description"),
                                new Product(4, "Café soluble", 2.00F, 200, "No description"),
                                new Product(5, "Frijol", 2.55F, 2, "No description"),
                                new Product(6, "Sopa", 0.15F, 7, "No description"),
                                new Product(7, "Huevos", 1.89F, 2, "No description"),
                                new Product(8, "Consomate", 0.45F, 8, "No description"),
                                new Product(9, "Harina de trigo", 2.25F, 4, "No description"),
                                new Product(10, "Azúar", 1.67F, 2, "No description"),
                                new Product(11, "Aceite", 2.11F, 3, "No description"),
                                new Product(12, "Manteca vegetal", 0.50F, 1, "No description"),
                                new Product(13, "Papa blanca", 1.00F, 1, "No description"),
                                new Product(14, "Jitomate", 4.91F, 3, "No description"),
                                new Product(15, "Pierna y muslo de pollo", 2.00F, 2, "No description"),
                                new Product(16, "Royal", 0.32F, 125, "No description"),
                                new Product(17, "Chiles", 1.12F, 1, "No description"),
                                new Product(18, "Chile verde", 0.72F, 1, "No description"),
                                new Product(19, "Cebollas", 0.45F, 1, "No description"),
                                new Product(20, "Detergente", 1.08F, 1, "No description"),
                                new Product(21, "Jabó de baño", 0.61F, 1, "No description"),
                                new Product(22, "Papel de baño", 0.13F, 1, "No description"),
                                new Product(23, "Cloro", 1.26F, 1, "No description"),
                                new Product(24, "Pan de caja", 1.26F, 1, "No description"),
                                new Product(25, "Sal", 0.23F, 20, "No description"),
                                new Product(26, "Shampoo", 0.63F, 1, "No description"),
                                new Product(27, "Soda", 3.09F, 4, "No description"),
                                new Product(28, "Naranjas", 0.73F, 2, "No description"),
                                new Product(29, "Pláanos", 0.55F, 2, "No description"),
                                new Product(30, "Limones", 0.32F, 1, "No description"),
                                new Product(31, "Tortillas de maiz", 9.55F, 14, "No description"),
                                new Product(32, "Pinol", 0.64F, 1, "No description"),
                                new Product(33, "Pasta de dientes", 0.91F, 1, "No description") 
                        }
                )
        );

        // Methods
        ArrayList<Product> getProducts();

        Product getProduct(Long id);

        void deleteProduct(Long id);

        void populateProducts();

        void addProduct(Product product);

        void addProducts(ArrayList<Product> products);

        void deleteProducts();

        void editProduct(Product product);

        void updateTotalPrice();

        Page<Product> findPaginated(Pageable pageable);
}