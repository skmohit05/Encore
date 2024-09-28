--liquibase formatted sql

--changeset CreateTable_UserAuthentication
CREATE TABLE UserAuthentication (
	UserAuthenticationId	INT				NOT NULL   AUTO_INCREMENT,
    UserId					INT				NOT NULL,
	LastSignInDate			DATE			NULL,
	MFAPassed				BIT				NOT NULL	DEFAULT 0,
	MFATypeId				INT				NOT NULL,			
	RememberMe				BIT				NULL,
	TrustedDeviceId			VARCHAR(1024)	NULL,
    Lud              		DATETIME        NULL,
    Lub              		INT             NULL,
    CONSTRAINT pkUserAuthentication PRIMARY KEY CLUSTERED (UserAuthenticationId),
    CONSTRAINT ukUserAuthentication UNIQUE (UserId),
    CONSTRAINT fkUserAuthenticationUserId FOREIGN KEY (UserId) REFERENCES Users (UserId) ON UPDATE NO ACTION ON DELETE NO ACTION,
    CONSTRAINT fkUserAuthenticationMFATypeId FOREIGN KEY (MFATypeId) REFERENCES EnumMFAType (MFATypeId) ON UPDATE NO ACTION ON DELETE NO ACTION
);
--rollback DROP TABLE UserAuthentication;
