
def build(){
    stage('Build'){
        withMaven(maven: 'jenkins-maven'){
            sh "mvn clean compile"
        }
    }
}