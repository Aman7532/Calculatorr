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
                    sh 'docker version'
                    sh 'docker info'
                }
            }
        }

		
		stage('Build Docker Image'){
			steps{
				script{
					sh "docker build -t ${DOCKER_IMAGE_NAME} ."
				}
			}
		}
		
		stage('Push Docker Images'){
			steps{
				script{
					docker.withRegistry('', 'DockerHub') {
						sh 'docker tag calculator aman7532/calculator:latest'
						sh 'docker push aman7532/calculator'
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
