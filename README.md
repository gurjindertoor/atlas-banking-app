# Atlas Banking App

The Atlas Banking App is a bank simulation project built using Java, Swing, and MySQL. The system manages various banking activities allowing you to experience a streamlined banking process.

## Project Setup

To run this project, you need to have Java and MySQL installed on your machine. In addition, you also need a MySQL Workbench where you can create and manage your databases.

### Pre-Requisites

- JDK (Java Development Kit)
- MySQL
- MySQL Workbench

### Steps to Run the Project

1. **Clone the Repository**: Start by cloning this repository to your local machine. 

2. **Set Up MySQL**: Once cloned, set up your MySQL server. If you don't have it installed, you can download it from [MySQL's official site](https://dev.mysql.com/downloads/mysql/).

3. **Create the Database**: Open the MySQL Workbench and create a new database named `bankmanagementsystem`.

4. **Database Connection**: In the project files, navigate to the `Conn.java` file inside the `bankmanagementsystem` package. This file contains the logic for database connection. Replace the first "root" with your MySQL username and the second "root" with your MySQL password.

Here is the code snippet you need to change:

```java
c = DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem", "root", "root");
```

5. **Build and Run**: Finally, you can build and run the project.

## Features

The Atlas Banking App is designed with several features to give users a realistic banking experience. These include:

- Opening a new bank account
- Depositing money into the account
- Withdrawing money from the account
- Transferring money to other accounts
- Checking account details
- Checking transaction history
- and many more...

## Contribution

Feel free to contribute to this project. Any contributions you make are greatly appreciated.

## Issues

If you encounter any issues or have questions about the project, please open an issue. We will do our best to help.

## License

This project is licensed under the MIT License. See `LICENSE` for more information.
