# Notice: Repository Deprecation
This repository is deprecated and no longer actively maintained. It contains outdated code examples or practices that do not align with current MongoDB best practices. While the repository remains accessible for reference purposes, we strongly discourage its use in production environments.
Users should be aware that this repository will not receive any further updates, bug fixes, or security patches. This code may expose you to security vulnerabilities, compatibility issues with current MongoDB versions, and potential performance problems. Any implementation based on this repository is at the user's own risk.
For up-to-date resources, please refer to the [MongoDB Developer Center](https://mongodb.com/developer).


# spring-dates-demo
Quick demo of working with dates in MongoDB using Spring Data

When the application is run, it connects to the specified MongoDB instance and 
creates three 'customer' documents in the 'customers' collection, each of which
includes an _id, a name and a date-of-birth field.

The application then shows expamples of how to search for a customer by specific ID, 
a specific DOB, or a specific birth month.
