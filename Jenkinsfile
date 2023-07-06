node {
  stage('GIT Checkout') {
      git branch:'main', url:'https://github.com/n-charan/my-app-cicd'
  }
  stage('Compile-Package') {
      def mvnHome = tool name: 'my-maven', type: 'maven'
      echo(${mvnHome})
      sh "${mvnHome}/bin/mvn package"  
  }
}
