==============================================================================
                       Readme file for JobAppTracker
          Authors: Justin Park, Chris Hill, Shawn Zhang, Jason You, 
==============================================================================

Important Notes
--------------------------------------
Edit Job Applications
We decided to allow the user to edit existing job applications, which was not part of our original use case scenarios. 
Editing job applications would be useful in case the user makes a mistake when entering data, or if any of the contained 
information changes, such as the location of the job.

Job Application Date
Our original design represented the application date with an integer, but to facilitate better communication with the database, 
we decided to switch to a java.sql.Date object to represent the date. Accepting the time from the user as an integer would have 
required us to parse the value for validity, which the java.sql.Date object lets us avoid.

Sorting Job Applications
We decided to change the use of List.js for the PrimeFaces framework for sorting the table elements. 
Using the PrimeFaces framework, we longer needed the JobAppController class to have a sort method. 
Instead, the sort is handled on the html page through the PrimeFaces sortBy expression.

Error Handling
If the user hits save or cancel on an incomplete form, error messages are shown notifying the user of the incomplete fields 
while the completed fields are saved. When the user tries to re-create the form, the uncompleted fields are shown in 
red while any completely fields are filled in.

How To Use
--------------------------------------
The four use cases we implemented are:
    Adding job applications
    Removing job applications
    Displaying job applications
    Edit job applications

This project was developed using the NetBeans IDE and the GlassFish server with the database connected to a MySQL server.

Check that the MySQL server is running and that the database is connected.
First run the sql script located in the web/resources directory to set up the database table. Choose the jdbc:mysql and not the
jdbc:derby option.
Clean and build the project. If you see a dialog about build.properties from another NetBeans installion,
you will need to click update and restart the NetBeans IDE.
Right click the project directory and go to properties. Select Run under the Categories on the left. Choose Chrome as the browser.
Then you can deploy and run the project.

Running The Tests
--------------------------------------
Unit Tests
Located in
    test/com/mycompany/entityclasses 
    test/com/mycompany/jsfclasses 
directories.

Build the project before running the unit tests.

System Tests
Located in
    test/com/mycompany/it

*** Currently only available for windows and linux. ***
Make sure Google Chrome is installed and that the version number is greater than 56.0.2884.0.
Build the project and deploy/run the project before running the tests.
Running these test files will automate the use case scenarios with the chrome driver and checks that the results are as expected.
