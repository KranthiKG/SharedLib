def fetchCode(){
  git url: "https://github.com/KranthiKG/Devops-Integration-SharedLib.git"
}


def GitFetch(){
 checkout scmGit(branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/KranthiKG/Devops-Integration-SharedLib.git']])
}

def fetchCode1(){
  git url: "https://github.com/KranthiKG/Devops-Integration-SharedLib.git"
}

def updateDeploy(){
                        sh "cat Deployment.yml"
                        sh "git config user.email kranthikirang@gmail.com"
                        sh "git config user.name KranthiKG"
                        sh "sed -i 's+kranthikg/sharedlibimage.*+${DOCKER_IMAGE_TAG}+g' Deployment.yml"
                        sh "cat Deployment.yml"
                        sh "git add ."
                        sh "git commit -m 'Done by Jenkins Job changemanifest: ${env.BUILD_NUMBER}'"
                        withCredentials([gitUsernamePassword(credentialsId: 'githubcred', gitToolName: 'Default')]) {
                        sh "git push https://github.com/KranthiKG/Devops-Integration-SharedLib.git HEAD:main"
  
}
