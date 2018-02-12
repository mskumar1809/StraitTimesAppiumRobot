# StraitTimesAppiumRobot

The tool set which I have choosen to automate is as below

1. Selenium Webdriver with Java
2. Appium with Java
3. Android SDK
4. Maven for Dependency Management
5. Robot Framework for Behaviour Driven Development using Keywords (similar to cucumber)
6. Eclipse as IDE
7. Git

The reasons, I have choosen this tool set is that, I am trying to create a framework which can be easily scalable, easily maintainable and easily readable, along with having the below attributes.

1. All are open source tools
2. Integrated framework for Mobile, Web and API automation 
2. Great reporting structure using Robot Framework
3. Ease of using Selenium with Java
4. Platform independent
5. Implementing BDD with ease.

Pre-requisites for running the code are as below.

1. Java 8 JDK
2. Maven
3. Google Chrome Driver 2.33 set to path

Assumptions

1. Appium Server is started manually before the execution of the tests
2. UDID of the devices are hardcoded as of now for the physical devices connected but can be made dynamic as well.


Also, please find the below link for the demo video of the automation framework, which I have worked on to automate the cases for both mobile and web.

https://drive.google.com/open?id=1qZ-najfP49YAdFKtXp_epHb2P0PqCSb0

Please feel free to clone the repo, review the code and run the code.


The project can be run from terminal/command prompt by 

cd <project_location>
mvn robotframework:run

The above command would execute the project.
