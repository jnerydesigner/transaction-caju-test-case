![Banner application](https://raw.githubusercontent.com/jnerydesigner/transaction-caju-test-case/main/assets/transaction-caju-test-case.png)

# Transaction Caju Test case

### Request Payload example

```
{
	"account": "123",
	"totalAmount": 100.00,
	"mcc": "5811",
	"merchant": "PADARIA DO ZE SAO PAULO BR"
}

```

### New Diagram Flow Application


![Current diagram Flow Application](https://raw.githubusercontent.com/jnerydesigner/transaction-caju-test-case/main/out/arquitecture/Flow%20Diagram.png)


### Start Project

1. The application.properties needs to include the environment variables, they will be in the message


2. Run the docker command

```
docker-compose up -d
```

3. Create jar file with below maven command

```
mvn package
```

4. Run the created jar

```
java -jar ./target/transaction_caju-0.0.1.jar
```

5. Includes a file with the insomnia json in the resource folder, there will be the environment variables included

6. the application swagger is at the address

[Swagger of the Application](http://localhost:5455/swagger-ui/index.html)


7. Front end in vue for some tests, not finished

[Repository FrontEnd](https://github.com/jnerydesigner/transaction-caju-test-case-frontend)

### Comments in Pt-br

* Levando-se em consideração o tempo, poderia ter feito mais features, incluindo uma autenticação, testes, e um frontend mais elaborado, espero ter ajudado e agradeço desde já a confiança da Caju.






