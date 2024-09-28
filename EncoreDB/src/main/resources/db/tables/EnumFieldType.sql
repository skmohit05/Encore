--liquibase formatted sql

--changeset CreateTable_EnumFieldType
CREATE TABLE EnumFieldType (
    FieldTypeId		INT				AUTO_INCREMENT,
    FieldTypeName	VARCHAR(128)	NOT NULL,
    FieldTypeDesc	VARCHAR(512)	NULL,
    IsActive		BIT				NOT NULL	DEFAULT 0,
    Lud				DATETIME		NULL,
    Lub				INT				NULL,
    CONSTRAINT pkEnumFieldType PRIMARY KEY CLUSTERED (FieldTypeId),
    CONSTRAINT ukEnumFieldType UNIQUE (FieldTypeName)
);
--rollback DROP TABLE EnumFieldType;