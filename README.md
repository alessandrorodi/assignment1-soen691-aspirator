# assignment1-soen691-aspirator
This is an implementation of Simpirator a simple static code checker based on Aspirator which is described in the research paper ‘Simple Testing Can Prevent Most Critical Failures: An Analysis of Production Failures in Distributed Data-Intensive Systems’ which was presented in 11th USENIX Symposium on  Operating Systems Design and Implementation. Aspirator is a static analyzer tool implemented to help avoid catastrophic failures by performing simple testing on error handling code.

This repository contains an IntelliJ project containing the code.

Usage:
java -jar tool.jar <path to src or txt file containing a list of files one per line>

Example output:
(i) Number of empty catch blocks: 20
(ii) Number of over-catches with aborts in catch blocks: 0
(iii) Number of TODO/FIXME in catch blocks: 4
(iv) Total number of catch blocks: 348

Files containinng locations of each type will be in the logs folder.
