create table accounts(
    id bigint not null auto_increment,
    owner_name varchar(50),
    account_number varchar(8),
    balance bigint,
    creation_date datetime,
    bank_id bigint,
    primary key (id)
);