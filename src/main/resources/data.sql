----- PRODUCT -----
insert into product (id, name, price, category, star_count)
values (111, 'product1', 99.99, 'product_category1', 4);

insert into product (id, name, price, category, star_count)
values (112, 'product2', 199.99, 'product_category1', 5);

insert into product (id, name, price, category, star_count)
values (113, 'product3', 59.99, 'product_category2', 3);
----- USER -----
insert into user_p (id, name)
values (1001, 'John');

insert into user_p (id, name)
values (1002, 'Simpson');
----- POST -----
insert into post (id, title, content, author, user_p_id)
values (201, 'Title1', 'Content1', 'Author1', 1001);

insert into post (id, title, content, author, user_p_id)
values (202, 'Title2', 'Content2', 'Author2', 1001);

insert into post (id, title, content, author, user_p_id)
values (203, 'Title3', 'Content3', 'Author3', 1002);
----- COMMENT -----
insert into comment (id, name, post_id)
values(301, 'Comment1', 201);

insert into comment (id, name, post_id)
values(302, 'Comment2', 201);


--- DELETE ---
-- delete from user_p where id = 1002;