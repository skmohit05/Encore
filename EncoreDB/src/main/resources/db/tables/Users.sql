--liquibase formatted sql

--changeset CreateTable_Users
CREATE TABLE Users (
    UserId					INT				NOT NULL   AUTO_INCREMENT,
    UserTypeId				INT				NULL,
    Email					CHAR(64)		NOT NULL,
    FirstName				CHAR(32)		NULL,
    LastName				CHAR(32)		NULL,
    Password				CHAR(128)		NOT NULL,
    StatusTypeId			INT				NOT NULL,
    FieldTypeId				INT				NULL,
    SubDomain				VARCHAR(256)	NULL,
	RegistrationDate		DATE			NULL,
	RemoveRequestedDate		DATE			NULL,
	OrganizationId			INT				NULL,
    Lud              		DATETIME		NULL,
    Lub              		INT             NULL,
    CONSTRAINT pkUsers PRIMARY KEY CLUSTERED (UserId),
    CONSTRAINT ukUsers UNIQUE (Email),
    CONSTRAINT fkUsersUserTypeId FOREIGN KEY (UserTypeId) REFERENCES EnumUserType (UserTypeId) ON UPDATE NO ACTION ON DELETE NO ACTION,
    CONSTRAINT fkUsersStatusTypeId FOREIGN KEY (StatusTypeId) REFERENCES EnumUserStatusType (UserStatusTypeId) ON UPDATE NO ACTION ON DELETE NO ACTION,
    CONSTRAINT fkUsersFieldTypeId FOREIGN KEY (FieldTypeId) REFERENCES EnumFieldType (FieldTypeId) ON UPDATE NO ACTION ON DELETE NO ACTION,
    CONSTRAINT fkUsersOrganizationId FOREIGN KEY (OrganizationId) REFERENCES Organization (OrganizationId) ON UPDATE NO ACTION ON DELETE NO ACTION
);
--rollback DROP TABLE Users;
