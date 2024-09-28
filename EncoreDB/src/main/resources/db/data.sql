use encore;

-- Start of EnumCommunicationChannelType.sql


INSERT INTO EnumCommunicationChannelType (CommunicationChannelTypeName, CommunicationChannelTypeDesc, IsActive) 
	VALUES ('Email', 'Email', 1);
INSERT INTO EnumCommunicationChannelType (CommunicationChannelTypeName, CommunicationChannelTypeDesc, IsActive) 
	VALUES ('SMS', 'SMS', 1);
	
-- End of EnumCommunicationChannelType.sql

-- Start of EnumSpecialityType.sql


INSERT INTO EnumSpecialityType (SpecialityTypeName, SpecialityTypeDesc, IsActive) 
	VALUES ('Cardiology', 'Cardiology', 1);
INSERT INTO EnumSpecialityType (SpecialityTypeName, SpecialityTypeDesc, IsActive) 
	VALUES ('Dermatology', 'Dermatology', 1);
INSERT INTO EnumSpecialityType (SpecialityTypeName, SpecialityTypeDesc, IsActive) 
	VALUES ('Nephrology', 'Nephrology', 1);
INSERT INTO EnumSpecialityType (SpecialityTypeName, SpecialityTypeDesc, IsActive) 
	VALUES ('Neurology', 'Neurology', 1);
INSERT INTO EnumSpecialityType (SpecialityTypeName, SpecialityTypeDesc, IsActive) 
	VALUES ('Pediatrics', 'Pediatrics', 1);
INSERT INTO EnumSpecialityType (SpecialityTypeName, SpecialityTypeDesc, IsActive) 
	VALUES ('Psychiatry', 'Psychiatry', 1);
INSERT INTO EnumSpecialityType (SpecialityTypeName, SpecialityTypeDesc, IsActive) 
	VALUES ('Pulmonology', 'Pulmonology', 1);
INSERT INTO EnumSpecialityType (SpecialityTypeName, SpecialityTypeDesc, IsActive) 
	VALUES ('Anesthesiology', 'Anesthesiology', 1);
INSERT INTO EnumSpecialityType (SpecialityTypeName, SpecialityTypeDesc, IsActive) 
	VALUES ('EmergencyMedicine', 'Emergency Medicine', 1);
INSERT INTO EnumSpecialityType (SpecialityTypeName, SpecialityTypeDesc, IsActive) 
	VALUES ('FamilyPractice', 'Family Practice', 1);
INSERT INTO EnumSpecialityType (SpecialityTypeName, SpecialityTypeDesc, IsActive) 
	VALUES ('GeneralPractice', 'General Practice', 1);
INSERT INTO EnumSpecialityType (SpecialityTypeName, SpecialityTypeDesc, IsActive) 
	VALUES ('Endocrinology', 'Endocrinology', 1);
INSERT INTO EnumSpecialityType (SpecialityTypeName, SpecialityTypeDesc, IsActive) 
	VALUES ('Gastroenterology', 'Gastroenterology', 1);
INSERT INTO EnumSpecialityType (SpecialityTypeName, SpecialityTypeDesc, IsActive) 
	VALUES ('Gynecology', 'Gynecology', 1);
INSERT INTO EnumSpecialityType (SpecialityTypeName, SpecialityTypeDesc, IsActive) 
	VALUES ('InternalMedicine', 'Internal Medicine', 1);
	
-- End of EnumSpecialityType.sql

-- Start of EnumJobType.sql


INSERT INTO EnumJobType (JobTypeName, JobTypeDesc, IsActive) 
	VALUES ('LocumTenens', 'Locum Tenens', 1);
INSERT INTO EnumJobType (JobTypeName, JobTypeDesc, IsActive) 
	VALUES ('Permanent', 'Permanent', 1);
INSERT INTO EnumJobType (JobTypeName, JobTypeDesc, IsActive) 
	VALUES ('Temporary', 'Temporary', 1);
	
-- End of EnumJobType.sql

-- Start of EnumShiftType.sql


