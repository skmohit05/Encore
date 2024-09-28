--liquibase formatted sql

--changeset InsertData_EnumUserStatusType

INSERT INTO EnumUserStatusType (UserStatusTypeName, UserStatusTypeDesc, IsActive) VALUES ('Active', 'USER is active', 1);
INSERT INTO EnumUserStatusType (UserStatusTypeName, UserStatusTypeDesc, IsActive) VALUES ('Inactive', 'User is inactive', 1);
INSERT INTO EnumUserStatusType (UserStatusTypeName, UserStatusTypeDesc, IsActive) VALUES ('Verified', 'User is verified', 1);
INSERT INTO EnumUserStatusType (UserStatusTypeName, UserStatusTypeDesc, IsActive) VALUES ('Pending', 'User is pending', 1);
INSERT INTO EnumUserStatusType (UserStatusTypeName, UserStatusTypeDesc, IsActive) VALUES ('Rejected', 'User is rejected', 1);
	
--rollback DELETE FROM EnumUserStatusType;