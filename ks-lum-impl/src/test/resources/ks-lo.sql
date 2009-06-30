// RichText
INSERT INTO KS_RICH_TEXT_T (ID, FORMATTED, PLAIN) VALUES ('RICHTEXT-9', '<p>Desc</p>', 'Desc')
INSERT INTO KS_RICH_TEXT_T (ID, FORMATTED, PLAIN) VALUES ('RICHTEXT-10', '<p>Learning Objectives maintained generally for Florida State University. These are distinct from those maintained in a particular subject area or by a particular department.</p>', 'Learning Objectives maintained generally for Florida State University. These are distinct from those maintained in a particular subject area or by a particular department.')
INSERT INTO KS_RICH_TEXT_T (ID, FORMATTED, PLAIN) VALUES ('RICHTEXT-11', '<p>Default Learning Objective type</p>', 'Default Learning Objective type')
INSERT INTO KS_RICH_TEXT_T (ID, FORMATTED, PLAIN) VALUES ('RICHTEXT-12', '<p>Basic Learning Objective type</p>', 'Basic Learning Objective type')
INSERT INTO KS_RICH_TEXT_T (ID, FORMATTED, PLAIN) VALUES ('RICHTEXT-13', '<p>Advanced Learning Objective type</p>', 'Advanced Learning Objective type')
INSERT INTO KS_RICH_TEXT_T (ID, FORMATTED, PLAIN) VALUES ('RICHTEXT-14', 'The ability to use sensory cues to ...', 'The ability to use sensory cues to guide motor activity.  This ranges from sensory stimulation, through cue selection, to translation.')
INSERT INTO KS_RICH_TEXT_T (ID, FORMATTED, PLAIN) VALUES ('RICHTEXT-15', '<p>Create Wiki</p>', 'Create Wiki')
INSERT INTO KS_RICH_TEXT_T (ID, FORMATTED, PLAIN) VALUES ('RICHTEXT-16', '<p>Update Wiki</p>', 'Update Wiki')
INSERT INTO KS_RICH_TEXT_T (ID, FORMATTED, PLAIN) VALUES ('RICHTEXT-17', '<p>Modify Wiki</p>', 'Modify Wiki')

// LoType
INSERT INTO KSLU_LO_TYPE (ID, NAME, DESCR, EFF_DT, EXPIR_DT, VERSIONIND) VALUES ('loType.default', 'Default','Default type of learning objective.', {ts '2008-01-01 00:00:00.0'}, {ts '2010-01-01 00:00:00.0'},1)

// LoHierarchy
INSERT INTO KSLU_LO_HIRCHY (ID, NAME, RT_DESCR_ID, EFF_DT, EXPIR_DT, VERSIONIND) VALUES ('loHierarchy.fsu', 'FSU', 'RICHTEXT-10', {ts '2008-01-01 00:00:00.0'}, {ts '2010-01-01 00:00:00.0'},1)
INSERT INTO KSLU_LO_HIRCHY (ID, NAME, RT_DESCR_ID, EFF_DT, EXPIR_DT, VERSIONIND) VALUES ('loHierarchy.kualiproject.common', 'Kuali', 'RICHTEXT-9', {ts '2008-01-01 00:00:00.0'}, {ts '2010-01-01 00:00:00.0'},1)

// LoCategory
INSERT INTO KSLU_LO_CATEGORY (ID, NAME, RT_DESCR_ID, LOHIRCHY_ID, EFF_DT, EXPIR_DT, VERSIONIND) VALUES ('550e8400-e29b-41d4-a716-446655440000', 'Perception', 'RICHTEXT-14', 'loHierarchy.kualiproject.common', {ts '2008-01-01 00:00:00.0'}, {ts '2010-01-01 00:00:00.0'},1)
INSERT INTO KSLU_LO_CATEGORY (ID, NAME, RT_DESCR_ID, LOHIRCHY_ID, EFF_DT, EXPIR_DT, VERSIONIND) VALUES ('054CAA88-C21D-4496-8287-36A311A11D68', 'Test Category 2', 'RICHTEXT-9', 'loHierarchy.fsu', {ts '2008-01-01 00:00:00.0'}, {ts '2010-01-01 00:00:00.0'},1)
INSERT INTO KSLU_LO_CATEGORY (ID, NAME, RT_DESCR_ID, LOHIRCHY_ID, EFF_DT, EXPIR_DT, VERSIONIND) VALUES ('162979A3-25B9-4921-BC8F-C861B2267A73', 'Test Category 3', 'RICHTEXT-9', 'loHierarchy.fsu', {ts '2008-01-01 00:00:00.0'}, {ts '2010-01-01 00:00:00.0'},1)
INSERT INTO KSLU_LO_CATEGORY (ID, NAME, RT_DESCR_ID, LOHIRCHY_ID, EFF_DT, EXPIR_DT, VERSIONIND) VALUES ('7114D2A4-F66D-4D3A-9D41-A7AA4299C797', 'Test Category 4', 'RICHTEXT-9', 'loHierarchy.kualiproject.common', {ts '2008-01-01 00:00:00.0'}, {ts '2010-01-01 00:00:00.0'},1)

