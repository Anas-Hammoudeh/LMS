CREATE TABLE books (
  id INT PRIMARY KEY AUTO_INCREMENT,
  title VARCHAR(255) NOT NULL,
  author VARCHAR(255) NOT NULL,
  isbn VARCHAR(255) NOT NULL UNIQUE,
  publisher VARCHAR(255) NOT NULL,
  publication_date DATE NOT NULL,
  quantity INT NOT NULL,
  available_quantity INT NOT NULL
);