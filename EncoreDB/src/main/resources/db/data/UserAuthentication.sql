--liquibase formatted sql

--changeset InsertData_UserAuthentication

insert into UserAuthentication (UserId, LastSignInDate, MFAPassed, MFATypeId) values (1, '2021-03-30', 1, 1);
insert into UserAuthentication (UserId, LastSignInDate, MFAPassed, MFATypeId) values (2, '2021-03-30', 1, 1);
insert into UserAuthentication (UserId, LastSignInDate, MFAPassed, MFATypeId) values (3, '2021-03-30', 1, 1);
insert into UserAuthentication (UserId, LastSignInDate, MFAPassed, MFATypeId) values (4, '2021-03-30', 1, 1);
insert into UserAuthentication (UserId, LastSignInDate, MFAPassed, MFATypeId) values (5, '2021-03-30', 1, 1);
insert into UserAuthentication (UserId, LastSignInDate, MFAPassed, MFATypeId) values (6, '2021-03-30', 1, 1);
insert into UserAuthentication (UserId, LastSignInDate, MFAPassed, MFATypeId) values (7, '2021-03-30', 1, 1);
insert into UserAuthentication (UserId, LastSignInDate, MFAPassed, MFATypeId) values (8, '2021-03-30', 1, 1);
insert into UserAuthentication (UserId, LastSignInDate, MFAPassed, MFATypeId) values (9, '2021-03-30', 1, 1);
	
--rollback DELETE FROM UserAuthentication;
