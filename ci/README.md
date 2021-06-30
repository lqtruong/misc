Docker find path mounted to HOST: C:\Users\truong.lequoc\jenkins_data\


Change Jenkins Admin Password if forgot

	ls var/jenkins_home/users/truong_5246216019566647562/config.xml

	cat var/jenkins_home/users/users.xml
	vim var/jenkins_home/users/truong_5246216019566647562/config.xml


Jenkins Login: truong/123456

SONAR login: admin/admin

mvn SONAR: 
mvn org.sonarsource.scanner.maven:sonar-maven-plugin:3.7.0.1746:sonar

Troubleshoots: [Checks API] No suitable checks publisher found

Jenkins Pipeline
	- add jacoco in Spring Boot project
	- add plugins in Jenkins: Checks API, JUnit, Maven, JDK11
	
Connect Jenkins to SONAR
	- install SONARQUBE Scanner plugin in Manage Jenkins > Global Tool Configuration > SonarQube Scanner
	- Configure SonarQube Server in Manage Jenkins > Configure System > SonarQube Servers
	- Go to SONAR and generate Token to login
	
	
ls /var/jenkins_home/workspace/ci-sample