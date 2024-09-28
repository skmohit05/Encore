--liquibase formatted sql

--changeset CreateTable_EnumOrganizationType
CREATE TABLE EnumOrganizationType (
    OrganizationTypeId		INT				AUTO_INCREMENT,
    OrganizationTypeName	VARCHAR(128)	NOT NULL,
    OrganizationTypeDesc	VARCHAR(512)	NULL,
    IsActive				BIT				NOT NULL	DEFAULT 0,
    Lud						DATETIME		NULL,
    Lub						INT				NULL,
    CONSTRAINT pkEnumOrganizationType PRIMARY KEY CLUSTERED (OrganizationTypeId),
    CONSTRAINT ukEnumOrganizationType UNIQUE (OrganizationTypeName)
);
--rollback DROP TABLE EnumOrganizationType;