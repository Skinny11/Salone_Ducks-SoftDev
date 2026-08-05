# Acceptance Criteria - Salone Ducks Document Application System

## US-01: Submit Document Application

**Scenario 1: Successful Submission**
Given I am a citizen of Sierra Leone
When I fill in all required fields and submit the form
Then I receive an Application ID
And I see a success message with my Application ID displayed

**Scenario 2: Missing Required Fields**
Given I am filling out an application
When I leave a required field blank and try to submit
Then I see a validation message indicating which fields are missing
And the application is not submitted

**Scenario 3: Invalid Email Format**
Given I am filling out an application
When I enter an invalid email address format
Then I see a validation message
And the application is not submitted

---

## US-02: Capture and Upload Photo

**Scenario 1: Upload Photo from Device**
Given I am filling out an application
When I select a photo from my device storage
Then the photo appears in the preview area
And the application preview shows "Uploaded"

**Scenario 2: Capture Photo Using Camera**
Given I am filling out an application
When I click "Start Camera" and then "Capture Photo"
Then the captured photo appears in the preview area
And the camera stops automatically
And the application preview shows "Captured"

**Scenario 3: Retake Photo**
Given I have captured a photo
When I click "Retake"
Then the captured photo is cleared
And I can start the camera again

**Scenario 4: Camera Permission Denied**
Given I am trying to use the camera
When the browser asks for camera permission
And I deny permission
Then I see an error message asking me to allow camera access
And I can still upload a photo from my device

---

## US-03: Track Application Status

**Scenario 1: Valid Application ID**
Given I have submitted an application
When I enter my Application ID in the tracker field
Then I see my application details displayed
Including status, document type, name, and submission date

**Scenario 2: Invalid Application ID**
Given I have not submitted an application
When I enter an invalid Application ID
Then I see an error message "No application found with this ID"
And I am prompted to check and try again

**Scenario 3: Empty Application ID**
Given I am trying to track an application
When I leave the Application ID field empty and click Track
Then I see a message to enter an Application ID

---

## US-04: Update Application Within 5 Days

**Scenario 1: Update Within 5 Days**
Given I have submitted an application within the last 5 days
When I view my application details
Then I see an "Update" button
And I can modify my application details

**Scenario 2: Update After 5 Days**
Given I have submitted an application more than 5 days ago
When I view my application details
Then I do not see an "Update" button
And I see a message that the application is locked

**Scenario 3: Successful Update**
Given I am within the 5-day window
When I update my application details and save
Then the changes are reflected in the application record
And I see a confirmation message

---

## US-05: Delete Application Within 5 Days

**Scenario 1: Delete Within 5 Days**
Given I have submitted an application within the last 5 days
When I click the "Delete" button
And I confirm deletion
Then the application is permanently removed
And I see a confirmation message

**Scenario 2: Delete After 5 Days**
Given I have submitted an application more than 5 days ago
When I view my application details
Then I do not see a "Delete" button
And I see a message that the application is locked

**Scenario 3: Cancel Deletion**
Given I have clicked the "Delete" button
When I cancel the confirmation dialog
Then the application is not deleted
And I see no change to my application

---

## US-06: View Real-Time Application Preview

**Scenario 1: Live Preview Updates**
Given I am filling out an application
When I type in any field
Then the preview updates immediately to reflect my input

**Scenario 2: Document Type Change**
Given I am filling out an application
When I change the document type
Then the preview shows the selected document type
And passport-specific fields appear/disappear as appropriate

**Scenario 3: Empty Preview State**
Given I am filling out an application
When no fields have been filled
Then the preview shows a placeholder message
And the preview is hidden until data is entered

---

## US-07: Age Validation for Driver's License

**Scenario 1: Age ≥ 18**
Given I am applying for a Driver's License
When I enter a date of birth showing I am 18 years or older
Then the application is accepted
And I can proceed to submit

