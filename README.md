# Bank-app

Bank-app is a Java-based banking application for financial management. It provides a graphical user interface (GUI) for managing accounts, users, and banking operations, including deposits, withdrawals, investments, and account statements.

## 🚀 Features

- User authentication (login)
- Account creation (current and savings)
- User management (create, delete users)
- Account management (deposit, withdraw, invest, view statements)
- View active accounts
- Logging of user actions
- MySQL database integration

## 🔧 Technologies

- Java (Swing for GUI)
- MySQL (database)
- Maven (build tool)
- JDBC (database connectivity)
- Logging (Java Util Logging)

## 🏗️ Setup

1. **Clone the repository**  
   `git clone <your-repo-url>`

2. **Configure the database**  
   - Use the provided [`sql_command.sql`] to create and initialize the MySQL database.
   - Update database credentials in [`bankapp.database.Database`] if needed.

3. **Build the project**  
   - Navigate to the `bank-app` directory.
   - Run:  
     `mvn clean install`

4. **Run the application**  
   - Execute the main class:  
     `java -cp target/classes bankapp.App`

## 🟢 Usage

- Login with your credentials.
- Manage accounts and users through the GUI.
- Perform banking operations and view logs in `program.log`.

## 🗂️ Folder Structure

- `src/main/java/bankapp/` - Source code
- `src/main/java/bankapp/views/` - GUI components
- `src/main/java/bankapp/controllers/` - Application controllers
- `src/main/java/bankapp/models/` - Data models
- `src/main/java/bankapp/database/` - Database integration
- `sql_command.sql` - SQL script for database setup

## 📝 License

This project is for educational purposes.
