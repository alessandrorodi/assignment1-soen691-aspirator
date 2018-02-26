# assignment1-soen691-aspirator
This is an implementation of Simpirator a simple static code checker based on Aspirator which is described in the research paper ‘Simple Testing Can Prevent Most Critical Failures: An Analysis of Production Failures in Distributed Data-Intensive Systems’ which was presented in 11th USENIX Symposium on  Operating Systems Design and Implementation. Aspirator is a static analyzer tool implemented to help avoid catastrophic failures by performing simple testing on error handling code.

# Binary
This repository contains an IntelliJ project containing the code. The binary is located in assignment1-soen691-aspirator\out\artifacts\assignment1_soen691_aspirator_jar

# Usage:
java -jar assignment1-soen691-aspirator.jar \<path to src or txt file containing a list of files one per line\>

Example output:

`WARNING: Empty catch block, Range: Line 135 - Line 139, File name: ..\..\..\src\test\resources\reactivex\exceptions\CompositeException.java

WARNING: TODO or FIXME in catch, Range: Line 114 - Line 117, File name: ..\..\..\src\test\resources\reactivex\observers\TestObserver.java

WARNING: TODO or FIXME in catch, Range: Line 142 - Line 146, File name: ..\..\..\src\test\resources\reactivex\observers\TestObserver.java

WARNING: TODO or FIXME in catch, Range: Line 375 - Line 379, File name: ..\..\..\src\test\resources\reactivex\plugins\RxJavaPlugins.java

WARNING: TODO or FIXME in catch, Range: Line 161 - Line 164, File name: ..\..\..\src\test\resources\reactivex\subscribers\TestSubscriber.java

WARNING: TODO or FIXME in catch, Range: Line 203 - Line 207, File name: ..\..\..\src\test\resources\reactivex\subscribers\TestSubscriber.java


(i) Number of empty catch blocks: 1

(ii) Number of over-catches with aborts in catch blocks: 0

(iii) Number of TODO/FIXME in catch blocks: 5

(iv) Total number of catch blocks: 348`

Files containing the locations of each type warning will be saved in the logs folder.
