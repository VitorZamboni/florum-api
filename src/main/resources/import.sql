insert into categories (name) values ('Vasos');
insert into categories (name) values ('Buques');
insert into categories (name) values ('Arranjos');
insert into categories (name) values ('Orquideas');
insert into categories (name) values ('Rosas');
insert into categories (name) values ('Cravos');
insert into categories (name) values ('Margaridas');
insert into categories (name) values ('Lirios');
insert into categories (name) values ('Copos de leite');
insert into categories (name) values ('Flores do campo');



INSERT INTO users(name, email, password) VALUES ('Administrador', 'admin@admin.com','$2a$10$.PVIfB07x.SfMYTcToxL0.yxcLWU0GbS2NUO1W1QAvqMm/TsFhVem');
INSERT INTO users(name, email, password) VALUES ('Teste', 'test@gmail.com','$2a$10$5Em3OojvftsFJcpaX7QIWuyhZseZHDRz.jWpQ8LCTHzekypJE1Bgm');



INSERT INTO products (discount, evaluation, price, stock, views, created_on, description, name) VALUES(0, 4.5, 199.99, 10, 1432, '2026-09-27 10:30:00-03', 'Um lindo buque de rosas', 'Buque de Rosas');
INSERT INTO products (discount, evaluation, price, stock, views, created_on, description, name) VALUES(0.1, 4.9, 165.99, 58, 5671, '2026-09-26 11:30:00-03', 'Um Belo vaso de orquideas', 'Vaso de Orquideas');
INSERT INTO products (discount, evaluation, price, stock, views, created_on, description, name) VALUES(0, 4, 65.99, 43, 8523, '2026-09-27 11:50:00-03', 'Um delicado arranjo de flores do campo', 'Arranjo de Flores do Campo');
INSERT INTO products (discount, evaluation, price, stock, views, created_on, description, name) VALUES(0.15, 4.8, 78.99, 15, 11531, '2026-11-27 18:12:00-03', 'Um colorido arranjo de cravos de várias cores, perfeito para decorar um ambiente com simplicidade e beleza.', 'Arranjo de Cravos Sortidos');
INSERT INTO products (discount, evaluation, price, stock, views, created_on, description, name) VALUES(0, 4.7, 113.99, 55, 4510, '2026-11-22 12:12:00-03', 'Um encantador Buque de margaridas brancas com folhagens verdes. Perfeito para presentear alguém especial ou decorar um ambiente com simplicidade e delicadeza.', 'Buque de Margaridas');
INSERT INTO products (discount, evaluation, price, stock, views, created_on, description, name) VALUES(0.20, 4.4, 150.99, 32, 1320, '2026-11-28 21:32:00-03', 'Arranjos de lirios rosas, perfeitos para decorar um ambiente com elegância e sofisticação.', 'Arranjo de Lirios');
INSERT INTO products (discount, evaluation, price, stock, views, created_on, description, name) VALUES(0, 4.7, 200.99, 21, 3210, '2026-11-23 10:15:00-03', 'Vasos de orquídeas vivas de várias cores, perfeitos para decorar um ambiente com elegância e sofisticação.', 'Vaso de Orquídeas');
INSERT INTO products (discount, evaluation, price, stock, views, created_on, description, name) VALUES(0, 4.9, 120.99, 43, 1533, '2026-11-12 19:42:00-03', 'Vasos de copos de leite, perfeitos para decorar um ambiente com elegância e descrição.', 'Vaso de Copos de Leite');
INSERT INTO products (discount, evaluation, price, stock, views, created_on, description, name) VALUES(0.3, 4.8, 134.99, 23, 7856, '2026-11-14 13:21:00-03', 'Buques de flores do campo, colorido e perfumado, perfeitos para presentear alguém em uma ocasião especial.', 'Vaso de Ortencias');
INSERT INTO products (discount, evaluation, price, stock, views, created_on, description, name) VALUES(0, 4.4, 213.99, 14, 3213, '2026-11-13 12:49:00-03', 'Vaso de ortencias vivas, perfeitas para serem cultivadas em ambientes internos ou externos, trazendo beleza e frescor para o seu espaço.', 'Buque de Flores do Campo');



