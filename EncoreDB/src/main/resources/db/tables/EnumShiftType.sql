--liquibase formatted sql

--changeset CreateTable_EnumShiftType
CREATE TABLE EnumShiftType (
    ShiftTypeId			INT				AUTO_INCREMENT,
    ShiftTypeName		VARCHAR(128)	NOT NULL,
    ShiftTypeDesc		VARCHAR(512)	NULL,
    IsActive			BIT				NOT NULL	DEFAULT 0,
    Lud					DATETIME		NULL,
    Lub					INT				NULL,
    CONSTRAINT pkEnumShiftType PRIMARY KEY CLUSTERED (ShiftTypeId),
    CONSTRAINT ukEnumShiftType UNIQUE (ShiftTypeName)
);
--rollback DROP TABLE EnumShiftType;