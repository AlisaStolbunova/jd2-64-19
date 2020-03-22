CREATE TABLE user_role (
    id int NOT NULL AUTO_INCREMENT,
    role varchar(255) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE user (
    id bigint NOT NULL AUTO_INCREMENT,
    userName varchar(255) NOT NULL,
    password varchar(255) NOT NULL,
    role_id int,
    CONSTRAINT fk_role_id
        FOREIGN KEY (role_id)
                REFERENCES user_role(id),
    PRIMARY KEY (id)
);
