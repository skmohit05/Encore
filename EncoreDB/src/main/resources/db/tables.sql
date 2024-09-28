use encore;

-- Start of EnumCommunicationChannelType.sql

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
-- End of EnumCommunicationChannelType.sql

-- Start of EnumSpecialityType.sql

CREATE TABLE EnumSpecialityType (
    SpecialityTypeId		INT				AUTO_INCREMENT,
    SpecialityTypeName		VARCHAR(128)	NOT NULL,
    SpecialityTypeDesc		VARCHAR(512)	NULL,
    IsActive				BIT				NOT NULL	DEFAULT 0,
    Lud						DATETIME		NULL,
    Lub						INT				NULL,
    CONSTRAINT pkEnumSpecialityType	PRIMARY KEY CLUSTERED (SpecialityTypeId),
    CONSTRAINT ukEnumSpecialityType	UNIQUE (SpecialityTypeName)
);
-- End of EnumSpecialityType.sql

-- Start of EnumJobType.sql

CREATE TABLE EnumJobType (
    JobTypeId		INT				AUTO_INCREMENT,
    JobTypeName		VARCHAR(128)	NOT NULL,
    JobTypeDesc		VARCHAR(512)	NULL,
    IsActive		BIT				NOT NULL	DEFAULT 0,
    Lud				DATETIME		NULL,
    Lub				INT				NULL,
    CONSTRAINT pkEnumJobType PRIMARY KEY CLUSTERED (JobTypeId),
    CONSTRAINT ukEnumJobType UNIQUE (JobTypeName)
);
-- End of EnumJobType.sql

-- Start of EnumShiftType.sql

CREATE TABLE EnumShiftType (
    ShiftTypeId			INT				AUTO_INCREMENT,
    ShiftTypeName		VARCHAR(128)	NOT NULL,
    ShiftTypeDesc		VARCHAR(512)	NULL,
    IsActive			BIT				NOT NULL	DEFAULT 0,
    Lud					DATETIME		NULL,
    Lub					INT				NULL,
    CONSTRAINT pkEnumShiftType PRIMARY KEY CLUSTERED (ShiftTypeId),
    CONSTRAINT ukEnumShiftType UNIQUE (ShiftTypeName)
);
-- End of EnumShiftType.sql

-- Start of EnumFacilityType.sql

CREATE TABLE EnumFacilityType (
    FacilityTypeId		INT				AUTO_INCREMENT,
    FacilityTypeName	VARCHAR(128)	NOT NULL,
    FacilityTypeDesc	VARCHAR(512)	NULL,
    IsActive			BIT				NOT NULL	DEFAULT 0,
    Lud					DATETIME		NULL,
    Lub					INT				NULL,
    CONSTRAINT pkEnumFacilityType PRIMARY KEY CLUSTERED (FacilityTypeId),
    CONSTRAINT ukEnumFacilityType UNIQUE (FacilityTypeName)
);
-- End of EnumFacilityType.sql

-- Start of EnumFacilitySubType.sql

CREATE TABLE EnumFacilitySubType (
    FacilitySubTypeId		INT				AUTO_INCREMENT,
    FacilitySubTypeName		VARCHAR(128)	NOT NULL,
    FacilitySubTypeDesc		VARCHAR(512)	NULL,
    IsActive				BIT				NOT NULL	DEFAULT 0,
    Lud						DATETIME		NULL,
    Lub						INT				NULL,
    CONSTRAINT pkEnumFacilitySubType PRIMARY KEY CLUSTERED (FacilitySubTypeId),
    CONSTRAINT ukEnumFacilitySubType UNIQUE (FacilitySubTypeName)
);
-- End of EnumFacilitySubType.sql

-- Start of EnumAssignmentType.sql

CREATE TABLE EnumAssignmentType (
    AssignmentTypeId		INT				AUTO_INCREMENT,
    AssignmentTypeName		VARCHAR(128)	NOT NULL,
    AssignmentTypeDesc		VARCHAR(512)	NULL,
    IsActive				BIT				NOT NULL	DEFAULT 0,
    Lud						DATETIME		NULL,
    Lub						INT				NULL,
    CONSTRAINT pkEnumAssignmentType PRIMARY KEY CLUSTERED (AssignmentTypeId),
    CONSTRAINT ukEnumAssignmentType UNIQUE (AssignmentTypeName)
);
-- End of EnumAssignmentType.sql

-- Start of EnumUserType.sql

