--liquibase formatted sql

--changeset InsertData_EnumCompensationType

INSERT INTO EnumCompensationType (CompensationTypeName, CompensationTypeDesc, IsActive) 
	VALUES ('Hourly', 'Hourly', 1);
INSERT INTO EnumCompensationType (CompensationTypeName, CompensationTypeDesc, IsActive) 
	VALUES ('Lumpsum', 'Lumpsum', 1);
INSERT INTO EnumCompensationType (CompensationTypeName, CompensationTypeDesc, IsActive) 
	VALUES ('Yearly', 'Yearly', 1);
	
--rollback DELETE FROM EnumCompensationType;