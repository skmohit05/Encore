--liquibase formatted sql

--changeset CreateTable_MedicalEmployerSurvey
CREATE TABLE MedicalEmployerSurvey (
	MedicalEmployerSurveyId			INT			AUTO_INCREMENT,
	MedicalEmployerUserId			INT			NOT NULL,
	MedicalEmployerJobPostingId		INT			NOT NULL,
	SatisfactionScore				INT			NOT NULL,
    Lud              				DATETIME    NULL,
    Lub              				INT         NULL,
	CONSTRAINT pkMedicalEmployerSurvey PRIMARY KEY CLUSTERED (MedicalEmployerSurveyId),
    CONSTRAINT ukMedicalEmployerSurvey UNIQUE (MedicalEmployerUserId, MedicalEmployerJobPostingId),
    CONSTRAINT fkMedicalEmployerSurveyMedicalEmployerUserId FOREIGN KEY (MedicalEmployerUserId) REFERENCES Users (UserId) ON UPDATE NO ACTION ON DELETE NO ACTION,
    CONSTRAINT fkMedicalEmployerSurveyMedicalEmployerJobPostingId FOREIGN KEY (MedicalEmployerJobPostingId) REFERENCES MedicalEmployerJobPosting (MedicalEmployerJobPostingId) ON UPDATE NO ACTION ON DELETE NO ACTION
);
--rollback DROP TABLE MedicalEmployerSurvey;