
def test(){
    withMaven(maven: 'jenkins-maven'){
        mvn test
    }
    junit 'maven-log4j/target/surefire-reports/*.xml'
}