--liquibase formatted sql

--changeset CreateTable_MedicalJobSeekerSurvey
CREATE TABLE MedicalJobSeekerSurvey (
	MedicalJobSeekerSurveyId		INT		AUTO_INCREMENT,
	MedicalJobSeekerUserId			INT		NOT NULL,
	MedicalEmployerJobPostingId		INT		NOT NULL,
	SatisfactionScore				INT		NOT NULL,
    Lud              				DATETIME       NULL,
    Lub              				INT             NULL,
	CONSTRAINT pkMedicalJobSeekerSurvey PRIMARY KEY CLUSTERED (MedicalJobSeekerSurveyId),
    CONSTRAINT ukMedicalJobSeekerSurvey UNIQUE (MedicalJobSeekerUserId, MedicalEmployerJobPostingId),
    CONSTRAINT fkMedicalJobSeekerSurveyMedicalJobSeekerUserId FOREIGN KEY (MedicalJobSeekerUserId) REFERENCES Users (UserId) ON UPDATE NO ACTION ON DELETE NO ACTION,
    CONSTRAINT fkMedicalJobSeekerSurveyMedicalEmployerJobPostingId FOREIGN KEY (MedicalEmployerJobPostingId) REFERENCES MedicalEmployerJobPosting (MedicalEmployerJobPostingId) ON UPDATE NO ACTION ON DELETE NO ACTION
);
--rollback DROP TABLE MedicalJobSeekerSurvey;