--liquibase formatted sql

--changeset CreateTable_MedicalJobSeekerJobInfo
CREATE TABLE MedicalJobSeekerJobInfo (
	MedicalJobSeekerJobInfoId	INT				AUTO_INCREMENT,
    Title						VARCHAR(512)	NOT NULL,
	Speciality					VARCHAR(512)	NOT NULL,
	Place						VARCHAR(512)	NOT NULL,
	FacilityName				VARCHAR(512)	NOT NULL,
	FacilityTypeId				INT				NOT NULL,
    OrganizationTypeId			INT				NULL,
    FacilitySubTypeId			INT				NULL,
	AssignmentTypeId			INT				NOT NULL,
	AssignmentShiftTypeId		INT				NOT NULL,
	City						VARCHAR(128)	NOT NULL,
	State						VARCHAR(128)	NOT NULL,
    Zip							CHAR(10)			NULL,
	AssignmentFromDate			DATE			NOT NULL,
	AssignmentToDate			DATE			NULL,
	Beds						INT				NULL,
	AvgPatientsInMonth			INT				NULL,
	Peers						INT				NULL,
	Nurses						INT				NULL,
	ORs							INT				NULL,
	Supervised					BIT				NULL,
	Compensation				INT				NULL,
	Travel						BIT				NULL		DEFAULT 0,
	TravelHousingCoverage		BIT				NULL		DEFAULT 0,
    Lud              			DATETIME       NULL,
    Lub              			INT             NULL,
	CONSTRAINT pkMedicalJobSeekerJobInfo PRIMARY KEY CLUSTERED (MedicalJobSeekerJobInfoId),
    CONSTRAINT fkMedicalJobSeekerJobInfoFacilityTypeId FOREIGN KEY (FacilityTypeId) REFERENCES EnumFacilityType (FacilityTypeId) ON UPDATE NO ACTION ON DELETE NO ACTION,
    CONSTRAINT fkMedicalJobSeekerJobInfoAssignmentTypeId FOREIGN KEY (AssignmentTypeId) REFERENCES EnumAssignmentType (AssignmentTypeId) ON UPDATE NO ACTION ON DELETE NO ACTION,
    CONSTRAINT fkMedicalJobSeekerJobInfoAssignmentShiftTypeId FOREIGN KEY (AssignmentShiftTypeId) REFERENCES EnumShiftType (ShiftTypeId) ON UPDATE NO ACTION ON DELETE NO ACTION,
    CONSTRAINT fkMedicalJobSeekerJobInfoOrganizationTypeId FOREIGN KEY (OrganizationTypeId) REFERENCES EnumOrganizationType (OrganizationTypeId) ON UPDATE NO ACTION ON DELETE NO ACTION,
    CONSTRAINT fkMedicalJobSeekerJobInfoFacilitySubTypeId FOREIGN KEY (FacilitySubTypeId) REFERENCES EnumFacilitySubType (FacilitySubTypeId) ON UPDATE NO ACTION ON DELETE NO ACTION
);
--rollback DROP TABLE MedicalJobSeekerJobInfo;