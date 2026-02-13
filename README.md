# Gym Management System

This is a **Java Web Application** created using **JSP, Servlets, and Oracle Database**. It allows users to manage gym member records by adding, viewing specific records, and viewing all stored records. This project follows the MVC architecture and demonstrates core concepts of Java web development with database integration.



## 🧾 **Project Overview**

The Gym Management System provides a simple interface to perform the following functions:

- Add a new gym member record
- View details of a specific member by name and joining date
- View all stored member records
- Validate inputs and handle errors appropriately

This system is designed as a part of academic coursework and follows the specifications provided for assessment.



## 🗂 **Technologies Used**

The project is built using the following technologies:

- **Java** – Programming language
- **JSP (JavaServer Pages)** – For dynamic webpage content
- **Servlets** – To control application logic
- **Oracle Database (SQL\*Plus)** – To store and manage data
- **Tomcat Server** – To deploy and run the web application
- **Eclipse IDE** – For development



## 📁 **Package Structure**

The source code is organized into the following packages:

- `com.wipro.gym.util` – Utility and database connection classes
- `com.wipro.gym.bean` – Java Bean class to represent a member record
- `com.wipro.gym.dao` – Data Access Object for database operations
- `com.wipro.gym.service` – Business logic and validations
- `com.wipro.gym.servlets` – Servlet controller



## 🖥️ **Features**

### ➤ Add Member Record
Users can insert a new member’s details including:
- Name
- Membership type
- Joining date
- Duration in months
- Fees paid
- Remarks

The system validates member name length, future date restrictions, and duplicates.



### ➤ View Specific Member Record
Users can search for a record by entering:
- Member name
- Joining date

If found, it shows all details. Otherwise, it displays an appropriate message.


### ➤ View All Member Records
Users can display a list of all currently stored members in the database. If no records exist, an informative message is shown.

<img width="422" height="248" alt="Screenshot 2026-02-13 214847" src="https://github.com/user-attachments/assets/3ecbc4ef-34ea-4dc5-adbf-2e55246f5dc9" />

<img width="319" height="431" alt="Screenshot 2026-02-13 214934" src="https://github.com/user-attachments/assets/c27d077d-e550-4663-a621-6d67ddeaa349" />

<img width="318" height="588" alt="Screenshot 2026-02-13 214840" src="https://github.com/user-attachments/assets/05f413fd-36fb-45f9-98b6-6456712fc746" />

