# Software Requirements Specification (SRS)
## Salone Ducks Document Application System
### Version 0.1

---

## 1. Introduction

### 1.1 Purpose
Salone Ducks is a digital document application and management system designed to enable Sierra Leonean citizens to apply for national documents (National ID Card, Passport, and Driver's License) online without requiring login or account creation.

The system aims to:
- Reduce the need for citizens to visit government offices in person
- Streamline the document application process
- Provide real-time application tracking and management
- Keep citizens informed about government news and services

### 1.2 Scope
The system provides:
- Online application submission for 3 document types
- Photo capture and upload functionality
- Real-time application preview
- Application tracking using Application ID
- Application update and deletion within 5 days
- News and updates with filtering
- Service center information and directions
- Contact support form
- Email subscription for updates

### 1.3 Definitions and Acronyms

| Term | Definition |
|------|------------|
| **Salone** | Colloquial term for Sierra Leone |
| **Application ID** | Unique identifier generated for each application |
| **NFR** | Non-Functional Requirement |
| **FURPS** | Functionality, Usability, Reliability, Performance, Supportability |
| **MoSCoW** | Must Have, Should Have, Could Have, Won't Have |
| **SRS** | Software Requirements Specification |
| **GUI** | Graphical User Interface |

---

## 2. Overall Description

### 2.1 Product Perspective
Salone Ducks is a self-contained web application that operates in a browser environment. It uses:
- Client-side storage (localStorage) for data persistence
- Device camera API for photo capture
- No server-side components (currently a static site)

The system interfaces with:
- **Users:** Citizens applying for documents
- **Service Centers:** Physical locations for document collection
- **Email Service:** Confirmation emails to users
- **Google Maps:** Directions to service centers

### 2.2 User Characteristics

| User Type | Description | Technical Level | Frequency |
|-----------|-------------|-----------------|-----------|
| **Citizen Applicant** | Sierra Leonean citizen applying for documents | Low to Medium | One-time or occasional |
| **News Subscriber** | Citizen receiving news updates | Low | Ongoing |
| **Service Center Staff** | (Future) Backend operators | Medium | Daily |

### 2.3 Operating Environment
- **Platform:** Web browser (Chrome, Firefox, Safari, Edge)
- **Mobile:** Android 10+, iOS 14+
- **Network:** Internet connection required for email confirmation
- **Hardware:** Camera required for photo capture (optional, file upload fallback available)
- **Storage:** Browser localStorage for data persistence

### 2.4 Assumptions and Dependencies
- Users have internet access to submit applications
- Users have a valid email address for confirmation
- Users are Sierra Leonean citizens
- Service centers exist at the listed locations
- Payment processing is handled externally (Orange Money/Afrimoney)

---

## 3. System Features

### 3.1 Feature: Document Application Submission
**User Stories:** US-01, US-02, US-06, US-07, US-14
**Use Cases:** UC-01, UC-02, UC-06, UC-07, UC-14

**Description:** Users can submit applications for National ID, Passport, or Driver's License by filling out a form. The system validates inputs, captures photos, and generates a unique Application ID.

**Functional Requirements:**
- F-01: Form validation for all required fields
- F-02: Age validation for Driver's License
- F-03: Photo upload and capture
- F-04: Unique Application ID generation
- F-05: Email confirmation with Application ID

### 3.2 Feature: Application Management
**User Stories:** US-03, US-04, US-05
**Use Cases:** UC-03, UC-04, UC-05

**Description:** Users can track, update, or delete their applications using their Application ID within 5 days of submission.

**Functional Requirements:**
- F-06: Application tracking by ID
- F-07: Application update within 5 days
- F-08: Application deletion within 5 days

### 3.3 Feature: News and Updates
**User Stories:** US-08, US-09
**Use Cases:** UC-08, UC-09

**Description:** Users can view news articles, filter by category, and subscribe to email updates.

**Functional Requirements:**
- F-09: Display news articles with categories
- F-10: Filter news by category
- F-11: Email subscription

### 3.4 Feature: Service Information
**User Stories:** US-10, US-11, US-12
**Use Cases:** UC-10, UC-11, UC-12

**Description:** Users can view service center details, get directions, and contact support.

**Functional Requirements:**
- F-12: Display service center information
- F-13: Google Maps integration for directions
- F-14: Contact form for support

### 3.5 Feature: Weather and Time
**User Stories:** US-13
**Use Cases:** UC-13

**Description:** Users can view current time and weather information.

**Functional Requirements:**
- F-15: Real-time clock display
- F-16: Weather information display

---

## 4. External Interface Requirements

### 4.1 User Interfaces
- **Home Page:** Hero section, document services, steps, latest news, FAQ
- **Application Page:** Form with live preview, camera capture, application tracker
- **News Page:** Filterable news feed, subscribe widget, weather widget
- **Contact Page:** Contact form, office details, service centers, map

### 4.2 Hardware Interfaces
- **Camera:** Used for live photo capture (requires user permission)
- **Storage:** Browser localStorage for data persistence

### 4.3 Software Interfaces
- **Google Maps API:** For directions to service centers
- **Email Service:** For confirmation emails (simulated)
- **OpenWeatherMap API:** For weather information (placeholder)

### 4.4 Communication Interfaces
- **HTTPS:** All data transmitted over secure connection
- **Email:** Confirmation and notification communication
- **WebRTC:** Camera access for photo capture

---

## 5. Non-Functional Requirements

### 5.1 Functionality (Security)

| ID | Requirement |
|----|-------------|
| F-01 | Form validation with clear error messages |
| F-02 | Age validation for Driver's License (minimum 18 years) |
| F-03 | Photo upload validation (JPG/PNG, <5MB) |
| F-04 | Unique Application ID generation |
| F-05 | SSL/HTTPS encryption |

### 5.2 Usability

| ID | Requirement |
|----|-------------|
| U-01 | Camera starts within 2 seconds |
| U-02 | Live preview updates within 500ms |
| U-03 | News filtering within 200ms |
| U-04 | Mobile responsive (320px - 1920px) |
| U-05 | Clear error messages |
| U-06 | WCAG 2.1 Level AA accessibility |

### 5.3 Reliability

| ID | Requirement |
|----|-------------|
| R-01 | Data persistence across sessions |
| R-02 | Email confirmation within 1 minute |
| R-03 | Form state preservation for 7 days |
| R-04 | Camera failure fallback to upload |
| R-05 | 99.9% system availability |

### 5.4 Performance

| ID | Requirement |
|----|-------------|
| P-01 | Form submission under 3 seconds |
| P-02 | Camera startup under 2 seconds |
| P-03 | Application tracking under 1 second |
| P-04 | Preview updates under 500ms |
| P-05 | Page load under 3 seconds |
| P-06 | Slideshow transitions under 200ms |
| P-07 | Supports 100 concurrent users |

### 5.5 Supportability

| ID | Requirement |
|----|-------------|
| S-01 | Cross-browser compatibility |
| S-02 | Mobile browser compatibility |
| S-03 | Offline fallback |
| S-04 | Data backup and recovery |
| S-05 | Code maintainability |
| S-06 | WCAG 2.1 Level AA compliance |
| S-07 | 90% device compatibility for camera |
| S-08 | Supports 10,000 applications |

---

## 6. Appendix

### 6.1 Glossary

| Term | Definition |
|------|------------|
| **Salone Ducks** | Government document portal |
| **Application ID** | Unique identifier for each application |
| **Service Center** | Physical location for document collection |
| **Orange Money** | Mobile money service in Sierra Leone |
| **Afrimoney** | Mobile money service in Sierra Leone |
| **LocalStorage** | Browser storage API for data persistence |

### 6.2 References
- Lecture 2: Requirements Engineering I
- Lecture 3: Requirements Engineering II
- Lecture 4: Architecture & Design Principles
- Lecture 5: Design Patterns

### 6.3 Document Change Log

| Version | Date | Author | Changes |
|---------|------|--------|---------|
| 0.1 | 2026-06-16 | [Student Name] | Initial draft |
