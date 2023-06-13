----- PRODUCT -----
insert into product (id, name, price, category, star_count)
values (111, 'product1', 99.99, 'product_category1', 4);

insert into product (id, name, price, category, star_count)
values (112, 'product2', 199.99, 'product_category1', 5);

insert into product (id, name, price, category, star_count)
values (113, 'product3', 59.99, 'product_category2', 3);
-- ----- POST -----
-- insert into post (id, title, content, author, user_p_id)
-- values (201, 'Title1', 'Content1', 'Author1', 1);
--
-- insert into post (id, title, content, author, user_p_id)
-- values (202, 'Title2', 'Content2', 'Author2', 1);
--
-- insert into post (id, title, content, author, user_p_id)
-- values (203, 'Title3', 'Content3', 'Author3', 2);
-- ----- COMMENT -----
-- insert into comment (id, name, post_id)
-- values(301, 'Comment1', 201);
--
-- insert into comment (id, name, post_id)
-- values(302, 'Comment2', 201);

INSERT INTO user_p (id, email, firstname, lastname, password)
VALUES (1, 'uinan@miu.edu', 'umur', 'inan', '$2a$12$IKEQb00u5QpZMx4v5zMweu.3wrq0pS7XLCHO4yHZ.BW/yvWu1feo2'); --123
INSERT INTO user_p (id, email, firstname, lastname, password)
VALUES (2, 'john@miu.edu', 'john', 'doe', '$2a$12$IKEQb00u5QpZMx4v5zMweu.3wrq0pS7XLCHO4yHZ.BW/yvWu1feo2'); --123
INSERT INTO user_p (id, email, firstname, lastname, password)
VALUES (3, 'dean@miu.edu', 'Dean', 'Altarawneh', '$2a$12$IKEQb00u5QpZMx4v5zMweu.3wrq0pS7XLCHO4yHZ.BW/yvWu1feo2'); --123

INSERT INTO role (id, role)
VALUES (1, 'ADMIN');
INSERT INTO role (id, role)
VALUES (2, 'USER');


INSERT INTO user_p_roles (user_id, roles_id)
VALUES (1, 1);
INSERT INTO user_p_roles (user_id, roles_id)
VALUES (2, 1);
INSERT INTO user_p_roles (user_id, roles_id)
VALUES (3, 2);