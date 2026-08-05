# Non-Functional Requirements - Salone Ducks Document Application System

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

**F-01: Form Validation Accuracy**
The system shall validate all form inputs (name, email, DOB, phone) and provide clear error messages within 500ms of submission attempt.

**F-02: Age Validation for Driver's License**
The system shall automatically calculate age from date of birth and block submissions for users under 18 years old with a clear denial message.

**F-03: Photo Upload Validation**
The system shall accept only image files (JPG, PNG) under 5MB and provide feedback within 1 second of selection.

**F-04: Application ID Uniqueness**
The system shall generate unique Application IDs for each submission with no duplicates across all applications.

**F-05: Data Encryption**
All user data submitted through forms shall be encrypted using HTTPS/SSL protocol.

---

## Usability (U)

**U-01: Live Camera Feedback**
The camera interface shall display the user's video feed within 2 seconds of clicking "Start Camera" on a 4G/5G network.

**U-02: Real-Time Preview**
The application preview shall update within 500ms of any field change, allowing users to verify details instantly.

**U-03: News Filter Responsiveness**
News filtering shall occur within 200ms of selecting a filter category, providing immediate visual feedback.

**U-04: Navigation Consistency**
All navigation menus and buttons shall be consistently positioned across all pages and work on screen sizes from 320px to 1920px.

**U-05: Error Message Clarity**
All error messages shall use plain English without technical jargon and include clear instructions on how to fix the issue.

**U-06: Mobile Responsiveness**
The website shall render properly on all screen sizes from 320px width (smartphones) to 1920px (desktops).

---

## Reliability (R)

**R-01: Data Persistence**
Application data stored in localStorage shall persist across browser sessions with 99.9% data integrity.

**R-02: Email Delivery Confirmation**
Email confirmation shall be sent within 1 minute of application submission with guaranteed delivery tracking.

**R-03: Form State Preservation**
If a user accidentally closes the browser during form filling, the system shall retain entered data for 7 days.

**R-04: Camera Error Recovery**
If camera access fails, the system shall automatically fall back to file upload option within 3 seconds.

**R-05: System Availability**
The Salone Ducks website shall be available 99.9% of the time (excluding scheduled maintenance).

---

## Performance (P)

**P-01: Form Submission Time**
The form submission process shall complete within 3 seconds on a 4G network and within 10 seconds on 3G.

**P-02: Camera Startup Time**
The camera shall start within 2 seconds of clicking the Start Camera button.

**P-03: Application Tracking Time**
The system shall retrieve and display application details within 1 second of entering an Application ID.

**P-04: Live Preview Performance**
The live preview shall update without noticeable delay (under 500ms) even on low-end devices.

**P-05: Page Load Time**
All pages shall load within 3 seconds on a 4G network and within 8 seconds on 3G.

**P-06: Slideshow Performance**
The slideshow shall transition between images every 2 seconds with smooth (under 200ms) transitions.

**P-07: Concurrent Users**
The system shall support at least 100 concurrent users without performance degradation.

---

## Supportability (S)

**S-01: Cross-Browser Compatibility**
The website shall work on all major browsers: Chrome (latest 2 versions), Firefox (latest 2 versions), Safari (latest 2 versions), and Edge (latest 2 versions).

**S-02: Mobile Browser Compatibility**
The website shall work on mobile browsers: Chrome for Android, Safari for iOS.

**S-03: Offline Fallback**
The website shall display a fallback message when offline, informing users to check their internet connection.

**S-04: Data Backup**
Application data shall be backed up to browser storage and recoverable in case of browser crash.

**S-05: Code Maintainability**
All CSS and JavaScript shall be organized with clear comments and consistent naming conventions.

**S-06: Accessibility (A11y)**
The website shall meet WCAG 2.1 Level AA standards for accessibility.

**S-07: Device Compatibility**
The camera feature shall work on 90% of modern smartphones (Android 10+ and iOS 14+).

**S-08: Scalability**
The localStorage-based data storage shall support up to 10,000 applications without performance degradation.

---

## NFR Summary

| Category | Count |
|----------|-------|
| Functionality | 5 |
| Usability | 6 |
| Reliability | 5 |
| Performance | 7 |
| Supportability | 8 |
| **TOTAL** | **31** |
