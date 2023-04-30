-- Insert 7 books
INSERT INTO books (title, author, isbn, publisher,  publication_date, quantity, available_quantity)
VALUES
    ('To Kill a Mockingbird', 'Harper Lee', '9780061120084', 'HarperCollins', '1960-10-10', 10, 10),
    ('The Great Gatsby', 'F. Scott Fitzgerald', '9780743273565', 'Scribner', '1925-10-14', 15, 15),
    ('1984', 'George Orwell', '9780451524935', 'Signet Classic', '1949-10-14', 12, 12),
    ('The Catcher in the Rye', 'J.D. Salinger', '9780316769488', 'Little, Brown and Company', '1949-10-14', 8, 8),
    ('Pride and Prejudice', 'Jane Austen', '9780141439518', 'Penguin Classics', '1949-10-14', 6, 6),
    ('To the Lighthouse', 'Virginia Woolf', '9780099478294', 'Vintage Classics', '1949-10-14', 9, 9),
    ('The Picture of Dorian Gray', 'Oscar Wilde', '9780141439570', 'Penguin Classics', '1949-10-14', 7, 7);

-- Insert 7 journals
INSERT INTO journals (title, publisher, publication_date, quantity,  available_quantity)
VALUES
    ('Nature', 'Springer Nature', '2022-10-10', 100,100),
    ('Science', 'American Association for the Advancement of Science', '2022-10-10', 382,382),
    ('The Lancet', 'Elsevier', '2022-10-10', 399,399),
    ('JAMA: The Journal of the American Medical Association', 'American Medical Association', '2022-10-10', 327,327),
    ('The New England Journal of Medicine', 'Massachusetts Medical Society', '2022-10-10', 386,386),
    ('Journal of Finance', 'Wiley-Blackwell', '2022-10-10', 77,77),
    ('Journal of Marketing', 'American Marketing Association', '2022-10-10', 86,86);

-- Insert 7 borrowers
INSERT INTO users (name,password, email, type)
VALUES
    ('John Smith','123', 'john.smith@example.com', 'student'),
    ('Jane Doe','123', 'jane.doe@example.com', 'student'),
    ('Bob Johnson','123', 'bob.johnson@example.com', 'faculty'),
    ('Emily Brown','123', 'emily.brown@example.com', 'faculty'),
    ('Tom Wilson','123', 'tom.wilson@example.com', 'student'),
    ('Amy Chen','123', 'amy.chen@example.com', 'student'),
    ('Mike Lee','123', 'mike.lee@example.com', 'faculty');

INSERT INTO borrows (item_id, item_type, borrower_id, borrow_date, return_date)
VALUES
    (1, 'book', 1, '2022-04-01', '2022-04-08'),
    (2, 'book', 1, '2022-04-15', '2022-04-22'),
    (3, 'book', 2, '2022-04-10', '2022-04-17'),
    (4, 'book', 3, '2022-04-05', '2022-04-12'),
    (5, 'book', 4, '2022-04-14', '2022-04-21'),
    (6, 'book', 5, '2022-04-09', '2022-04-16'),
    (7, 'book', 6, '2022-04-02', '2022-04-09');