INSERT INTO EnumShiftType (ShiftTypeName, ShiftTypeDesc, IsActive) VALUES ('Day', 'Day', 1);
INSERT INTO EnumShiftType (ShiftTypeName, ShiftTypeDesc, IsActive) VALUES ('Night', 'Night', 1);
INSERT INTO EnumShiftType (ShiftTypeName, ShiftTypeDesc, IsActive) VALUES ('Weekend', 'Weekend', 1);
INSERT INTO EnumShiftType (ShiftTypeName, ShiftTypeDesc, IsActive) VALUES ('AllDay', 'All Day', 1);
INSERT INTO EnumShiftType (ShiftTypeName, ShiftTypeDesc, IsActive) VALUES ('NoPreference', 'No Preference', 1);
INSERT INTO EnumShiftType (ShiftTypeName, ShiftTypeDesc, IsActive) VALUES ('All', 'All', 1);
INSERT INTO EnumShiftType (ShiftTypeName, ShiftTypeDesc, IsActive) VALUES ('Variable', 'Variable', 1);
	
-- End of EnumShiftType.sql

-- Start of EnumFacilityType.sql


INSERT INTO EnumFacilityType (FacilityTypeName, FacilityTypeDesc, IsActive) VALUES ('ER', 'ER', 1);
INSERT INTO EnumFacilityType (FacilityTypeName, FacilityTypeDesc, IsActive) VALUES ('OP', 'OP', 1);
INSERT INTO EnumFacilityType (FacilityTypeName, FacilityTypeDesc, IsActive) VALUES ('Hospital', 'Hospital', 1);
INSERT INTO EnumFacilityType (FacilityTypeName, FacilityTypeDesc, IsActive) VALUES ('ImagingCenter', 'Imaging Center', 1);
	
-- End of EnumFacilityType.sql

-- Start of EnumFacilitySubType.sql


INSERT INTO EnumFacilitySubType (FacilitySubTypeName, FacilitySubTypeDesc, IsActive) VALUES ('PrimacyCareCenter', 'Primacy Care Center', 1);
INSERT INTO EnumFacilitySubType (FacilitySubTypeName, FacilitySubTypeDesc, IsActive) VALUES ('TertiaryCareCenter', 'Tertiary Care Center', 1);
INSERT INTO EnumFacilitySubType (FacilitySubTypeName, FacilitySubTypeDesc, IsActive) VALUES ('TraumaCenter1', 'Trauma Center 1', 1);
INSERT INTO EnumFacilitySubType (FacilitySubTypeName, FacilitySubTypeDesc, IsActive) VALUES ('TraumaCenter2', 'Trauma Center 2', 1);
INSERT INTO EnumFacilitySubType (FacilitySubTypeName, FacilitySubTypeDesc, IsActive) VALUES ('TraumaCenter3', 'Trauma Center 3', 1);
INSERT INTO EnumFacilitySubType (FacilitySubTypeName, FacilitySubTypeDesc, IsActive) VALUES ('UniversityCenter', 'University Center', 1);
INSERT INTO EnumFacilitySubType (FacilitySubTypeName, FacilitySubTypeDesc, IsActive) VALUES ('CriticalAccessHospital', 'Critical Access Hospital', 1);
INSERT INTO EnumFacilitySubType (FacilitySubTypeName, FacilitySubTypeDesc, IsActive) VALUES ('CommunityHospital', 'Community Hospital', 1);
	
-- End of EnumFacilitySubType.sql

-- Start of EnumAssignmentType.sql


INSERT INTO EnumAssignmentType (AssignmentTypeName, AssignmentTypeDesc, IsActive) 
	VALUES ('OR', 'OR', 1);
INSERT INTO EnumAssignmentType (AssignmentTypeName, AssignmentTypeDesc, IsActive) 
	VALUES ('Outpatient', 'Outpatient', 1);
INSERT INTO EnumAssignmentType (AssignmentTypeName, AssignmentTypeDesc, IsActive) 
	VALUES ('ER', 'ER', 1);
	
-- End of EnumAssignmentType.sql

-- Start of EnumFieldType.sql


INSERT INTO EnumFieldType (FieldTypeName, FieldTypeDesc, IsActive) VALUES ('Medical', 'Medical', 1);
INSERT INTO EnumFieldType (FieldTypeName, FieldTypeDesc, IsActive) VALUES ('IT', 'IT', 1);
	
-- End of EnumFieldType.sql

-- Start of EnumUserStatusType.sql


