# Acceptance Criteria - Salone Ducks

## US-01: Submit Document Application

**Scenario: Successful Submission**
Given I am a citizen of Sierra Leone
When I fill in all required fields and submit the form
Then I receive an Application ID
And I see a success message with my Application ID

**Scenario: Missing Required Fields**
Given I am filling out an application
When I leave a required field blank and try to submit
Then I see a validation message indicating which fields are missing
And the application is not submitted

**Scenario: Invalid Email Format**
Given I am filling out an application
When I enter an invalid email address
Then I see a validation message
And the application is not submitted

---

## US-02: Capture and Upload Photo

**Scenario: Upload Photo from Device**
Given I am filling out an application
When I select a photo from my device
Then the photo appears in the preview area

**Scenario: Capture Photo Using Camera**
Given I am filling out an application
When I click "Start Camera" and then "Capture Photo"
Then the captured photo appears in the preview area
And the camera stops automatically

**Scenario: Camera Permission Denied**
Given I am trying to use the camera
When I deny camera permission
Then I see an error message
And I can still upload a photo from my device

---

## US-03: Track Application Status

**Scenario: Valid Application ID**
Given I have submitted an application
When I enter my Application ID in the tracker
Then I see my application details displayed
Including status, document type, name, and submission date

**Scenario: Invalid Application ID**
When I enter an invalid Application ID
Then I see an error message "No application found"

---

## US-04: Update Application Within 5 Days

**Scenario: Update Within 5 Days**
Given I have submitted an application within the last 5 days
When I view my application details
Then I see an "Update" button
And I can modify my details

**Scenario: Update After 5 Days**
Given I have submitted an application more than 5 days ago
When I view my application details
Then I do not see an "Update" button
And I see a message that the application is locked

---

## US-05: Delete Application Within 5 Days

**Scenario: Delete Within 5 Days**
Given I have submitted an application within the last 5 days
When I click the "Delete" button and confirm
Then the application is permanently removed

**Scenario: Delete After 5 Days**
Given I have submitted an application more than 5 days ago
When I view my application details
Then I do not see a "Delete" button

---

## US-06: View Real-Time Application Preview

**Scenario: Live Preview Updates**
Given I am filling out an application
When I type in any field
Then the preview updates immediately

**Scenario: Document Type Change**
Given I am filling out an application
When I change the document type
Then the preview shows the selected document type

---

## US-07: Age Validation for Driver's License

**Scenario: Age ≥ 18**
Given I am applying for a Driver's License
When I enter a date of birth showing I am 18 or older
Then the application is accepted

**Scenario: Age < 18**
Given I am applying for a Driver's License
When I enter a date of birth showing I am under 18
Then I see a message "You must be at least 18 years old"
And the application is not submitted

---

## US-08: Subscribe to News and Updates

**Scenario: Successful Subscription**
Given I am on the news page
When I enter a valid email and click Subscribe
Then I see a success message

**Scenario: Already Subscribed**
When I enter an already subscribed email
Then I see a message "This email is already subscribed"

---

## US-09: Filter News by Category

**Scenario: Filter by Press Releases**
Given I am on the news page
When I click the "Press Releases" filter tab
Then only news articles with the Press tag are displayed

**Scenario: Show All News**
Given I am on the news page
When I click the "All" filter tab
Then all news articles are displayed

---

## US-10: Contact Support

**Scenario: Send Message Successfully**
Given I am on the contact page
When I fill in all required fields and click "Send Message"
Then I see a success message

**Scenario: Missing Required Fields**
Given I am on the contact page
When I leave a required field blank and click "Send Message"
Then I see a validation message
And the message is not sent
