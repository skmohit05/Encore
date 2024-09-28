--liquibase formatted sql

--changeset CreateTable_EnumSpecialityType
CREATE TABLE EnumSpecialityType (
    SpecialityTypeId		INT				AUTO_INCREMENT,
    SpecialityTypeName		VARCHAR(128)	NOT NULL,
    SpecialityTypeDesc		VARCHAR(512)	NULL,
    IsActive				BIT				NOT NULL	DEFAULT 0,
    Lud						DATETIME		NULL,
    Lub						INT				NULL,
    CONSTRAINT pkEnumSpecialityType	PRIMARY KEY CLUSTERED (SpecialityTypeId),
    CONSTRAINT ukEnumSpecialityType	UNIQUE (SpecialityTypeName)
);
--rollback DROP TABLE EnumSpecialityType;