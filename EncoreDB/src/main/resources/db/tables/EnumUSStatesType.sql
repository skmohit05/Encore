--liquibase formatted sql

--changeset CreateTable_EnumUSStatesType
CREATE TABLE EnumUSStatesType (
    USStatesTypeId		INT				AUTO_INCREMENT,
    USStatesTypeName	VARCHAR(128)	NOT NULL,
    USStatesTypeDesc	VARCHAR(512)	NULL,
    IsActive			BIT				NOT NULL	DEFAULT 0,
    Lud					DATETIME		NULL,
    Lub					INT				NULL,
    CONSTRAINT pkEnumUSStatesType PRIMARY KEY CLUSTERED (USStatesTypeId),
    CONSTRAINT ukEnumUSStatesType UNIQUE (USStatesTypeName)
);
--rollback DROP TABLE EnumUSStatesType;