-- Imagens do buque de rosas
INSERT INTO product_images (sort_index,  product_id, url) VALUES(1, 1, 'https://images.pexels.com/photos/30190562/pexels-photo-30190562.jpeg?auto=compress&cs=tinysrgb&w=1200');
INSERT INTO product_images (sort_index,  product_id, url) VALUES(2, 1, 'https://images.pexels.com/photos/30190561/pexels-photo-30190561.jpeg?auto=compress&cs=tinysrgb&w=1200');
INSERT INTO product_images (sort_index,  product_id, url) VALUES(3, 1, 'https://images.pexels.com/photos/13364478/pexels-photo-13364478.jpeg?auto=compress&cs=tinysrgb&w=1200');
INSERT INTO product_images (sort_index,  product_id, url) VALUES(4, 1, 'https://images.pexels.com/photos/5706647/pexels-photo-5706647.jpeg?auto=compress&cs=tinysrgb&w=1200');

-- Imagens do vaso de orquideas
INSERT INTO product_images (sort_index,  product_id, url) VALUES(1, 2, 'https://cdn.pixabay.com/photo/2015/01/10/14/32/orchids-595242_1280.jpg');
INSERT INTO product_images (sort_index,  product_id, url) VALUES(2, 2, 'https://cdn.pixabay.com/photo/2019/02/12/14/29/flower-3992392_640.jpg');
INSERT INTO product_images (sort_index,  product_id, url) VALUES(3, 2, 'https://cdn.pixabay.com/photo/2022/02/06/09/51/orchids-6996661_640.jpg');
INSERT INTO product_images (sort_index,  product_id, url) VALUES(4, 2, 'https://cdn.pixabay.com/photo/2015/01/10/14/29/orchids-595237_1280.jpg');

-- Imagens do arranjo de flores do campo
INSERT INTO product_images (sort_index,  product_id, url) VALUES(1, 3, 'https://images.pexels.com/photos/14299951/pexels-photo-14299951.jpeg?auto=compress&cs=tinysrgb&w=1200');
INSERT INTO product_images (sort_index,  product_id, url) VALUES(2, 3, 'https://images.pexels.com/photos/34580551/pexels-photo-34580551.jpeg?auto=compress&cs=tinysrgb&w=1200');
INSERT INTO product_images (sort_index,  product_id, url) VALUES(3, 3, 'https://images.pexels.com/photos/6295319/pexels-photo-6295319.jpeg?auto=compress&cs=tinysrgb&w=1200');
INSERT INTO product_images (sort_index,  product_id, url) VALUES(4, 3, 'https://images.pexels.com/photos/12774934/pexels-photo-12774934.jpeg?auto=compress&cs=tinysrgb&w=1200');


-- Imagens do Arranjo de Cravos Sortidos
INSERT INTO product_images (sort_index,  product_id, url) VALUES(1, 4, 'https://images.pexels.com/photos/9393542/pexels-photo-9393542.jpeg?auto=compress&cs=tinysrgb&w=1200');
INSERT INTO product_images (sort_index,  product_id, url) VALUES(2, 4, 'https://images.pexels.com/photos/36702390/pexels-photo-36702390.jpeg?auto=compress&cs=tinysrgb&w=1200');
INSERT INTO product_images (sort_index,  product_id, url) VALUES(3, 4, 'https://images.pexels.com/photos/37030314/pexels-photo-37030314.jpeg?auto=compress&cs=tinysrgb&w=1200');
INSERT INTO product_images (sort_index,  product_id, url) VALUES(4, 4, 'https://images.pexels.com/photos/16120226/pexels-photo-16120226.jpeg?auto=compress&cs=tinysrgb&w=1200');

