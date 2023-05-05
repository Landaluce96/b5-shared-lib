
def packageStage(){
    try{
        stage('Package'){
            sh 'mvn -B -DskipTests package dependency:copy-dependencies'
        }
    }catch(err){

    }finally{
        def currentResult = currentBuild.result
        if (currentResult == 'SUCCESS') {
            archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
            archiveArtifacts artifacts: 'target/dependency', fingerprint: true
        }	
    }
}
