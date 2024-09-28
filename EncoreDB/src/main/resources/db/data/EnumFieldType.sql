--liquibase formatted sql

--changeset InsertData_EnumFieldType

INSERT INTO EnumFieldType (FieldTypeName, FieldTypeDesc, IsActive) VALUES ('Medical', 'Medical', 1);
INSERT INTO EnumFieldType (FieldTypeName, FieldTypeDesc, IsActive) VALUES ('IT', 'IT', 1);
	
--rollback DELETE FROM EnumFieldType;