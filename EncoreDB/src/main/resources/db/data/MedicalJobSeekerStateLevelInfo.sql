--liquibase formatted sql

--changeset InsertData_MedicalJobSeekerStateLevelInfo

INSERT INTO MedicalJobSeekerStateLevelInfo (MedicalJobSeekerExtendedInfoId, StateId, PrescriptionAuthority) VALUES (1, 35, 1);
INSERT INTO MedicalJobSeekerStateLevelInfo (MedicalJobSeekerExtendedInfoId, StateId, PrescriptionAuthority) VALUES (2, 1, 1);

--rollback DELETE FROM MedicalJobSeekerStateLevelInfo;