Mysql Installation and starting the application
------------------------------------------------------------
1. Install mysql and make sure it is running on 3306 port, userName=root and password=root.
2. Run mvn clean install on root folder of project, on successful run it should create default database and tables.
3. Any the above database parameters can be overriden in EncoreDB/src/main/resources/database.properties
   and the same values should be copied to EncoreWebService/src/main/resources/database.properties inorder to run the webservices.