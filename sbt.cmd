set SCRIPT_DIR=%~dp0
java %SBT_OPTS% -Dfile.encoding=UTF-8 -Xss4M -Xmx1024M -XX:MaxPermSize=256M -jar "%SCRIPT_DIR%sbt-launch-0.7.4.jar" @sbt.boot.properties %*
