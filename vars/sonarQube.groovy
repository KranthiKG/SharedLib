// def sonarAnalysis(String key, String name, String url, String login){
//       sh "mvn sonar:sonar -Dsonar.projectKey=${key}	-Dsonar.projectName=${name} -Dsonar.host.url=${url}  -Dsonar.login=${login}"
// }

def sonarAnalysis(String Project_Key, String Project_Name, String Sonar_URL, String Sonar_login){
      sh "mvn sonar:sonar \
      -Dsonar.projectKey=${Project_Key}	\
      -Dsonar.projectName=${Project_Name}  \
      -Dsonar.host.url=${Sonar_URL}  \
      -Dsonar.login=${Sonar_login}"
}

// def call(Map config) {
//   stage('Sonar') {
//     withSonarQubeEnv('sonarqube') {
//       sh "mvn sonar:sonar -Dsonar.projectKey=${config.projectKey} -Dsonar.login=${config.login} -Dsonar.projectVersion=${config.projectVersion} -Dsonar.host.url=${config.hostUrl}"
//     }
//   }
// }

//      stage('Sonar') {
//             steps {
//                 sonarQube(projectKey: 'demo-jenkins', login: '4cab7b06e178c4e93a64ac2518a1281a7d480b70', projectVersion: '1.0', hostUrl: 'http://15.206.124.252:9000')
//               }
//         }
