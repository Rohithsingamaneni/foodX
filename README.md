# FoodX - Microservices-Based Food Ordering System

## 🚀 Overview
FoodX is a microservices-based food ordering system designed to handle restaurant and menu management efficiently. The project follows **Spring Boot (Java 23)** for backend services and **PostgreSQL with R2DBC** for reactive database management.

### **🔹 Current Features Implemented**
####  **1. Service Registry & API Gateway**
- Implemented **Eureka Server** for service discovery.
- Configured **API Gateway** to route requests to microservices.

####  **2. Restaurant Service**
- **CRUD operations** for managing restaurant details.
- Each restaurant is uniquely identified by name.
- Exposed endpoints via **API Gateway**.

####  **3. Menu Service**
- Each restaurant has a **single menu**, categorized (e.g., Chicken, Veg, Drinks, Desserts).
- **Menu items are unique within a restaurant** but not globally.
- Implemented **Redis caching** for frequently accessed menus.
- Pagination handled using **Reactive Streams**.

### **🔹 API Endpoints**
| Method | Endpoint | Description |
|--------|---------|-------------|
| `POST` | `/restaurants` | Add a new restaurant |
| `GET` | `/restaurants` | Get all restaurants |
| `GET` | `/restaurants/{name}` | Get restaurant details |
| `POST` | `/restaurants/{name}/menus` | Add menu items |
| `GET` | `/restaurants/{name}/menus` | Get all menu items for a restaurant |
| `GET` | `/restaurants/{name}/menus/{category}` | Get menu items by category |
| `PUT` | `/restaurants/{name}/menus/{category}/{item_name}` | Update a menu item |
| `DELETE` | `/restaurants/{name}/menus/{category}/{item_name}` | Delete a menu item |

---

## 🛠️ **Technology Stack**
### **🔹 Backend**
- **Java 23 + Spring Boot** (Microservices Architecture)
- **Spring WebFlux** (Reactive Programming)
- **PostgreSQL + R2DBC** (Non-blocking Database)
- **Redis** (Caching Layer)
- **API Gateway + Eureka** (Service Discovery & Routing)
- **Docker** (Containerization)

---

## 🏗️ **Next Steps**
1️⃣ Implement **order processing service**.
2️⃣ Integrate **user authentication (JWT-based security)**.
3️⃣ Implement **payment gateway integration**.
4️⃣ Enhance **Redis caching strategies** for high-performance queries.

---

## 🏃‍♂️ **How to Run the Project?**
### **1️⃣ Prerequisites**
- Java 23 installed
- PostgreSQL running on `localhost:5432`
- Docker (if needed for MongoDB in future)

### **2️⃣ Steps to Run**
```bash
# Clone the repository
git clone https://github.com/yourusername/foodx.git
cd foodx

# Start the Eureka Server (Service Registry)
cd eureka-server
mvn spring-boot:run

# Start API Gateway
cd ../api-gateway
mvn spring-boot:run

# Start Restaurant Service
cd ../restaurant-service
mvn spring-boot:run

# Start Menu Service
cd ../menu-service
mvn spring-boot:run
```

---

## 📢 **Contributions & Feedback**
The project is **still under development** 🚧, and feedback is always welcome. If you’re interested in contributing or testing, feel free to reach out!

🚀 **Stay tuned for more updates!**

