
def jacocoTest(){
    sh 'mvn jacoco:prepare-agent jacoco:report'
    archiveArtifacts artifacts: 'target/site/jacoco/', fingerprint: true
}