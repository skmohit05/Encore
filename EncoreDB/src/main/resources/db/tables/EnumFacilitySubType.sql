--liquibase formatted sql

--changeset CreateTable_EnumFacilitySubType
CREATE TABLE EnumFacilitySubType (
    FacilitySubTypeId		INT				AUTO_INCREMENT,
    FacilitySubTypeName		VARCHAR(128)	NOT NULL,
    FacilitySubTypeDesc		VARCHAR(512)	NULL,
    IsActive				BIT				NOT NULL	DEFAULT 0,
    Lud						DATETIME		NULL,
    Lub						INT				NULL,
    CONSTRAINT pkEnumFacilitySubType PRIMARY KEY CLUSTERED (FacilitySubTypeId),
    CONSTRAINT ukEnumFacilitySubType UNIQUE (FacilitySubTypeName)
);
--rollback DROP TABLE EnumFacilitySubType;