CREATE TABLE EnumUserType (
    UserTypeId		INT				AUTO_INCREMENT,
    UserTypeName	VARCHAR(128)	NOT NULL,
    UserTypeDesc	VARCHAR(512)	NULL,
    UserRole        NVARCHAR(64)    NOT NULL,
    IsActive		BIT				NOT NULL	DEFAULT 0,
    Lud				DATETIME		NULL,
    Lub				INT				NULL,
    CONSTRAINT pkEnumUserType PRIMARY KEY CLUSTERED (UserTypeId),
    CONSTRAINT ukEnumUserType UNIQUE (UserTypeName)
);
-- End of EnumUserType.sql

-- Start of EnumUserStatusType.sql

CREATE TABLE EnumUserStatusType (
    UserStatusTypeId		INT				AUTO_INCREMENT,
    UserStatusTypeName		VARCHAR(128)	NOT NULL,
    UserStatusTypeDesc		VARCHAR(512)	NULL,
    IsActive				BIT				NOT NULL	DEFAULT 0,
    Lud						DATETIME		NULL,
    Lub						INT				NULL,
    CONSTRAINT pkEnumUserStatusType PRIMARY KEY CLUSTERED (UserStatusTypeId),
    CONSTRAINT ukEnumUserStatusType UNIQUE (UserStatusTypeName)
);
-- End of EnumUserStatusType.sql

-- Start of EnumJobPostingStatusType.sql

CREATE TABLE EnumJobPostingStatusType (
    JobPostingStatusTypeId		INT				AUTO_INCREMENT,
    JobPostingStatusTypeName	VARCHAR(128)	NOT NULL,
    JobPostingStatusTypeDesc	VARCHAR(512)	NULL,
    IsActive					BIT				NOT NULL	DEFAULT 0,
    Lud							DATETIME		NULL,
    Lub							INT				NULL,
    CONSTRAINT pkEnumJobPostingStatusType PRIMARY KEY CLUSTERED (JobPostingStatusTypeId),
    CONSTRAINT ukEnumJobPostingStatusType UNIQUE (JobPostingStatusTypeName)
);
-- End of EnumJobPostingStatusType.sql

-- Start of EnumFieldType.sql

CREATE TABLE EnumFieldType (
    FieldTypeId		INT				AUTO_INCREMENT,
    FieldTypeName	VARCHAR(128)	NOT NULL,
    FieldTypeDesc	VARCHAR(512)	NULL,
    IsActive		BIT				NOT NULL	DEFAULT 0,
    Lud				DATETIME		NULL,
    Lub				INT				NULL,
    CONSTRAINT pkEnumFieldType PRIMARY KEY CLUSTERED (FieldTypeId),
    CONSTRAINT ukEnumFieldType UNIQUE (FieldTypeName)
);
-- End of EnumFieldType.sql

-- Start of EnumOrganizationType.sql

CREATE TABLE EnumOrganizationType (
    OrganizationTypeId		INT				AUTO_INCREMENT,
    OrganizationTypeName	VARCHAR(128)	NOT NULL,
    OrganizationTypeDesc	VARCHAR(512)	NULL,
    IsActive				BIT				NOT NULL	DEFAULT 0,
    Lud						DATETIME		NULL,
    Lub						INT				NULL,
    CONSTRAINT pkEnumOrganizationType PRIMARY KEY CLUSTERED (OrganizationTypeId),
    CONSTRAINT ukEnumOrganizationType UNIQUE (OrganizationTypeName)
);
-- End of EnumOrganizationType.sql

-- Start of EnumPriorityFeatureType.sql

CREATE TABLE EnumPriorityFeatureType (
    PriorityFeatureTypeId		INT				AUTO_INCREMENT,
    PriorityFeatureTypeName		VARCHAR(128)	NOT NULL,
    PriorityFeatureTypeDesc		VARCHAR(512)	NULL,
    IsActive					BIT				NOT NULL	DEFAULT 0,
    Lud							DATETIME		NULL,
    Lub							INT				NULL,
    CONSTRAINT pkEnumPriorityFeatureType PRIMARY KEY CLUSTERED (PriorityFeatureTypeId),
    CONSTRAINT ukEnumPriorityFeatureType UNIQUE (PriorityFeatureTypeName)
);
-- End of EnumPriorityFeatureType.sql

-- Start of EnumCompensationType.sql

