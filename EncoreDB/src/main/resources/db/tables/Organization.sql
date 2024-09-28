--liquibase formatted sql

--changeset CreateTable_Organization
CREATE TABLE Organization (
    OrganizationId			INT					NOT NULL   AUTO_INCREMENT,
    OrganizationName		VARCHAR(256)		NOT NULL,
    OrganizationTypeId		INT					NOT NULL,
    Speciality				VARCHAR(1024)		NULL,
    FacilityTypeId			INT					NULL,
    FacilitySubTypeId			INT				NULL,
    Government				BIT					NULL		DEFAULT 0,
    Lud              		DATETIME       		NULL,
    Lub              		INT             	NULL,
    CONSTRAINT pkOrganization PRIMARY KEY CLUSTERED (OrganizationId),
    CONSTRAINT ukOrganization UNIQUE (OrganizationName),
    CONSTRAINT fkOrganizationOrganizationTypeId FOREIGN KEY (OrganizationTypeId) REFERENCES EnumOrganizationType (OrganizationTypeId) ON UPDATE NO ACTION ON DELETE NO ACTION,
    CONSTRAINT fkOrganizationFacilityTypeId FOREIGN KEY (FacilityTypeId) REFERENCES EnumFacilityType (FacilityTypeId) ON UPDATE NO ACTION ON DELETE NO ACTION,
    CONSTRAINT fkOrganizationFacilitySubTypeId FOREIGN KEY (FacilitySubTypeId) REFERENCES EnumFacilitySubType (FacilitySubTypeId) ON UPDATE NO ACTION ON DELETE NO ACTION
);
--rollback DROP TABLE Organization;
