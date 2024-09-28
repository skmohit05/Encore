--liquibase formatted sql

--changeset CreateTable_EnumJobPostingStatusType
CREATE TABLE EnumJobPostingStatusType (
    JobPostingStatusTypeId		INT				AUTO_INCREMENT,
    JobPostingStatusTypeName	VARCHAR(128)	NOT NULL,
    JobPostingStatusTypeDesc	VARCHAR(512)	NULL,
    IsActive					BIT				NOT NULL	DEFAULT 0,
    Lud							DATETIME		NULL,
    Lub							INT				NULL,
    CONSTRAINT pkEnumJobPostingStatusType PRIMARY KEY CLUSTERED (JobPostingStatusTypeId),
    CONSTRAINT ukEnumJobPostingStatusType UNIQUE (JobPostingStatusTypeName)
);
--rollback DROP TABLE EnumJobPostingStatusType;