INSERT INTO EnumUserStatusType (UserStatusTypeName, UserStatusTypeDesc, IsActive) VALUES ('Active', 'USER is active', 1);
INSERT INTO EnumUserStatusType (UserStatusTypeName, UserStatusTypeDesc, IsActive) VALUES ('Inactive', 'User is inactive', 1);
INSERT INTO EnumUserStatusType (UserStatusTypeName, UserStatusTypeDesc, IsActive) VALUES ('Verified', 'User is verified', 1);
INSERT INTO EnumUserStatusType (UserStatusTypeName, UserStatusTypeDesc, IsActive) VALUES ('Pending', 'User is pending', 1);
INSERT INTO EnumUserStatusType (UserStatusTypeName, UserStatusTypeDesc, IsActive) VALUES ('Rejected', 'User is rejected', 1);
	
-- End of EnumUserStatusType.sql

-- Start of EnumJobPostingStatusType.sql


INSERT INTO EnumJobPostingStatusType (JobPostingStatusTypeName, JobPostingStatusTypeDesc, IsActive) VALUES ('Active', 'Job Posting is active', 1);
INSERT INTO EnumJobPostingStatusType (JobPostingStatusTypeName, JobPostingStatusTypeDesc, IsActive) VALUES ('Inactive', 'Job Posting is inactive', 1);
INSERT INTO EnumJobPostingStatusType (JobPostingStatusTypeName, JobPostingStatusTypeDesc, IsActive) VALUES ('Verified', 'Job Posting is verified', 1);
INSERT INTO EnumJobPostingStatusType (JobPostingStatusTypeName, JobPostingStatusTypeDesc, IsActive) VALUES ('Pending', 'Job Posting is pending', 1);
INSERT INTO EnumJobPostingStatusType (JobPostingStatusTypeName, JobPostingStatusTypeDesc, IsActive) VALUES ('Rejected', 'Job Posting is rejected', 1);
	
-- End of EnumJobPostingStatusType.sql

-- Start of EnumUserType.sql


INSERT INTO EnumUserType (UserTypeName, UserTypeDesc, UserRole, IsActive) VALUES ('Admin', 'Admin', 'ROLE_ADMIN', 1);
INSERT INTO EnumUserType (UserTypeName, UserTypeDesc, UserRole, IsActive) VALUES ('Employer', 'Employer', 'ROLE_EMPLOYER', 1);
INSERT INTO EnumUserType (UserTypeName, UserTypeDesc, UserRole, IsActive) VALUES ('JobSeeker', 'JobSeeker', 'ROLE_JOBSEEKER', 1);
	
-- End of EnumUserType.sql

-- Start of EnumOrganizationType.sql


INSERT INTO EnumOrganizationType (OrganizationTypeName, OrganizationTypeDesc, IsActive) VALUES ('EmployeeBasedPractice', 'Employee Based Practice', 1);
INSERT INTO EnumOrganizationType (OrganizationTypeName, OrganizationTypeDesc, IsActive) VALUES ('PrivatePractice', 'Private Practice', 1);
INSERT INTO EnumOrganizationType (OrganizationTypeName, OrganizationTypeDesc, IsActive) VALUES ('Corporate', 'Corporate', 1);
	
-- End of EnumOrganizationType.sql

-- Start of EnumMFAType.sql


INSERT INTO EnumMFAType (MFATypeName, MFATypeDesc, IsActive) VALUES ('Email', 'Email', 1);
INSERT INTO EnumMFAType (MFATypeName, MFATypeDesc, IsActive) VALUES ('SMS', 'SMS', 1);
INSERT INTO EnumMFAType (MFATypeName, MFATypeDesc, IsActive) VALUES ('Biometric', 'Biometric', 1);
	
-- End of EnumMFAType.sql

-- Start of EnumPriorityFeatureType.sql


INSERT INTO EnumPriorityFeatureType (PriorityFeatureTypeName, PriorityFeatureTypeDesc, IsActive) VALUES ('Supervision', 'Supervision Required', 1);
INSERT INTO EnumPriorityFeatureType (PriorityFeatureTypeName, PriorityFeatureTypeDesc, IsActive) VALUES ('PrescriptionAuthority', 'Prescription Authority Required', 1);
INSERT INTO EnumPriorityFeatureType (PriorityFeatureTypeName, PriorityFeatureTypeDesc, IsActive) VALUES ('Compensation', 'Salary', 1);
INSERT INTO EnumPriorityFeatureType (PriorityFeatureTypeName, PriorityFeatureTypeDesc, IsActive) VALUES ('NumberOfYears', 'Years of Experience', 1);
INSERT INTO EnumPriorityFeatureType (PriorityFeatureTypeName, PriorityFeatureTypeDesc, IsActive) VALUES ('AssignmentShift', 'Shift', 1);
INSERT INTO EnumPriorityFeatureType (PriorityFeatureTypeName, PriorityFeatureTypeDesc, IsActive) VALUES ('MalpracticeCandidate', 'Malpractice Candidate Accepted', 1);
INSERT INTO EnumPriorityFeatureType (PriorityFeatureTypeName, PriorityFeatureTypeDesc, IsActive) VALUES ('FacilityType', 'Facility Type', 1);
	
