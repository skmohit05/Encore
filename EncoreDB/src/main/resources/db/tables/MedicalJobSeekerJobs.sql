--liquibase formatted sql

--changeset CreateTable_MedicalJobSeekerJobs
CREATE TABLE MedicalJobSeekerJobs (
	MedicalJobSeekerJobId		INT		AUTO_INCREMENT,
	MedicalJobSeekerUserId		INT		NOT NULL,
	MedicalJobSeekerJobInfoId	INT		NOT NULL,
    Lud              			DATETIME       NULL,
    Lub              			INT             NULL,
	CONSTRAINT pkMedicalJobSeekerJobs PRIMARY KEY CLUSTERED (MedicalJobSeekerJobId),
    CONSTRAINT ukMedicalJobSeekerJobs UNIQUE (MedicalJobSeekerUserId, MedicalJobSeekerJobInfoId),
    CONSTRAINT fkMedicalJobSeekerJobsMedicalJobSeekerUserId FOREIGN KEY (MedicalJobSeekerUserId) REFERENCES Users (UserId) ON UPDATE NO ACTION ON DELETE NO ACTION,
    CONSTRAINT fkMedicalJobSeekerJobsMedicalJobSeekerJobInfoId FOREIGN KEY (MedicalJobSeekerJobInfoId) REFERENCES MedicalJobSeekerJobInfo (MedicalJobSeekerJobInfoId) ON UPDATE NO ACTION ON DELETE NO ACTION
);
--rollback DROP TABLE MedicalJobSeekerJobs;