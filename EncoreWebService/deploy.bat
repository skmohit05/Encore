@ECHO OFF
REM once mvn clean intall is complete, this batch file can be run to deploy the build folder to VM
REM deploy [key path]
IF "%1"=="" GOTO :HAVE_0

@ECHO ON
ssh -i %1 ubuntu@locums.encoretime.co "sudo systemctl stop encoreapp"
scp -i %1 target/encore-webservice-2020.1-SNAPSHOT.jar ubuntu@locums.encoretime.co:/data/encoreapp
ssh -i %1 ubuntu@locums.encoretime.co "sudo systemctl start encoreapp"
@ECHO OFF
GOTO :END

:HAVE_0
ECHO "Arguments missing. deploy [keyPath]"

:END