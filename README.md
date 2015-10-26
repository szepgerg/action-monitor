# action-monitor

## Build
`mvn package`

## Configuration
The application uses MongoDB. To configure the host, port, user, and password open the **application.properties** file and set the following lines:
```
spring.data.mongodb.host=127.0.0.1
spring.data.mongodb.port=27017
spring.data.mongodb.username=example
spring.data.mongodb.password=pass
```

## Run
`java -jar target/action-monitor-1.0.jar`

## Usage
The application exposes the following REST endpoints:

*host:port/user* - Supports Http POST and PUT for inserting/updating a db row. The expected JSON format:
```
{
  "id": "id0",
  "name": "name0"
}
```
*host:port/healthy* - Supports Http GET request to get the application status.

*host:port/version* - Supports Http Get request to get the application version.

## GUI
Click the 'Start monitoring' button to start monitoring the DB insert/update operations.

