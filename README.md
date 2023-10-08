# Admin System

Welcome to the Admin System Repository! This system allows users to log in and provides administrative capabilities to manage user information (add, delete, update). This project is built using Vue.js for the frontend and Java Spring Boot with MyBatis Plus for the backend functionality. MySQL is used to store data, and Redis serves as a caching mechanism for login data.

## 📋 Table of Contents

- [Prerequisites](#prerequisites)
- [Setup and Installation](#setup-and-installation)
  - [Frontend](#frontend)
  - [Backend](#backend)
- [Running the Application](#running-the-application)
  - [Frontend](#frontend-1)
  - [Backend](#backend-1)
- [Features](#features)

## 🛠 Prerequisites

- Node.js and npm
- Java (JDK)
- MySQL
- Redis

## 🔧 Setup and Installation

### Frontend

1. Navigate to the frontend directory:
   ```bash
   cd path_to_repo/frontend
2. Install the necessary npm packages:
    ```bash
    npm install

### Backend
- Ensure you have a running instance of MySQL and Redis.
- Configure the Spring Boot application properties to point to your MySQL and Redis instances.
- Compile and package your Java Spring Boot application.

## 🚀 Running the Application
### Frontend
1. To start the development server, run:
    ```bash
    npm run dev
### Backend
1. Start your Spring Boot application (the exact command may vary based on your project setup).
2. Download redis and run following command in your terminal:
    ```bash
    redis-server
## 🌟 Features
1. User login
2. Admin capabilities to add, delete, and update user information
3. Display user information in pages
4. Data caching with Redis for efficient login operations