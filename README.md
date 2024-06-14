# OnlineBookstore

## Introduction
This Online Bookstore Management System allows users to manage books through various operations that interact with the database.

## Features
- Add a single book using title, author, genre, and other details with validation to ensure inputs are correct.
- Retrieve books:
    - Retrieve all books
    - Retrieve books by Title
    - Retrieve books by Author
    - Retrieve books by Genre
    - Retrieve books by ID
    - Retrieve books in sorted orders
- Update existing book details with validation
- Delete books from the database
- Display the homepage with a welcome message

## Setup Instruction
1. Clone the repository: `git clone https://github.com/hyah01/OnlineBookstore`
2. Navigate to the project directory `cd OnlineBookstore`
3. Create a MySQL database for the project `CREATE DATABASE your_database_name`
4. Open `application.properties` file located in `src/main/resources`
5. Modify the configuration based on your database 
   ```
   spring.datasource.url=jdbc:mysql://localhost:3306/onlinebookstore
   spring.datasource.username=username`
   `spring.datasource.password=password`
   ```
6. Build the project `mvn clean install`
7. Run the application `mvn spring-boot:run`
8. Access the application through `http://localhost:9090`
9. Use Postman to utilize HTTP Requests

## Usage
### Homepage
Access `GET` method on `/` to display a welcome message.

### Get All Books
Use `GET` method on `/Books`

### Get Books Sorted
Use `GET` method on `/Books/sorted`

### Get Book By Title
Use `GET` method on `/Books/title?title={BookTitle}` Where BookTitle is the title of the book

### Get All Book Titles
Use `GET` method on `/Books/titles`

### Get Book By Author
Use `GET` method on `/Books/author?author={BookAuthor}` Where BookAuthor is the name of the author

### Get All Book Authors
Use `GET` method on `/Books/authors`

### Get Books By Genre
Use `GET` method on `/Books/genre/{genre}` Where genre is the genre of the book

### Get Book By ID
Use `GET` method on `/Books/{bookId}` Where bookId is the ID of the book

### Add a New Book
Use `POST` method on `/Books`
On Body `{
"title": "Book Title",
"author": "Author Name",
"genre": ["Genre1", "Genre2"],
"price": 19.99
}`

### Update a Book
Use `PUT` method on `/Books`
On Body `{
"id": 1,
"title": "Updated Book Title",
"author": "Updated Author Name",
"genre": ["Updated Genre1", "Updated Genre2"],
"price": 24.99
}`

### Delete a Book
Use `DELETE` method on `/Books/{bookId}` Where bookId is the ID of the book