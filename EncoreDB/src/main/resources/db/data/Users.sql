--liquibase formatted sql

--changeset InsertData_Users

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
	
--rollback DELETE FROM Users;