CREATE TABLE EnumCompensationType (
    CompensationTypeId		INT				AUTO_INCREMENT,
    CompensationTypeName	VARCHAR(128)	NOT NULL,
    CompensationTypeDesc	VARCHAR(512)	NULL,
    IsActive				BIT				NOT NULL	DEFAULT 0,
    Lud						DATETIME		NULL,
    Lub						INT				NULL,
    CONSTRAINT pkEnumCompensationType PRIMARY KEY CLUSTERED (CompensationTypeId),
    CONSTRAINT ukEnumCompensationType UNIQUE (CompensationTypeName)
);
-- End of EnumCompensationType.sql

-- Start of EnumMFAType.sql

CREATE TABLE EnumMFAType (
    MFATypeId		INT				AUTO_INCREMENT,
    MFATypeName		VARCHAR(128)	NOT NULL,
    MFATypeDesc		VARCHAR(512)	NULL,
    IsActive		BIT				NOT NULL	DEFAULT 0,
    Lud				DATETIME		NULL,
    Lub				INT				NULL,
    CONSTRAINT pkEnumMFAType PRIMARY KEY CLUSTERED (MFATypeId),
    CONSTRAINT ukEnumMFAType UNIQUE (MFATypeName)
);
-- End of EnumMFAType.sql

-- Start of EnumUSStatesType.sql

CREATE TABLE EnumUSStatesType (
    USStatesTypeId		INT				AUTO_INCREMENT,
    USStatesTypeName	VARCHAR(128)	NOT NULL,
    USStatesTypeDesc	VARCHAR(512)	NULL,
    IsActive			BIT				NOT NULL	DEFAULT 0,
    Lud					DATETIME		NULL,
    Lub					INT				NULL,
    CONSTRAINT pkEnumUSStatesType PRIMARY KEY CLUSTERED (USStatesTypeId),
    CONSTRAINT ukEnumUSStatesType UNIQUE (USStatesTypeName)
);
-- End of EnumUSStatesType.sql

-- Start of Organization.sql

CREATE TABLE Organization (
    OrganizationId			INT					NOT NULL   AUTO_INCREMENT,
    OrganizationName		VARCHAR(256)		NOT NULL,
    OrganizationTypeId		INT					NOT NULL,
    Speciality				VARCHAR(1024)		NULL,
    FacilityTypeId			INT					NULL,
    FacilitySubTypeId			INT				NULL,
    Government				BIT					NULL		DEFAULT 0,
    Lud              		DATETIME       		NULL,
    Lub              		INT             	NULL,
    CONSTRAINT pkOrganization PRIMARY KEY CLUSTERED (OrganizationId),
    CONSTRAINT ukOrganization UNIQUE (OrganizationName),
    CONSTRAINT fkOrganizationOrganizationTypeId FOREIGN KEY (OrganizationTypeId) REFERENCES EnumOrganizationType (OrganizationTypeId) ON UPDATE NO ACTION ON DELETE NO ACTION,
    CONSTRAINT fkOrganizationFacilityTypeId FOREIGN KEY (FacilityTypeId) REFERENCES EnumFacilityType (FacilityTypeId) ON UPDATE NO ACTION ON DELETE NO ACTION,
    CONSTRAINT fkOrganizationFacilitySubTypeId FOREIGN KEY (FacilitySubTypeId) REFERENCES EnumFacilitySubType (FacilitySubTypeId) ON UPDATE NO ACTION ON DELETE NO ACTION
);
-- End of Organization.sql

-- Start of Users.sql

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
-- End of Users.sql

-- Start of UserAuthentication.sql

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
-- End of UserAuthentication.sql

-- Start of UserCommunicationPref.sql

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
-- End of UserCommunicationPref.sql

-- Start of MedicalJobSeekerExtendedInfo.sql

