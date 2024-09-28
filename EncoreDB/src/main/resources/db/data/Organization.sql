--liquibase formatted sql

--changeset InsertData_Organization

INSERT INTO Organization (OrganizationName, OrganizationTypeId, Speciality, FacilityTypeId, Government) 
	VALUES ('IITM', 2, 'Product Development, Software Development', 1, 1);
INSERT INTO Organization (OrganizationName, OrganizationTypeId, Speciality, FacilityTypeId, Government) 
	VALUES ('DiviniSoft', 2, 'Software Solution Provider', 1, 0);
INSERT INTO Organization (OrganizationName, OrganizationTypeId) 
	VALUES ('Encore', 3);
	
--rollback DELETE FROM Organization;
