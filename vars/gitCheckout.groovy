def call(Map config) {
    node {
        git url: "https://github.com/${config.name}/${config.repo}"
        sh 'mvn install'
        sh 'mvn clean install'
    }
}

//         stage('gitcheckout') {
//             steps {
//                 gitCheckout(name:"23ArushiJain" ,repo: "webapp_jenkins.git")
//             }
//         }
