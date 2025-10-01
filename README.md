
ZIDIOConnect - Production-ready Backend (starter)

Features included:
- JWT-based Authentication (register/login)
- Role-based access (STUDENT, RECRUITER, ADMIN)
- Job postings (create/list/get/update/delete)
- Applications (students can apply, recruiters can view)
- File upload (resume upload stored locally)
- Notifications (simple entity)
- Postman collection for testing

Run:
1. Install Java 17+, Maven, and MySQL.
2. Create a database: CREATE DATABASE zidioconnect;
3. Update src/main/resources/application.properties with your MySQL credentials.
4. mvn clean package
5. java -jar target/zidioconnect-1.0.0.jar

Notes:
- JWT secret in properties is base64; replace for production.
- Uploaded files are stored in the 'uploads' folder by default.
