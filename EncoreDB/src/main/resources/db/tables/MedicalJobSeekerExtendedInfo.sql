--liquibase formatted sql

--changeset CreateTable_MedicalJobSeekerExtendedInfo
CREATE TABLE MedicalJobSeekerExtendedInfo (
	MedicalJobSeekerExtendedInfoId		INT				AUTO_INCREMENT,
	MedicalJobSeekerUserId				INT				NOT NULL,
    Address1							VARCHAR(512)	NOT NULL,
    Address2							VARCHAR(512)	NULL,
    City								VARCHAR(128)	NOT NULL,
    State								CHAR(30)		NOT NULL,
    Zip									CHAR(10)			NOT NULL,
    Title								CHAR(7)			NOT NULL,
	SpecialityTypeId					INT				NOT NULL,
	Malpractice							BIT				NULL,
	BoardActions						BIT				NULL,
	DisciplinaryActions					BIT				NULL,
	LossOfPrivileges					BIT				NULL,
	NPDB								BIT				NULL,
	EpicExperience						BIT				NULL,
    MalpracticeInfo						VARCHAR(1024)	NULL,
	BoardActionsInfo					VARCHAR(1024)	NULL,
	DisciplinaryActionsInfo				VARCHAR(1024)	NULL,
	LossOfPrivilegesInfo				VARCHAR(1024)	NULL,
	NPDBInfo							VARCHAR(1024)	NULL,
	EpicExperienceYears					INT				NULL,
	JobPreferenceTypeId					INT				NOT NULL,
	Travel								BIT				NULL		DEFAULT 0,
	TravelStatePreferenceId				INT				NULL,
	ShiftPreferenceTypeId				INT				NOT NULL,
	CallPreference						BIT				NULL		DEFAULT 0,
	GovernmentAssignment				BIT				NULL		DEFAULT 0,
	Compensation						INT				NULL,
	CompensationTypeId					INT				NULL,
	YearsExperience						INT				NULL,
	AdditionalInformation1				VARCHAR(1024)	NULL,
	AdditionalInformation2				VARCHAR(1024)	NULL,
	AdditionalInformation3				VARCHAR(1024)	NULL,
    Lud              					DATETIME        NULL,
    Lub              					INT             NULL,
	CONSTRAINT pkMedicalJobSeekerExtendedInfo PRIMARY KEY CLUSTERED (MedicalJobSeekerExtendedInfoId),
    CONSTRAINT ukMedicalJobSeekerExtendedInfo UNIQUE (MedicalJobSeekerUserId),
    CONSTRAINT fkMedicalJobSeekerExtendedInfoMedicalJobSeekerUserId FOREIGN KEY (MedicalJobSeekerUserId) REFERENCES Users (UserId) ON UPDATE NO ACTION ON DELETE NO ACTION,
    CONSTRAINT fkMedicalJobSeekerExtendedInfoSpecialityTypeId FOREIGN KEY (SpecialityTypeId) REFERENCES EnumSpecialityType (SpecialityTypeId) ON UPDATE NO ACTION ON DELETE NO ACTION,
    CONSTRAINT fkMedicalJobSeekerExtendedInfoJobPreferenceTypeId FOREIGN KEY (JobPreferenceTypeId) REFERENCES EnumJobType (JobTypeId) ON UPDATE NO ACTION ON DELETE NO ACTION,
    CONSTRAINT fkMedicalJobSeekerExtendedInfoTravelStatePreferenceId FOREIGN KEY (TravelStatePreferenceId) REFERENCES EnumUSStatesType (USStatesTypeId) ON UPDATE NO ACTION ON DELETE NO ACTION,
    CONSTRAINT fkMedicalJobSeekerExtendedInfoShiftPreferenceTypeId FOREIGN KEY (ShiftPreferenceTypeId) REFERENCES EnumShiftType (ShiftTypeId) ON UPDATE NO ACTION ON DELETE NO ACTION, 
    CONSTRAINT fkMedicalJobSeekerExtendedInfoCompensationTypeId FOREIGN KEY (CompensationTypeId) REFERENCES EnumCompensationType (CompensationTypeId) ON UPDATE NO ACTION ON DELETE NO ACTION
);
--rollback DROP TABLE MedicalJobSeekerExtendedInfo;