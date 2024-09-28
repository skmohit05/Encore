--liquibase formatted sql

--changeset InsertData_EnumShiftType

INSERT INTO EnumShiftType (ShiftTypeName, ShiftTypeDesc, IsActive) VALUES ('Day', 'Day', 1);
INSERT INTO EnumShiftType (ShiftTypeName, ShiftTypeDesc, IsActive) VALUES ('Night', 'Night', 1);
INSERT INTO EnumShiftType (ShiftTypeName, ShiftTypeDesc, IsActive) VALUES ('Weekend', 'Weekend', 1);
INSERT INTO EnumShiftType (ShiftTypeName, ShiftTypeDesc, IsActive) VALUES ('AllDay', 'All Day', 1);
INSERT INTO EnumShiftType (ShiftTypeName, ShiftTypeDesc, IsActive) VALUES ('NoPreference', 'No Preference', 1);
INSERT INTO EnumShiftType (ShiftTypeName, ShiftTypeDesc, IsActive) VALUES ('All', 'All', 1);
INSERT INTO EnumShiftType (ShiftTypeName, ShiftTypeDesc, IsActive) VALUES ('Variable', 'Variable', 1);
	
--rollback DELETE FROM EnumShiftType;