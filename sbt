#!/bin/bash

java $SBT_OPTS -Dfile.encoding=UTF-8 -Xss4M -Xmx1024M -XX:MaxPermSize=256M -jar `dirname $0`/sbt-launch-0.7.4.jar @sbt.boot.properties "$@"
