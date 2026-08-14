# Non-Functional Requirements - Salone Ducks

## FURPS Categories

| Category | Definition |
|----------|------------|
| **F**unctionality | Features, capabilities, security |
| **U**sability | Human factors, aesthetics, consistency |
| **R**eliability | Availability, recovery, fault tolerance |
| **P**erformance | Speed, efficiency, responsiveness |
| **S**upportability | Maintainability, compatibility, scalability |

---

## Functionality (F)

**F-01: Form Validation**
The system shall validate all form inputs and provide clear error messages within 500ms of submission attempt.

**F-02: Age Validation**
The system shall calculate age from date of birth and block Driver's License submissions for users under 18.

**F-03: Photo Validation**
The system shall accept only image files (JPG, PNG) under 5MB.

**F-04: Application ID Uniqueness**
The system shall generate unique Application IDs with no duplicates.

---

## Usability (U)

**U-01: Camera Feedback**
The camera shall display video feed within 2 seconds of clicking "Start Camera".

**U-02: Real-Time Preview**
The preview shall update within 500ms of any field change.

**U-03: News Filtering**
News filtering shall occur within 200ms of selecting a filter.

**U-04: Mobile Responsive**
The website shall work on screen sizes from 320px to 1920px.

---

## Reliability (R)

**R-01: Data Persistence**
Application data shall persist across browser sessions.

**R-02: Camera Failure**
If camera access fails, the system shall fall back to file upload.

---

## Performance (P)

**P-01: Form Submission**
Form submission shall complete within 3 seconds on 4G network.

**P-02: Camera Startup**
Camera shall start within 2 seconds.

**P-03: Application Tracking**
Tracking results shall display within 1 second.

**P-04: Preview Updates**
Preview updates shall occur without noticeable delay (under 500ms).

**P-05: Page Load**
Pages shall load within 3 seconds on 4G network.

---

## Supportability (S)

**S-01: Cross-Browser**
The website shall work on Chrome, Firefox, Safari, and Edge (latest 2 versions).

**S-02: Mobile Browsers**
The website shall work on Chrome for Android and Safari for iOS.

---

## NFR Summary

| Category | Count |
|----------|-------|
| Functionality | 4 |
| Usability | 4 |
| Reliability | 2 |
| Performance | 5 |
| Supportability | 2 |
| **TOTAL** | **17** |
