# Salesforce Test Automation Framework
Tests checklist:

### UI
#### Accounts and contacts
1. Creating account with all data fields filled;
2. Creating account with necessary fields filled;
3. Creating account with empty data fields (error checks);
4. Editing account;
5. Deleting account;
6. Reading account main fields;
7. Login with invalid credentials;

Same tests for contacts.

### API
#### Accounts and contacts
1. Create account with all complete data fields;
2. Create account with necessary fields;
3. Get list of accounts;
4. Read account;
5. Edit account;
6. Delete account;

Same tests for contacts.

# Installation and running guide
1. Register Salesforce dev account here: https://developer.salesforce.com/signup
2. Confirm your email and login to Salesforce system
3. Register your connected app for API using guideline: https://www.sfdcstop.com/2019/01/how-to-connect-to-salesforce-with.html
   !!!IMPORTANT!!! write down following data from point 3:
   - Username (email)
   - Password
   - VerificationCode
   - Client_ID (from Connected App)
   - Client_Secret (from Connected App)
4. Activate Salesforce API using guide: https://help.salesforce.com/s/articleView?id=release-notes.rn_security_username-password_flow_blocked_by_default.htm&release=244&type=5

### Running Locally
1. Checkout project from Git
2. Open src/maim/resources/config.properties and set following properties:
   * LoginUrl = https://login.salesforce.com/
   * ApiUrl = %Your Salesforce Domain Address%, e.g. https://mydomain-dev-ed.develop.my.salesforce.com/
   * password = password saved in main paragraph's p3;
   * verificationCode = Verification Code saved in main paragraph's p3;
   * login = username (email) saved in main paragraph's p3;
   * grant_type = password;
   * client_id = Client_Id saved in main paragraph's p3;
   * client_secret = Client_Secret saved in main paragraph's p3;
3. Run command 'mvn clean test'

### Running via Jenkins
1. Add 'Allure Reporting' plugin to make resulting report look great;
2. Create new Jenkins pipeline with running schedule of your choice; 
3. Set checkbox 'This project is parametrized' to true;
4. Add following parameters with default values:
   * Git Parameter: Name - BRANCH, Parameter Type - Branch, Default Value - origin/main
   * Choice Parameter: Name - BROWSER, Choices: Chrome, Firefox
   * String Parameter: Name - LOGINURL, default value - https://login.salesforce.com/
   * String Parameter: Name - APIURL, default value - %Your Salesforce Domain Address%, e.g. https://mydomain-dev-ed.develop.my.salesforce.com/
   * String Parameter: Name - LOGIN, default value - username (email) saved in main paragraph's p3;
   * String Parameter: Name - PASSWORD, default value - password saved in main paragraph's p3;
   * String Parameter: Name - VERIFICATIONCODE, default value - Verification Code saved in main paragraph's p3;
   * String Parameter: Name - GRANTTYPE, default value - password
   * String Parameter: Name - CLIENT_ID, default value - Client_Id saved in main paragraph's p3;
   * String Parameter: Name - CLIENT_Secret, default value - Client_Secret saved in main paragraph's p3;
5. In definition select 'Pipeline script for SCM';
6. In SCM select 'Git';
7. Set https://github.com/MKruglov250/salesforceAutomation.git in 'Repository URL' field
8. Add Branch to build - specify $BRANCH as Branch Specifier
9. Set Jenkinsfile in 'Script Path' field

Build and run Autotests as needed. Sit back and relax watching Jenkins doing the job. 
