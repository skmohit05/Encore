--liquibase formatted sql

--changeset CreateTable_EnumJobType
CREATE TABLE EnumJobType (
    JobTypeId		INT				AUTO_INCREMENT,
    JobTypeName		VARCHAR(128)	NOT NULL,
    JobTypeDesc		VARCHAR(512)	NULL,
    IsActive		BIT				NOT NULL	DEFAULT 0,
    Lud				DATETIME		NULL,
    Lub				INT				NULL,
    CONSTRAINT pkEnumJobType PRIMARY KEY CLUSTERED (JobTypeId),
    CONSTRAINT ukEnumJobType UNIQUE (JobTypeName)
);
--rollback DROP TABLE EnumJobType;