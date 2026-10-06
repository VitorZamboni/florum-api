insert into categories (name) values ('Vasos');
insert into categories (name) values ('Buques');
insert into categories (name) values ('Arranjos');
insert into categories (name) values ('Orquideas');
insert into categories (name) values ('Rosas');

INSERT INTO users(name, email, password) VALUES ('Administrador', 'admin@admin.com','$2a$10$.PVIfB07x.SfMYTcToxL0.yxcLWU0GbS2NUO1W1QAvqMm/TsFhVem');
INSERT INTO users(name, email, password) VALUES ('Teste', 'test@gmail.com','$2a$10$5Em3OojvftsFJcpaX7QIWuyhZseZHDRz.jWpQ8LCTHzekypJE1Bgm');

INSERT INTO products (discount, evaluation, price, stock, "views", created_on, description, "name") VALUES(0, 4.5, 199.99, 10, 1432, '2026-09-27 10:30:00-03', 'Um lindo buque de rosas', 'Buque de Rosas');
INSERT INTO products (discount, evaluation, price, stock, "views", created_on, description, "name") VALUES(0.1, 4.9, 165.99, 58, 5671, '2026-09-26 11:30:00-03', 'Um Belo vaso de orquideas', 'Vaso de Orquideas');
INSERT INTO products (discount, evaluation, price, stock, "views", created_on, description, "name") VALUES(0, 4, 65.99, 43, 8523, '2026-09-27 11:50:00-03', 'Um delicado arranjo de flores do campo', 'Arranjo de Flores do Campo');

-- Imagens do buque de rosas
INSERT INTO product_images (sort_index,  product_id, url) VALUES(1, 1, 'https://images.pexels.com/photos/30190562/pexels-photo-30190562.jpeg');
INSERT INTO product_images (sort_index,  product_id, url) VALUES(2, 1, 'https://images.pexels.com/photos/30190561/pexels-photo-30190561.jpeg');
INSERT INTO product_images (sort_index,  product_id, url) VALUES(3, 1, 'https://images.pexels.com/photos/13364478/pexels-photo-13364478.jpeg');
INSERT INTO product_images (sort_index,  product_id, url) VALUES(4, 1, 'https://images.pexels.com/photos/5706647/pexels-photo-5706647.jpeg');

-- Imagens do vaso de orquideas
INSERT INTO product_images (sort_index,  product_id, url) VALUES(1, 2, 'https://cdn.pixabay.com/photo/2015/01/10/14/32/orchids-595242_1280.jpg');
INSERT INTO product_images (sort_index,  product_id, url) VALUES(2, 2, 'https://cdn.pixabay.com/photo/2019/02/12/14/29/flower-3992392_640.jpg');
INSERT INTO product_images (sort_index,  product_id, url) VALUES(3, 2, 'https://cdn.pixabay.com/photo/2022/02/06/09/51/orchids-6996661_640.jpg');
INSERT INTO product_images (sort_index,  product_id, url) VALUES(4, 2, 'https://cdn.pixabay.com/photo/2015/01/10/14/29/orchids-595237_1280.jpg');

-- Imagens do arranjo de flores do campo
INSERT INTO product_images (sort_index,  product_id, url) VALUES(1, 3, 'https://images.pexels.com/photos/14299951/pexels-photo-14299951.jpeg');
INSERT INTO product_images (sort_index,  product_id, url) VALUES(2, 3, 'https://images.pexels.com/photos/34580551/pexels-photo-34580551.jpeg');
INSERT INTO product_images (sort_index,  product_id, url) VALUES(3, 3, 'https://images.pexels.com/photos/6295319/pexels-photo-6295319.jpeg');
INSERT INTO product_images (sort_index,  product_id, url) VALUES(4, 3, 'https://images.pexels.com/photos/12774934/pexels-photo-12774934.jpeg');

-- Rosas
INSERT INTO public.products_categories (category_id, product_id) VALUES(2, 1);
INSERT INTO public.products_categories (category_id, product_id) VALUES(3, 1);

-- Orquideas
INSERT INTO public.products_categories (category_id, product_id) VALUES(1, 2);
INSERT INTO public.products_categories (category_id, product_id) VALUES(4, 2);

-- Flores do Campo
INSERT INTO public.products_categories (category_id, product_id) VALUES(3, 3);

INSERT INTO public.addresses (cep,  "number", user_id, city, district, state, street, complement, country, active) VALUES('85513899',  '123', 2, 'Pato Branco', 'São Caetano', 'PR', 'Est Rio Dourado', 'Km 3', 'Brasil', true);

INSERT INTO public.coupons (discount_amount, expires_on, code) VALUES(30, '2027-09-27 10:30:00-03', '1COMPRA');
INSERT INTO public.coupons (discount_amount, expires_on, code) VALUES(36, '2026-09-27 10:30:00-03', 'COMPRA');

INSERT INTO public.orders (address_id, coupon_id, purchased_on, user_id, payment_type, shipping, discount, total, status) VALUES(1, 1, '2026-09-28 12:30:00-03', 2, 'PIX', 20.00, 30.00, 888.75, 'PENDING');

INSERT INTO public.order_items (price, quantity, order_id, product_id) VALUES(199.99, 3, 1, 1);
INSERT INTO public.order_items (price, quantity, order_id, product_id) VALUES(149.39, 2, 1, 2);

INSERT INTO public.carts (user_id) VALUES(2);

INSERT INTO public.cart_items (quantity, cart_id, product_id) VALUES(2, 1, 3);