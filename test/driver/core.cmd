set QA=https://test.kuali.org/svn/student/deploymentlab/branches/1.0.0.x/core
set DEV=https://test.kuali.org/svn/student/ks-core/branches/ks-core-1.0.0-m4
call removeThenCopy %QA% %DEV% ks-common-impl
call removeThenCopy %QA% %DEV% ks-common-test
call removeThenCopy %QA% %DEV% ks-common-ui
call removeThenCopy %QA% %DEV% ks-common-util
call removeThenCopy %QA% %DEV% ks-core-api
call removeThenCopy %QA% %DEV% ks-core-impl
call removeThenCopy %QA% %DEV% ks-core-ui
