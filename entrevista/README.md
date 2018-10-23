# TEST MERCADO LIVRE

 Rafael Holtz - rholtzbr@gmail.com

# Configuraçãoes 

	build com maven
	compiler source 1.10


### Instalação


1 - Executar o install pelo maven
	
	mvn install 

	jar gerado em entrevista\target\entrevista-0.1.jar
	
2 - Executar o jar gerado 	
	
	java -jar /entrevista/target/entrevista-0.1.jar

3 - Acesso localhost:8080

	Startup com sucesso mensagem "Hello"
	
4 -  Arquivo de log

	/tmp/entrevista-0.1.log	
 
### Test

	Template do Postman para executar as requisições
	
		src/test/java/ml.postman_collection_v1.json
		src/test/java/ml.postman_collection_v2.json


### URL's remotas.
	
	Hello - GET
		http://ec2-18-228-153-13.sa-east-1.compute.amazonaws.com:8080

	Nivel 2 - POST- mutant
		http://ec2-18-228-153-13.sa-east-1.compute.amazonaws.com:8080/mutant
		
	Nivel 3 - GET - statis
		http://ec2-18-228-153-13.sa-east-1.compute.amazonaws.com:8080/statis

 