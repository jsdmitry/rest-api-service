create table if not exists customers (
    ID bigint primary key ,
    CompanyName text NOT NULL,
    Address text NOT NULL,
    City varchar(200) NOT NULL,
    State varchar(200) NOT NULL,
    Zipcode bigint ,
    Phone varchar(16) NOT NULL,
    Website text
)