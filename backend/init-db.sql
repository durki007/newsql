-- Create sample clubs
INSERT INTO clubs (name, city, conference, division, founding_year, arena_name, owner_name, region_code, created_at, updated_at)
VALUES 
    ('Lakers', 'Los Angeles', 'West', 'Pacific', 1947, 'Crypto.com Arena', 'Jeanie Buss', 'US-WEST', NOW(), NOW()),
    ('Celtics', 'Boston', 'East', 'Atlantic', 1946, 'TD Garden', 'Boston Basketball Partners', 'US-EAST', NOW(), NOW()),
    ('Bulls', 'Chicago', 'East', 'Central', 1966, 'United Center', 'Jerry Reinsdorf', 'US-CENTRAL', NOW(), NOW()),
    ('Heat', 'Miami', 'East', 'Southeast', 1988, 'Kaseya Center', 'Micky Arison', 'US-EAST', NOW(), NOW()),
    ('Warriors', 'San Francisco', 'West', 'Pacific', 1946, 'Chase Center', 'Joe Lacob', 'US-WEST', NOW(), NOW());

-- Create sample players
-- Lakers players
INSERT INTO players (first_name, last_name, jersey_number, position, height_cm, weight_kg, date_of_birth, nationality, player_category, draft_year, draft_position, salary, club_id, created_at, updated_at)
VALUES 
    ('LeBron', 'James', 23, 'SF', 206, 113.4, '1984-12-30', 'USA', 'star', 2003, 1, 44474988, 1, NOW(), NOW()),
    ('Anthony', 'Davis', 3, 'PF', 208, 114.8, '1993-03-11', 'USA', 'star', 2012, 1, 40600080, 1, NOW(), NOW());

-- Celtics players
INSERT INTO players (first_name, last_name, jersey_number, position, height_cm, weight_kg, date_of_birth, nationality, player_category, draft_year, draft_position, salary, club_id, created_at, updated_at)
VALUES 
    ('Jayson', 'Tatum', 0, 'SF', 203, 95.3, '1998-03-03', 'USA', 'star', 2017, 3, 32600060, 2, NOW(), NOW()),
    ('Jaylen', 'Brown', 7, 'SG', 198, 101.2, '1996-10-24', 'USA', 'star', 2016, 3, 30700000, 2, NOW(), NOW());

-- Bulls players
INSERT INTO players (first_name, last_name, jersey_number, position, height_cm, weight_kg, date_of_birth, nationality, player_category, draft_year, draft_position, salary, club_id, created_at, updated_at)
VALUES 
    ('Zach', 'LaVine', 8, 'SG', 196, 90.7, '1995-03-10', 'USA', 'star', 2014, 13, 40064220, 3, NOW(), NOW()),
    ('Nikola', 'Vucevic', 9, 'C', 211, 118.0, '1990-10-24', 'Montenegro', 'veteran', 2011, 16, 20000000, 3, NOW(), NOW());

-- Heat players
INSERT INTO players (first_name, last_name, jersey_number, position, height_cm, weight_kg, date_of_birth, nationality, player_category, draft_year, draft_position, salary, club_id, created_at, updated_at)
VALUES 
    ('Jimmy', 'Butler', 22, 'SF', 201, 104.3, '1989-09-14', 'USA', 'star', 2011, 30, 45183960, 4, NOW(), NOW()),
    ('Bam', 'Adebayo', 13, 'C', 206, 115.7, '1997-07-18', 'USA', 'star', 2017, 14, 32600060, 4, NOW(), NOW());

-- Warriors players
INSERT INTO players (first_name, last_name, jersey_number, position, height_cm, weight_kg, date_of_birth, nationality, player_category, draft_year, draft_position, salary, club_id, created_at, updated_at)
VALUES 
    ('Stephen', 'Curry', 30, 'PG', 188, 84.0, '1988-03-14', 'USA', 'star', 2009, 7, 51915615, 5, NOW(), NOW()),
    ('Klay', 'Thompson', 11, 'SG', 198, 99.8, '1990-02-08', 'USA', 'veteran', 2011, 11, 43219440, 5, NOW(), NOW()); 