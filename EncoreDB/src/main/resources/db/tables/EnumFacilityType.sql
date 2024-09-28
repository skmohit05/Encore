--liquibase formatted sql

--changeset CreateTable_EnumFacilityType
CREATE TABLE EnumFacilityType (
    FacilityTypeId		INT				AUTO_INCREMENT,
    FacilityTypeName	VARCHAR(128)	NOT NULL,
    FacilityTypeDesc	VARCHAR(512)	NULL,
    IsActive			BIT				NOT NULL	DEFAULT 0,
    Lud					DATETIME		NULL,
    Lub					INT				NULL,
    CONSTRAINT pkEnumFacilityType PRIMARY KEY CLUSTERED (FacilityTypeId),
    CONSTRAINT ukEnumFacilityType UNIQUE (FacilityTypeName)
);
--rollback DROP TABLE EnumFacilityType;