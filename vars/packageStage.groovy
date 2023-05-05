
def packageStage(){
    try{
        stage('Package'){
            sh 'mvn -B -DskipTests package dependency:copy-dependencies'
            echo "***************"
            echo "*** ARCHIVE ***"
            echo "***************"
            archiveArtifacts artifacts: 'target/**/*.jar', fingerprint: true
            echo "***************"
            echo "*** ARCHIVE ***"
            echo "***************"
        }
    }catch(err){

    }finally{
        def currentResult = currentBuild.result
        if (currentResult == 'SUCCESS') {
            
        }	
    }
}
