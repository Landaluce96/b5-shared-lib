
def jacocoTest(){
    withMaven(maven: 'jenkins-maven'){
        sh 'mvn jacoco:prepare-agent jacoco:report'
    }
}