CREATE TABLE MedicalJobSeekerExtendedInfo (
	MedicalJobSeekerExtendedInfoId		INT				AUTO_INCREMENT,
	MedicalJobSeekerUserId				INT				NOT NULL,
    Address1							VARCHAR(512)	NOT NULL,
    Address2							VARCHAR(512)	NULL,
    City								VARCHAR(128)	NOT NULL,
    State								CHAR(30)		NOT NULL,
    Zip									CHAR(10)			NOT NULL,
    Title								CHAR(7)			NOT NULL,
	SpecialityTypeId					INT				NOT NULL,
	Malpractice							BIT				NULL,
	BoardActions						BIT				NULL,
	DisciplinaryActions					BIT				NULL,
	LossOfPrivileges					BIT				NULL,
	NPDB								BIT				NULL,
	EpicExperience						BIT				NULL,
    MalpracticeInfo						VARCHAR(1024)	NULL,
	BoardActionsInfo					VARCHAR(1024)	NULL,
	DisciplinaryActionsInfo				VARCHAR(1024)	NULL,
	LossOfPrivilegesInfo				VARCHAR(1024)	NULL,
	NPDBInfo							VARCHAR(1024)	NULL,
	EpicExperienceYears					INT				NULL,
	JobPreferenceTypeId					INT				NOT NULL,
	Travel								BIT				NULL		DEFAULT 0,
	TravelStatePreferenceId				INT				NULL,
	ShiftPreferenceTypeId				INT				NOT NULL,
	CallPreference						BIT				NULL		DEFAULT 0,
	GovernmentAssignment				BIT				NULL		DEFAULT 0,
	Compensation						INT				NULL,
	CompensationTypeId					INT				NULL,
	YearsExperience						INT				NULL,
	AdditionalInformation1				VARCHAR(1024)	NULL,
	AdditionalInformation2				VARCHAR(1024)	NULL,
	AdditionalInformation3				VARCHAR(1024)	NULL,
    Lud              					DATETIME        NULL,
    Lub              					INT             NULL,
	CONSTRAINT pkMedicalJobSeekerExtendedInfo PRIMARY KEY CLUSTERED (MedicalJobSeekerExtendedInfoId),
    CONSTRAINT ukMedicalJobSeekerExtendedInfo UNIQUE (MedicalJobSeekerUserId),
    CONSTRAINT fkMedicalJobSeekerExtendedInfoMedicalJobSeekerUserId FOREIGN KEY (MedicalJobSeekerUserId) REFERENCES Users (UserId) ON UPDATE NO ACTION ON DELETE NO ACTION,
    CONSTRAINT fkMedicalJobSeekerExtendedInfoSpecialityTypeId FOREIGN KEY (SpecialityTypeId) REFERENCES EnumSpecialityType (SpecialityTypeId) ON UPDATE NO ACTION ON DELETE NO ACTION,
    CONSTRAINT fkMedicalJobSeekerExtendedInfoJobPreferenceTypeId FOREIGN KEY (JobPreferenceTypeId) REFERENCES EnumJobType (JobTypeId) ON UPDATE NO ACTION ON DELETE NO ACTION,
    CONSTRAINT fkMedicalJobSeekerExtendedInfoTravelStatePreferenceId FOREIGN KEY (TravelStatePreferenceId) REFERENCES EnumUSStatesType (USStatesTypeId) ON UPDATE NO ACTION ON DELETE NO ACTION,
    CONSTRAINT fkMedicalJobSeekerExtendedInfoShiftPreferenceTypeId FOREIGN KEY (ShiftPreferenceTypeId) REFERENCES EnumShiftType (ShiftTypeId) ON UPDATE NO ACTION ON DELETE NO ACTION, 
    CONSTRAINT fkMedicalJobSeekerExtendedInfoCompensationTypeId FOREIGN KEY (CompensationTypeId) REFERENCES EnumCompensationType (CompensationTypeId) ON UPDATE NO ACTION ON DELETE NO ACTION
);
-- End of MedicalJobSeekerExtendedInfo.sql

-- Start of MedicalJobSeekerJobInfo.sql

