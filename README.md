This is the collaborative Project of Jacob, Brendan, and Chidera.
We are group 13, working on functional area 3.

**Data Entry**
==============

**![](https://github.com/loftzo/Immigrant-Attorney-Request/assets/58479250/b99db4b1-c132-4155-9144-f62ddae0f5d9)**

The Data entry screen was made by Jacob Smith. It includes fields for relevant information such as Name, Address and ID of the Applicant, and the Name, Firm, and Phone Number of the requested Attorney. It has language support for English, Spanish, French, Mandarin, and Hindi (5 of the most common immigrant languages in the U.S.

![](https://github.com/loftzo/Immigrant-Attorney-Request/assets/58479250/af3cee36-9993-4ceb-ad4b-9bbc489888a1)

It supports individual field error messages, which are also language supported. If there is an issue during submission, a user can click on the 'Report Problem' link, which opens a panel to another screen where they can report the issue.

![](https://github.com/loftzo/Immigrant-Attorney-Request/assets/58479250/a318ecbb-4992-420c-9339-9c7714379fad)

Upon a successful submission, the 'AttorneyRequest' Object is saved to a database designed by Jacob Smith, and its status is set to indicate that it is ready to move on to the Review step. It is also placed into a custom queue object made by Jacob Smith to supply in the Review step.

Review
======

Implemented by Brendan Pagano, the review step is when a human reviewer can request any attorney requests in the ReviewQueue, and view the data visually on the interface. They are then able to review the application for common typos, misspellings, or misunderstandings. They are able to type and attach notes that stay with the AttorneyForm object, and either Reject or Approve the application. Upon approval, it gets sent to the ApproveQueue object, where it waits until an Approver requests it.

![](https://github.com/loftzo/Immigrant-Attorney-Request/assets/58479250/8aa5627a-4b8b-420f-8872-de903cabf15a)

Approval
========

Implemented by Chidera Oragui, the approval step is when a human approver can request any attorney requests in the ApproveQueue, and view the data visually on the interface. They are then able to review the application for legitimacy, such as verifying phone numbers and the Attorney's credentials. They are able to attach notes and either Reject or Approve the form. Upon rejection, it is sent back to the review queue with notes attached, either to fix typos, or for the reviewer then reject the application, sending it back to the original filer with notes attached.

![](https://github.com/loftzo/Immigrant-Attorney-Request/assets/58479250/d5ec13ca-e5c3-4fce-a1d2-b13c31ff7dc5)
