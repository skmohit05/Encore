--liquibase formatted sql

--changeset InsertData_EnumJobType

INSERT INTO EnumJobType (JobTypeName, JobTypeDesc, IsActive) 
	VALUES ('LocumTenens', 'Locum Tenens', 1);
INSERT INTO EnumJobType (JobTypeName, JobTypeDesc, IsActive) 
	VALUES ('Permanent', 'Permanent', 1);
INSERT INTO EnumJobType (JobTypeName, JobTypeDesc, IsActive) 
	VALUES ('Temporary', 'Temporary', 1);
	
--rollback DELETE FROM EnumJobType;