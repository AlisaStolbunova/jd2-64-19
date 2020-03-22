CREATE TABLE patient (
    id bigint NOT NULL AUTO_INCREMENT,
    name varchar(255) NOT NULL,
    address varchar(255),
    phoneNumber varchar(255),
    section_id int,
    CONSTRAINT fk_patient_section_id
    FOREIGN KEY (section_id)
            REFERENCES section(id),
    PRIMARY KEY (id)
);

CREATE TABLE ticket (
    id bigint NOT NULL AUTO_INCREMENT,
    specialist_id bigint NOT NULL,
    data bigint NOT NULL,
    user_id bigint,
    CONSTRAINT fk_specialist_id
    FOREIGN KEY (specialist_id)
            REFERENCES doctors(id),
    CONSTRAINT fk_user_id
    FOREIGN KEY (user_id)
             REFERENCES user(id),
    PRIMARY KEY (id)
);





