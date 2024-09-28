--liquibase formatted sql

--changeset InsertData_EnumFacilitySubType

INSERT INTO EnumFacilitySubType (FacilitySubTypeName, FacilitySubTypeDesc, IsActive) VALUES ('PrimacyCareCenter', 'Primacy Care Center', 1);
INSERT INTO EnumFacilitySubType (FacilitySubTypeName, FacilitySubTypeDesc, IsActive) VALUES ('TertiaryCareCenter', 'Tertiary Care Center', 1);
INSERT INTO EnumFacilitySubType (FacilitySubTypeName, FacilitySubTypeDesc, IsActive) VALUES ('TraumaCenter1', 'Trauma Center 1', 1);
INSERT INTO EnumFacilitySubType (FacilitySubTypeName, FacilitySubTypeDesc, IsActive) VALUES ('TraumaCenter2', 'Trauma Center 2', 1);
INSERT INTO EnumFacilitySubType (FacilitySubTypeName, FacilitySubTypeDesc, IsActive) VALUES ('TraumaCenter3', 'Trauma Center 3', 1);
INSERT INTO EnumFacilitySubType (FacilitySubTypeName, FacilitySubTypeDesc, IsActive) VALUES ('UniversityCenter', 'University Center', 1);
INSERT INTO EnumFacilitySubType (FacilitySubTypeName, FacilitySubTypeDesc, IsActive) VALUES ('CriticalAccessHospital', 'Critical Access Hospital', 1);
INSERT INTO EnumFacilitySubType (FacilitySubTypeName, FacilitySubTypeDesc, IsActive) VALUES ('CommunityHospital', 'Community Hospital', 1);
	
--rollback DELETE FROM EnumFacilitySubType;