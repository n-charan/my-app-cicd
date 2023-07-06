node {
  tools {
    maven 'my-maven' 
  }
  stage('GIT Checkout') {
      git branch:'main', url:'https://github.com/n-charan/my-app-cicd'
  }
  stage('Compile-Package') {
      sh "mvn package"
  }
}
