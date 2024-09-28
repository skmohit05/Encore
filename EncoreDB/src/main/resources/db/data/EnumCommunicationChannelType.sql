--liquibase formatted sql

--changeset InsertData_EnumCommunicationChannelType

INSERT INTO EnumCommunicationChannelType (CommunicationChannelTypeName, CommunicationChannelTypeDesc, IsActive) 
	VALUES ('Email', 'Email', 1);
INSERT INTO EnumCommunicationChannelType (CommunicationChannelTypeName, CommunicationChannelTypeDesc, IsActive) 
	VALUES ('SMS', 'SMS', 1);
	
--rollback DELETE FROM EnumCommunicationChannelType;