CREATE TABLE MedicalJobSeekerJobInfo (
	MedicalJobSeekerJobInfoId	INT				AUTO_INCREMENT,
    Title						VARCHAR(512)	NOT NULL,
	Speciality					VARCHAR(512)	NOT NULL,
	Place						VARCHAR(512)	NOT NULL,
	FacilityName				VARCHAR(512)	NOT NULL,
	FacilityTypeId				INT				NOT NULL,
    OrganizationTypeId			INT				NULL,
    FacilitySubTypeId			INT				NULL,
	AssignmentTypeId			INT				NOT NULL,
	AssignmentShiftTypeId		INT				NOT NULL,
	City						VARCHAR(128)	NOT NULL,
	State						VARCHAR(128)	NOT NULL,
    Zip							CHAR(10)			NULL,
	AssignmentFromDate			DATE			NOT NULL,
	AssignmentToDate			DATE			NULL,
	Beds						INT				NULL,
	AvgPatientsInMonth			INT				NULL,
	Peers						INT				NULL,
	Nurses						INT				NULL,
	ORs							INT				NULL,
	Supervised					BIT				NULL,
	Compensation				INT				NULL,
	Travel						BIT				NULL		DEFAULT 0,
	TravelHousingCoverage		BIT				NULL		DEFAULT 0,
    Lud              			DATETIME       NULL,
    Lub              			INT             NULL,
	CONSTRAINT pkMedicalJobSeekerJobInfo PRIMARY KEY CLUSTERED (MedicalJobSeekerJobInfoId),
    CONSTRAINT fkMedicalJobSeekerJobInfoFacilityTypeId FOREIGN KEY (FacilityTypeId) REFERENCES EnumFacilityType (FacilityTypeId) ON UPDATE NO ACTION ON DELETE NO ACTION,
    CONSTRAINT fkMedicalJobSeekerJobInfoAssignmentTypeId FOREIGN KEY (AssignmentTypeId) REFERENCES EnumAssignmentType (AssignmentTypeId) ON UPDATE NO ACTION ON DELETE NO ACTION,
    CONSTRAINT fkMedicalJobSeekerJobInfoAssignmentShiftTypeId FOREIGN KEY (AssignmentShiftTypeId) REFERENCES EnumShiftType (ShiftTypeId) ON UPDATE NO ACTION ON DELETE NO ACTION,
    CONSTRAINT fkMedicalJobSeekerJobInfoOrganizationTypeId FOREIGN KEY (OrganizationTypeId) REFERENCES EnumOrganizationType (OrganizationTypeId) ON UPDATE NO ACTION ON DELETE NO ACTION,
    CONSTRAINT fkMedicalJobSeekerJobInfoFacilitySubTypeId FOREIGN KEY (FacilitySubTypeId) REFERENCES EnumFacilitySubType (FacilitySubTypeId) ON UPDATE NO ACTION ON DELETE NO ACTION
);
-- End of MedicalJobSeekerJobInfo.sql

-- Start of MedicalJobSeekerJobs.sql

CREATE TABLE MedicalJobSeekerJobs (
	MedicalJobSeekerJobId		INT		AUTO_INCREMENT,
	MedicalJobSeekerUserId		INT		NOT NULL,
	MedicalJobSeekerJobInfoId	INT		NOT NULL,
    Lud              			DATETIME       NULL,
    Lub              			INT             NULL,
	CONSTRAINT pkMedicalJobSeekerJobs PRIMARY KEY CLUSTERED (MedicalJobSeekerJobId),
    CONSTRAINT ukMedicalJobSeekerJobs UNIQUE (MedicalJobSeekerUserId, MedicalJobSeekerJobInfoId),
    CONSTRAINT fkMedicalJobSeekerJobsMedicalJobSeekerUserId FOREIGN KEY (MedicalJobSeekerUserId) REFERENCES Users (UserId) ON UPDATE NO ACTION ON DELETE NO ACTION,
    CONSTRAINT fkMedicalJobSeekerJobsMedicalJobSeekerJobInfoId FOREIGN KEY (MedicalJobSeekerJobInfoId) REFERENCES MedicalJobSeekerJobInfo (MedicalJobSeekerJobInfoId) ON UPDATE NO ACTION ON DELETE NO ACTION
);
-- End of MedicalJobSeekerJobs.sql

-- Start of MedicalEmployerExtendedInfo.sql

CREATE TABLE MedicalEmployerExtendedInfo (
	MedicalEmployerExtendedInfoId			INT				AUTO_INCREMENT,
	MedicalEmployerUserId					INT				NOT NULL,
	OrganizationRole						VARCHAR(512)	NULL,
    Address1								VARCHAR(512)	NULL,
    Address2								VARCHAR(512)	NULL,
    City									VARCHAR(128)	NOT NULL,
    State									VARCHAR(128)	NOT NULL,
    Zip										CHAR(10)			NULL,
	Phone									CHAR(10)		NULL,
	MalpracticeCandidateAcceptable			BIT				NULL		DEFAULT 0,
	BoardActionsCandidateAcceptable			BIT				NULL		DEFAULT 0,
	DisciplinaryActionCandidateAcceptable	BIT				NULL		DEFAULT 0,
	JobPreferenceTypeId						INT				NULL,
	GovernmentAssignment					BIT				NULL		DEFAULT 0,
	Beds									INT				NULL,
	AvgPatientsInMonth						INT				NULL,
	Peers									INT				NULL,
	Nurses									INT				NULL,
	ORs										INT				NULL,
	MalpracticeCoverage						BIT				NULL		DEFAULT 0,
	CredentialingCoverage					BIT				NULL		DEFAULT 0,
	LicenseCoverage							BIT				NULL		DEFAULT 0,
	TravelHousingCoverage					BIT				NULL		DEFAULT 0,
    Lud										DATETIME		NULL,
    Lub										INT				NULL,
	CONSTRAINT pkMedicalEmployerExtendedInfo PRIMARY KEY CLUSTERED (MedicalEmployerExtendedInfoId),
    CONSTRAINT ukJobSeekerExtendedInformation UNIQUE (MedicalEmployerUserId),
    CONSTRAINT fkMedicalEmployerExtendedInfoMedicalEmployerUserId FOREIGN KEY (MedicalEmployerUserId) REFERENCES Users (UserId) ON UPDATE NO ACTION ON DELETE NO ACTION,
    CONSTRAINT fkMedicalEmployerExtendedInfoJobPreferenceTypeId FOREIGN KEY (JobPreferenceTypeId) REFERENCES EnumJobType (JobTypeId) ON UPDATE NO ACTION ON DELETE NO ACTION
);
-- End of MedicalEmployerExtendedInfo.sql

