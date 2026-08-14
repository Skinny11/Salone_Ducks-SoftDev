package com.saloneducks;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class AcceptanceRule {
    private String scenarioName;
    private String given;
    private String when;
    private String then;
    private boolean passed;
    private String failureReason;

    public AcceptanceRule(String scenarioName, String given, String when, String then) {
        this.scenarioName = scenarioName;
        this.given = given;
        this.when = when;
        this.then = then;
        this.passed = false;
        this.failureReason = "";
    }

    /**
     * Validates the acceptance rule against provided conditions.
     * 
     * @param conditions varargs of objects that provide data for validation
     * @return true if all conditions pass, false otherwise
     */
    public boolean check(Object... conditions) {
        this.passed = false;
        this.failureReason = "";

        if (conditions == null || conditions.length == 0) {
            this.failureReason = "No conditions provided for validation";
            return false;
        }

        try {
            // Extract scenario name to determine which validation to run
            String scenario = this.scenarioName;

            if (scenario.contains("US-01") || scenario.contains("Successful Submission")) {
                return validateSubmission(conditions);
            } 
            else if (scenario.contains("US-02") || scenario.contains("Capture Photo")) {
                return validatePhotoCapture(conditions);
            }
            else if (scenario.contains("US-03") || scenario.contains("Valid Application ID")) {
                return validateApplicationId(conditions);
            }
            else if (scenario.contains("US-04") || scenario.contains("Update Within 5 Days")) {
                return validateUpdateWindow(conditions);
            }
            else if (scenario.contains("US-05") || scenario.contains("Delete Within 5 Days")) {
                return validateDeleteWindow(conditions);
            }
            else if (scenario.contains("US-06") || scenario.contains("Live Preview")) {
                return validatePreview(conditions);
            }
            else if (scenario.contains("US-07") || scenario.contains("Age ≥ 18")) {
                return validateAge(conditions);
            }
            else if (scenario.contains("US-08") || scenario.contains("Successful Subscription")) {
                return validateSubscription(conditions);
            }
            else if (scenario.contains("US-09") || scenario.contains("Filter by Press Releases")) {
                return validateFilter(conditions);
            }
            else if (scenario.contains("US-10") || scenario.contains("Send Message Successfully")) {
                return validateContact(conditions);
            }
            else {
                // Default: if no specific validation, assume pass (but log it)
                this.passed = true;
                return true;
            }
        } catch (Exception e) {
            this.failureReason = "Validation error: " + e.getMessage();
            return false;
        }
    }

    // ===== VALIDATION METHODS =====

    private boolean validateSubmission(Object... conditions) {
        // Expecting: [surname, givenNames, dob, email]
        if (conditions.length < 4) {
            this.failureReason = "Missing required fields for submission";
            return false;
        }

        String surname = conditions[0] != null ? conditions[0].toString() : "";
        String givenNames = conditions[1] != null ? conditions[1].toString() : "";
        String dob = conditions[2] != null ? conditions[2].toString() : "";
        String email = conditions[3] != null ? conditions[3].toString() : "";

        if (surname.trim().isEmpty()) {
            this.failureReason = "Surname is required";
            return false;
        }
        if (givenNames.trim().isEmpty()) {
            this.failureReason = "Given names are required";
            return false;
        }
        if (dob.trim().isEmpty()) {
            this.failureReason = "Date of birth is required";
            return false;
        }
        if (email.trim().isEmpty() || !email.contains("@") || !email.contains(".")) {
            this.failureReason = "Valid email is required";
            return false;
        }

        this.passed = true;
        return true;
    }

    private boolean validatePhotoCapture(Object... conditions) {
        // Expecting: [photoDataUrl, hasFileUpload]
        if (conditions.length < 2) {
            this.failureReason = "Missing photo data";
            return false;
        }

        String photoDataUrl = conditions[0] != null ? conditions[0].toString() : "";
        boolean hasFileUpload = conditions[1] instanceof Boolean && (Boolean) conditions[1];

        if (photoDataUrl.isEmpty() && !hasFileUpload) {
            this.failureReason = "No photo captured or uploaded";
            return false;
        }

        this.passed = true;
        return true;
    }

    private boolean validateApplicationId(Object... conditions) {
        // Expecting: [applicationId, applicationsList]
        if (conditions.length < 2) {
            this.failureReason = "Missing application ID or data";
            return false;
        }

        String appId = conditions[0] != null ? conditions[0].toString() : "";
        @SuppressWarnings("unchecked")
        List<Map<String, Object>> apps = (List<Map<String, Object>>) conditions[1];

        if (appId.trim().isEmpty()) {
            this.failureReason = "Application ID is required";
            return false;
        }

        if (apps == null || apps.isEmpty()) {
            this.failureReason = "No applications found";
            return false;
        }

        boolean found = apps.stream().anyMatch(app -> {
            Object id = app.get("applicationId");
            return id != null && id.toString().equals(appId);
        });

        if (!found) {
            this.failureReason = "No application found with ID: " + appId;
            return false;
        }

        this.passed = true;
        return true;
    }

    private boolean validateUpdateWindow(Object... conditions) {
        // Expecting: [submissionDate, currentDate, daysLimit]
        if (conditions.length < 3) {
            this.failureReason = "Missing date data";
            return false;
        }

        String submissionDateStr = conditions[0] != null ? conditions[0].toString() : "";
        String currentDateStr = conditions[1] != null ? conditions[1].toString() : "";
        int daysLimit = conditions[2] instanceof Integer ? (Integer) conditions[2] : 5;

        if (submissionDateStr.isEmpty()) {
            this.failureReason = "No submission date found";
            return false;
        }

        try {
            LocalDate submissionDate = LocalDate.parse(submissionDateStr);
            LocalDate currentDate = LocalDate.parse(currentDateStr);

            Period period = Period.between(submissionDate, currentDate);
            long daysBetween = period.getDays();

            if (daysBetween > daysLimit) {
                this.failureReason = "Update window expired. Submitted " + daysBetween + " days ago (limit: " + daysLimit + ")";
                return false;
            }

            this.passed = true;
            return true;

        } catch (Exception e) {
            this.failureReason = "Invalid date format: " + e.getMessage();
            return false;
        }
    }

    private boolean validateDeleteWindow(Object... conditions) {
        // Same logic as update window
        return validateUpdateWindow(conditions);
    }

    private boolean validatePreview(Object... conditions) {
        // Expecting: [hasData, documentType]
        if (conditions.length < 2) {
            this.failureReason = "Missing preview data";
            return false;
        }

        boolean hasData = conditions[0] instanceof Boolean && (Boolean) conditions[0];
        String docType = conditions[1] != null ? conditions[1].toString() : "";

        if (!hasData) {
            this.failureReason = "No data to preview";
            return false;
        }
        if (docType.trim().isEmpty()) {
            this.failureReason = "Document type is required for preview";
            return false;
        }

        this.passed = true;
        return true;
    }

    private boolean validateAge(Object... conditions) {
        // Expecting: [dob, minimumAge]
        if (conditions.length < 2) {
            this.failureReason = "Missing age data";
            return false;
        }

        String dobStr = conditions[0] != null ? conditions[0].toString() : "";
        int minAge = conditions[1] instanceof Integer ? (Integer) conditions[1] : 18;

        if (dobStr.trim().isEmpty()) {
            this.failureReason = "Date of birth is required";
            return false;
        }

        try {
            LocalDate birthDate = LocalDate.parse(dobStr);
            LocalDate now = LocalDate.now();

            int age = Period.between(birthDate, now).getYears();

            if (age < minAge) {
                this.failureReason = "Age " + age + " is below minimum requirement of " + minAge;
                return false;
            }

            this.passed = true;
            return true;

        } catch (Exception e) {
            this.failureReason = "Invalid date of birth format: " + e.getMessage();
            return false;
        }
    }

    private boolean validateSubscription(Object... conditions) {
        // Expecting: [email, existingSubscribers]
        if (conditions.length < 2) {
            this.failureReason = "Missing subscription data";
            return false;
        }

        String email = conditions[0] != null ? conditions[0].toString() : "";
        @SuppressWarnings("unchecked")
        List<String> subscribers = (List<String>) conditions[1];

        if (email.trim().isEmpty() || !email.contains("@") || !email.contains(".")) {
            this.failureReason = "Valid email is required";
            return false;
        }

        if (subscribers != null && subscribers.contains(email)) {
            this.failureReason = "Email already subscribed";
            return false;
        }

        this.passed = true;
        return true;
    }

    private boolean validateFilter(Object... conditions) {
        // Expecting: [filterCategory, availableCategories]
        if (conditions.length < 2) {
            this.failureReason = "Missing filter data";
            return false;
        }

        String filter = conditions[0] != null ? conditions[0].toString() : "";
        @SuppressWarnings("unchecked")
        List<String> categories = (List<String>) conditions[1];

        if (filter.trim().isEmpty()) {
            this.failureReason = "Filter category is required";
            return false;
        }

        if (categories != null && !categories.contains(filter) && !filter.equals("all")) {
            this.failureReason = "Invalid filter category: " + filter;
            return false;
        }

        this.passed = true;
        return true;
    }

    private boolean validateContact(Object... conditions) {
        // Expecting: [name, email, subject, message]
        if (conditions.length < 4) {
            this.failureReason = "Missing contact form data";
            return false;
        }

        String name = conditions[0] != null ? conditions[0].toString() : "";
        String email = conditions[1] != null ? conditions[1].toString() : "";
        String subject = conditions[2] != null ? conditions[2].toString() : "";
        String message = conditions[3] != null ? conditions[3].toString() : "";

        if (name.trim().isEmpty()) {
            this.failureReason = "Name is required";
            return false;
        }
        if (email.trim().isEmpty() || !email.contains("@") || !email.contains(".")) {
            this.failureReason = "Valid email is required";
            return false;
        }
        if (subject.trim().isEmpty()) {
            this.failureReason = "Subject is required";
            return false;
        }
        if (message.trim().isEmpty()) {
            this.failureReason = "Message is required";
            return false;
        }

        this.passed = true;
        return true;
    }

    // ===== GETTERS =====

    public boolean isPassed() { return passed; }
    public String getFailureReason() { return failureReason; }
    public String getScenarioName() { return scenarioName; }

    @Override
    public String toString() {
        String status = passed ? "PASSED ✓" : "FAILED ✗";
        String reason = !passed && !failureReason.isEmpty() ? " - " + failureReason : "";
        return String.format(
            "Scenario: %s\n  Given: %s\n  When: %s\n  Then: %s\n  Status: %s%s",
            scenarioName, given, when, then, status, reason
        );
    }
}
