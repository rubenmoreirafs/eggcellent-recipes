DROP DATABASE IF EXISTS egg;
CREATE DATABASE egg;
USE egg;


CREATE TABLE user(
    id INTEGER AUTO_INCREMENT,
    username VARCHAR(20) NOT  NULL UNIQUE,
    password VARCHAR(20),
    email VARCHAR(40) NOT NULL UNIQUE,
    PRIMARY KEY (id)
);

CREATE TABLE recipe(
    id INTEGER AUTO_INCREMENT,
    name VARCHAR(20) NOT NULL,
    instructions TEXT NOT NULL,
    owner_id INTEGER  NOT NULL,
    creation_date DATE,
    prep_time INTEGER,
    photo_url VARCHAR(40),
    PRIMARY KEY (id)
);

CREATE TABLE ingredient(
    id INTEGER AUTO_INCREMENT,
    name VARCHAR(20) UNIQUE,
    PRIMARY KEY (id)
);

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

INSERT INTO ingredient values (1, 'milk');
INSERT INTO ingredient values (2, 'egg');
INSERT INTO ingredient values (3, 'flour');
INSERT INTO ingredient values (4, 'baking soda');
INSERT INTO ingredient values (5, 'sugar');

INSERT INTO recipe values (1, 'Pancakes', "Pour milk, whisk eggs.. blah blah", 1, '2023-10-04', 15, "/resources/photos/pancake.jpg");
INSERT INTO recipe values (2, 'Waffles', "Mix all the stuffs together and pray", 3, '2023-10-04', 20, "/resources/photos/waffles.jpg");
INSERT INTO recipe values (3, 'Milky Milk', "If you milk the milk you will have it all milked", 1, '2023-10-04', 30, "/resources/photos/waffles.jpg");

INSERT INTO recipe_book values (1, 1, 1);
INSERT INTO recipe_book values (2, 1, 2);
INSERT INTO recipe_book values (3, 2, 1);
INSERT INTO recipe_book values (4, 3, 2);

