DROP TABLE IF EXISTS project;
DROP TABLE IF EXISTS client;

CREATE TABLE client (
    id IDENTITY PRIMARY KEY,
    name VARCHAR(100) NOT NULL
);

CREATE TABLE project (
    id IDENTITY PRIMARY KEY,
    name VARCHAR(200) NOT NULL,
    client_id INT,
    start_date DATE,
    finish_date DATE,

    CONSTRAINT fk_project_client
        FOREIGN KEY (client_id)
        REFERENCES client(id)
);