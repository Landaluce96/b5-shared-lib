
def package(){
    stage('Package'){
        try{
            sh 'mvn -B -DskipTests package dependency:copyDependencies'
        }catch{

        }finally{
            def currentResult = currentBuild.result
            if (currentResult == 'SUCCESS') {
                archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
                archiveArtifacts artifacts: 'target/dependency', fingerprint: true
            }	
        }
    }
}
