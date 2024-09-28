--liquibase formatted sql

--changeset CreateTable_EnumAccessRight
CREATE TABLE EnumAccessRight (
    AccessRightId   INT             NOT NULL    AUTO_INCREMENT,
    AccessRightName NVARCHAR(128)   NOT NULL,
    AccessRightDesc NVARCHAR(512)   NULL,
    AccessRightRole NVARCHAR(64)    NOT NULL,
    IsActive        BIT             NOT NULL    DEFAULT 0,
    Lud             DATETIME        NULL,
    Lub             INT             NULL,
    CONSTRAINT pkEnumAccessRight PRIMARY KEY CLUSTERED (AccessRightId),
    CONSTRAINT ukEnumAccessRight UNIQUE (AccessRightName)
);
--rollback DROP TABLE EnumAccessRight;

