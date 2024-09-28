--liquibase formatted sql

--changeset CreateTable_UserCommunicationPref
CREATE TABLE UserCommunicationPref (
	UserCommunicationPrefId			INT			AUTO_INCREMENT,
	UserId							INT			NOT NULL,
	CommunicationChannelTypeId		INT			NOT NULL,
    JobSubscription					BIT			NULL		DEFAULT 0,
    CandidateSubscription			BIT			NULL		DEFAULT 0,
    SiteFeatureSubscription			BIT			NULL		DEFAULT 0,
	MarketingSubscription			BIT			NULL		DEFAULT 0,
    Lud              				DATETIME	NULL,
    Lub              				INT			NULL,
	CONSTRAINT pkUserCommunicationPref PRIMARY KEY CLUSTERED (UserCommunicationPrefId),
    CONSTRAINT ukUserCommunicationPref UNIQUE (CommunicationChannelTypeId),
    CONSTRAINT fkUserCommunicationPrefUserId FOREIGN KEY (UserId) REFERENCES Users (UserId) ON UPDATE NO ACTION ON DELETE NO ACTION,
    CONSTRAINT fkUserCommunicationPrefCommunicationChannelTypeId FOREIGN KEY (CommunicationChannelTypeId) REFERENCES EnumCommunicationChannelType (CommunicationChannelTypeId) ON UPDATE NO ACTION ON DELETE NO ACTION
);
--rollback DROP TABLE UserCommunicationPref;