--liquibase formatted sql

--changeset InsertData_MedicalJobSeekerJobs

INSERT INTO MedicalJobSeekerJobs (MedicalJobSeekerUserId, MedicalJobSeekerJobInfoId) VALUES (4, 1);
INSERT INTO MedicalJobSeekerJobs (MedicalJobSeekerUserId, MedicalJobSeekerJobInfoId) VALUES (4, 2);
INSERT INTO MedicalJobSeekerJobs (MedicalJobSeekerUserId, MedicalJobSeekerJobInfoId) VALUES (5, 3);
INSERT INTO MedicalJobSeekerJobs (MedicalJobSeekerUserId, MedicalJobSeekerJobInfoId) VALUES (5, 4);
INSERT INTO MedicalJobSeekerJobs (MedicalJobSeekerUserId, MedicalJobSeekerJobInfoId) VALUES (8, 5);

--rollback DELETE FROM MedicalJobSeekerJobs;