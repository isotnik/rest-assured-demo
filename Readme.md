# Rest Assured Demo Project
### Project demonstrating my skills in API testing using RestAssured library

Jira is chosen as subject for demonstrating as its instance can be easily created by anyone for free.
There are smoke E2E test for Jira Rest API using plain TestNG as well as Cucumber with TestNG. Combining Cucumber and "plain" tests in one project is not real-life example, just a demonstration of different approaches.

To run tests:
1. Create properties file in `src/main/resources/jira.properties` (use `jira_example.properties` as an example)
2. Execute `mvn test -Dtest=JiraSmokeE2ETest` for "plain" Jira smoke tests
3. Execute `mvn test -Dtest=JiraSmokeE2ECucumberTest` for Cucumber  Jira smoke tests