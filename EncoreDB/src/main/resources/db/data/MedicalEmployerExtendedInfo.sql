--liquibase formatted sql

--changeset InsertData_MedicalEmployerExtendedInfo

INSERT INTO MedicalEmployerExtendedInfo (MedicalEmployerUserId, City, State) VALUES (2, 'Columbus', 'Ohio');
INSERT INTO MedicalEmployerExtendedInfo (MedicalEmployerUserId, City, State) VALUES (3, 'Alabama', 'Foley');
--rollback DELETE FROM MedicalEmployerExtendedInfo;
