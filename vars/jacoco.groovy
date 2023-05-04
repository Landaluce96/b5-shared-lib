
def jacoco(){
    withMaven(maven: 'jenkins-maven'){
        sh 'mvn jacoco:prepare-agent jacoco:report'
    }
    jacoco()
}