-- End of EnumPriorityFeatureType.sql

-- Start of EnumCompensationType.sql


INSERT INTO EnumCompensationType (CompensationTypeName, CompensationTypeDesc, IsActive) 
	VALUES ('Hourly', 'Hourly', 1);
INSERT INTO EnumCompensationType (CompensationTypeName, CompensationTypeDesc, IsActive) 
	VALUES ('Lumpsum', 'Lumpsum', 1);
INSERT INTO EnumCompensationType (CompensationTypeName, CompensationTypeDesc, IsActive) 
	VALUES ('Yearly', 'Yearly', 1);
	
-- End of EnumCompensationType.sql

-- Start of EnumUSStatesType.sql


INSERT INTO EnumUSStatesType (USStatesTypeName, USStatesTypeDesc, IsActive) VALUES ('Alabama', 'Alabama', 1);
INSERT INTO EnumUSStatesType (USStatesTypeName, USStatesTypeDesc, IsActive) VALUES ('Alaska', 'Alaska', 1);
INSERT INTO EnumUSStatesType (USStatesTypeName, USStatesTypeDesc, IsActive) VALUES ('Arizona', 'Arizona', 1);
INSERT INTO EnumUSStatesType (USStatesTypeName, USStatesTypeDesc, IsActive) VALUES ('Arkansas', 'Arkansas',1);
INSERT INTO EnumUSStatesType (USStatesTypeName, USStatesTypeDesc, IsActive) VALUE  ('California','California',1);
INSERT INTO EnumUSStatesType (USStatesTypeName, USStatesTypeDesc, IsActive) VALUES ('Colorado', 'Colorado', 1);
INSERT INTO EnumUSStatesType (USStatesTypeName, USStatesTypeDesc, IsActive) VALUES ('Connecticut', 'Connecticut', 1);
INSERT INTO EnumUSStatesType (USStatesTypeName, USStatesTypeDesc, IsActive) VALUES ('Delaware', 'Delaware', 1);
INSERT INTO EnumUSStatesType (USStatesTypeName, USStatesTypeDesc, IsActive) VALUES ('Florida', 'Florida', 1);
INSERT INTO EnumUSStatesType (USStatesTypeName, USStatesTypeDesc, IsActive) VALUES ('Georgia', 'Georgia', 1);
INSERT INTO EnumUSStatesType (USStatesTypeName, USStatesTypeDesc, IsActive) VALUES ('Hawaii', 'Hawaii', 1);
INSERT INTO EnumUSStatesType (USStatesTypeName, USStatesTypeDesc, IsActive) VALUES ('Idaho', 'Idaho', 1);
INSERT INTO EnumUSStatesType (USStatesTypeName, USStatesTypeDesc, IsActive) VALUES ('Illinois', 'Illinois', 1);
INSERT INTO EnumUSStatesType (USStatesTypeName, USStatesTypeDesc, IsActive) VALUES ('Indiana', 'Indiana', 1);
INSERT INTO EnumUSStatesType (USStatesTypeName, USStatesTypeDesc, IsActive) VALUES ('Iowa', 'Iowa', 1);
INSERT INTO EnumUSStatesType (USStatesTypeName, USStatesTypeDesc, IsActive) VALUES ('Kansas', 'Kansas', 1);
INSERT INTO EnumUSStatesType (USStatesTypeName, USStatesTypeDesc, IsActive) VALUES ('Kentucky', 'Kentucky', 1);
INSERT INTO EnumUSStatesType (USStatesTypeName, USStatesTypeDesc, IsActive) VALUES ('Louisiana', 'Louisiana', 1);
INSERT INTO EnumUSStatesType (USStatesTypeName, USStatesTypeDesc, IsActive) VALUES ('Maine', 'Maine', 1);
INSERT INTO EnumUSStatesType (USStatesTypeName, USStatesTypeDesc, IsActive) VALUES ('Maryland', 'Maryland', 1);
INSERT INTO EnumUSStatesType (USStatesTypeName, USStatesTypeDesc, IsActive) VALUES ('Massachusetts', 'Massachusetts', 1);
INSERT INTO EnumUSStatesType (USStatesTypeName, USStatesTypeDesc, IsActive) VALUES ('Michigan', 'Michigan', 1);
INSERT INTO EnumUSStatesType (USStatesTypeName, USStatesTypeDesc, IsActive) VALUES ('Minnesota', 'Minnesota', 1);
INSERT INTO EnumUSStatesType (USStatesTypeName, USStatesTypeDesc, IsActive) VALUES ('Mississippi', 'Mississippi', 1);
INSERT INTO EnumUSStatesType (USStatesTypeName, USStatesTypeDesc, IsActive) VALUES ('Missouri', 'Missouri', 1);
INSERT INTO EnumUSStatesType (USStatesTypeName, USStatesTypeDesc, IsActive) VALUES ('Montana', 'Montana', 1);
INSERT INTO EnumUSStatesType (USStatesTypeName, USStatesTypeDesc, IsActive) VALUES ('Nebraska', 'Nebraska', 1);
INSERT INTO EnumUSStatesType (USStatesTypeName, USStatesTypeDesc, IsActive) VALUES ('Nevada', 'Nevada', 1);
INSERT INTO EnumUSStatesType (USStatesTypeName, USStatesTypeDesc, IsActive) VALUES ('New Hampshire', 'New Hampshire', 1);
INSERT INTO EnumUSStatesType (USStatesTypeName, USStatesTypeDesc, IsActive) VALUES ('New Jersey', 'New Jersey', 1);
INSERT INTO EnumUSStatesType (USStatesTypeName, USStatesTypeDesc, IsActive) VALUES ('New Mexico', 'New Mexico', 1);
INSERT INTO EnumUSStatesType (USStatesTypeName, USStatesTypeDesc, IsActive) VALUES ('New York', 'New York', 1);
INSERT INTO EnumUSStatesType (USStatesTypeName, USStatesTypeDesc, IsActive) VALUES ('North Carolina', 'North Carolina', 1);
INSERT INTO EnumUSStatesType (USStatesTypeName, USStatesTypeDesc, IsActive) VALUES ('North Dakota', 'North Dakota', 1);
INSERT INTO EnumUSStatesType (USStatesTypeName, USStatesTypeDesc, IsActive) VALUES ('Ohio', 'Ohio', 1);
INSERT INTO EnumUSStatesType (USStatesTypeName, USStatesTypeDesc, IsActive) VALUES ('Oklahoma', 'Oklahoma', 1);
INSERT INTO EnumUSStatesType (USStatesTypeName, USStatesTypeDesc, IsActive) VALUES ('Oregon', 'Oregon', 1);
INSERT INTO EnumUSStatesType (USStatesTypeName, USStatesTypeDesc, IsActive) VALUES ('Pennsylvania', 'Pennsylvania', 1);
INSERT INTO EnumUSStatesType (USStatesTypeName, USStatesTypeDesc, IsActive) VALUES ('Rhode Island', 'Rhode Island', 1);
INSERT INTO EnumUSStatesType (USStatesTypeName, USStatesTypeDesc, IsActive) VALUES ('South Carolina', 'South Carolina', 1);
INSERT INTO EnumUSStatesType (USStatesTypeName, USStatesTypeDesc, IsActive) VALUES ('South Dakota', 'South Dakota', 1);
INSERT INTO EnumUSStatesType (USStatesTypeName, USStatesTypeDesc, IsActive) VALUES ('Tennessee', 'Tennessee', 1);
INSERT INTO EnumUSStatesType (USStatesTypeName, USStatesTypeDesc, IsActive) VALUES ('Texas', 'Texas', 1);
INSERT INTO EnumUSStatesType (USStatesTypeName, USStatesTypeDesc, IsActive) VALUES ('Utah', 'Utah', 1);
INSERT INTO EnumUSStatesType (USStatesTypeName, USStatesTypeDesc, IsActive) VALUES ('Vermont', 'Vermont', 1);
INSERT INTO EnumUSStatesType (USStatesTypeName, USStatesTypeDesc, IsActive) VALUES ('Virginia', 'Virginia', 1);
INSERT INTO EnumUSStatesType (USStatesTypeName, USStatesTypeDesc, IsActive) VALUES ('Washington', 'Washington', 1);
INSERT INTO EnumUSStatesType (USStatesTypeName, USStatesTypeDesc, IsActive) VALUES ('West Virginia', 'West Virginia', 1);
INSERT INTO EnumUSStatesType (USStatesTypeName, USStatesTypeDesc, IsActive) VALUES ('Wisconsin', 'Wisconsin', 1);
INSERT INTO EnumUSStatesType (USStatesTypeName, USStatesTypeDesc, IsActive) VALUES ('Wyoming', 'Wyoming', 1);
	
