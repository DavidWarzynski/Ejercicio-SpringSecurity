-- Insertar roles
INSERT INTO roles (name) VALUES ('USER');
INSERT INTO roles (name) VALUES ('ADMIN');

-- Insertar usuarios
INSERT INTO users (username, password) VALUES ('user1', '$2a$10$D/9ej3nBJXzsnog83z6hPevNOyKUPOFcd/hn/XdbJ0bDvbdStIlx2');
INSERT INTO user_roles (user_id, role_id) VALUES (1, 1);

INSERT INTO users (username, password) VALUES ('admin1', '$2a$10$D/9ej3nBJXzsnog83z6hPevNOyKUPOFcd/hn/XdbJ0bDvbdStIlx2');
INSERT INTO user_roles (user_id, role_id) VALUES (2, 2);
