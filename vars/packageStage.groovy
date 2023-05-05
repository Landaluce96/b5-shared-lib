
def packageStage(){
    try{
        stage('Package'){
            sh 'mvn -B -DskipTests package dependency:copy-dependencies'
            echo "***************"
            echo "*** ARCHIVE ***"
            echo "***************"
            zip zipfile: 'app.zip', archive: true, overwrite: true, glob: 'target/*.jar,target/dependency'
            archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
            archiveArtifacts artifacts: 'target/dependency', fingerprint: true
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
