CREATE TABLE journals (
  id INT PRIMARY KEY AUTO_INCREMENT,
  title VARCHAR(255) NOT NULL,
  publisher VARCHAR(255) NOT NULL,
  publication_date DATE NOT NULL,
  quantity INT NOT NULL,
  available_quantity INT NOT NULL
);