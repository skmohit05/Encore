--liquibase formatted sql

--changeset InsertData_EnumUSStatesType

INSERT INTO EnumUSStatesType (USStatesTypeName, USStatesTypeDesc, IsActive) VALUES ('Alabama', 'Alabama', 1);
INSERT INTO EnumUSStatesType (USStatesTypeName, USStatesTypeDesc, IsActive) VALUES ('Alaska', 'Alaska', 1);
INSERT INTO EnumUSStatesType (USStatesTypeName, USStatesTypeDesc, IsActive) VALUES ('Arizona', 'Arizona', 1);
INSERT INTO EnumUSStatesType (USStatesTypeName, USStatesTypeDesc, IsActive) VALUES ('Arkansas', 'Arkansas',1);
INSERT INTO EnumUSStatesType (USStatesTypeName, USStatesTypeDesc, IsActive) VALUE  ('California','California',1);
INSERT INTO EnumUSStatesType (USStatesTypeName, USStatesTypeDesc, IsActive) VALUES ('Colorado', 'Colorado', 1);
INSERT INTO EnumUSStatesType (USStatesTypeName, USStatesTypeDesc, IsActive) VALUES ('Connecticut', 'Connecticut', 1);
INSERT INTO EnumUSStatesType (USStatesTypeName, USStatesTypeDesc, IsActive) VALUES ('Delaware', 'Delaware', 1);
INSERT INTO EnumUSStatesType (USStatesTypeName, USStatesTypeDesc, IsActive) VALUES ('Florida', 'Florida', 1);
INSERT INTO EnumUSStatesType (USStatesTypeName, USStatesTypeDesc, IsActive) VALUES ('Georgia', 'Georgia', 1);
INSERT INTO EnumUSStatesType (USStatesTypeName, USStatesTypeDesc, IsActive) VALUES ('Hawaii', 'Hawaii', 1);
INSERT INTO EnumUSStatesType (USStatesTypeName, USStatesTypeDesc, IsActive) VALUES ('Idaho', 'Idaho', 1);
INSERT INTO EnumUSStatesType (USStatesTypeName, USStatesTypeDesc, IsActive) VALUES ('Illinois', 'Illinois', 1);
INSERT INTO EnumUSStatesType (USStatesTypeName, USStatesTypeDesc, IsActive) VALUES ('Indiana', 'Indiana', 1);
INSERT INTO EnumUSStatesType (USStatesTypeName, USStatesTypeDesc, IsActive) VALUES ('Iowa', 'Iowa', 1);
INSERT INTO EnumUSStatesType (USStatesTypeName, USStatesTypeDesc, IsActive) VALUES ('Kansas', 'Kansas', 1);
INSERT INTO EnumUSStatesType (USStatesTypeName, USStatesTypeDesc, IsActive) VALUES ('Kentucky', 'Kentucky', 1);
INSERT INTO EnumUSStatesType (USStatesTypeName, USStatesTypeDesc, IsActive) VALUES ('Louisiana', 'Louisiana', 1);
INSERT INTO EnumUSStatesType (USStatesTypeName, USStatesTypeDesc, IsActive) VALUES ('Maine', 'Maine', 1);
INSERT INTO EnumUSStatesType (USStatesTypeName, USStatesTypeDesc, IsActive) VALUES ('Maryland', 'Maryland', 1);
INSERT INTO EnumUSStatesType (USStatesTypeName, USStatesTypeDesc, IsActive) VALUES ('Massachusetts', 'Massachusetts', 1);
INSERT INTO EnumUSStatesType (USStatesTypeName, USStatesTypeDesc, IsActive) VALUES ('Michigan', 'Michigan', 1);
INSERT INTO EnumUSStatesType (USStatesTypeName, USStatesTypeDesc, IsActive) VALUES ('Minnesota', 'Minnesota', 1);
INSERT INTO EnumUSStatesType (USStatesTypeName, USStatesTypeDesc, IsActive) VALUES ('Mississippi', 'Mississippi', 1);
INSERT INTO EnumUSStatesType (USStatesTypeName, USStatesTypeDesc, IsActive) VALUES ('Missouri', 'Missouri', 1);
INSERT INTO EnumUSStatesType (USStatesTypeName, USStatesTypeDesc, IsActive) VALUES ('Montana', 'Montana', 1);
INSERT INTO EnumUSStatesType (USStatesTypeName, USStatesTypeDesc, IsActive) VALUES ('Nebraska', 'Nebraska', 1);
INSERT INTO EnumUSStatesType (USStatesTypeName, USStatesTypeDesc, IsActive) VALUES ('Nevada', 'Nevada', 1);
INSERT INTO EnumUSStatesType (USStatesTypeName, USStatesTypeDesc, IsActive) VALUES ('New Hampshire', 'New Hampshire', 1);
INSERT INTO EnumUSStatesType (USStatesTypeName, USStatesTypeDesc, IsActive) VALUES ('New Jersey', 'New Jersey', 1);
INSERT INTO EnumUSStatesType (USStatesTypeName, USStatesTypeDesc, IsActive) VALUES ('New Mexico', 'New Mexico', 1);
INSERT INTO EnumUSStatesType (USStatesTypeName, USStatesTypeDesc, IsActive) VALUES ('New York', 'New York', 1);
INSERT INTO EnumUSStatesType (USStatesTypeName, USStatesTypeDesc, IsActive) VALUES ('North Carolina', 'North Carolina', 1);
INSERT INTO EnumUSStatesType (USStatesTypeName, USStatesTypeDesc, IsActive) VALUES ('North Dakota', 'North Dakota', 1);
INSERT INTO EnumUSStatesType (USStatesTypeName, USStatesTypeDesc, IsActive) VALUES ('Ohio', 'Ohio', 1);
INSERT INTO EnumUSStatesType (USStatesTypeName, USStatesTypeDesc, IsActive) VALUES ('Oklahoma', 'Oklahoma', 1);
INSERT INTO EnumUSStatesType (USStatesTypeName, USStatesTypeDesc, IsActive) VALUES ('Oregon', 'Oregon', 1);
INSERT INTO EnumUSStatesType (USStatesTypeName, USStatesTypeDesc, IsActive) VALUES ('Pennsylvania', 'Pennsylvania', 1);
INSERT INTO EnumUSStatesType (USStatesTypeName, USStatesTypeDesc, IsActive) VALUES ('Rhode Island', 'Rhode Island', 1);
INSERT INTO EnumUSStatesType (USStatesTypeName, USStatesTypeDesc, IsActive) VALUES ('South Carolina', 'South Carolina', 1);
INSERT INTO EnumUSStatesType (USStatesTypeName, USStatesTypeDesc, IsActive) VALUES ('South Dakota', 'South Dakota', 1);
INSERT INTO EnumUSStatesType (USStatesTypeName, USStatesTypeDesc, IsActive) VALUES ('Tennessee', 'Tennessee', 1);
INSERT INTO EnumUSStatesType (USStatesTypeName, USStatesTypeDesc, IsActive) VALUES ('Texas', 'Texas', 1);
INSERT INTO EnumUSStatesType (USStatesTypeName, USStatesTypeDesc, IsActive) VALUES ('Utah', 'Utah', 1);
INSERT INTO EnumUSStatesType (USStatesTypeName, USStatesTypeDesc, IsActive) VALUES ('Vermont', 'Vermont', 1);
INSERT INTO EnumUSStatesType (USStatesTypeName, USStatesTypeDesc, IsActive) VALUES ('Virginia', 'Virginia', 1);
INSERT INTO EnumUSStatesType (USStatesTypeName, USStatesTypeDesc, IsActive) VALUES ('Washington', 'Washington', 1);
INSERT INTO EnumUSStatesType (USStatesTypeName, USStatesTypeDesc, IsActive) VALUES ('West Virginia', 'West Virginia', 1);
INSERT INTO EnumUSStatesType (USStatesTypeName, USStatesTypeDesc, IsActive) VALUES ('Wisconsin', 'Wisconsin', 1);
INSERT INTO EnumUSStatesType (USStatesTypeName, USStatesTypeDesc, IsActive) VALUES ('Wyoming', 'Wyoming', 1);
	
--rollback DELETE FROM EnumUSStatesType;