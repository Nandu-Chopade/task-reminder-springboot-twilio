# Task Reminder System with Spring Boot & Twilio

## 📌 Project Description
The **Task Reminder System** is a Spring Boot-based application that allows users to schedule task reminders and send notifications via **WhatsApp** using Twilio API. This system helps users stay on top of their tasks by sending automated reminders at specified times.

## 🚀 Features
- 📝 **Create Tasks** – Users can create tasks with descriptions and reminder times.
- 🔔 **Automated WhatsApp Reminders** – Sends scheduled reminders via Twilio's WhatsApp API.
- 📅 **Task Management** – Retrieve, update, and delete tasks.
- 🛠 **Spring Boot Backend** – Fully developed with RESTful APIs.
- 📑 **Swagger UI** – API documentation and testing directly from the browser.

## 🏗️ Tech Stack
- **Backend:** Spring Boot, Java, Spring Data JPA
- **Database:** MySQL
- **Messaging API:** Twilio (WhatsApp API)
- **Documentation:** Swagger UI

## ⚙️ Setup Instructions
### 1️⃣ Clone the Repository
```sh
$ git clone https://github.com/your-username/task-reminder-springboot-twilio.git
$ cd task-reminder-springboot-twilio
```

### 2️⃣ Configure Twilio Credentials
Create a `.env` file or configure the `application.properties` file:
```properties
# Twilio Configuration
twilio.account.sid=YOUR_TWILIO_ACCOUNT_SID
twilio.auth.token=YOUR_TWILIO_AUTH_TOKEN
twilio.whatsapp.number=whatsapp:+14155238886
```
⚠️ **Do NOT expose your Twilio credentials in a public repository!**

### 3️⃣ Setup MySQL Database
Create a database and configure `application.properties`:
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/task_manager
spring.datasource.username=root
spring.datasource.password=root
spring.jpa.hibernate.ddl-auto=update
spring.jpa.database-platform=org.hibernate.dialect.MySQL8Dialect
```

### 4️⃣ Build & Run the Project
```sh
$ mvn clean install
$ mvn spring-boot:run
```

### 5️⃣ Access API via Swagger
Once the application is running, open:
```
http://localhost:9090/swagger-ui.html
```

## 📩 API Endpoints
| Method | Endpoint | Description |
|--------|---------|-------------|
| `POST` | `/tasks` | Create a new task |
| `GET` | `/tasks/{id}` | Get task details |
| `PUT` | `/tasks/{id}` | Update task |
| `DELETE` | `/tasks/{id}` | Delete task |

## 📌 Example JSON Request for Task Creation
```json
{
    "taskName": "Submit Report",
    "description": "Submit the weekly report to the manager.",
    "reminderTime": "2025-03-26T00:50:22.000",
    "phoneNumber": "whatsapp:+918788776905"
}
```

## 📜 License
This project is **open-source** under the MIT License.

## 🙌 Contributions
Feel free to fork, raise issues, or submit pull requests.

---
🔥 **Developed by [Your Name]** 🚀

