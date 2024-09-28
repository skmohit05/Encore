--liquibase formatted sql

--changeset InsertData_EnumMFAType

INSERT INTO EnumMFAType (MFATypeName, MFATypeDesc, IsActive) VALUES ('Email', 'Email', 1);
INSERT INTO EnumMFAType (MFATypeName, MFATypeDesc, IsActive) VALUES ('SMS', 'SMS', 1);
INSERT INTO EnumMFAType (MFATypeName, MFATypeDesc, IsActive) VALUES ('Biometric', 'Biometric', 1);
	
--rollback DELETE FROM EnumMFAType;