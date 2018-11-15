Tools installation
    IntelliJ IDEA (Community version) from https://www.jetbrains.com/idea/download/#section=windows
    Geckodriver (latest) from https://github.com/mozilla/geckodriver/releases
    JDK 10 from https://www.oracle.com/technetwork/java/javase/downloads/jdk10-downloads-4416644.html
    Firefox (latest)
    Maven from https://maven.apache.org/download.cgi
    Jenkins from http://mirrors.jenkins.io/windows/latest

Tools setup
    IntelliJ IDEA   default install
    Geckodriver     Unzip and put into /system32
    JDKdefault      install
    Firefox         default install
    Maven           see https://dev-pages.info/how-to-install-maven-on-windows-10/
    Jenkins         see https://dzone.com/articles/how-to-install-jenkins-on-windows

\src\test\java\test - contains test classes
\src\test\java\page - contains page objects classes
.gitignore - contains list of folders/files to be excluded for GIT sync
pom.xml - contains info about project and its configuration. Is needed for Maven
tests.xml - definition of test suite for TestNG