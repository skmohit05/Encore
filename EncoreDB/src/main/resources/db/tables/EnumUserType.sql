--liquibase formatted sql

--changeset CreateTable_EnumUserType
CREATE TABLE EnumUserType (
    UserTypeId		INT				AUTO_INCREMENT,
    UserTypeName	VARCHAR(128)	NOT NULL,
    UserTypeDesc	VARCHAR(512)	NULL,
    UserRole        NVARCHAR(64)    NOT NULL,
    IsActive		BIT				NOT NULL	DEFAULT 0,
    Lud				DATETIME		NULL,
    Lub				INT				NULL,
    CONSTRAINT pkEnumUserType PRIMARY KEY CLUSTERED (UserTypeId),
    CONSTRAINT ukEnumUserType UNIQUE (UserTypeName)
);
--rollback DROP TABLE EnumUserType;