--liquibase formatted sql

--changeset InsertData_EnumJobPostingStatusType

INSERT INTO EnumJobPostingStatusType (JobPostingStatusTypeName, JobPostingStatusTypeDesc, IsActive) VALUES ('Active', 'Job Posting is active', 1);
INSERT INTO EnumJobPostingStatusType (JobPostingStatusTypeName, JobPostingStatusTypeDesc, IsActive) VALUES ('Inactive', 'Job Posting is inactive', 1);
INSERT INTO EnumJobPostingStatusType (JobPostingStatusTypeName, JobPostingStatusTypeDesc, IsActive) VALUES ('Verified', 'Job Posting is verified', 1);
INSERT INTO EnumJobPostingStatusType (JobPostingStatusTypeName, JobPostingStatusTypeDesc, IsActive) VALUES ('Pending', 'Job Posting is pending', 1);
INSERT INTO EnumJobPostingStatusType (JobPostingStatusTypeName, JobPostingStatusTypeDesc, IsActive) VALUES ('Rejected', 'Job Posting is rejected', 1);
	
--rollback DELETE FROM EnumJobPostingStatusType;