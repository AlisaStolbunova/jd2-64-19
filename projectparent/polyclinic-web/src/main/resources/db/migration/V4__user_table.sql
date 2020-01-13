INSERT INTO user_role
VALUES (1, 'ADMIN'),
       (2, 'USER');

ALTER TABLE user
    AUTO_INCREMENT = 100;

ALTER TABLE user
ADD COLUMN salt varchar(50)  NOT NULL AFTER password;

INSERT INTO user
VALUES (1, 'user1', 'cbb5e2641ecb0297e6aab7091d63bc2b4d5c053ffb24a5192fcd366c1d49c0ba', 'gl7a44WqZDKb6LsNFKhlLSKOA3g', 1),
       (2, 'user2', '30282f9bc6af77860ed93d71985fe3ce6c0a4a6a2405d788b00cf3b58bdd95de', 'RiTAbpPDRLoncHofjk4', 2);