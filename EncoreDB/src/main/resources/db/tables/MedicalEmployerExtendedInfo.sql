--liquibase formatted sql

--changeset CreateTable_MedicalEmployerExtendedInfo
CREATE TABLE MedicalEmployerExtendedInfo (
	MedicalEmployerExtendedInfoId			INT				AUTO_INCREMENT,
	MedicalEmployerUserId					INT				NOT NULL,
	OrganizationRole						VARCHAR(512)	NULL,
    Address1								VARCHAR(512)	NULL,
    Address2								VARCHAR(512)	NULL,
    City									VARCHAR(128)	NOT NULL,
    State									VARCHAR(128)	NOT NULL,
    Zip										CHAR(10)			NULL,
	Phone									CHAR(10)		NULL,
	MalpracticeCandidateAcceptable			BIT				NULL		DEFAULT 0,
	BoardActionsCandidateAcceptable			BIT				NULL		DEFAULT 0,
	DisciplinaryActionCandidateAcceptable	BIT				NULL		DEFAULT 0,
	JobPreferenceTypeId						INT				NULL,
	GovernmentAssignment					BIT				NULL		DEFAULT 0,
	Beds									INT				NULL,
	AvgPatientsInMonth						INT				NULL,
	Peers									INT				NULL,
	Nurses									INT				NULL,
	ORs										INT				NULL,
	MalpracticeCoverage						BIT				NULL		DEFAULT 0,
	CredentialingCoverage					BIT				NULL		DEFAULT 0,
	LicenseCoverage							BIT				NULL		DEFAULT 0,
	TravelHousingCoverage					BIT				NULL		DEFAULT 0,
    Lud										DATETIME		NULL,
    Lub										INT				NULL,
	CONSTRAINT pkMedicalEmployerExtendedInfo PRIMARY KEY CLUSTERED (MedicalEmployerExtendedInfoId),
    CONSTRAINT ukJobSeekerExtendedInformation UNIQUE (MedicalEmployerUserId),
    CONSTRAINT fkMedicalEmployerExtendedInfoMedicalEmployerUserId FOREIGN KEY (MedicalEmployerUserId) REFERENCES Users (UserId) ON UPDATE NO ACTION ON DELETE NO ACTION,
    CONSTRAINT fkMedicalEmployerExtendedInfoJobPreferenceTypeId FOREIGN KEY (JobPreferenceTypeId) REFERENCES EnumJobType (JobTypeId) ON UPDATE NO ACTION ON DELETE NO ACTION
);
--rollback DROP TABLE MedicalEmployerExtendedInfo;