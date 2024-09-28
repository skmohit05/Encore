--liquibase formatted sql

--changeset encore:InsertData_EnumAccessRight

INSERT INTO EnumAccessRight (AccessRightName, AccessRightDesc, AccessRightRole, IsActive, Lud, Lub) VALUES ('Admin', 'Administrative user', 'ROLE_ADMIN', 1, UTC_TIMESTAMP(), 1);
INSERT INTO EnumAccessRight (AccessRightName, AccessRightDesc, AccessRightRole, IsActive, Lud, Lub) VALUES ('GeneralUser', 'Create, Update and View access', 'ROLE_GENERALUSER', 1, UTC_TIMESTAMP(), 1);

--rollback DELETE FROM EnumAccessRight;

