--liquibase formatted sql

--changeset CreateTable_MedicalJobSeekerStateLevelInfo
CREATE TABLE MedicalJobSeekerStateLevelInfo (
	MedicalJobSeekerStateLevelInfoId	INT			AUTO_INCREMENT,
	MedicalJobSeekerExtendedInfoId		INT			NOT NULL,
	StateId								INT			NOT NULL,
    LicenseExpirationDate              	DATETIME    NULL,
    PrescriptionAuthority              	INT         NULL,
	CONSTRAINT pkMedicalJobSeekerStateLevelInfo PRIMARY KEY CLUSTERED (MedicalJobSeekerStateLevelInfoId),
    CONSTRAINT ukMedicalJobSeekerStateLevelInfo UNIQUE (MedicalJobSeekerExtendedInfoId, StateId),
    CONSTRAINT fkMedicalJobSeekerStateLevelInfoMedicalJobSeekerExtendedInfoId FOREIGN KEY (MedicalJobSeekerExtendedInfoId) REFERENCES MedicalJobSeekerExtendedInfo (MedicalJobSeekerExtendedInfoId) ON UPDATE NO ACTION ON DELETE NO ACTION,
    CONSTRAINT fkMedicalJobSeekerStateLevelInfoStateId FOREIGN KEY (StateId) REFERENCES EnumUSStatesType (USStatesTypeId) ON UPDATE NO ACTION ON DELETE NO ACTION
);
--rollback DROP TABLE MedicalJobSeekerStateLevelInfo;