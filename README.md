#  Library Book Management API

A simple **CRUD API** for managing books in a small library system using **Spring Boot**.

---

##  Framework
- **Spring Boot** (Java 17+)

---

##  Dependencies
- **Spring Web**
- **Spring Data JPA**
- **H2 Database**
- **Spring Boot DevTools**

---

##  Entity: `Book`
| Field           | Type      | Constraints     |
|-----------------|-----------|-----------------|
| `id`            | Long      | Primary key     |
| `title`         | String    | Not null        |
| `author`        | String    | Not null        |
| `publishedData` | LocalDate | Not null        |

---

##  Endpoints

| Method | Endpoint           | Description              |
|--------|-------------------|--------------------------|
| POST   | `/books`           | Create a new book        |
| GET    | `/books`           | Get all books            |
| GET    | `/books/{id}`      | Get a book by ID         |
| PUT    | `/books/{id}`      | Update a book’s details  |
| DELETE | `/books/{id}`      | Remove a book            |

---

##  Database
- **H2 in-memory** database (no external setup required).
- H2 console available at: [`/h2-console`](http://localhost:8080/h2-console)

---

##  Goals
- Understand **Spring Boot project structure**:
    - `entity`, `repository`, `controller`, `service`
- Learn **basic JPA CRUD operations**.
- Practice **HTTP request/response handling**.

---

##  Stretch Features
1. **Search by Author**
    - `GET /books/search?author=Name`
2. **Validation**
    - Ensure `title` and `author` are required (`@NotNull`, `@Size`)
3. **Exception Handling**
    - Use `@ControllerAdvice` for "Book Not Found" cases

---

TODO:
