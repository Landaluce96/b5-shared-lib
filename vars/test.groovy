
def test(){
    sh 'mvn test'
    junit 'target/surefire-reports/*.xml'
}