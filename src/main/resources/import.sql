--import.sql
insert into categories (name) values ('Vasos');
insert into categories (name) values ('Buques');
insert into categories (name) values ('Arranjos');
insert into categories (name) values ('Orquideas');
insert into categories (name) values ('Rosas');

insert into products (name, description, price, category_id) values ('Buque de Rosas','Um lindo buque de rosas',199.0,2);

INSERT INTO users(name, email, password) VALUES ('Administrador', 'admin@admin.com','$2a$10$.PVIfB07x.SfMYTcToxL0.yxcLWU0GbS2NUO1W1QAvqMm/TsFhVem');
INSERT INTO users(name, name, password) VALUES ('Teste', 'test@gmail.com','$2a$10$.PVIfB07x.SfMYTcToxL0.yxcLWU0GbS2NUO1W1QAvqMm/TsFhVem');