-- Start of MedicalEmployerJobPosting.sql

CREATE TABLE MedicalEmployerJobPosting (
	MedicalEmployerJobPostingId		INT				AUTO_INCREMENT,
	MedicalEmployerUserId			INT				NOT NULL,
    Title							VARCHAR(512)	NOT NULL,
	Speciality						VARCHAR(512)	NOT NULL,
	JobDescription					TEXT			NULL,
	AssignmentTypeId				INT				NULL,
	AssignmentShiftTypeId			INT				NULL,
	Supervised						BIT				NULL	DEFAULT 0,
	PrescriptionAuthorityNeeded		BIT				NULL	DEFAULT 0,
	AssignmentFromDate				DATE			NULL,
	AssignmentToDate				DATE			NULL,
	CompensationRange				VARCHAR(128)	NULL,
	Compensation					INT				NULL,
	CompensationTypeId				INT				NULL,
	MalpracticeAccepted				BIT				NULL	DEFAULT 0,
	MalpracticeCoverage				BIT				NULL	DEFAULT 0,
	CredentialingCoverage			BIT				NULL	DEFAULT 0,
	LicenseCoverage					BIT				NULL	DEFAULT 0,
	TravelHousingCoverage			BIT				NULL	DEFAULT 0,
	YearsExperience					INT				NULL,
	Priority1						INT				NULL,
	Priority2						INT				NULL,
	Priority3						INT				NULL,
	Priority4						INT				NULL,
	Priority5						INT				NULL,
	PostedDate						DATE			NULL,
	UpdatedDate						DATE			NULL,
	StatusTypeId					INT				NULL,
	ExpiryDate						DATE			NULL,
    State							VARCHAR(128)	NULL,
    Lud								DATETIME		NULL,
    Lub								INT				NULL,
	CONSTRAINT pkMedicalEmployerJobPosting PRIMARY KEY CLUSTERED (MedicalEmployerJobPostingId),
    CONSTRAINT fkMedicalEmployerJobPostingMedicalEmployerUserId FOREIGN KEY (MedicalEmployerUserId) REFERENCES Users (UserId) ON UPDATE NO ACTION ON DELETE NO ACTION,
    CONSTRAINT fkMedicalEmployerJobPostingAssignmentTypeId FOREIGN KEY (AssignmentTypeId) REFERENCES EnumAssignmentType (AssignmentTypeId) ON UPDATE NO ACTION ON DELETE NO ACTION,
    CONSTRAINT fkMedicalEmployerJobPostingAssignmentShiftTypeId FOREIGN KEY (AssignmentShiftTypeId) REFERENCES EnumShiftType (ShiftTypeId) ON UPDATE NO ACTION ON DELETE NO ACTION,
    CONSTRAINT fkMedicalEmployerJobPostingPriority1 FOREIGN KEY (Priority1) REFERENCES EnumPriorityFeatureType (PriorityFeatureTypeId) ON UPDATE NO ACTION ON DELETE NO ACTION,
    CONSTRAINT fkMedicalEmployerJobPostingPriority2 FOREIGN KEY (Priority2) REFERENCES EnumPriorityFeatureType (PriorityFeatureTypeId) ON UPDATE NO ACTION ON DELETE NO ACTION,
    CONSTRAINT fkMedicalEmployerJobPostingPriority3 FOREIGN KEY (Priority3) REFERENCES EnumPriorityFeatureType (PriorityFeatureTypeId) ON UPDATE NO ACTION ON DELETE NO ACTION,
    CONSTRAINT fkMedicalEmployerJobPostingPriority4 FOREIGN KEY (Priority4) REFERENCES EnumPriorityFeatureType (PriorityFeatureTypeId) ON UPDATE NO ACTION ON DELETE NO ACTION,
    CONSTRAINT fkMedicalEmployerJobPostingPriority5 FOREIGN KEY (Priority5) REFERENCES EnumPriorityFeatureType (PriorityFeatureTypeId) ON UPDATE NO ACTION ON DELETE NO ACTION,
    CONSTRAINT fkMedicalEmployerJobPostingCompensationTypeId FOREIGN KEY (CompensationTypeId) REFERENCES EnumCompensationType (CompensationTypeId) ON UPDATE NO ACTION ON DELETE NO ACTION,
    CONSTRAINT fkMedicalEmployerJobPostingStatusTypeId FOREIGN KEY (StatusTypeId) REFERENCES EnumJobPostingStatusType (JobPostingStatusTypeId) ON UPDATE NO ACTION ON DELETE NO ACTION
);
-- End of MedicalEmployerJobPosting.sql

