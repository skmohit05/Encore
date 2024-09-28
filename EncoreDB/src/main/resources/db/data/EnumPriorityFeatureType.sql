--liquibase formatted sql

--changeset InsertData_EnumPriorityFeatureType

INSERT INTO EnumPriorityFeatureType (PriorityFeatureTypeName, PriorityFeatureTypeDesc, IsActive) VALUES ('Supervision', 'Supervision Required', 1);
INSERT INTO EnumPriorityFeatureType (PriorityFeatureTypeName, PriorityFeatureTypeDesc, IsActive) VALUES ('PrescriptionAuthority', 'Prescription Authority Required', 1);
INSERT INTO EnumPriorityFeatureType (PriorityFeatureTypeName, PriorityFeatureTypeDesc, IsActive) VALUES ('Compensation', 'Salary', 1);
INSERT INTO EnumPriorityFeatureType (PriorityFeatureTypeName, PriorityFeatureTypeDesc, IsActive) VALUES ('NumberOfYears', 'Years of Experience', 1);
INSERT INTO EnumPriorityFeatureType (PriorityFeatureTypeName, PriorityFeatureTypeDesc, IsActive) VALUES ('AssignmentShift', 'Shift', 1);
INSERT INTO EnumPriorityFeatureType (PriorityFeatureTypeName, PriorityFeatureTypeDesc, IsActive) VALUES ('MalpracticeCandidate', 'Malpractice Candidate Accepted', 1);
INSERT INTO EnumPriorityFeatureType (PriorityFeatureTypeName, PriorityFeatureTypeDesc, IsActive) VALUES ('FacilityType', 'Facility Type', 1);
	
--rollback DELETE FROM EnumPriorityFeatureType;