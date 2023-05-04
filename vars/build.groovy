
def build(){
    stage('Build'){
        withMaven(maven: 'jenkins-maven'){
            sh "mvn -B -DskipTests clean package dependency:copy-dependencies"
        }
    }
}