DROP DATABASE IF EXISTS egg;
CREATE DATABASE egg;
USE egg;

DROP TABLE IF EXISTS user;
CREATE TABLE user(
    id INTEGER AUTO_INCREMENT,
    username VARCHAR(20) NOT  NULL UNIQUE,
    password VARCHAR(20),
    email VARCHAR(40) NOT NULL UNIQUE,
    PRIMARY KEY (id)
);

DROP TABLE IF EXISTS recipe;
CREATE TABLE recipe(
    id INTEGER AUTO_INCREMENT,
    name VARCHAR(20) NOT NULL,
    is_private BOOL,
    instructions TEXT NOT NULL,
    owner_id INTEGER  NOT NULL,
    creation_date DATE,
    prep_time INTEGER,
    photo_url VARCHAR(40),
    PRIMARY KEY (id)
);

DROP TABLE IF EXISTS ingredient;
CREATE TABLE ingredient(
    id INTEGER,
    recipe_id INTEGER,
    name VARCHAR(20),
    PRIMARY KEY (id),
    FOREIGN KEY (recipe_id) REFERENCES recipe (id)
);


DROP TABLE IF EXISTS recipe_book;
CREATE TABLE recipe_book(
    user_id INTEGER,
    recipe_id INTEGER,
    PRIMARY KEY (user_id, recipe_id),
    FOREIGN KEY (user_id) REFERENCES user (id),
    FOREIGN KEY (recipe_id) REFERENCES recipe (id)
);

INSERT INTO user values (1, 'ruben', 'ruben', 'rubenfnmoreira@gmail.com');
INSERT INTO user values (2, 'joão', 'joão', 'joaomendanha@gmail.com');
INSERT INTO user values (3, 'leith', 'leith', 'leithatia@gmail.com');

INSERT INTO recipe values (1, 'Pancakes',0, "Pour milk, whisk eggs.. blah blah", 1, '2023-10-04', 15, "/resources/photos/pancake.jpg");
INSERT INTO recipe values (2, 'Waffles', 1,"Mix all the stuffs together and pray", 3, '2023-10-04', 20, "/resources/photos/waffles.jpg");

INSERT INTO ingredient values ( 1, 1, 'milk');
INSERT INTO ingredient values (2,2, 'egg');
INSERT INTO ingredient values (3,1, 'flour');
INSERT INTO ingredient values (4,2, 'baking soda');
INSERT INTO ingredient values (5, 1, 'sugar');

INSERT INTO recipe_book values (1, 1);
INSERT INTO recipe_book values (2, 1);
INSERT INTO recipe_book values (3, 2);