-- Imagens do Buque de Margaridas
INSERT INTO product_images (sort_index,  product_id, url) VALUES(1, 5, 'https://images.pexels.com/photos/30062436/pexels-photo-30062436.jpeg?auto=compress&cs=tinysrgb&w=1200');
INSERT INTO product_images (sort_index,  product_id, url) VALUES(2, 5, 'https://images.pexels.com/photos/30062438/pexels-photo-30062438.jpeg?auto=compress&cs=tinysrgb&w=1200');
INSERT INTO product_images (sort_index,  product_id, url) VALUES(3, 5, 'https://images.pexels.com/photos/7085610/pexels-photo-7085610.jpeg?auto=compress&cs=tinysrgb&w=1200');
INSERT INTO product_images (sort_index,  product_id, url) VALUES(4, 5, 'https://images.pexels.com/photos/10050253/pexels-photo-10050253.jpeg?auto=compress&cs=tinysrgb&w=1200');

-- Imagens do Arranjo de Lirios
INSERT INTO product_images (sort_index,  product_id, url) VALUES(1, 6, 'https://images.pexels.com/photos/34480861/pexels-photo-34480861.jpeg?auto=compress&cs=tinysrgb&w=1200');
INSERT INTO product_images (sort_index,  product_id, url) VALUES(2, 6, 'https://images.pexels.com/photos/34524770/pexels-photo-34524770.jpeg?auto=compress&cs=tinysrgb&w=1200');
INSERT INTO product_images (sort_index,  product_id, url) VALUES(3, 6, 'https://images.pexels.com/photos/36503422/pexels-photo-36503422.jpeg?auto=compress&cs=tinysrgb&w=1200');
INSERT INTO product_images (sort_index,  product_id, url) VALUES(4, 6, 'https://images.pexels.com/photos/34480830/pexels-photo-34480830.jpeg?auto=compress&cs=tinysrgb&w=1200');

-- Imagens do Vaso de Orquídeas
INSERT INTO product_images (sort_index,  product_id, url) VALUES(1, 7, 'https://cdn.pixabay.com/photo/2015/01/10/14/32/orchids-595242_1280.jpg');
INSERT INTO product_images (sort_index,  product_id, url) VALUES(2, 7, 'https://cdn.pixabay.com/photo/2019/02/12/14/29/flower-3992392_640.jpg');
INSERT INTO product_images (sort_index,  product_id, url) VALUES(3, 7, 'https://cdn.pixabay.com/photo/2022/02/06/09/51/orchids-6996661_640.jpg');
INSERT INTO product_images (sort_index,  product_id, url) VALUES(4, 7, 'https://cdn.pixabay.com/photo/2015/01/10/14/29/orchids-595237_1280.jpg');

-- Imagens do Vaso de Copos de Leite
INSERT INTO product_images (sort_index,  product_id, url) VALUES(1, 8, 'https://images.pexels.com/photos/6902884/pexels-photo-6902884.jpeg?auto=compress&cs=tinysrgb&w=1200');
INSERT INTO product_images (sort_index,  product_id, url) VALUES(2, 8, 'https://images.pexels.com/photos/6902882/pexels-photo-6902882.jpeg?auto=compress&cs=tinysrgb&w=1200');
INSERT INTO product_images (sort_index,  product_id, url) VALUES(3, 8, 'https://images.pexels.com/photos/35131603/pexels-photo-35131603.jpe');
INSERT INTO product_images (sort_index,  product_id, url) VALUES(4, 8, 'https://images.pexels.com/photos/8068662/pexels-photo-8068662.jpeg?auto=compress&cs=tinysrgb&w=1200');

-- Imagens do Buque de Flores do Campo
INSERT INTO product_images (sort_index,  product_id, url) VALUES(1, 9, 'https://images.pexels.com/photos/14299951/pexels-photo-14299951.jpeg?auto=compress&cs=tinysrgb&w=1200');
INSERT INTO product_images (sort_index,  product_id, url) VALUES(2, 9, 'https://images.pexels.com/photos/12774934/pexels-photo-12774934.jpeg?auto=compress&cs=tinysrgb&w=1200');
INSERT INTO product_images (sort_index,  product_id, url) VALUES(3, 9, 'https://images.pexels.com/photos/34580551/pexels-photo-34580551.jpeg?auto=compress&cs=tinysrgb&w=1200');
INSERT INTO product_images (sort_index,  product_id, url) VALUES(4, 9, 'https://images.pexels.com/photos/6295319/pexels-photo-6295319.jpeg?auto=compress&cs=tinysrgb&w=1200');

