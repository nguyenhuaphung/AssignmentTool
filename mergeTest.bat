@echo off
rem %1 target
rem %2 directory containing testcases
rem %3 number of testcases
if exist %1 del %1 
for /L %%v in (1,1,%3) do (

	echo -------------------- >> %1
	echo test %%v >> %1
	more %2\%%v.txt >> %1
	
 )