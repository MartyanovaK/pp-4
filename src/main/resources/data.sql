INSERT INTO roles (role)
VALUES ('ROLE_USER');

INSERT INTO roles (role)
VALUES ('ROLE_ADMIN');
INSERT INTO users (username, name, last_name, email, password) VALUES ('admin', 'Boris', 'Ivanov', 'mail.ru', '$2a$08$rpiT312X4Vq5.3U685EI9e4UrTvrB2hnr2fF1dbviq1p.nF5bnCtC');
INSERT INTO users (username, name, last_name, email, password) VALUES ('user', 'Ivan', 'Borisov', 'gmail.ru', '$2a$08$j.2li2T86pya1o/RqPAMoO1SadL/nA/9qVi/RMLcgsr6T2XK00fvW');
INSERT users_roles (user_id, role_id)
VALUES ((SELECT id FROM users WHERE username = 'user'), (SELECT id FROM roles WHERE role = 'ROLE_USER'));
INSERT users_roles (user_id, role_id)
VALUES ((SELECT id FROM users WHERE username = 'admin'), (SELECT id FROM roles WHERE role = 'ROLE_ADMIN'));
INSERT users_roles (user_id, role_id)
VALUES ((SELECT id FROM users WHERE username = 'admin'), (SELECT id FROM roles WHERE role = 'ROLE_USER'));