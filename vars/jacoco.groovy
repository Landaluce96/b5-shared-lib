
def jacocoTest(){
    sh 'mvn jacoco:prepare-agent jacoco:report'
}