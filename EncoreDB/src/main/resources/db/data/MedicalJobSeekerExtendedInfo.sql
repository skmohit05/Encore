--liquibase formatted sql

--changeset InsertData_MedicalJobSeekerExtendedInfo

INSERT INTO MedicalJobSeekerExtendedInfo (MedicalJobSeekerUserId, Address1, City, State, Zip, Title, SpecialityTypeId, 
	JobPreferenceTypeId, ShiftPreferenceTypeId, Compensation, CompensationTypeId, YearsExperience, Malpractice) 
	VALUES (4, 'Addr', 'Columbus', 'Ohio', '123456', 'ABC', 1, 1, 1, 100, 1, 2, 1);
INSERT INTO MedicalJobSeekerExtendedInfo (MedicalJobSeekerUserId, Address1, City, State, Zip, Title, SpecialityTypeId, 
	JobPreferenceTypeId, ShiftPreferenceTypeId, Compensation, CompensationTypeId, YearsExperience, Malpractice) 
	VALUES (5, 'Addr', 'Columbus', 'Ohio', '123456', 'ABC', 1, 1, 1, 100, 1, 2, 1);
INSERT INTO MedicalJobSeekerExtendedInfo (MedicalJobSeekerUserId, Address1, City, State, Zip, Title, SpecialityTypeId, 
	JobPreferenceTypeId, ShiftPreferenceTypeId, Compensation, CompensationTypeId, YearsExperience) 
	VALUES (6, 'Addr', 'Columbus', 'Ohio', '123456', 'ABC', 1, 1, 1, 100, 1, 2);
INSERT INTO MedicalJobSeekerExtendedInfo (MedicalJobSeekerUserId, Address1, City, State, Zip, Title, SpecialityTypeId, 
	JobPreferenceTypeId, ShiftPreferenceTypeId, Compensation, CompensationTypeId, YearsExperience, Malpractice) 
	VALUES (7, 'Addr', 'Columbus', 'Ohio', '123456', 'ABC', 1, 1, 1, 100, 1, 2, 1);
INSERT INTO MedicalJobSeekerExtendedInfo (MedicalJobSeekerUserId, Address1, City, State, Zip, Title, SpecialityTypeId, 
	JobPreferenceTypeId, ShiftPreferenceTypeId, Compensation, CompensationTypeId, YearsExperience, Malpractice) 
	VALUES (8, 'Addr', 'Columbus', 'Ohio', '123456', 'ABC', 1, 1, 1, 100, 1, 2, 1);
INSERT INTO MedicalJobSeekerExtendedInfo (MedicalJobSeekerUserId, Address1, City, State, Zip, Title, SpecialityTypeId, 
	JobPreferenceTypeId, ShiftPreferenceTypeId, Malpractice) 
	VALUES (9, 'Addr', 'Columbus', 'Ohio', '123456', 'ABC', 1, 1, 1, 1);
--rollback DELETE FROM MedicalJobSeekerExtendedInfo;