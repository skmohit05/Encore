--liquibase formatted sql

--changeset CreateTable_EnumMFAType
CREATE TABLE EnumMFAType (
    MFATypeId		INT				AUTO_INCREMENT,
    MFATypeName		VARCHAR(128)	NOT NULL,
    MFATypeDesc		VARCHAR(512)	NULL,
    IsActive		BIT				NOT NULL	DEFAULT 0,
    Lud				DATETIME		NULL,
    Lub				INT				NULL,
    CONSTRAINT pkEnumMFAType PRIMARY KEY CLUSTERED (MFATypeId),
    CONSTRAINT ukEnumMFAType UNIQUE (MFATypeName)
);
--rollback DROP TABLE EnumMFAType;