-- End of EnumUSStatesType.sql

-- Start of Organization.sql


INSERT INTO Organization (OrganizationName, OrganizationTypeId, Speciality, FacilityTypeId, Government) 
	VALUES ('IITM', 2, 'Product Development, Software Development', 1, 1);
INSERT INTO Organization (OrganizationName, OrganizationTypeId, Speciality, FacilityTypeId, Government) 
	VALUES ('DiviniSoft', 2, 'Software Solution Provider', 1, 0);
INSERT INTO Organization (OrganizationName, OrganizationTypeId) 
	VALUES ('Encore', 3);
	
-- End of Organization.sql

-- Start of Users.sql


INSERT INTO Users 	(UserTypeId, FirstName, LastName, Email, Password, StatusTypeId, FieldTypeId) 
	VALUES (1, 'admin', NULL, 'sysadmin@healthcare.com', '$2a$10$Vl7unTXMqkgRnglNeeb8iu2f25vceo0.eNtynSZe8.9XofwtDuIhG', 1, 1);
INSERT INTO Users 	(UserTypeId, FirstName, LastName, Email, Password, StatusTypeId, FieldTypeId, RegistrationDate, OrganizationId) 
	VALUES (2, 'Phani', 'Yenugu', 'pyenugu@hotmail.com', '$2a$10$suCl2VnYqH.MgrOejnZQtuEGy1Co9Ax3XK.W68cE.LaKzDy1ns3Re', 1, 1, '2021-03-08', 3);
