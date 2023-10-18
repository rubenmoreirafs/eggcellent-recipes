DROP TABLE IF EXISTS user_recipe;
DROP TABLE IF EXISTS recipe_ingredient;
DROP TABLE IF EXISTS ingredient;
DROP TABLE IF EXISTS recipe;
DROP TABLE IF EXISTS user;

CREATE TABLE user(
    id INTEGER AUTO_INCREMENT,
    username VARCHAR(20) NOT  NULL UNIQUE,
    password VARCHAR(20),
    email VARCHAR(40) NOT NULL UNIQUE,
    PRIMARY KEY (id)
);
CREATE TABLE recipe(
    id INTEGER AUTO_INCREMENT,
    user_id INTEGER NOT NULL UNIQUE,
    name VARCHAR(20) NOT NULL,
    owner_id INTEGER UNIQUE,
    creation_date DATE,
    prep_time INTEGER,
    photo_url VARCHAR(20),
    PRIMARY KEY (id)
);
CREATE TABLE ingredient(
    id INTEGER,
    name VARCHAR(20) UNIQUE,
    PRIMARY KEY (id)
);
CREATE TABLE recipe_ingredient(
    id INTEGER AUTO_INCREMENT,
    recipe_id INTEGER,
    ingredient_id INTEGER,
    quantity INTEGER,
    measurement_type VARCHAR(20),
    PRIMARY KEY (id),
    FOREIGN KEY (recipe_id) REFERENCES recipe(id)
);
CREATE TABLE user_recipe(
    id INTEGER AUTO_INCREMENT,
    user_id INTEGER,
    recipe_id INTEGER,
    PRIMARY KEY (id),
    FOREIGN KEY (user_id) REFERENCES user(id)
);

INSERT INTO user values (1, 'ruben', 'ruben', 'rubenfnmoreira@gmail.com');
INSERT INTO user values (2, 'joão', 'joão', 'joãomendanha@gmail.com');
INSERT INTO user values (3, 'leith', 'leith', 'leithatia@gmail.com');

INSERT INTO ingredient values (1, 'milk');
INSERT INTO ingredient values (2, 'egg');
INSERT INTO ingredient values (3, 'flour');
INSERT INTO ingredient values (4, 'baking soda');
INSERT INTO ingredient values (5, 'sugar');


