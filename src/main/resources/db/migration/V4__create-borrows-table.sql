CREATE TABLE borrows (
  id INT PRIMARY KEY AUTO_INCREMENT,
  item_id INT NOT NULL,
  item_type ENUM('book', 'journal') NOT NULL,
  borrower_id INT NOT NULL,
  borrow_date DATE NOT NULL,
  return_date DATE NOT NULL,
  FOREIGN KEY (item_id) REFERENCES books(id) ,
  FOREIGN KEY (item_id) REFERENCES journals(id) ,
  FOREIGN KEY (borrower_id) REFERENCES users(id)
);