INSERT INTO Users 	(UserTypeId, FirstName, Email, Password, StatusTypeId, FieldTypeId, RegistrationDate, OrganizationId) 
	VALUES (2, 'Employer2', 'e2@hotmail.com', '$2a$10$febN8k2o3Xvui3xQo.OjauTFX6fzGxu1xChtvv3TwFM4tVY/wPz3e', 1, 1, '2021-03-08', 3);
INSERT INTO Users 	(UserTypeId, FirstName, Email, Password, StatusTypeId, FieldTypeId, RegistrationDate, OrganizationId) 
	VALUES (3, 'JobSeeker1', 'js1@hotmail.com', '$2a$10$febN8k2o3Xvui3xQo.OjauTFX6fzGxu1xChtvv3TwFM4tVY/wPz3e', 1, 1, '2021-03-08', 3);
INSERT INTO Users 	(UserTypeId, FirstName, Email, Password, StatusTypeId, FieldTypeId, RegistrationDate, OrganizationId) 
	VALUES (3, 'JobSeeker2', 'js2@hotmail.com', '$2a$10$febN8k2o3Xvui3xQo.OjauTFX6fzGxu1xChtvv3TwFM4tVY/wPz3e', 1, 1, '2021-03-08', 3);
INSERT INTO Users 	(UserTypeId, FirstName, Email, Password, StatusTypeId, FieldTypeId, RegistrationDate, OrganizationId) 
	VALUES (3, 'JobSeeker3', 'js3@hotmail.com', '$2a$10$febN8k2o3Xvui3xQo.OjauTFX6fzGxu1xChtvv3TwFM4tVY/wPz3e', 1, 1, '2021-03-08', 3);
INSERT INTO Users 	(UserTypeId, FirstName, Email, Password, StatusTypeId, FieldTypeId, RegistrationDate, OrganizationId) 
	VALUES (3, 'JobSeeker4', 'js4@hotmail.com', '$2a$10$febN8k2o3Xvui3xQo.OjauTFX6fzGxu1xChtvv3TwFM4tVY/wPz3e', 1, 1, '2021-03-08', 3);
