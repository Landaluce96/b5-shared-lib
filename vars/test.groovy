
def test(){
    withMaven(maven: 'jenkins-maven'){
        sh 'mvn test'
    }
    junit 'target/surefire-reports/*.xml'
}