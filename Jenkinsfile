pipeline{
	agent any

	tools {
            maven 'Maven'
    }
	
	environment{
		DOCKER_IMAGE_NAME='calculator'
		GITHUB_REPO_URL='https://github.com/Aman7532/Calculatorr'
	}
	
	stages{
		stage('Checkout'){
			steps{
				script{
					git branch: 'main', url: "${GITHUB_REPO_URL}"
				}
			}
		}

		stage('Build and test') {
			steps {
				script {
					sh 'mvn clean package'
				}
			}
		}
		stage('Debug Docker') {
            steps {
                script {
                    sh 'whoami'
                    sh '/usr/local/bin/docker version'  // Full path
                    sh '/usr/local/bin/docker info'     // Full path
                }
            }
        }

		
		stage('Build Docker Image'){
			steps{
				script{
					sh "/usr/local/bin/docker build -t ${DOCKER_IMAGE_NAME} ."
				}
			}
		}
		
		stage('Push Docker Images'){
			steps{
				script{
					docker.withRegistry('', 'DockerHub') {
						sh '/usr/local/bin/docker tag calculator aman7532/calculator:latest'
						sh '/usr/local/bin/docker push aman7532/calculator'
					}
				}
			}
		}
		
               stage('Run Ansible playbook') {
              		steps {
        			script {
          				ansiblePlaybook(
				            playbook: 'deploy.yaml'
          				)
        			}
      			}
    		}
	}
}							
