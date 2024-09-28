--liquibase formatted sql

--changeset InsertData_EnumAssignmentType

INSERT INTO EnumAssignmentType (AssignmentTypeName, AssignmentTypeDesc, IsActive) 
	VALUES ('OR', 'OR', 1);
INSERT INTO EnumAssignmentType (AssignmentTypeName, AssignmentTypeDesc, IsActive) 
	VALUES ('Outpatient', 'Outpatient', 1);
INSERT INTO EnumAssignmentType (AssignmentTypeName, AssignmentTypeDesc, IsActive) 
	VALUES ('ER', 'ER', 1);
	
--rollback DELETE FROM EnumAssignmentType;