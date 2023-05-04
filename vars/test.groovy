
def test(){
    withMaven(maven: 'jenkins-maven'){
        sh 'mvn test'
    }
    junit 'maven-log4j/target/surefire-reports/*.xml'
}