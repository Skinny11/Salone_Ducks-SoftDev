package com.saloneducks;

import java.util.*;

public class Demo {
    public static void main(String[] args) {
        System.out.println("╔══════════════════════════════════════════════════════════╗");
        System.out.println("║          SALONE DUCKS - PRIORITISED BACKLOG             ║");
        System.out.println("╚══════════════════════════════════════════════════════════╝\n");

        // Create user stories (10 stories matching documentation)
        List<UserStory> backlog = new ArrayList<>();

        // MUST HAVE Stories (6)
        backlog.add(new UserStory("US-01", "Submit Document Application",
            "citizen of Sierra Leone",
            "submit an application for a national document online",
            "obtain official identification without visiting a government office",
            MoscowPriority.MUST_HAVE, "UC-01"));

        backlog.add(new UserStory("US-02", "Capture and Upload Photo",
            "citizen applying for a document",
            "upload a photo from my device or capture one live using my camera",
            "provide a valid passport-sized photo",
            MoscowPriority.MUST_HAVE, "UC-02"));

        backlog.add(new UserStory("US-03", "Track Application Status",
            "citizen who has submitted an application",
            "track the status of my application using my Application ID",
            "know when my document is ready for collection",
            MoscowPriority.MUST_HAVE, "UC-03"));

        backlog.add(new UserStory("US-04", "Update Application Within 5 Days",
            "citizen who has submitted an application",
            "update my application details within 5 days of submission",
            "correct errors before processing begins",
            MoscowPriority.MUST_HAVE, "UC-04"));

        backlog.add(new UserStory("US-05", "Delete Application Within 5 Days",
            "citizen who has submitted an application",
            "delete my application within 5 days of submission",
            "cancel if I no longer need the document",
            MoscowPriority.MUST_HAVE, "UC-05"));

        backlog.add(new UserStory("US-06", "View Real-Time Application Preview",
            "citizen filling out an application",
            "see a live preview of my document as I fill in the form",
            "verify all details are correct before submitting",
            MoscowPriority.MUST_HAVE, "UC-06"));

        // SHOULD HAVE Stories (2)
        backlog.add(new UserStory("US-07", "Age Validation for Driver's License",
            "citizen applying for a Driver's License",
            "be informed if I am below the minimum age of 18",
            "not waste time on an application that will be rejected",
            MoscowPriority.SHOULD_HAVE, "UC-07"));

        backlog.add(new UserStory("US-08", "Subscribe to News and Updates",
            "citizen",
            "subscribe to receive news, holiday announcements, and job vacancies via email",
            "stay informed about government services and opportunities",
            MoscowPriority.SHOULD_HAVE, "UC-08"));

        // COULD HAVE Stories (2)
        backlog.add(new UserStory("US-09", "Filter News by Category",
            "citizen browsing the news section",
            "filter news articles by category",
            "quickly find information relevant to my interests",
            MoscowPriority.COULD_HAVE, "UC-09"));

        backlog.add(new UserStory("US-10", "Contact Support",
            "citizen experiencing issues",
            "send a message to the support team",
            "get help with my application or report problems",
            MoscowPriority.COULD_HAVE, "UC-10"));

        // Sort by priority (Must Have first, then Should Have, then Could Have)
        Comparator<UserStory> priorityOrder = Comparator
            .comparing((UserStory u) -> {
                switch (u.getPriority()) {
                    case MUST_HAVE: return 0;
                    case SHOULD_HAVE: return 1;
                    case COULD_HAVE: return 2;
                    default: return 3;
                }
            });

        backlog.sort(priorityOrder);

        // Print backlog
        System.out.println("┌─────────────────────────────────────────────────────────────────────────────┐");
        System.out.println("│                              BACKLOG                                        │");
        System.out.println("├─────────────────────────────────────────────────────────────────────────────┤");

        for (UserStory story : backlog) {
            System.out.printf("│ %s │ %-20s │ %-12s │\n",
                story.getId(),
                story.getTitle().length() > 20 ? story.getTitle().substring(0, 20) : story.getTitle(),
                story.getPriority());
        }

        System.out.println("├─────────────────────────────────────────────────────────────────────────────┤");
        System.out.printf("│ Total User Stories: %-2d                                                        │\n", backlog.size());
        System.out.println("└─────────────────────────────────────────────────────────────────────────────┘\n");

        // Show MoSCoW Summary
        System.out.println("╔══════════════════════════════════════════════════════════╗");
        System.out.println("║                MoSCoW SUMMARY                            ║");
        System.out.println("╠══════════════════════════════════════════════════════════╣");

        long mustHave = backlog.stream().filter(u -> u.getPriority() == MoscowPriority.MUST_HAVE).count();
        long shouldHave = backlog.stream().filter(u -> u.getPriority() == MoscowPriority.SHOULD_HAVE).count();
        long couldHave = backlog.stream().filter(u -> u.getPriority() == MoscowPriority.COULD_HAVE).count();
        long wontHave = backlog.stream().filter(u -> u.getPriority() == MoscowPriority.WONT_HAVE).count();

        System.out.printf("│  MUST HAVE   : %-2d  (%.0f%%)                                       │\n", mustHave, (mustHave * 100.0 / backlog.size()));
        System.out.printf("│  SHOULD HAVE : %-2d  (%.0f%%)                                       │\n", shouldHave, (shouldHave * 100.0 / backlog.size()));
        System.out.printf("│  COULD HAVE  : %-2d  (%.0f%%)                                       │\n", couldHave, (couldHave * 100.0 / backlog.size()));
        System.out.printf("│  WON'T HAVE  : %-2d  (%.0f%%)                                       │\n", wontHave, (wontHave * 100.0 / backlog.size()));
        System.out.println("╚══════════════════════════════════════════════════════════╝\n");

        // ===== ACCEPTANCE CHECKS WITH REAL DATA =====
        System.out.println("╔══════════════════════════════════════════════════════════╗");
        System.out.println("║                   ACCEPTANCE CHECKS                      ║");
        System.out.println("╚══════════════════════════════════════════════════════════╝\n");

        // Create acceptance rules (10 rules matching the 10 stories)
        List<AcceptanceRule> rules = new ArrayList<>();

        rules.add(new AcceptanceRule(
            "US-01: Successful Submission",
            "I am a citizen of Sierra Leone",
            "I fill in all required fields and submit the form",
            "I receive an Application ID and see a success message"
        ));

        rules.add(new AcceptanceRule(
            "US-02: Capture Photo Using Camera",
            "I am filling out an application",
            "I click 'Start Camera' and then 'Capture Photo'",
            "The captured photo appears in the preview area"
        ));

        rules.add(new AcceptanceRule(
            "US-03: Valid Application ID",
            "I have submitted an application",
            "I enter my Application ID in the tracker field",
            "I see my application details displayed"
        ));

        rules.add(new AcceptanceRule(
            "US-04: Update Within 5 Days",
            "I have submitted an application within the last 5 days",
            "I view my application details",
            "I see an 'Update' button and can modify my details"
        ));

        rules.add(new AcceptanceRule(
            "US-05: Delete Within 5 Days",
            "I have submitted an application within the last 5 days",
            "I click the 'Delete' button and confirm",
            "The application is permanently removed"
        ));

        rules.add(new AcceptanceRule(
            "US-06: Live Preview Updates",
            "I am filling out an application",
            "I type in any field",
            "The preview updates immediately to reflect my input"
        ));

        rules.add(new AcceptanceRule(
            "US-07: Age ≥ 18",
            "I am applying for a Driver's License",
            "I enter a date of birth showing I am 18 years or older",
            "The application is accepted and I can proceed"
        ));

        rules.add(new AcceptanceRule(
            "US-08: Successful Subscription",
            "I am on the news page",
            "I enter a valid email address and click Subscribe",
            "I see a success message and my email is saved"
        ));

        rules.add(new AcceptanceRule(
            "US-09: Filter by Press Releases",
            "I am on the news page",
            "I click the 'Press Releases' filter tab",
            "Only news articles with the Press tag are displayed"
        ));

        rules.add(new AcceptanceRule(
            "US-10: Send Message Successfully",
            "I am on the contact page",
            "I fill in all required fields and click 'Send Message'",
            "I see a success message and the form clears"
        ));

        // ===== RUN ACCEPTANCE CHECKS WITH REAL TEST DATA =====
        int passed = 0;
        int total = rules.size();

        // Test data for each rule
        // US-01: Valid submission data
        Object[] submissionData = {"Koroma", "Ishmael", "1990-05-15", "ishmael@example.com"};
        // US-02: Photo data
        Object[] photoData = {"data:image/png;base64,abc123...", true};
        // US-03: Application ID tracking
        List<Map<String, Object>> mockApps = new ArrayList<>();
        Map<String, Object> mockApp = new HashMap<>();
        mockApp.put("applicationId", "SLD-2026-001");
        mockApps.add(mockApp);
        Object[] trackingData = {"SLD-2026-001", mockApps};
        // US-04 & US-05: Date data (today is within 5 days)
        String today = java.time.LocalDate.now().toString();
        String fiveDaysAgo = java.time.LocalDate.now().minusDays(3).toString();
        Object[] dateData = {fiveDaysAgo, today, 5};
        // US-06: Preview data
        Object[] previewData = {true, "National ID"};
        // US-07: Age data (25 years old - passes)
        Object[] ageData = {"2000-01-01", 18};
        // US-08: Subscription data
        List<String> subscribers = new ArrayList<>();
        subscribers.add("existing@example.com");
        Object[] subscriptionData = {"newuser@example.com", subscribers};
        // US-09: Filter data
        List<String> categories = Arrays.asList("press", "holiday", "job");
        Object[] filterData = {"press", categories};
        // US-10: Contact data
        Object[] contactData = {"Ishmael Koroma", "ishmael@example.com", "General Inquiry", "I need help with my application"};

        // Apply each rule with appropriate test data
        // Note: In a real implementation, you'd map these more elegantly.
        // For demo purposes, we're using a simple index-based approach.

        // Since each rule expects different data, we'll check each one individually
        System.out.println("Running acceptance checks with real data...\n");

        // US-01
        AcceptanceRule rule1 = rules.get(0);
        boolean result1 = rule1.check(submissionData);
        System.out.println(rule1);
        System.out.println();
        if (result1) passed++;

        // US-02
        AcceptanceRule rule2 = rules.get(1);
        boolean result2 = rule2.check(photoData);
        System.out.println(rule2);
        System.out.println();
        if (result2) passed++;

        // US-03
        AcceptanceRule rule3 = rules.get(2);
        boolean result3 = rule3.check(trackingData);
        System.out.println(rule3);
        System.out.println();
        if (result3) passed++;

        // US-04
        AcceptanceRule rule4 = rules.get(3);
        boolean result4 = rule4.check(dateData);
        System.out.println(rule4);
        System.out.println();
        if (result4) passed++;

        // US-05
        AcceptanceRule rule5 = rules.get(4);
        boolean result5 = rule5.check(dateData);
        System.out.println(rule5);
        System.out.println();
        if (result5) passed++;

        // US-06
        AcceptanceRule rule6 = rules.get(5);
        boolean result6 = rule6.check(previewData);
        System.out.println(rule6);
        System.out.println();
        if (result6) passed++;

        // US-07
        AcceptanceRule rule7 = rules.get(6);
        boolean result7 = rule7.check(ageData);
        System.out.println(rule7);
        System.out.println();
        if (result7) passed++;

        // US-08
        AcceptanceRule rule8 = rules.get(7);
        boolean result8 = rule8.check(subscriptionData);
        System.out.println(rule8);
        System.out.println();
        if (result8) passed++;

        // US-09
        AcceptanceRule rule9 = rules.get(8);
        boolean result9 = rule9.check(filterData);
        System.out.println(rule9);
        System.out.println();
        if (result9) passed++;

        // US-10
        AcceptanceRule rule10 = rules.get(9);
        boolean result10 = rule10.check(contactData);
        System.out.println(rule10);
        System.out.println();
        if (result10) passed++;

        // Also demonstrate a failing case
        System.out.println("--- Testing a failing case ---");
        AcceptanceRule failingRule = new AcceptanceRule(
            "US-07: Age ≥ 18",
            "I am applying for a Driver's License",
            "I enter a date of birth showing I am 16 years old",
            "The application is rejected"
        );
        Object[] failingAgeData = {"2009-01-01", 18};
        boolean failingResult = failingRule.check(failingAgeData);
        System.out.println(failingRule);
        System.out.println();

        // Final summary
        System.out.println("╔══════════════════════════════════════════════════════════╗");
        System.out.println("║                  ACCEPTANCE SUMMARY                     ║");
        System.out.println("╠══════════════════════════════════════════════════════════╣");
        System.out.printf("│  Passed: %-2d  /  %-2d   (%.0f%%)                                   │\n", passed, total, (passed * 100.0 / total));
        System.out.println("╚══════════════════════════════════════════════════════════╝\n");

        System.out.println("╔══════════════════════════════════════════════════════════╗");
        System.out.println("║                    DEMO COMPLETE                         ║");
        System.out.println("║           Salone Ducks - Document Application System    ║");
        System.out.println("║              10 User Stories | 6 Must, 2 Should, 2 Could ║");
        System.out.println("╚══════════════════════════════════════════════════════════╝");
    }
}
