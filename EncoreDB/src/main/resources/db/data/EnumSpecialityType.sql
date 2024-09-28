--liquibase formatted sql

--changeset InsertData_EnumSpecialityType

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
	
--rollback DELETE FROM EnumSpecialityType;