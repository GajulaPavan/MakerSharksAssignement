# MakerSharksAssignement

Criteria Based Search API

Overview

This project aims to develop a search api which was developed using Java Spring Boot Tool Suite and MySQL where this api returns the values based on the given criteria.

Prerequisites

Ensure you have the following installed:

•	Java 8 or higher
•	MySQL
•	Maven (for building the project)
•	An IDE like IntelliJ IDEA, Eclipse, or VSCode
•	Spring Boot Tool Suite (Preferable)

Setup Instructions

1. Clone the Repository
Clone the project to your local machine:
cd <filedirectory>
git clone https://github.com/GajulaPavan/MakerSharksAssignement.git

2. Import the Project
Using IntelliJ IDEA:

 1.	Open IntelliJ IDEA.
 2.	Go to File -> New -> Project from Existing Sources....
 3.	Navigate to the project directory and select the root folder.
 4.	IntelliJ should automatically detect it as a Maven or Gradle project. Follow the prompts to finish importing.
Using Spring Boot Tool Suite (Eclipse):

 5.	Open Eclipse.
 6.	Go to File -> Import....
 7.	Choose Maven -> Existing Maven Projects and click Next.
 8.	Browse to the project directory and click Finish.
    

3. Configure MySQL Database

To connect your project to the MySQL database:

 1.	Create a MySQL Database:
  o	Open MySQL Workbench or another MySQL client.
  o	Execute the following command to create a new database:
  CREATE DATABASE your_database_name;

 2.	Update MySQL Credentials:
  o	In the project, locate the src/main/resources/application.properties or application.yml file.
  o	Replace the default values with your MySQL credentials:
   spring.datasource.url=jdbc:mysql://localhost:3306/your_database_name 
   spring.datasource.username=your_username
   spring.datasource.password=your_password

4. Build and Run the Application
   Using Maven:
   1. Open a terminal and navigate to the project directory.
   2. Run the following command to build the project:
             mvn clean install
   3. After building, start the application using:
       mvn spring-boot:run
   Using Spring Boot Tool Suite:
   1. Right Click on Imported Project 
   2. In Menu Click on Run As 
   3. Then Click on Spring Boot Application 

5. Access the Application

Once the application is running, open your browser and go to http://localhost:8080 to access the application.

Additional Notes

•	Make sure your MySQL server is running when starting the application.
•	You can customize additional settings in the application.properties or application.yml file as needed.

Curl Command

curl -X POST "http://localhost:8080/api/supplier/query?location=Hyderabad&natureOfBusiness=small_scale&manufacturingProcess=casting&pageNumber=0&pageSize=10&sortBy=supplierId&sortOrder=asc"

