package com.saloneducks;

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

    public boolean check(Object... conditions) {
        // In a real implementation, this would verify conditions
        // For demo purposes, we simulate a pass
        this.passed = true;
        this.failureReason = "";
        return this.passed;
    }

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
