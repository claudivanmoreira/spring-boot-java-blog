CREATE TABLE user (
  id varchar(120) PRIMARY KEY,
  name varchar(255),
  email varchar(120),
  password varchar(120),
  created_at timestamp,
  updated_at timestamp
);

CREATE TABLE tag (
  id varchar(120) PRIMARY KEY,
  name varchar(100),
  description varchar(150),
  created_at timestamp,
  updated_at timestamp
);

CREATE TABLE category (
  id varchar(120) PRIMARY KEY,
  name varchar(100),
  description varchar(150),
  created_at timestamp,
  updated_at timestamp
);

CREATE TABLE article (
  id varchar(120) PRIMARY KEY,
  title varchar(160),
  content varchar(255),
  author_id varchar(120),
  category_id varchar(120),
  created_at timestamp,
  updated_at timestamp,
  CONSTRAINT fk_author_article FOREIGN KEY(author_id) REFERENCES user(id),
  CONSTRAINT fk_category_article FOREIGN KEY(category_id) REFERENCES category(id)
);

CREATE TABLE comment (
  id varchar(120) PRIMARY KEY,
  content varchar(255),
  author_id varchar(120),
  article_id varchar(120),
  created_at timestamp,
  updated_at timestamp,
  CONSTRAINT fk_user_comment FOREIGN KEY(author_id) REFERENCES user(id),
  CONSTRAINT fk_article_comment FOREIGN KEY(article_id) REFERENCES article(id)
);

CREATE TABLE article_tags (
  article_id varchar(120),
  tag_id varchar(120) UNIQUE,
  CONSTRAINT pk_article_tags PRIMARY KEY(article_id, tag_id),
  CONSTRAINT fk_tag_article_tags FOREIGN KEY(tag_id) REFERENCES tag(id),
  CONSTRAINT fk_article_article_tags FOREIGN KEY(article_id) REFERENCES article(id)
);