-- Imagens do Vaso de Ortencias
INSERT INTO product_images (sort_index,  product_id, url) VALUES(1, 10, 'https://images.pexels.com/photos/10102526/pexels-photo-10102526.jpeg?auto=compress&cs=tinysrgb&w=1200');
INSERT INTO product_images (sort_index,  product_id, url) VALUES(2, 10, 'https://images.pexels.com/photos/16704707/pexels-photo-16704707.jpeg?auto=compress&cs=tinysrgb&w=1200');
INSERT INTO product_images (sort_index,  product_id, url) VALUES(3, 10, 'https://images.pexels.com/photos/32083540/pexels-photo-32083540.jpeg?auto=compress&cs=tinysrgb&w=1200');
INSERT INTO product_images (sort_index,  product_id, url) VALUES(4, 10, 'https://images.pexels.com/photos/34713346/pexels-photo-34713346.jpeg?auto=compress&cs=tinysrgb&w=1200');



-- Flores do Campo 10
INSERT INTO public.products_categories (category_id, product_id) VALUES(10, 3);
INSERT INTO public.products_categories (category_id, product_id) VALUES(10, 9);

-- Copos de leite 9
INSERT INTO public.products_categories (category_id, product_id) VALUES(9, 8);

-- Lirios 8
INSERT INTO public.products_categories (category_id, product_id) VALUES(8, 6);

-- Margaridas 7
INSERT INTO public.products_categories (category_id, product_id) VALUES(7, 5);

-- Cravos 6
INSERT INTO public.products_categories (category_id, product_id) VALUES(3, 4);

-- Rosas 5
INSERT INTO public.products_categories (category_id, product_id) VALUES(2, 1);
INSERT INTO public.products_categories (category_id, product_id) VALUES(3, 1);

-- Orquideas 4
INSERT INTO public.products_categories (category_id, product_id) VALUES(1, 2);
INSERT INTO public.products_categories (category_id, product_id) VALUES(4, 2);
INSERT INTO public.products_categories (category_id, product_id) VALUES(4, 7);

--Arranjos 3
INSERT INTO public.products_categories (category_id, product_id) VALUES(3, 4);
INSERT INTO public.products_categories (category_id, product_id) VALUES(3, 6);

--Buques 2
INSERT INTO public.products_categories (category_id, product_id) VALUES(2, 5);
INSERT INTO public.products_categories (category_id, product_id) VALUES(2, 9);

--Vasos 1
INSERT INTO public.products_categories (category_id, product_id) VALUES(1, 7);
INSERT INTO public.products_categories (category_id, product_id) VALUES(1, 8);
INSERT INTO public.products_categories (category_id, product_id) VALUES(1, 10);



INSERT INTO public.addresses (cep,  number, user_id, city, district, state, street, complement, country, active, lat, lng) VALUES('85513899',  '123', 2, 'Pato Branco', 'São Caetano', 'PR', 'Est Rio Dourado', 'Km 3', 'Brasil', true, '-12.321', '32.123');



INSERT INTO public.coupons (discount_amount, expires_on, code) VALUES(30, '2027-09-27 10:30:00-03', '1COMPRA');
INSERT INTO public.coupons (discount_amount, expires_on, code) VALUES(36, '2026-09-27 10:30:00-03', 'COMPRA');



INSERT INTO public.orders (address_id, coupon_id, purchased_on, user_id, payment_type, shipping, discount, total, status) VALUES(1, 1, '2026-09-28 12:30:00-03', 2, 'PIX', 20.00, 30.00, 888.75, 'PENDING');



INSERT INTO public.order_items (price, quantity, order_id, product_id) VALUES(199.99, 3, 1, 1);
INSERT INTO public.order_items (price, quantity, order_id, product_id) VALUES(149.39, 2, 1, 2);



INSERT INTO public.carts (user_id) VALUES(2);



INSERT INTO public.cart_items (quantity, cart_id, product_id) VALUES(2, 1, 3);