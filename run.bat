@echo off
title MarauderScape Run
"C:\Program Files\Java\jdk1.8.0_25\bin\java.exe" -Xmx800m -cp bin;deps/poi.jar;deps/mysql.jar;deps/mina.jar;deps/slf4j.jar;deps/slf4j-nop.jar;deps/jython.jar;log4j-1.2.15.jar; server.Server
pause