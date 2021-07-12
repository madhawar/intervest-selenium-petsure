# Petsure Web UI Automation

This automation framework employs Java/ Selenium/ TestNG/ Maven/ Log4j

Pre-requisites:
1. Your favorite Linux distro (optional)
2. OpenJDK (16 or latest)
3. IntelliJ IDEA C (or U)
4. Git

Setup:

1. Clone from Git 

## Installation

src/test/resources folder contains JSON data files.
Please add your own JSON file, without customizing existing ones as they are serving the purpose of data driven testing.

### Default JSONS (DO NOT EDIT):
* pet-common.json
* pet-extra.json
* pet-fixing.json
* pet-medical.json
* pet-min.json
* pet-type.json

## Rules

* lower case

## Usage

### -Dbrowser

* "chrome" for headless Chrome (Recommended)
* "test" for Google Chrome GUI
* "edge" and "firefox" for Microsoft Edge and Mozilla Firefox respectively. Please refrain from use.

### -DsuiteXmlFile

Type of testing. Parameters supported:
* "RegressionTest.xml" for full regression pack sans skipped/ disabled tests. (Recommended)

### -Denvironment

Environment that need to be tested. Example:

```java
mvn clean test -Dbrowser=headless -DsuiteXmlFile=Regression.xml -Denvironment=exaltwebuat.petsure.com
```

### Jenkins
Freestyle project
* Source Code Management > Git

```java
git@gitlab.intervest.lk:avanti/automation-wapp-web-ui.git
```

* Build Triggers > Poll SCM

```java
H H * * *
```

* Build > Invoke top-level Maven targets

```java
clean test -Dbrowser=headless -DsuiteXmlFile=Regression.xml -Denvironment=exaltwebuat.petsure.com
```

* Post-build Actions > Publish JUnit test results report > Test report XMLs

```java
**/target/surefire-reports/*.xml
```

* Post-build Actions > Editable Email Notification > Attachments

```java
**/target/surefire-reports/emailable-report.html
```

## Contributing

Send an email to madhawa@intervest.lk

## License
All Rights Reserved by Intervest Software Technologies.