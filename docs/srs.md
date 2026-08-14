# Software Requirements Specification (SRS)
## Salone Ducks Document Application System
### Version 1.0

---

## 1. Introduction

### 1.1 Purpose
Salone Ducks is a digital document application system for Sierra Leone citizens to apply for National ID, Passport, and Driver's License online without requiring login.

### 1.2 Scope
The system provides:
- Online application submission for 3 document types
- Photo capture and upload
- Real-time application preview
- Application tracking, update, and deletion
- News with filtering
- Contact support

### 1.3 Definitions

| Term | Definition |
|------|------------|
| Salone | Colloquial term for Sierra Leone |
| Application ID | Unique identifier for each application |
| MoSCoW | Must Have, Should Have, Could Have, Won't Have |
| FURPS | Functionality, Usability, Reliability, Performance, Supportability |

---

## 2. Overall Description

### 2.1 Product Perspective
Salone Ducks is a self-contained web application using:
- Client-side storage (localStorage) for data persistence
- Device camera API for photo capture
- No server-side components

### 2.2 User Characteristics

| User Type | Description | Technical Level |
|-----------|-------------|-----------------|
| Citizen Applicant | Sierra Leonean applying for documents | Low to Medium |
| News Subscriber | Citizen receiving news updates | Low |

### 2.3 Operating Environment
- Platform: Web browser (Chrome, Firefox, Safari, Edge)
- Mobile: Android 10+, iOS 14+
- Hardware: Camera optional (file upload fallback)
- Storage: Browser localStorage

---

## 3. System Features

### 3.1 Document Application Submission
**User Stories:** US-01, US-02, US-06
- Submit applications for National ID, Passport, or Driver's License
- Capture or upload photo
- Live preview before submission

### 3.2 Application Management
**User Stories:** US-03, US-04, US-05
- Track application by ID
- Update application within 5 days
- Delete application within 5 days

### 3.3 User Assistance
**User Stories:** US-07, US-08, US-09, US-10
- Age validation for Driver's License
- Subscribe to news updates
- Filter news by category
- Contact support

---

## 4. Non-Functional Requirements

### 4.1 Functionality
- F-01: Form validation with clear error messages
- F-02: Age validation (minimum 18 for Driver's License)
- F-03: Photo validation (JPG/PNG, <5MB)
- F-04: Unique Application ID generation

### 4.2 Usability
- U-01: Camera starts within 2 seconds
- U-02: Preview updates within 500ms
- U-03: News filtering within 200ms
- U-04: Mobile responsive (320px - 1920px)

### 4.3 Reliability
- R-01: Data persists across sessions
- R-02: Camera failure fallback to upload

### 4.4 Performance
- P-01: Form submission under 3 seconds
- P-02: Camera startup under 2 seconds
- P-03: Tracking results under 1 second
- P-04: Preview updates under 500ms
- P-05: Page load under 3 seconds

### 4.5 Supportability
- S-01: Cross-browser compatibility
- S-02: Mobile browser compatibility

---

## 5. Appendix

### 5.1 Glossary

| Term | Definition |
|------|------------|
| Salone Ducks | Government document portal |
| Application ID | Unique identifier for each application |
| localStorage | Browser storage API |

### 5.2 References
- Lecture 2: Requirements Engineering I
- Lecture 3: Requirements Engineering II

### 5.3 Change Log

| Version | Date | Changes |
|---------|------|---------|
| 1.0 | 2026-08-13 | Updated to 10 user stories |
| 0.1 | 2026-06-16 | Initial draft |
