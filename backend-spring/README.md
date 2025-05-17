# NBA Draft Backend Application

This is a Spring Boot application for managing NBA clubs and players with CRUD operations.

## Database Schema

The application uses two main entities:
- **Club**: Represents an NBA team with attributes like name, city, conference, etc.
- **Player**: Represents a basketball player with attributes like name, position, stats, etc.

## Requirements

- Java 21
- Maven
- Docker and Docker Compose

## Running the Application

### Option 1: Using Docker Compose (Recommended)

The easiest way to run the entire stack is using Docker Compose:

```bash
# Build and start both the PostgreSQL database and Spring Boot application
docker-compose up -d
```

This will:
1. Start PostgreSQL with the `nba_draft` database
2. Build and start the Spring Boot application
3. Load sample data into the database

The API will be available at http://localhost:8080

### Option 2: Run Components Separately

#### 1. Start the PostgreSQL Database

```bash
# Start only the PostgreSQL container
docker-compose up -d postgres
```

#### 2. Run the Spring Boot Application Locally

```bash
# Using Maven
./mvnw spring-boot:run

# Or if you prefer:
mvn spring-boot:run
```

## Sample Data

The application comes with SQL script for inserting sample data - `init-db.sql`.
The easiest option for running is it connect to the db in container or connect to the db by pgAdmin.

The script contains data for:
- 5 NBA clubs (Lakers, Celtics, Bulls, Heat, Warriors)
- 10 players (2 for each club)

## API Endpoints

### Clubs

- **GET /api/clubs** - Get all clubs
- **GET /api/clubs/{id}** - Get a club by ID
- **POST /api/clubs** - Create a new club
- **PUT /api/clubs/{id}** - Update a club
- **DELETE /api/clubs/{id}** - Delete a club
- **GET /api/clubs/region/{regionCode}** - Get clubs by region code
- **GET /api/clubs/conference/{conference}** - Get clubs by conference
- **GET /api/clubs/division/{division}** - Get clubs by division

#### Example
```
curl -X GET http://localhost:8080/api/clubs/1 -H "Accept: application/json"
```

### Players

- **GET /api/players** - Get all players
- **GET /api/players/{id}** - Get a player by ID
- **POST /api/players** - Create a new player
- **PUT /api/players/{id}** - Update a player
- **DELETE /api/players/{id}** - Delete a player
- **GET /api/players/club/{clubId}** - Get players by club ID
- **GET /api/players/category/{category}** - Get players by category
- **GET /api/players/search?lastName={lastName}** - Search players by last name
- **GET /api/players/position/{position}** - Get players by position
- **GET /api/players/draft/{year}** - Get players by draft year

## Future Enhancements

- Migration to CockroachDB
- Implementation of data partitioning strategies 