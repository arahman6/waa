-- Insert into User table
INSERT INTO users (name) VALUES ('Arif Rahman');
INSERT INTO users (name) VALUES ('Prayash Shrestha');

-- Get the generated IDs for the users
-- Assuming the IDs are 1 and 2

-- Insert into Post table
INSERT INTO post (title, content, author, user_id) VALUES ('First Post', 'This is the content of the first post.', 'Arif Rahman', 1);
INSERT INTO post (title, content, author, user_id) VALUES ('Second Post', 'This is the content of the second post.', 'Arif Rahman', 1);
INSERT INTO post (title, content, author, user_id) VALUES ('Third Post', 'This is the content of the third post.', 'Prayash Shrestha', 2);
INSERT INTO post (title, content, author, user_id) VALUES ('Fourth Post', 'This is the content of the fourth post.', 'Prayash Shrestha', 2);
