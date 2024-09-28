--liquibase formatted sql

--changeset CreateTable_EnumPriorityFeatureType
CREATE TABLE EnumPriorityFeatureType (
    PriorityFeatureTypeId		INT				AUTO_INCREMENT,
    PriorityFeatureTypeName		VARCHAR(128)	NOT NULL,
    PriorityFeatureTypeDesc		VARCHAR(512)	NULL,
    IsActive					BIT				NOT NULL	DEFAULT 0,
    Lud							DATETIME		NULL,
    Lub							INT				NULL,
    CONSTRAINT pkEnumPriorityFeatureType PRIMARY KEY CLUSTERED (PriorityFeatureTypeId),
    CONSTRAINT ukEnumPriorityFeatureType UNIQUE (PriorityFeatureTypeName)
);
--rollback DROP TABLE EnumPriorityFeatureType;