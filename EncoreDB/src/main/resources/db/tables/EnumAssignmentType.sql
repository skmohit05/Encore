--liquibase formatted sql

--changeset CreateTable_EnumAssignmentType
CREATE TABLE EnumAssignmentType (
    AssignmentTypeId		INT				AUTO_INCREMENT,
    AssignmentTypeName		VARCHAR(128)	NOT NULL,
    AssignmentTypeDesc		VARCHAR(512)	NULL,
    IsActive				BIT				NOT NULL	DEFAULT 0,
    Lud						DATETIME		NULL,
    Lub						INT				NULL,
    CONSTRAINT pkEnumAssignmentType PRIMARY KEY CLUSTERED (AssignmentTypeId),
    CONSTRAINT ukEnumAssignmentType UNIQUE (AssignmentTypeName)
);
--rollback DROP TABLE EnumAssignmentType;