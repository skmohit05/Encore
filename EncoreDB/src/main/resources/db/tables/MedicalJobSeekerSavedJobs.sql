--liquibase formatted sql

--changeset CreateTable_MedicalJobSeekerSavedJobs
CREATE TABLE MedicalJobSeekerSavedJobs (
	MedicalJobSeekerSavedJobId		INT		AUTO_INCREMENT,
	MedicalJobSeekerUserId			INT		NOT NULL,
	MedicalEmployerJobPostingId		INT		NOT NULL,
	SavedDate						DATE	NOT NULL,
    Lud              				DATETIME       NULL,
    Lub              				INT             NULL,
	CONSTRAINT pkMedicalJobSeekerSavedJobs PRIMARY KEY CLUSTERED (MedicalJobSeekerSavedJobId),
    CONSTRAINT ukMedicalJobSeekerSavedJobs UNIQUE (MedicalJobSeekerUserId, MedicalEmployerJobPostingId),
    CONSTRAINT fkMedicalJobSeekerSavedJobsMedicalJobSeekerUserId FOREIGN KEY (MedicalJobSeekerUserId) REFERENCES Users (UserId) ON UPDATE NO ACTION ON DELETE NO ACTION,
    CONSTRAINT fkMedicalJobSeekerSavedJobsMedicalEmployerJobPostingId FOREIGN KEY (MedicalEmployerJobPostingId) REFERENCES MedicalEmployerJobPosting (MedicalEmployerJobPostingId) ON UPDATE NO ACTION ON DELETE NO ACTION
);
--rollback DROP TABLE MedicalJobSeekerSavedJobs;