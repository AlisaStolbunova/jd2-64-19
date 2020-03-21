CREATE TABLE department (
    id int NOT NULL AUTO_INCREMENT,
    department_name varchar(255) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE section (
id int NOT NULL AUTO_INCREMENT,
    street varchar(255) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE doctors (
    id bigint NOT NULL AUTO_INCREMENT,
    name varchar(255) NOT NULL,
    post varchar(255),
    department_id int,
    section_id int,
    office int,
    CONSTRAINT fk_department_id
        FOREIGN KEY (department_id)
                REFERENCES department(id),
    CONSTRAINT fk_section_id
            FOREIGN KEY (section_id)
                    REFERENCES section(id),
    PRIMARY KEY (id)
);



