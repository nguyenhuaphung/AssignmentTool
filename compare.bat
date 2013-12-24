@echo off
for /L %%v in (%3,1,%4) do (
	echo %%v
	fc %1\%%v.txt %2\%%v.txt
)
