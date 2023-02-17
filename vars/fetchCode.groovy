def fetchCode(){
  git url: "https://github.com/KranthiKG/Devops-Integration-SharedLib.git"
}


def GitFetch(){
 checkout scmGit(branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/KranthiKG/Devops-Integration-SharedLib.git']])
}

def fetchCode1(){
  git url: "https://github.com/KranthiKG/Devops-Integration-SharedLib.git"
}