-- Start of MedicalJobSeekerSavedJobs.sql

CREATE TABLE MedicalJobSeekerSavedJobs (
	MedicalJobSeekerSavedJobId		INT		AUTO_INCREMENT,
	MedicalJobSeekerUserId			INT		NOT NULL,
	MedicalEmployerJobPostingId		INT		NOT NULL,
	SavedDate						DATE	NOT NULL,
    Lud              				DATETIME       NULL,
    Lub              				INT             NULL,
	CONSTRAINT pkMedicalJobSeekerSavedJobs PRIMARY KEY CLUSTERED (MedicalJobSeekerSavedJobId),
    CONSTRAINT ukMedicalJobSeekerSavedJobs UNIQUE (MedicalJobSeekerUserId, MedicalEmployerJobPostingId),
    CONSTRAINT fkMedicalJobSeekerSavedJobsMedicalJobSeekerUserId FOREIGN KEY (MedicalJobSeekerUserId) REFERENCES Users (UserId) ON UPDATE NO ACTION ON DELETE NO ACTION,
    CONSTRAINT fkMedicalJobSeekerSavedJobsMedicalEmployerJobPostingId FOREIGN KEY (MedicalEmployerJobPostingId) REFERENCES MedicalEmployerJobPosting (MedicalEmployerJobPostingId) ON UPDATE NO ACTION ON DELETE NO ACTION
);
-- End of MedicalJobSeekerSavedJobs.sql

-- Start of MedicalJobSeekerJobApplicationInfo.sql

CREATE TABLE MedicalJobSeekerJobApplicationInfo (
	MedicalJobSeekerJobApplicationInfoId		INT		AUTO_INCREMENT,
	MedicalJobSeekerUserId						INT		NOT NULL,
	MedicalEmployerJobPostingId					INT		NOT NULL,
	AppliedDate									DATE	NOT NULL,
	Accepted									BIT		NOT NULL	DEFAULT 0,
	StartDate									DATE	NULL,
	EndDate										DATE	NULL,
	Compensation								INT		NULL,
	CompensationTypeId							INT		NULL,
	JobCompletedAsPerAgreement					BIT		NULL	DEFAULT 0,
	EmployerJobAgreementSignedUserId			INT		NULL,
    Lud              							DATETIME       NULL,
    Lub              							INT             NULL,
	CONSTRAINT pkMedicalJobSeekerJobApplicationInfo PRIMARY KEY CLUSTERED (MedicalJobSeekerJobApplicationInfoId),
    CONSTRAINT ukMedicalJobSeekerJobApplicationInfo UNIQUE (MedicalJobSeekerUserId, MedicalEmployerJobPostingId),
    CONSTRAINT fkMedicalJobSeekerJobApplicationInfoMedicalJobSeekerUserId FOREIGN KEY (MedicalJobSeekerUserId) REFERENCES Users (UserId) ON UPDATE NO ACTION ON DELETE NO ACTION,
    CONSTRAINT fkMedicalJobSeekerJobApplicationInfoMedicalEmployerJobPostingId FOREIGN KEY (MedicalEmployerJobPostingId) REFERENCES MedicalEmployerJobPosting (MedicalEmployerJobPostingId) ON UPDATE NO ACTION ON DELETE NO ACTION,
    CONSTRAINT fkMedicalJobSeekerJobApplicationInfoCompensationTypeId FOREIGN KEY (CompensationTypeId) REFERENCES EnumCompensationType (CompensationTypeId) ON UPDATE NO ACTION ON DELETE NO ACTION,
    CONSTRAINT fkMedicalJobSeekerJobAppInfoEmployerJobAgreementSignedUserId FOREIGN KEY (EmployerJobAgreementSignedUserId) REFERENCES Users (UserId) ON UPDATE NO ACTION ON DELETE NO ACTION
);
-- End of MedicalJobSeekerJobApplicationInfo.sql

