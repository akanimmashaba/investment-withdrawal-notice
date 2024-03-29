# investment-withdrawal-notice

## 1. Project Description
The Enviro365 Investments Automation System is designed to streamline the withdrawal notice process for investors. Currently, investors must manually download, complete, and email PDF forms to initiate withdrawals, resulting in a time-consuming and error-prone process. The proposed automation system aims to enhance investor experience by providing a user-friendly interface for submitting withdrawal notices.

Features
Investor Management: Keep track of investor information, including personal details, addresses, contacts, and a list of invested products.
Product Management: Manage investment products, including their type (RETIREMENT/SAVINGS), names, and current balances.
Withdrawal Notice Creation: Allow investors to initiate withdrawal notices by selecting a product, specifying the withdrawal amount, dates, and banking details.
Balance Notification: Send investors notifications showing their balance before and after a withdrawal, along with the withdrawn amount.
Validation Rules: Implement validation rules to ensure withdrawal notices comply with business rules (e.g., age check for retirement products, withdrawal amount limits).


## 2. Tech Stack

- Java
- Spring Boot
- Gradle
- Spring Data JPA
- H2 Database (in-memory database)

## 3. Dependencies

List of key dependencies used in the project

- Spring Boot: Latest version
- Spring Data JPA: Latest version
- H2 Database: Latest version


Make sure to check for the latest versions on the respective repositories.

## 4. How to Run the Project

### Prerequisites
- Java 11 or later
- Gradle or Maven installed

### Steps

1. Clone the repository:

   ```bash
   git clone https://github.com/akanimmashaba/investment-withdrawal-notice.git
   cd investment-withdrawal-notice
   ```

2. Build the project:

   ```bash
   ./gradlew build
   ```

   or if using Maven:

   ```bash
   mvn clean install
   ```

3. Run the application:

   ```bash
   ./gradlew bootRun
   ```

   or if using Maven:

   ```bash
   mvn spring-boot:run
   ```

   The application will be accessible at `http://localhost:8080`.

## 5. API Endpoints

### Investor Endpoints

- **GET /api/investors:** Retrieve all investors.
- **GET /api/investors/{id}:** Retrieve a specific investor by ID.
- **POST /api/investors:** Create a new investor.
- **PUT /api/investors/{id}:** Update an existing investor.
- **DELETE /api/investors/{id}:** Delete an investor by ID.

### Product Endpoints

- **GET /api/products:** Retrieve all products.
- **GET /api/products/{id}:** Retrieve a specific product by ID.
- **POST /api/products:** Create a new product.
- **PUT /api/products/{id}:** Update an existing product.
- **DELETE /api/products/{id}:** Delete a product by ID.

### Statement Endpoints

- **GET /api/statements:** Retrieve all statements.
- **GET /api/statements/{id}:** Retrieve a specific statement by ID.
- **POST /api/statements:** Create a new statement.
- **PUT /api/statements/{id}:** Update an existing statement.
- **DELETE /api/statements/{id}:** Delete a statement by ID.

### Withdrawal Endpoints

- **GET /api/withdrawals:** Retrieve all withdrawal notices.
- **GET /api/withdrawals/{id}:** Retrieve a specific withdrawal notice by ID.
- **POST /api/withdrawals:** Create a new withdrawal notice.
- **PUT /api/withdrawals/{id}:** Update an existing withdrawal notice.
- **DELETE /api/withdrawals/{id}:** Delete a withdrawal notice by ID.


### Resources Used
