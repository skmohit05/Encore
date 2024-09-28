--liquibase formatted sql

--changeset InsertData_EnumOrganizationType

INSERT INTO EnumOrganizationType (OrganizationTypeName, OrganizationTypeDesc, IsActive) VALUES ('EmployeeBasedPractice', 'Employee Based Practice', 1);
INSERT INTO EnumOrganizationType (OrganizationTypeName, OrganizationTypeDesc, IsActive) VALUES ('PrivatePractice', 'Private Practice', 1);
INSERT INTO EnumOrganizationType (OrganizationTypeName, OrganizationTypeDesc, IsActive) VALUES ('Corporate', 'Corporate', 1);
	
--rollback DELETE FROM EnumOrganizationType;