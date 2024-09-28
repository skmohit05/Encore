--liquibase formatted sql

--changeset InsertData_MedicalJobSeekerJobInfo

INSERT INTO MedicalJobSeekerJobInfo (Title, Speciality, Place, FacilityName, FacilityTypeId, AssignmentTypeId, 
	AssignmentShiftTypeId, City, State, AssignmentFromDate, Supervised) 
	VALUES ('Test Title 1', 'Test Speciality 1', 'Ohio', 'Test Facility 1', 1, 1, 1, 'Columbus', 'Ohio', '2020-05-01', 0);
INSERT INTO MedicalJobSeekerJobInfo (Title, Speciality, Place, FacilityName, FacilityTypeId, AssignmentTypeId, 
	AssignmentShiftTypeId, City, State, AssignmentFromDate, Supervised) 
	VALUES ('Test Title 2', 'Test Speciality 2', 'Ohio', 'Test Facility 1', 1, 1, 1, 'Columbus', 'Ohio', '2020-08-01', 1);
INSERT INTO MedicalJobSeekerJobInfo (Title, Speciality, Place, FacilityName, FacilityTypeId, AssignmentTypeId, 
	AssignmentShiftTypeId, City, State, AssignmentFromDate, Supervised) 
	VALUES ('Test Title 3', 'Test Speciality 3', 'Ohio', 'Test Facility 1', 1, 1, 1, 'Columbus', 'Ohio', '2020-05-01', 1);
INSERT INTO MedicalJobSeekerJobInfo (Title, Speciality, Place, FacilityName, FacilityTypeId, AssignmentTypeId, 
	AssignmentShiftTypeId, City, State, AssignmentFromDate, Supervised) 
	VALUES ('Test Title 4', 'Test Speciality 4', 'Ohio', 'Test Facility 1', 1, 1, 1, 'Columbus', 'Ohio', '2020-08-01', 1);
INSERT INTO MedicalJobSeekerJobInfo (Title, Speciality, Place, FacilityName, FacilityTypeId, AssignmentTypeId, 
	AssignmentShiftTypeId, City, State, AssignmentFromDate, Supervised) 
	VALUES ('Test Title 5', 'Test Speciality 5', 'Ohio', 'Test Facility 1', 1, 1, 1, 'Columbus', 'Ohio', '2020-05-01', 1);

--rollback DELETE FROM MedicalJobSeekerJobInfo;