INSERT INTO Users 	(UserTypeId, FirstName, Email, Password, StatusTypeId, FieldTypeId, RegistrationDate, OrganizationId) 
	VALUES (3, 'JobSeeker5', 'js5@hotmail.com', '$2a$10$febN8k2o3Xvui3xQo.OjauTFX6fzGxu1xChtvv3TwFM4tVY/wPz3e', 1, 1, '2021-03-08', 3);
INSERT INTO Users 	(UserTypeId, FirstName, Email, Password, StatusTypeId, FieldTypeId, RegistrationDate, OrganizationId) 
	VALUES (3, 'JobSeeker6', 'js6@hotmail.com', '$2a$10$febN8k2o3Xvui3xQo.OjauTFX6fzGxu1xChtvv3TwFM4tVY/wPz3e', 1, 1, '2021-03-08', 3);
	
-- End of Users.sql

-- Start of UserAuthentication.sql


insert into UserAuthentication (UserId, LastSignInDate, MFAPassed, MFATypeId) values (1, '2021-03-30', 1, 1);
insert into UserAuthentication (UserId, LastSignInDate, MFAPassed, MFATypeId) values (2, '2021-03-30', 1, 1);
insert into UserAuthentication (UserId, LastSignInDate, MFAPassed, MFATypeId) values (3, '2021-03-30', 1, 1);
insert into UserAuthentication (UserId, LastSignInDate, MFAPassed, MFATypeId) values (4, '2021-03-30', 1, 1);
insert into UserAuthentication (UserId, LastSignInDate, MFAPassed, MFATypeId) values (5, '2021-03-30', 1, 1);
insert into UserAuthentication (UserId, LastSignInDate, MFAPassed, MFATypeId) values (6, '2021-03-30', 1, 1);
insert into UserAuthentication (UserId, LastSignInDate, MFAPassed, MFATypeId) values (7, '2021-03-30', 1, 1);
insert into UserAuthentication (UserId, LastSignInDate, MFAPassed, MFATypeId) values (8, '2021-03-30', 1, 1);
insert into UserAuthentication (UserId, LastSignInDate, MFAPassed, MFATypeId) values (9, '2021-03-30', 1, 1);
	
-- End of UserAuthentication.sql

-- Start of MedicalEmployerExtendedInfo.sql


INSERT INTO MedicalEmployerExtendedInfo (MedicalEmployerUserId, City, State) VALUES (2, 'Columbus', 'Ohio');
INSERT INTO MedicalEmployerExtendedInfo (MedicalEmployerUserId, City, State) VALUES (3, 'Alabama', 'Foley');
-- End of MedicalEmployerExtendedInfo.sql

-- Start of MedicalJobSeekerExtendedInfo.sql


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
-- End of MedicalJobSeekerExtendedInfo.sql

-- Start of MedicalJobSeekerJobInfo.sql


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

-- End of MedicalJobSeekerJobInfo.sql

-- Start of MedicalJobSeekerJobs.sql


INSERT INTO MedicalJobSeekerJobs (MedicalJobSeekerUserId, MedicalJobSeekerJobInfoId) VALUES (4, 1);
INSERT INTO MedicalJobSeekerJobs (MedicalJobSeekerUserId, MedicalJobSeekerJobInfoId) VALUES (4, 2);
INSERT INTO MedicalJobSeekerJobs (MedicalJobSeekerUserId, MedicalJobSeekerJobInfoId) VALUES (5, 3);
INSERT INTO MedicalJobSeekerJobs (MedicalJobSeekerUserId, MedicalJobSeekerJobInfoId) VALUES (5, 4);
INSERT INTO MedicalJobSeekerJobs (MedicalJobSeekerUserId, MedicalJobSeekerJobInfoId) VALUES (8, 5);

-- End of MedicalJobSeekerJobs.sql

-- Start of MedicalJobSeekerStateLevelInfo.sql


INSERT INTO MedicalJobSeekerStateLevelInfo (MedicalJobSeekerExtendedInfoId, StateId, PrescriptionAuthority) VALUES (1, 35, 1);
INSERT INTO MedicalJobSeekerStateLevelInfo (MedicalJobSeekerExtendedInfoId, StateId, PrescriptionAuthority) VALUES (2, 1, 1);

-- End of MedicalJobSeekerStateLevelInfo.sql

