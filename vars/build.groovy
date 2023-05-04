
def build(){
    withMaven(maven: 'jenkins-maven'){
        sh "mvn clean compile"
    }
}