**Scenario 2: Age < 18**
Given I am applying for a Driver's License
When I enter a date of birth showing I am under 18
Then I see a message "Application Denied: You must be at least 18 years old"
And the application is not submitted

**Scenario 3: National ID Application - No Age Restriction**
Given I am applying for a National ID Card
When I enter any date of birth
Then no age validation is shown
And the application proceeds normally

---

## US-08: Subscribe to News and Updates

**Scenario 1: Successful Subscription**
Given I am on the news page
When I enter a valid email address and click Subscribe
Then I see a success message "You have been subscribed successfully"
And my email is saved for future notifications

**Scenario 2: Already Subscribed**
Given I have already subscribed with my email
When I enter the same email address again and click Subscribe
Then I see a message "This email is already subscribed"

**Scenario 3: Invalid Email Format**
Given I am on the news page
When I enter an invalid email address and click Subscribe
Then I see a message "Please enter a valid email address"
And I am not subscribed

---

## US-09: Filter News by Category

**Scenario 1: Filter by Press Releases**
Given I am on the news page
When I click the "Press Releases" filter tab
Then only news articles with the Press tag are displayed
And all other articles are hidden

**Scenario 2: Filter by Holidays**
Given I am on the news page
When I click the "Holidays" filter tab
Then only news articles with the Holiday tag are displayed
And all other articles are hidden

**Scenario 3: Filter by Job Vacancies**
Given I am on the news page
When I click the "Job Vacancies" filter tab
Then only news articles with the Job tag are displayed
And all other articles are hidden

**Scenario 4: Show All News**
Given I am on the news page
When I click the "All" filter tab
Then all news articles are displayed

---

## US-10: Get Directions to Service Center

**Scenario 1: Open Directions in Google Maps**
Given I am on the contact page
When I click the "Get Directions" button
Then Google Maps opens in a new tab
With the Salone Ducks office address as the destination

**Scenario 2: Directions Button is Accessible**
Given I am on the contact page
When I view the directions button
Then I see "Get Directions" text with a map icon
And the button is clearly visible and clickable

---

## US-11: View Service Center Information

**Scenario 1: View All Service Centers**
Given I am on the contact page
When I view the service centers list
Then I see all service centers (Freetown, Bo, Kenema, Makeni)
With addresses and phone numbers

**Scenario 2: Contact Details Are Accurate**
Given I am on the contact page
When I view the office contact details
Then I see the correct email address (support@saloneducks.gov.sl)
And the correct phone number (+232 76 123 456)

---

## US-12: Contact Support

**Scenario 1: Send Message Successfully**
Given I am on the contact page
When I fill in all required fields (Name, Email, Subject, Message)
And click "Send Message"
Then I see a success message "Message Sent!"
And the form clears

**Scenario 2: Missing Required Fields**
Given I am on the contact page
When I leave a required field blank and click "Send Message"
Then I see a validation message
And the message is not sent

**Scenario 3: Subject Selection**
Given I am on the contact page
When I click the subject dropdown
Then I see all available options (General Inquiry, Application Support, etc.)
And I can select one

---

## US-13: View Weather and Time

**Scenario 1: Current Time Displayed**
Given I am on the Salone Ducks website
When I view the top navigation bar
Then I see the current date and time
Updating every second

**Scenario 2: Weather Information Displayed**
Given I am on the news page
When I view the weather widget
Then I see temperature, time, and wind information
(Even if placeholder data is used)

---

## US-14: Receive Email Confirmation

**Scenario 1: Confirmation Email Contains Application ID**
Given I have submitted an application
When I receive the confirmation email
Then the email contains my Application ID
And the email contains payment instructions

**Scenario 2: Confirmation Email Contains Document Type**
Given I have submitted an application
When I receive the confirmation email
Then the email specifies which document I applied for

**Scenario 3: Confirmation Email Sent Immediately**
Given I have submitted an application
When I click Submit
Then the confirmation email is sent within 1 minute
(Simulated in the demo)
