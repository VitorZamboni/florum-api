INSERT INTO users(name, email, password) VALUES ('Teste', 'test@gmail.com','$2a$10$5Em3OojvftsFJcpaX7QIWuyhZseZHDRz.jWpQ8LCTHzekypJE1Bgm');

INSERT INTO products (discount, evaluation, price, stock, views, created_on, description, name) VALUES(0, 4.5, 199.99, 10, 1432, '2026-09-27 10:30:00-03', 'Um lindo buque de rosas', 'Buque de Rosas');
INSERT INTO products (discount, evaluation, price, stock, views, created_on, description, name) VALUES(0.1, 4.9, 165.99, 58, 5671, '2026-09-26 11:30:00-03', 'Um Belo vaso de orquideas', 'Vaso de Orquideas');

INSERT INTO public.addresses (cep, number, user_id, city, district, state, street, complement, country, active, lat, lng) VALUES('85513899',  '123', 1, 'Pato Branco', 'São Caetano', 'PR', 'Est Rio Dourado', 'Km 3', 'Brasil', true, '-12.321', '32.123');
