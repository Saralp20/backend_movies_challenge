# Movie API Backend Challenge

This project is a simple REST API for managing movie data. The API allows for basic CRUD operations (Create, Read, Update, Delete) and provides filtering by launch date and rank. The API was developed using Spring Boot and an embedded H2 database.

## Technologies Used

- **Java 17**
- **Spring Boot 3**
- **H2 Database** (embedded)
- **Maven** (for dependency management)
- **Postman** (for API testing)

## Running the Application

To run this application, follow the steps below:

### 1. Clone the repository
    
```bash
git clone https://github.com/Saralp20/backend_movies_challenge
cd backend_movies_challenge
```

### 2. Build and Run the Project
    
```bash
mvn clean install
mvn spring-boot:run
```

This will start the server on `localhost:8080`.

### 3. H2 Database Console

The application uses an embedded H2 database. You can access the H2 database console at:

```
http://localhost:8080/h2-console
```

**JDBC URL:** `jdbc:h2:mem:testdb`  
**Username:** `sa`  
**Password:** (leave empty)

#### Mock Data for Testing
```sql
-- Insert mock data into Movies table
INSERT INTO Movies (title, date, rank, revenue) VALUES ('The Matrix', '1999-03-31', 9, 463);
INSERT INTO Movies (title, date, rank, revenue) VALUES ('Inception', '2010-07-16', 8, 829);
INSERT INTO Movies (title, date, rank, revenue) VALUES ('Interstellar', '2014-11-07', 8, 677);
INSERT INTO Movies (title, date, rank, revenue) VALUES ('The Dark Knight', '2008-07-18', 9, 1004);
INSERT INTO Movies (title, date, rank, revenue) VALUES ('Pulp Fiction', '1994-10-14', 9, 213);
INSERT INTO Movies (title, date, rank, revenue) VALUES ('The Lord of the Rings: The Fellowship of the Ring', '2001-12-19', 9, 897);
INSERT INTO Movies (title, date, rank, revenue) VALUES ('The Godfather', '1972-03-24', 10, 246);
INSERT INTO Movies (title, date, rank, revenue) VALUES ('Forrest Gump', '1994-07-06', 8, 678);
INSERT INTO Movies (title, date, rank, revenue) VALUES ('Gladiator', '2000-05-05', 8, 457);
INSERT INTO Movies (title, date, rank, revenue) VALUES ('Titanic', '1997-12-19', 9, 2187);
INSERT INTO Movies (title, date, rank, revenue) VALUES ('Avatar', '2009-12-18', 9, 2788);
INSERT INTO Movies (title, date, rank, revenue) VALUES ('Star Wars: Episode IV - A New Hope', '1977-05-25', 8, 775);
INSERT INTO Movies (title, date, rank, revenue) VALUES ('Jurassic Park', '1993-06-11', 8, 1034);
INSERT INTO Movies (title, date, rank, revenue) VALUES ('The Avengers', '2012-05-04', 8, 1519);
INSERT INTO Movies (title, date, rank, revenue) VALUES ('Iron Man', '2008-05-02', 7, 585);
```


### 4. API Endpoints

#### Retrieve All Movies
**GET** `/movies`

```
http://localhost:8080/movies
```

#### Retrieve Movies by Rank
**GET** `/movies?rank={rank}`

```
http://localhost:8080/movies?rank=8
```

#### Retrieve Movies by Launch Date
**GET** `/movies?date={launchDate}`

```
http://localhost:8080/movies?date=2009-12-18
```

#### Add a Movie
**POST** `/movies`

**Body (JSON):**
```json
{
  "title": "Spider-Man: No Way Home",
  "date": "2021-12-17",
  "rank": 8,
  "revenue": 1920
}
```

#### Update a Movie
**PUT** `/movies`

**Body (JSON):**
```json
{
  "title": "Spider-Man: No Way Home",
  "date": "2021-12-17",
  "rank": 9,
  "revenue": 2000
}
```

#### Delete a Movie by Title
**DELETE** `/movies/{title}`

```
http://localhost:8080/movies/Spider-Man: No Way Home
```

### 5. Project Structure
- **controller**: Contains the MovieController class which defines the REST API endpoints.
- **model**: Contains the Movie entity and the MovieService class for business logic.
- **repository**: Contains the MovieRepository interface for data persistence with H2.
