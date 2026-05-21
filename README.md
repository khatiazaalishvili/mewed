# 🚀 Spring Boot REST API: Social & Dynamic User Management System

![Java](https://img.shields.io/badge/Java-17%2B-orange?logo=openjdk)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.x-brightgreen?logo=springboot)
![Spring Security](https://img.shields.io/badge/Security-JWT_Stateless-blue?logo=springsecurity)
![PostgreSQL](https://img.shields.io/badge/Database-PostgreSQL%20%2F%20MySQL-blue?logo=postgresql)

A robust, enterprise-grade Spring Boot REST API designed with a clean, layered architecture. The application handles core social platform operations (Users, Posts, and Comments) and features seamless integration with a third-party API via OpenFeign, complete with automated database synchronization.

---

## 🏗️ Architectural Layers & Data Flow

The project strictly follows the **Layered Architecture** pattern to enforce a clear separation of concerns:

1. **Controller Layer (`@RestController`):** Handles incoming HTTP requests, enforces request validation, and returns structured DTO responses.
2. **Service Layer (`@Service`):** Contains the core business logic, permissions/access control checks, and transaction handling.
3. **Repository Layer (`@Repository`):** Interfaces with the database using Spring Data JPA / Hibernate.
4. **Security Layer (`Spring Security + JWT`):** A stateless authentication mechanism leveraging a custom filter to intercept requests and validate Bearer tokens.
5. **Exception Handling Layer (`@RestControllerAdvice`):** Intercepts exceptions globally and returns consistent, clean error payloads via `ExceptionBody`.

---

## ✨ Key Features

* **🔒 Stateless JWT Authentication:** Fully customized security workflow featuring a custom `JwtAuthenticationFilter` and `JwtUtil` for token generation and extraction. Includes safe exclusions for public endpoints (Swagger UI, Login).
* **🌐 Third-Party API Integration (OpenFeign):** Interacts dynamically with external remote endpoints (`https://reqres.in/api`).
* **🔄 Automated Lifecycle Synchronization:** * Uses `@PostConstruct` to pull external users on startup, refactor their credentials through Java Streams, and persist them.
  * Uses `@PreDestroy` to systematically purge external mock records from the database upon application shutdown.
* **🛡️ Role-Based Access Control & Ownership Protection:** Distinguishes between `USER` and `ADMIN` profiles. Users can only modify or delete posts/comments they explicitly own, while Administrators possess unconditional data-management privileges.
* **📄 Pagination & Sorting:** Handled efficiently at the database level using `Pageable` and `PageRequest` workflows to minimize network load.
* **📜 Interactive Documentation:** Complete with custom Swagger OpenAPI integration pre-configured to accept Global Bearer Token authorizations.

---

## 🛠️ Technical Stack

* **Core Framework:** Spring Boot (Web, Security, Data JPA)
* **API Client:** Spring Cloud OpenFeign
* **Database Mapping:** Hibernate / JPA (with native DTO-to-Entity Custom Mappers)
* **Data Validation:** Jakarta Validation (`@NotBlank`, `@Size`, `@Pattern`)
* **Utilities & Styling:** Lombok (`@RequiredArgsConstructor`, `@Getter`, `@Setter`)
* **API Documentation:** Springdoc OpenAPI / Swagger UI

---

## 🚀 Getting Started

### Prerequisites
* JDK 17 or higher
* Maven 3.x
* A configured relational database (PostgreSQL / MySQL)

### Installation
1. Clone the repository:
   ```bash
   git clone [https://github.com/khatiazaalishvili/spring-social-api-backend.git](https://github.com/khatiazaalishvili/spring-social-api-backend.git)




   ```markdown
# 🚀 Spring Boot REST API: სოციალური და მომხმარებელთა დინამიური მართვის სისტემა

![Java](https://img.shields.io/badge/Java-17%2B-orange?logo=openjdk)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.x-brightgreen?logo=springboot)
![Spring Security](https://img.shields.io/badge/Security-JWT_Stateless-blue?logo=springsecurity)

ეს არის სრულფასოვანი, ინდუსტრიული სტანდარტების შესაბამისი Spring Boot REST API, რომელიც აგებულია სუფთა სამშრიანი (Layered) არქიტექტურის პრინციპების დაცვით. აპლიკაცია მართავს სოციალური პლატფორმისთვის დამახასიათებელ ბირთვულ პროცესებს (მომხმარებლები, პოსტები, კომენტარები) და ახდენს მონაცემთა სინქრონიზაციას გარე API-სთან OpenFeign კლიენტის გამოყენებით.

---

## 🏗️ არქიტექტურული ფენები

პროექტი მკაცრად მიყვება ფენოვან სტრუქტურას კოდის მაქსიმალური წაკითხვადობისა და მოდულარობისთვის:

1. **კონტროლერები (`@RestController`):** იღებს მომხმარებლის HTTP მოთხოვნებს, ახდენს შემავალი DTO-ების ვალიდაციას და აბრუნებს სტრუქტურირებულ პასუხებს.
2. **სერვისები (`@Service`):** პროექტის "ტვინი", სადაც იწერება მთავარი ბიზნეს ლოგიკა, უფლებების შემოწმება და ტრანზაქციების მართვა.
3. **რეპოზიტორიები (`@Repository`):** ურთიერთქმედებს მონაცემთა ბაზასთან Spring Data JPA-სა და Hibernate-ის მეშვეობით.
4. **უსაფრთხოება (`Spring Security + JWT`):** ახდენს მოთხოვნების გაფილტვრას `JwtAuthenticationFilter`-ით და ამოწმებს Bearer თოკენის ვალიდურობას.
5. **შეცდომების გლობალური დამუშავება (`@RestControllerAdvice`):** იჭერს ნებისმიერ დარღვევას ან ერორს და მომხმარებელს უბრუნებს ერთიან, სუფთა JSON ფორმატს (`ExceptionBody`).

---

## ✨ ძირითადი ფუნქციონალი

* **🔒 უსაფრთხოება (Stateless JWT Authentication):** სრულად მორგებული ავტორიზაციის პროცესი `JwtUtil`-ისა და ფილტრების ბაზაზე. საჯარო ენდპოინტები (Login, Swagger) სრულიად იზოლირებულია დაცული ზონებისგან.
* **🌐 გარე API ინტეგრაცია (OpenFeign):** აპლიკაცია დინამიურად უკავშირდება `https://reqres.in/api` სერვერს RestTemplate-ის ზედმეტი კოდის წერის გარეშე.
* **🔄 ავტომატური სინქრონიზაცია (Lifecycle Management):**
  * `@PostConstruct`-ით აპლიკაციის გაშვებისთანავე იტვირთება გარე მომხმარებლების სია, მუშავდება Java Stream-ებით და ინახება ადგილობრივ ბაზაში.
  * `@PreDestroy`-ით აპლიკაციის გათიშვისას ბაზა ავტომატურად სუფთავდება სატესტო (Reqres) მომხმარებლებისგან.
* **🛡️ უფლებების დიფერენციაცია (RBAC):** სისტემა ყოფს მომხმარებლებს `USER` და `ADMIN` როლებად. ჩვეულებრივ იუზერს აქვს წვდომა მხოლოდ საკუთარ პოსტებზე/კომენტარებზე, ხოლო ადმინისტრატორს აქვს სრული კონტროლი ნებისმიერ მონაცემზე.
* **📄 პაგინაცია და სორტირება (Pagination & Sorting):** მონაცემთა ბაზიდან პოსტებისა და კომენტარების წამოღება ხდება ოპტიმიზებულად `Pageable` არქიტექტურით.
* **📜 ინტერაქტიული Swagger დოკუმენტაცია:** სრულად კონფიგურირებული OpenAPI, რომელიც მხარს უჭერს Global Bearer Token-ით ავტორიზაციას პირდაპირ ბრაუზერიდან ტესტირებისთვის.

---

## 🛠️ ტექნოლოგიური სტეკი

* **მთავარი ფრეიმვორკი:** Spring Boot (Web, Security, Data JPA)
* **API კლიენტი:** Spring Cloud OpenFeign
* **მონაცემთა ვალიდაცია:** Jakarta Validation (`@NotBlank`, `@Size`, `@Pattern`)
* **დამხმარე ბიბლიოთეკები:** Lombok, Java JWT (jjwt)
* **დოკუმენტაცია:** Springdoc OpenAPI / Swagger UI

---
