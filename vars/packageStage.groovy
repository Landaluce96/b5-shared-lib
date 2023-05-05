
def packageStage(){
    try{
        stage('Package'){
            sh 'mvn -B -DskipTests package dependency:copy-dependencies'
        }
    }catch(err){

    }finally{
        def currentResult = currentBuild.result
        if (currentResult == 'SUCCESS') {
            echo "***************"
            echo "*** ARCHIVE ***"
            echo "***************"
            zip zipfile: 'app.zip', archive: true, overwrite: true, glob: 'target/*.jar,target/dependency'
            archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
            archiveArtifacts artifacts: 'target/dependency/*.jar', fingerprint: true
            echo "***************"
            echo "*** ARCHIVE ***"
            echo "***************"
        }	
    }
}
