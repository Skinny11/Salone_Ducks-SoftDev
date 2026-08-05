package com.saloneducks;

import java.util.*;

public class Demo {
    public static void main(String[] args) {
        System.out.println("╔══════════════════════════════════════════════════════════╗");
        System.out.println("║          SALONE DUCKS - PRIORITISED BACKLOG             ║");
        System.out.println("╚══════════════════════════════════════════════════════════╝\n");

        // Create user stories
        List<UserStory> backlog = new ArrayList<>();

        // MUST HAVE Stories
        backlog.add(new UserStory("US-01", "Submit Document Application",
            "citizen of Sierra Leone",
            "submit an application for a national document online",
            "obtain official identification without visiting a government office",
            MoscowPriority.MUST_HAVE, "UC-01"));

        backlog.add(new UserStory("US-06", "View Real-Time Application Preview",
            "citizen filling out an application",
            "see a live preview of my document as I fill in the form",
            "verify all details are correct before submitting",
            MoscowPriority.MUST_HAVE, "UC-06"));

        backlog.add(new UserStory("US-02", "Capture and Upload Photo",
            "citizen applying for a document",
            "upload a photo from my device or capture one live using my camera",
            "provide a valid passport-sized photo",
            MoscowPriority.MUST_HAVE, "UC-02"));

        backlog.add(new UserStory("US-07", "Age Validation for Driver's License",
            "citizen applying for a Driver's License",
            "be automatically informed if I am below the minimum age of 18",
            "not waste time completing an application that will be rejected",
            MoscowPriority.MUST_HAVE, "UC-07"));

        backlog.add(new UserStory("US-14", "Receive Email Confirmation",
            "citizen who has submitted an application",
            "receive an email confirmation with my Application ID and payment details",
            "have a record of my application and know how to pay",
            MoscowPriority.MUST_HAVE, "UC-14"));

        backlog.add(new UserStory("US-03", "Track Application Status",
            "citizen who has submitted an application",
            "track the status of my application using my Application ID",
            "know when my document is ready for collection",
            MoscowPriority.MUST_HAVE, "UC-03"));

        backlog.add(new UserStory("US-04", "Update Application Within 5 Days",
            "citizen who has submitted an application",
            "update my application details within 5 days of submission",
            "correct errors or provide additional information before processing",
            MoscowPriority.MUST_HAVE, "UC-04"));

        backlog.add(new UserStory("US-05", "Delete Application Within 5 Days",
            "citizen who has submitted an application",
            "delete my application within 5 days of submission",
            "cancel the application if I no longer need the document",
            MoscowPriority.MUST_HAVE, "UC-05"));

        // SHOULD HAVE Stories
        backlog.add(new UserStory("US-12", "Contact Support",
            "citizen experiencing issues",
            "send a message to the support team",
            "get help with my application or report problems",
            MoscowPriority.SHOULD_HAVE, "UC-12"));

        backlog.add(new UserStory("US-08", "Subscribe to News and Updates",
            "citizen",
            "subscribe to receive news, holiday announcements, and job vacancies via email",
            "stay informed about government services and opportunities",
            MoscowPriority.SHOULD_HAVE, "UC-08"));

        backlog.add(new UserStory("US-09", "Filter News by Category",
            "citizen browsing the news section",
            "filter news articles by category",
            "quickly find information relevant to my interests",
            MoscowPriority.SHOULD_HAVE, "UC-09"));

        backlog.add(new UserStory("US-11", "View Service Center Information",
            "citizen",
            "view contact details and addresses of all service centers",
            "know where to go for document collection or inquiries",
            MoscowPriority.SHOULD_HAVE, "UC-11"));

        // COULD HAVE Stories
        backlog.add(new UserStory("US-10", "Get Directions to Service Center",
            "citizen who needs to collect a document",
            "get directions to the nearest service center",
            "easily find the location and plan my visit",
            MoscowPriority.COULD_HAVE, "UC-10"));

        backlog.add(new UserStory("US-13", "View Weather and Time",
            "citizen visiting the Salone Ducks website",
            "view the current time and weather information",
            "plan my visit to a service center accordingly",
            MoscowPriority.COULD_HAVE, "UC-13"));

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

        // Acceptance Checks
        System.out.println("╔══════════════════════════════════════════════════════════╗");
        System.out.println("║                   ACCEPTANCE CHECKS                      ║");
        System.out.println("╚══════════════════════════════════════════════════════════╝\n");

        // Create acceptance rules
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
            "US-10: Open Directions in Google Maps",
            "I am on the contact page",
            "I click the 'Get Directions' button",
            "Google Maps opens in a new tab with the address"
        ));

        rules.add(new AcceptanceRule(
            "US-11: View All Service Centers",
            "I am on the contact page",
            "I view the service centers list",
            "I see all service centers with addresses and phone numbers"
        ));

        rules.add(new AcceptanceRule(
            "US-12: Send Message Successfully",
            "I am on the contact page",
            "I fill in all required fields and click 'Send Message'",
            "I see a success message and the form clears"
        ));

        rules.add(new AcceptanceRule(
            "US-13: Current Time Displayed",
            "I am on the Salone Ducks website",
            "I view the top navigation bar",
            "I see the current date and time updating every second"
        ));

        rules.add(new AcceptanceRule(
            "US-14: Email Contains Application ID",
            "I have submitted an application",
            "I receive the confirmation email",
            "The email contains my Application ID"
        ));

        // Run acceptance checks
        int passed = 0;
        int total = rules.size();

        for (AcceptanceRule rule : rules) {
            boolean result = rule.check();
            System.out.println(rule);
            System.out.println();
            if (result) passed++;
        }

        System.out.println("╔══════════════════════════════════════════════════════════╗");
        System.out.println("║                  ACCEPTANCE SUMMARY                     ║");
        System.out.println("╠══════════════════════════════════════════════════════════╣");
        System.out.printf("│  Passed: %-2d  /  %-2d   (%.0f%%)                                   │\n", passed, total, (passed * 100.0 / total));
        System.out.println("╚══════════════════════════════════════════════════════════╝\n");

        System.out.println("╔══════════════════════════════════════════════════════════╗");
        System.out.println("║                    DEMO COMPLETE                         ║");
        System.out.println("║           Salone Ducks - Document Application System    ║");
        System.out.println("╚══════════════════════════════════════════════════════════╝");
    }
}
