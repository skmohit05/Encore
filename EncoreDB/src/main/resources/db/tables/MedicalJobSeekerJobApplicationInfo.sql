--liquibase formatted sql

--changeset CreateTable_MedicalJobSeekerJobApplicationInfo
CREATE TABLE MedicalJobSeekerJobApplicationInfo (
	MedicalJobSeekerJobApplicationInfoId		INT		AUTO_INCREMENT,
	MedicalJobSeekerUserId						INT		NOT NULL,
	MedicalEmployerJobPostingId					INT		NOT NULL,
	AppliedDate									DATE	NOT NULL,
	Accepted									BIT		NOT NULL	DEFAULT 0,
	StartDate									DATE	NULL,
	EndDate										DATE	NULL,
	Compensation								INT		NULL,
	CompensationTypeId							INT		NULL,
	JobCompletedAsPerAgreement					BIT		NULL	DEFAULT 0,
	EmployerJobAgreementSignedUserId			INT		NULL,
    Lud              							DATETIME       NULL,
    Lub              							INT             NULL,
	CONSTRAINT pkMedicalJobSeekerJobApplicationInfo PRIMARY KEY CLUSTERED (MedicalJobSeekerJobApplicationInfoId),
    CONSTRAINT ukMedicalJobSeekerJobApplicationInfo UNIQUE (MedicalJobSeekerUserId, MedicalEmployerJobPostingId),
    CONSTRAINT fkMedicalJobSeekerJobApplicationInfoMedicalJobSeekerUserId FOREIGN KEY (MedicalJobSeekerUserId) REFERENCES Users (UserId) ON UPDATE NO ACTION ON DELETE NO ACTION,
    CONSTRAINT fkMedicalJobSeekerJobApplicationInfoMedicalEmployerJobPostingId FOREIGN KEY (MedicalEmployerJobPostingId) REFERENCES MedicalEmployerJobPosting (MedicalEmployerJobPostingId) ON UPDATE NO ACTION ON DELETE NO ACTION,
    CONSTRAINT fkMedicalJobSeekerJobApplicationInfoCompensationTypeId FOREIGN KEY (CompensationTypeId) REFERENCES EnumCompensationType (CompensationTypeId) ON UPDATE NO ACTION ON DELETE NO ACTION,
    CONSTRAINT fkMedicalJobSeekerJobAppInfoEmployerJobAgreementSignedUserId FOREIGN KEY (EmployerJobAgreementSignedUserId) REFERENCES Users (UserId) ON UPDATE NO ACTION ON DELETE NO ACTION
);
--rollback DROP TABLE MedicalJobSeekerJobApplicationInfo;