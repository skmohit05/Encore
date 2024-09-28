--liquibase formatted sql

--changeset CreateTable_EnumUserStatusType
CREATE TABLE EnumUserStatusType (
    UserStatusTypeId		INT				AUTO_INCREMENT,
    UserStatusTypeName		VARCHAR(128)	NOT NULL,
    UserStatusTypeDesc		VARCHAR(512)	NULL,
    IsActive				BIT				NOT NULL	DEFAULT 0,
    Lud						DATETIME		NULL,
    Lub						INT				NULL,
    CONSTRAINT pkEnumUserStatusType PRIMARY KEY CLUSTERED (UserStatusTypeId),
    CONSTRAINT ukEnumUserStatusType UNIQUE (UserStatusTypeName)
);
--rollback DROP TABLE EnumUserStatusType;