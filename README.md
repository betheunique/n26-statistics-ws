# n26-statistics-ws
Coding Challenge.

# N26 Case Study Problem Statement
The main use case for our API is
to calculate real time statistic from the last 60 seconds. There will be two APIs, one of
them is called every time a transaction is made. It is also the sole input of this rest
API. The other one returns the statistic based of the transactions of the last 60.

## How to run
You can run the application from Maven. To build the application you will need Maven and Java8. After few seconds the application should be available, for example http://localhost:8080/v1/statistics.

### Maven
Form the repository base folder run:
```
mvn spring-boot:run
```
## Java standalone executable
```
mvn package
java -jar target/n26-statistics-ws-0.0.1-SNAPSHOT.jar
```
## Application End Points 
````
POST /v1/transactions
````
Every Time a new transaction happened, this endpoint will be called.
```
Request Body:
{
"amount": 12.3,
"timestamp": 1478192204000
}
```

Where:
````
● amount - transaction amount
● timestamp - transaction time in epoch in millis in UTC time zone (this is not current
timestamp)

Response: Empty body with either 201 or 204.
● 201 - in case of success
● 204 - if transaction is older than 60 seconds
Where:
● amount is a double specifying the amount
● time is a long specifying unix time format in milliseconds
````
````
GET /v1/statistics
````
This returns statistics of last 60 seconds transactions.
```
Response:
{
"sum": 1000,
"avg": 100,
"max": 200,
"min": 50,
"count": 10
}
```
Where:
```
● sum is a double specifying the total sum of transaction value in the last 60 seconds

● avg is a double specifying the average amount of transaction value in the last 60
seconds
● max is a double specifying single highest transaction value in the last 60 seconds
● min is a double specifying single lowest transaction value in the last 60 seconds
● count is a long specifying the total number of transactions happened in the last 60
seconds.
```

## Cobertura Code Coverage
```
mvn cobertura:cobertura
```
Code Coverage result will be in target/site/index.html