// Lo 
INSERT INTO KSLU_LO (ID, NAME, RT_DESCR_ID, LOHIRCHY_ID, EFF_DT, EXPIR_DT, LOTYPE_ID, ST, VERSIONIND) VALUES ('81ABEA67-3BCC-4088-8348-E265F3670145', 'Edit Wiki Message Structure', 'RICHTEXT-9', 'loHierarchy.fsu', {ts '2008-01-01 00:00:00.0'}, {ts '2010-01-01 00:00:00.0'}, 'loType.default', 'Active', 1)
INSERT INTO KSLU_LO (ID, NAME, RT_DESCR_ID, LOHIRCHY_ID, EFF_DT, EXPIR_DT, LOTYPE_ID, ST, VERSIONIND) VALUES ('E0B456B2-62CB-4BD3-8867-A0D59FD8F2CF', 'Navigate Wiki', 'RICHTEXT-12', 'loHierarchy.fsu', {ts '2008-01-01 00:00:00.0'}, {ts '2010-01-01 00:00:00.0'}, 'loType.default', 'Active', 1)
INSERT INTO KSLU_LO (ID, NAME, RT_DESCR_ID, LOHIRCHY_ID, EFF_DT, EXPIR_DT, LOTYPE_ID, ST, VERSIONIND) VALUES ('DD0658D2-FDC9-48FA-9578-67A2CE53BF8A', 'Install Wiki Engine', 'RICHTEXT-13', 'loHierarchy.fsu', {ts '2008-01-01 00:00:00.0'}, {ts '2010-01-01 00:00:00.0'}, 'loType.default', 'Active', 1)
INSERT INTO KSLU_LO (ID, NAME, RT_DESCR_ID, LOHIRCHY_ID, EFF_DT, EXPIR_DT, LOTYPE_ID, ST, VERSIONIND) VALUES ('ABD8AE21-34E9-4858-A714-B04134F55D68', 'Create Wiki', 'RICHTEXT-15', 'loHierarchy.fsu', {ts '2008-01-01 00:00:00.0'}, {ts '2010-01-01 00:00:00.0'}, 'loType.default', 'Active', 1)
INSERT INTO KSLU_LO (ID, NAME, RT_DESCR_ID, LOHIRCHY_ID, EFF_DT, EXPIR_DT, LOTYPE_ID, ST, VERSIONIND) VALUES ('E0619A90-66D6-4AF4-B357-E73AE44F7E88', 'Update Wiki', 'RICHTEXT-16', 'loHierarchy.fsu', {ts '2008-01-01 00:00:00.0'}, {ts '2010-01-01 00:00:00.0'}, 'loType.default', 'Active', 1)
INSERT INTO KSLU_LO (ID, NAME, RT_DESCR_ID, LOHIRCHY_ID, EFF_DT, EXPIR_DT, LOTYPE_ID, ST, VERSIONIND) VALUES ('7BCD7C0E-3E6B-4527-AC55-254C58CECC22', 'Modify Wiki', 'RICHTEXT-17', 'loHierarchy.kualiproject.common', {ts '2008-01-01 00:00:00.0'}, {ts '2010-01-01 00:00:00.0'}, 'loType.default', 'Active', 1)

// Lo-Lo LoHierarchy relation join table
INSERT INTO KSLU_LO_LO_HIRCHY_RELTN (PARENT_LO_ID, CHILD_LO_ID) VALUES ('81ABEA67-3BCC-4088-8348-E265F3670145', 'E0B456B2-62CB-4BD3-8867-A0D59FD8F2CF')
INSERT INTO KSLU_LO_LO_HIRCHY_RELTN (PARENT_LO_ID, CHILD_LO_ID) VALUES ('81ABEA67-3BCC-4088-8348-E265F3670145', 'DD0658D2-FDC9-48FA-9578-67A2CE53BF8A')
INSERT INTO KSLU_LO_LO_HIRCHY_RELTN (PARENT_LO_ID, CHILD_LO_ID) VALUES ('E0B456B2-62CB-4BD3-8867-A0D59FD8F2CF', 'ABD8AE21-34E9-4858-A714-B04134F55D68')
INSERT INTO KSLU_LO_LO_HIRCHY_RELTN (PARENT_LO_ID, CHILD_LO_ID) VALUES ('DD0658D2-FDC9-48FA-9578-67A2CE53BF8A', 'ABD8AE21-34E9-4858-A714-B04134F55D68')

// Lo-Lo equivalence relation join table
INSERT INTO KSLU_LO_LO_EQUIV_RELTN (LO_ID, EQUIV_LO_ID) VALUES ('E0619A90-66D6-4AF4-B357-E73AE44F7E88', '81ABEA67-3BCC-4088-8348-E265F3670145')
INSERT INTO KSLU_LO_LO_EQUIV_RELTN (LO_ID, EQUIV_LO_ID) VALUES ('ABD8AE21-34E9-4858-A714-B04134F55D68', 'DD0658D2-FDC9-48FA-9578-67A2CE53BF8A')
