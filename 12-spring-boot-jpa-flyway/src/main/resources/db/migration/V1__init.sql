CREATE TABLE CUSTOMER (
  id BIGINT GENERATED BY DEFAULT AS IDENTITY,
  firstname varchar(255) not null,
  lastname varchar(255) not null
);
CREATE TABLE CHECKOUT (
  id BIGINT GENERATED BY DEFAULT AS IDENTITY,
  customer_id BIGINT
);
