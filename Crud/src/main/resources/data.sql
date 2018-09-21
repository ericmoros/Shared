-- PRODUCTS
DELETE FROM PRODUCT;
INSERT INTO PRODUCT (id, name, price, stock, total_price, description) VALUES (1, 'Leche', 2.87, 1, 2.87, 'No description');
INSERT INTO PRODUCT (id, name, price, stock, total_price, description) VALUES (2, 'Arroz', 0.61, 1, 0.61, 'No description');
INSERT INTO PRODUCT (id, name, price, stock, total_price, description) VALUES (3, 'Maizena', 1.27, 7, 8.89, 'No description');
INSERT INTO PRODUCT (id, name, price, stock, total_price, description) VALUES (4, 'Café soluble', 2.00, 200, 400, 'No description');
INSERT INTO PRODUCT (id, name, price, stock, total_price, description) VALUES (5, 'Frijol', 2.55, 2, 5.1, 'No description');
INSERT INTO PRODUCT (id, name, price, stock, total_price, description) VALUES (6, 'Sopa', 0.15, 7, 1.05, 'No description');
INSERT INTO PRODUCT (id, name, price, stock, total_price, description) VALUES (7, 'Huevos', 1.89, 2, 3.78, 'No description');
INSERT INTO PRODUCT (id, name, price, stock, total_price, description) VALUES (8, 'Consomate', 0.45, 8, 3.6, 'No description');
INSERT INTO PRODUCT (id, name, price, stock, total_price, description) VALUES (9, 'Harina de trigo', 2.25, 4, 9, 'No description');
INSERT INTO PRODUCT (id, name, price, stock, total_price, description) VALUES (10, 'Azúar', 1.67, 2, 3.34, 'No description');
INSERT INTO PRODUCT (id, name, price, stock, total_price, description) VALUES (11, 'Aceite', 2.11, 3, 6.33, 'No description');
INSERT INTO PRODUCT (id, name, price, stock, total_price, description) VALUES (12, 'Manteca vegetal', 0.50, 1, 0.5, 'No description');
INSERT INTO PRODUCT (id, name, price, stock, total_price, description) VALUES (13, 'Papa blanca', 1.00, 1, 1, 'No description');
INSERT INTO PRODUCT (id, name, price, stock, total_price, description) VALUES (14, 'Jitomate', 4.91, 3, 14.73, 'No description');
INSERT INTO PRODUCT (id, name, price, stock, total_price, description) VALUES (15, 'Pierna y muslo de pollo', 2.00, 2, 4, 'No description');
INSERT INTO PRODUCT (id, name, price, stock, total_price, description) VALUES (16, 'Royal', 0.32, 125, 40, 'No description');
INSERT INTO PRODUCT (id, name, price, stock, total_price, description) VALUES (17, 'Chiles', 1.12, 1, 1.12, 'No description');
INSERT INTO PRODUCT (id, name, price, stock, total_price, description) VALUES (18, 'Chile verde', 0.72, 1, 0.72, 'No description');
INSERT INTO PRODUCT (id, name, price, stock, total_price, description) VALUES (19, 'Cebollas', 0.45, 1, 0.45, 'No description');
INSERT INTO PRODUCT (id, name, price, stock, total_price, description) VALUES (20, 'Detergente', 1.08, 1, 1.08, 'No description');
INSERT INTO PRODUCT (id, name, price, stock, total_price, description) VALUES (21, 'Jabó de baño', 0.61, 1, 0.61, 'No description');
INSERT INTO PRODUCT (id, name, price, stock, total_price, description) VALUES (22, 'Papel de baño', 0.13, 1, 0.13, 'No description');
INSERT INTO PRODUCT (id, name, price, stock, total_price, description) VALUES (23, 'Cloro', 1.26, 1, 1.26, 'No description');
INSERT INTO PRODUCT (id, name, price, stock, total_price, description) VALUES (24, 'Pan de caja', 1.26, 1, 1.26, 'No description');
INSERT INTO PRODUCT (id, name, price, stock, total_price, description) VALUES (25, 'Sal', 0.23, 20, 4.6, 'No description');
INSERT INTO PRODUCT (id, name, price, stock, total_price, description) VALUES (26, 'Shampoo', 0.63, 1, 0.63, 'No description');
INSERT INTO PRODUCT (id, name, price, stock, total_price, description) VALUES (27, 'Soda', 3.09, 4, 12.36, 'No description');
INSERT INTO PRODUCT (id, name, price, stock, total_price, description) VALUES (28, 'Naranjas', 0.73, 2, 1.46, 'No description');
INSERT INTO PRODUCT (id, name, price, stock, total_price, description) VALUES (29, 'Pláanos', 0.55, 2, 1.1, 'No description');
INSERT INTO PRODUCT (id, name, price, stock, total_price, description) VALUES (30, 'Limones', 0.32, 1, 0.32, 'No description');
INSERT INTO PRODUCT (id, name, price, stock, total_price, description) VALUES (31, 'Tortillas de maiz', 9.55, 14, 133.7, 'No description');
INSERT INTO PRODUCT (id, name, price, stock, total_price, description) VALUES (32, 'Pinol', 0.64, 1, 0.64, 'No description');
INSERT INTO PRODUCT (id, name, price, stock, total_price, description) VALUES (33, 'Pasta de dientes', 0.91, 1, 0.91, 'No description');

-- Coupons
-- DROP TABLE COUPON;
DELETE FROM COUPON;
INSERT INTO COUPON (id, code, coupon_type, amount) VALUES (1, 'ABCDEFGHIJKLMNABS001', 'ABSOLUTE', 6);
INSERT INTO COUPON (id, code, coupon_type, amount) VALUES (2, 'ABCDEFGHIJKLMNABS002', 'ABSOLUTE', 2.2);
INSERT INTO COUPON (id, code, coupon_type, amount) VALUES (3, 'ABCDEFGHIJKLMNPER003', 'PERCENTAGE', 50);
INSERT INTO COUPON (id, code, coupon_type, amount) VALUES (4, 'ABCDEFGHIJKLMNPER004', 'PERCENTAGE', 20.3);
-- CART
-- DELETE FROM CART;
-- INSERT INTO 
-- 1L, "Eric's cart", new ArrayList<Product>
-- 2L, "Susan's cart", new ArrayList<Product>

-- DELETE FROM Cart;
-- INSERT INTO Cart (id, name, totalPrice, discount, Cupon) VALUES (1, 'Cart 1', 0, null);
-- INSERT INTO Cart (id, name, price, stock, description) VALUES (2, 'Cat 2', 0.61, 1, null);
-- INSERT INTO Cart (id, name, price, stock, description) VALUES (3, 'Cart 3', 1.27, 7, null);
-- INSERT INTO Cart (id, name, price, stock, description) VALUES (4, 'Cart 4', 2.00, 200, null);