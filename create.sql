
    create table contract (
        id integer not null,
        type tinyint check (type between 0 and 2),
        start_date datetime(6),
        customer_codice_fiscale varchar(255),
        primary key (id)
    ) engine=InnoDB;

    create table contract_seq (
        next_val bigint
    ) engine=InnoDB;

    insert into contract_seq values ( 1 );

    create table customer (
        type tinyint check (type between 0 and 1),
        codice_fiscale varchar(255) not null,
        name varchar(255),
        primary key (codice_fiscale)
    ) engine=InnoDB;

    create table customer_seq (
        next_val bigint
    ) engine=InnoDB;

    insert into customer_seq values ( 1 );

    alter table contract 
       add constraint FKpwwejg3a7egwrs68lru3eka0e 
       foreign key (customer_codice_fiscale) 
       references customer (codice_fiscale);
