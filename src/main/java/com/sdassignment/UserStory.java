package com.saloneducks;

public class UserStory {
    private String id;
    private String title;
    private String asA;
    private String iWant;
    private String soThat;
    private MoscowPriority priority;
    private String useCaseLink;

    public UserStory(String id, String title, String asA, String iWant, 
                     String soThat, MoscowPriority priority, String useCaseLink) {
        this.id = id;
        this.title = title;
        this.asA = asA;
        this.iWant = iWant;
        this.soThat = soThat;
        this.priority = priority;
        this.useCaseLink = useCaseLink;
    }

    public String getId() { return id; }
    public String getTitle() { return title; }
    public String getAsA() { return asA; }
    public String getIWant() { return iWant; }
    public String getSoThat() { return soThat; }
    public MoscowPriority getPriority() { return priority; }
    public String getUseCaseLink() { return useCaseLink; }

    @Override
    public String toString() {
        return String.format("%s | %s | Priority: %s | Use Case: %s",
            id, title, priority, useCaseLink);
    }
}
