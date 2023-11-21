INSERT INTO db_pizzeria.pizze (description, name, price, url_img) VALUES('La pizza Margherita è la tipica pizza napoletana, la più popolare pizza Italiana.', 'Margherita', 5.00, 'https://www.lemilleeunabontadifranci.it/wp-content/uploads/2021/04/Pizza-margherita-fatta-in-casa-orizzontale.jpg');
INSERT INTO db_pizzeria.pizze (description, name, price, url_img) VALUES('Tipica pizza a base di pomodoro, mozzarella, funghi, prosciutto cotto, olive e carciofini.', 'Capricciosa', 7.50, 'https://wips.plug.it/cips/buonissimo.org/cms/2019/04/pizza-capricciosa.jpg');
INSERT INTO db_pizzeria.pizze (description, name, price, url_img) VALUES('Un mix mediterraneo con feta cheese, olive, pomodori secchi e spinaci freschi.', 'Mediterranean Delight', 7.00, 'https://img.cdn4dd.com/p/fit=cover,width=1200,height=1200,format=auto,quality=90/media/photos/1345ead7-0841-47e9-8cb7-fb1810b04dd5-retina-large.jpg');
INSERT INTO db_pizzeria.pizze (description, name, price, url_img) VALUES('Una pizza piccante con pepperoni, jalapeños e una salsa piccante.', 'Spicy Inferno', 6.50, 'https://img.freepik.com/premium-photo/pizza-with-pepperoni-it-tomatoes-table_581634-15916.jpg');
INSERT INTO db_pizzeria.pizze (description, name, price, url_img) VALUES('Una deliziosa combinazione di quattro formaggi: mozzarella, gorgonzola, parmigiano e fontina.', 'Quattro Formaggi', 5.50, 'https://www.grandecheese.com/wp-content/uploads/2020/09/QuattroFormaggiPizza.jpg');
INSERT INTO db_pizzeria.pizze (description, name, price, url_img) VALUES('Una pizza ricca di verdure fresche come pomodori, peperoni, cipolle, olive e funghi.', 'Vegetariana', 6.00, 'https://www.cucina-naturale.it/wp-content/uploads/2021/04/falafel-pizza-vegan-534x462.jpg');
INSERT INTO db_pizzeria.pizze (description, name, price, url_img) VALUES('Pollo grigliato, cipolla rossa e salsa barbecue su una base di formaggio.', 'BBQ Chicken', 8.00, 'https://staticcookist.akamaized.net/wp-content/uploads/sites/22/2022/02/bbq-chicken-pizza-1-1200x675.jpg');
INSERT INTO db_pizzeria.pizze (description, name, price, url_img) VALUES('Una classica pizza con mozzarella e capperi.', 'Toscana', 5.50, 'https://www.eolieshop.it/wp-content/uploads/2020/05/pizza-con-capperi.jpg');
INSERT INTO db_pizzeria.pizze (description, name, price, url_img) VALUES('Mozzarella di bufala, pomodoro fresco e basilico su una base croccante.', 'Bufalina', 7.00, 'https://www.tasteatlas.com/images/dishes/ee6654d7ee434fe79fde54ad4abe9102.jpg');
INSERT INTO db_pizzeria.pizze (description, name, price, url_img) VALUES('Ispirata alla pasta carbonara, con pancetta, uova e formaggio pecorino.', 'Carbonara', 9.50, 'https://www.comedera.com/wp-content/uploads/2022/04/pizza-carbonara.jpg');

INSERT INTO ingredients(name) VALUES('pomodoro');
INSERT INTO ingredients(name) VALUES('mozzarella');
INSERT INTO ingredients(name) VALUES('basilico');
INSERT INTO ingredients(name) VALUES('olio');

INSERT INTO pizze_ingredients(pizza_id, ingredients_id) VALUES(1, 1);
INSERT INTO pizze_ingredients(pizza_id, ingredients_id) VALUES(1, 2);

INSERT INTO roles (id, name) VALUES(1, 'ADMIN');
INSERT INTO roles (id, name) VALUES(2, 'USER');

INSERT INTO users (email, password, first_name, last_name, registered_at) VALUES ('andrea@mail.com', '{noop}andrea', 'Andrea', 'Serra', '2023-11-19 12:00');
INSERT INTO users (email, password, first_name, last_name, registered_at) VALUES ('robi@mail.com', '{noop}robi', 'Roberta', 'Carboni', '2023-11-19 12:30');

INSERT INTO users_roles (user_id, roles_id) VALUE(1, 1);
INSERT INTO users_roles (user_id, roles_id) VALUE(1, 2);
INSERT INTO users_roles (user_id, roles_id) VALUE(2, 2);