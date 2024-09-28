--liquibase formatted sql

--changeset CreateTable_EnumCommunicationChannelType
CREATE TABLE EnumCommunicationChannelType (
    CommunicationChannelTypeId			INT 			AUTO_INCREMENT,
    CommunicationChannelTypeName    	VARCHAR(128)	NOT NULL,
    CommunicationChannelTypeDesc    	VARCHAR(512)	NULL,
    IsActive							BIT				NOT NULL	DEFAULT 0,
    Lud									DATETIME		NULL,
    Lub									INT				NULL,
    CONSTRAINT pkEnumCommunicationChannelType PRIMARY KEY CLUSTERED (CommunicationChannelTypeId),
    CONSTRAINT ukEnumCommunicationChannelType UNIQUE (CommunicationChannelTypeName)
);
--rollback DROP TABLE EnumCommunicationChannelType;