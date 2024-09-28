--liquibase formatted sql

--changeset InsertData_EnumFacilityType

INSERT INTO EnumFacilityType (FacilityTypeName, FacilityTypeDesc, IsActive) VALUES ('ER', 'ER', 1);
INSERT INTO EnumFacilityType (FacilityTypeName, FacilityTypeDesc, IsActive) VALUES ('OP', 'OP', 1);
INSERT INTO EnumFacilityType (FacilityTypeName, FacilityTypeDesc, IsActive) VALUES ('Hospital', 'Hospital', 1);
INSERT INTO EnumFacilityType (FacilityTypeName, FacilityTypeDesc, IsActive) VALUES ('ImagingCenter', 'Imaging Center', 1);
	
--rollback DELETE FROM EnumFacilityType;