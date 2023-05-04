
def jacocoTest(){
    withMaven(maven: 'jenkins-maven'){
        sh 'mvn jacoco:prepare-agent jacoco:report'
    }
    jacoco(
        execPattern: '**/build/jacoco/*.exec',
        classPattern: '**/build/classes/java/main',
        sourcePattern: '**/src/main'
    )
}