rem %1 target
rem %2 number of test
rem %3 directory of test cases
rem %4 directory of solutions
@echo off
if exist %1 del %1
for /L %%v in (1,1,%2) do (
	echo -------------------- >> %1
	echo test %%v >> %1
 	<nul (set/p=//) >> %1
	more %4\%%v.txt >> %1
rem	more %4\e%%v.txt >> %1
	more %3\%%v.txt >> %1	
).