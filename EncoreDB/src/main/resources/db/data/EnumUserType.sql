--liquibase formatted sql

--changeset InsertData_EnumUserType

INSERT INTO EnumUserType (UserTypeName, UserTypeDesc, UserRole, IsActive) VALUES ('Admin', 'Admin', 'ROLE_ADMIN', 1);
INSERT INTO EnumUserType (UserTypeName, UserTypeDesc, UserRole, IsActive) VALUES ('Employer', 'Employer', 'ROLE_EMPLOYER', 1);
INSERT INTO EnumUserType (UserTypeName, UserTypeDesc, UserRole, IsActive) VALUES ('JobSeeker', 'JobSeeker', 'ROLE_JOBSEEKER', 1);
	
--rollback DELETE FROM EnumUserType;