-- Start of MedicalJobSeekerStateLevelInfo.sql

CREATE TABLE MedicalJobSeekerStateLevelInfo (
	MedicalJobSeekerStateLevelInfoId	INT			AUTO_INCREMENT,
	MedicalJobSeekerExtendedInfoId		INT			NOT NULL,
	StateId								INT			NOT NULL,
    LicenseExpirationDate              	DATETIME    NULL,
    PrescriptionAuthority              	INT         NULL,
	CONSTRAINT pkMedicalJobSeekerStateLevelInfo PRIMARY KEY CLUSTERED (MedicalJobSeekerStateLevelInfoId),
    CONSTRAINT ukMedicalJobSeekerStateLevelInfo UNIQUE (MedicalJobSeekerExtendedInfoId, StateId),
    CONSTRAINT fkMedicalJobSeekerStateLevelInfoMedicalJobSeekerExtendedInfoId FOREIGN KEY (MedicalJobSeekerExtendedInfoId) REFERENCES MedicalJobSeekerExtendedInfo (MedicalJobSeekerExtendedInfoId) ON UPDATE NO ACTION ON DELETE NO ACTION,
    CONSTRAINT fkMedicalJobSeekerStateLevelInfoStateId FOREIGN KEY (StateId) REFERENCES EnumUSStatesType (USStatesTypeId) ON UPDATE NO ACTION ON DELETE NO ACTION
);
-- End of MedicalJobSeekerStateLevelInfo.sql

-- Start of MedicalJobSeekerSurvey.sql

CREATE TABLE MedicalJobSeekerSurvey (
	MedicalJobSeekerSurveyId		INT		AUTO_INCREMENT,
	MedicalJobSeekerUserId			INT		NOT NULL,
	MedicalEmployerJobPostingId		INT		NOT NULL,
	SatisfactionScore				INT		NOT NULL,
    Lud              				DATETIME       NULL,
    Lub              				INT             NULL,
	CONSTRAINT pkMedicalJobSeekerSurvey PRIMARY KEY CLUSTERED (MedicalJobSeekerSurveyId),
    CONSTRAINT ukMedicalJobSeekerSurvey UNIQUE (MedicalJobSeekerUserId, MedicalEmployerJobPostingId),
    CONSTRAINT fkMedicalJobSeekerSurveyMedicalJobSeekerUserId FOREIGN KEY (MedicalJobSeekerUserId) REFERENCES Users (UserId) ON UPDATE NO ACTION ON DELETE NO ACTION,
    CONSTRAINT fkMedicalJobSeekerSurveyMedicalEmployerJobPostingId FOREIGN KEY (MedicalEmployerJobPostingId) REFERENCES MedicalEmployerJobPosting (MedicalEmployerJobPostingId) ON UPDATE NO ACTION ON DELETE NO ACTION
);
-- End of MedicalJobSeekerSurvey.sql

-- Start of MedicalEmployerSurvey.sql

CREATE TABLE MedicalEmployerSurvey (
	MedicalEmployerSurveyId			INT			AUTO_INCREMENT,
	MedicalEmployerUserId			INT			NOT NULL,
	MedicalEmployerJobPostingId		INT			NOT NULL,
	SatisfactionScore				INT			NOT NULL,
    Lud              				DATETIME    NULL,
    Lub              				INT         NULL,
	CONSTRAINT pkMedicalEmployerSurvey PRIMARY KEY CLUSTERED (MedicalEmployerSurveyId),
    CONSTRAINT ukMedicalEmployerSurvey UNIQUE (MedicalEmployerUserId, MedicalEmployerJobPostingId),
    CONSTRAINT fkMedicalEmployerSurveyMedicalEmployerUserId FOREIGN KEY (MedicalEmployerUserId) REFERENCES Users (UserId) ON UPDATE NO ACTION ON DELETE NO ACTION,
    CONSTRAINT fkMedicalEmployerSurveyMedicalEmployerJobPostingId FOREIGN KEY (MedicalEmployerJobPostingId) REFERENCES MedicalEmployerJobPosting (MedicalEmployerJobPostingId) ON UPDATE NO ACTION ON DELETE NO ACTION
);
-- End of MedicalEmployerSurvey.sql

