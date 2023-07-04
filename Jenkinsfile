node {
  stage('GIT Checkout') {
      git 'https://github.com/n-charan/my-app-cicd'
  }
  stage('Compile-Package') {
      sh 'mvn package'  
  }
}
