-- begin OPTAPLANNER_PROCESS
create table OPTAPLANNER_PROCESS (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    NAME varchar(255),
    REQUIRED_CPU_POWER integer,
    REQUIRED_MEMORY integer,
    REQUIRED_NETWORK_BANDWIDTH integer,
    COMPUTER_ID varchar(36),
    CLOUD_BALANCE_ID varchar(36),
    --
    primary key (ID)
)^
-- end OPTAPLANNER_PROCESS
-- begin OPTAPLANNER_COMPUTER
create table OPTAPLANNER_COMPUTER (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    NAME varchar(255),
    CPU_POWER integer,
    MEMORY integer,
    NETWORK_BANDWIDTH integer,
    COST integer,
    CLOUD_BALANCE_ID varchar(36),
    --
    primary key (ID)
)^
-- end OPTAPLANNER_COMPUTER
-- begin OPTAPLANNER_CLOUD_BALANCE
create table OPTAPLANNER_CLOUD_BALANCE (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    NAME varchar(255),
    HARD_SCORE integer,
    SOFT_SCORE integer,
    --
    primary key (ID)
)^
-- end OPTAPLANNER_CLOUD_BALANCE
