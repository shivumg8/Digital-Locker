# 🗄 Digital Locker Application

This project simulates a simple digital version of a physical locker. Users can:

- 🔒 Create a locker secured with a PIN
- 🔑 Change the PIN of the locker
- 📄 Store documents in the locker (secured by PIN)
- 📂 Retrieve stored documents by entering the correct PIN

All data is stored *in memory* (no database used), making this a lightweight and beginner-friendly Spring Boot + JavaScript project.

---

## 🛠 Tech Stack

- *Backend:* Java, Spring Boot
- *Frontend:* HTML, CSS, JavaScript (Vanilla)
- *Storage:* In-memory Java data struc
- tures (no database)

---

## 📁 Project Structure

digital-locker/
│
├── src/
│ └── main/
│ ├── java/com/example/digitallocker/
│ │ ├── controller/LockerController.java
│ │ ├── model/Locker.java
│ │ └── service/LockerService.java
│
├── static/
│ ├── index.html
│ ├── style.css
│ └── locker.js
│
└── README.md
---

## 🚀 Getting Started

### 🧑‍💻 Prerequisites
- Java 17+
- Maven
- Spring Boot

### ▶ Run the application

1. Clone the repository:

git clone https://github.com/your-username/digital-locker.git
cd digital-locker
Build and run the Spring Boot app:

./mvnw spring-boot:run
Open your browser and navigate to:

http://localhost:8080/index.html
📦 Features
✅ Create Locker
User sets a PIN to create a locker.

Only one locker exists at a time.

🔐 Change PIN
Enter the old PIN to set a new one.

📥 Store Document
Enter a document name and content.

Must enter the correct PIN to store the document.

📤 Retrieve Document
Enter the document name and correct PIN to retrieve it.

🧹 Limitations
Only one locker exists (like a personal vault).

Data is not persistent (resets on server restart).

📄 License
This project is open-source and free to use for learning or development purposes
