# AVENTRA Tourism Management System

A Java 17 + Maven + MySQL/JDBC command-line application for managing a small tourism startup's customer accounts, destinations, packages and bookings.

## Assignment coverage

This project implements the technical requirements listed in the IIC 1153 group-assignment brief:

| Requirement | Implementation |
|---|---|
| Encapsulation | Private model fields with public getters/setters |
| Abstraction | Abstract `User` and `TourismPackage` base classes |
| Inheritance | `Customer`, `Admin`, `TourGuide`, `AdventurePackage` and `RelaxationPackage` |
| Polymorphism | Overridden role and package-price methods, and base-type references |
| Exception handling | Custom application exceptions; JDBC exceptions wrapped as `DatabaseException`; input validation |
| Collections & Generics | Typed `List<TourismPackage>`, `List<Booking>`, `List<Destination>` collections |
| File handling | `FileAuditLogger` appends booking events to `data/aventra-audit.log` using NIO |
| Interfaces & Packages | `BookingOperations` and `AuditLogger` interfaces; layered `model`, `repository`, `service`, `db`, `util`, and `exception` packages |
| Version control | Follow the Git workflow below; actual commits/branches must be created by your group |

## Main features

- Customer registration and login
- Role-based customer and admin menus
- Browse seeded Sri Lankan destinations and tourism packages
- Create a booking for a future date (1–20 guests)
- View personal booking history and profile
- Booking audit log saved to a local text file
- Input validation and readable error handling
- JDBC resources managed with try-with-resources

## Important group-assignment requirement: startup investigation

The brief requires your group to identify a local startup, interview or discuss its current operational/management problem, and define a solution. Do not claim an interview has happened unless your group has actually conducted it.

Before submission, complete `docs/STARTUP_CASE_STUDY_TEMPLATE.md` with your real startup name, interview date, participant (with permission), problem evidence, and agreed requirements. Adapt the application if the actual startup's problem differs from the example tourism workflow.

## Requirements

- JDK 17 or later
- Apache Maven
- MySQL Server 8 or later

## Database setup

1. Open MySQL Workbench or your MySQL client.
2. Run `database/Aventra.sql`.
3. The script creates `aventra_tourism`, its tables and sample Sri Lankan destinations/packages.
4. Default connection: `jdbc:mysql://localhost:3306/aventra_tourism?useSSL=false&serverTimezone=UTC`, username `root`, password empty.
5. For custom credentials, set environment variables:

```bash
export AVENTRA_DB_URL='jdbc:mysql://localhost:3306/aventra_tourism?useSSL=false&serverTimezone=UTC'
export AVENTRA_DB_USER='root'
export AVENTRA_DB_PASSWORD='your_mysql_password'
```

## Run

From the project root:

```bash
mvn clean compile
mvn exec:java
```

Or open the folder as a Maven project in IntelliJ IDEA and run `com.aventra.Main`.

## Create an admin account

Register a normal account in the application, then promote it in MySQL:

```sql
USE aventra_tourism;
UPDATE users SET role = 'ADMIN' WHERE email = 'your-email@example.com';
```

Log out and log in again to see the admin menu.

## Git/GitHub workflow (complete this with your group)

```bash
git init
git add .
git commit -m "Initial Aventra tourism management system"

git checkout -b feature/booking-audit
# Make and test a change
git add .
git commit -m "Add booking audit file handling"
git checkout main
git merge feature/booking-audit
git remote add origin <your-group-repository-url>
git push -u origin main
git push -u origin feature/booking-audit
```

Each member should make meaningful commits using their own account. Include the real repository URL and contribution/branch evidence in your presentation. Do not fabricate commits or collaboration evidence.

## Submission

The assignment brief specifies `GA_Codes_<GroupNo>.zip` for code and `GA_<GroupNo>.pptx` for the presentation. Rename the final ZIP using your actual group number.

## Detailed package catalogue
The package catalogue now includes category, group limit, difficulty, best season, day-by-day itinerary, accommodation, transport, meals, inclusions and exclusions. Select a package ID to display its full details. Sample prices are illustrative per-person LKR estimates. The updated SQL is intended for a fresh database; back up and migrate an existing schema before importing it.


## Group assignment — six-member task allocation

See [`docs/SIX_MEMBER_TASK_ALLOCATION_AND_GITHUB_GUIDE.md`](docs/SIX_MEMBER_TASK_ALLOCATION_AND_GITHUB_GUIDE.md) for file-level responsibilities, OOP concept evidence, Git branches, commits and Pull Request workflow.
