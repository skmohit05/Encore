--liquibase formatted sql

--changeset CreateTable_EnumCompensationType
CREATE TABLE EnumCompensationType (
    CompensationTypeId		INT				AUTO_INCREMENT,
    CompensationTypeName	VARCHAR(128)	NOT NULL,
    CompensationTypeDesc	VARCHAR(512)	NULL,
    IsActive				BIT				NOT NULL	DEFAULT 0,
    Lud						DATETIME		NULL,
    Lub						INT				NULL,
    CONSTRAINT pkEnumCompensationType PRIMARY KEY CLUSTERED (CompensationTypeId),
    CONSTRAINT ukEnumCompensationType UNIQUE (CompensationTypeName)
);
--rollback DROP TABLE EnumCompensationType;