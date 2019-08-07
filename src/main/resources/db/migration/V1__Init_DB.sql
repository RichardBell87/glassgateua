Hibernate: create sequence hibernate_sequence start 1 increment 1
Hibernate: create table gg_lot (
    id int8 not null,
    filename varchar(255),
    lotdescription varchar(255),
    lotexpiringdate varchar(255),
    lottotalprice int8,
    lotunitprice int8,
    tag date;
    gg_user_id int8, primary key (id)
)
Hibernate: create table gg_user (
    id int8 not null,
    activation_code varchar(255),
    active boolean not null,
    password varchar(255),
    usercardcvv2cvc2code varchar(255),
    usercardexpirationdatemonth varchar(255),
    usercardexpirationdateyear varchar(255),
    usercardnumber1 varchar(255),
    usercardnumber2 varchar(255),
    usercardnumber3 varchar(255),
    usercardnumber4 varchar(255),
    usercardnumber varchar(255),
    userconfirmpassword varchar(255),
    useremail varchar(255),
    userfirstname varchar(255),
    userlastname varchar(255),
    username varchar(255),
    userpatronymic varchar(255),
    userphone varchar(255), primary key (id)
    )
Hibernate: create table user_role (
    user_id int8 not null,
    roles varchar(255)
    )
Hibernate: alter table if exists gg_lot
    add constraint FKjn3j5ws7qsnijyxuenxnuiepe
    foreign key (gg_user_id) references gg_user
Hibernate: alter table if exists user_role
    add constraint FKbeujcv99pa84u0906hha8bp8i
    foreign key (user_id) references gg_user