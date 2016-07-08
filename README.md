# CRUD RESTful Web Service with Spring Boot

This guide walks you through the process of creating an application that provides a CRUD RESTful web service.
You’ll build an application that uses Spring’s @RestController to publish a RESTful Web Service on http://localhost:8080/data.
In particular a DataLogger will be simulated. THe RESTful WebService will allow to:
- POST data
- GET data
- DELETE data

## The classes
The following classes are involved:
- DataLogger represents a container for data (e.g., List<Data> data). It is a @Service.
- Data represent the data collected by the DataLoger:
```json
{
   "temperature": 25.76,
   "timestamp": 1467993597000 //in ms from epoch
}
```
- DataLoggerController is the service to manage the DataLogger. It needs the DataLogger to be injected (to this end use Dependecy Injection with Annotations) to operate on the DataLogger to add, remove, get the collected data.
- DataLoggerControllerConfiguration to implement the Dependency Injection programmatically by using Spring Annotations.

The following Web Methods will be available:
- POST http://localhost:8080/data with Data in JSON format as @RequestBody
- GET http://localhost:8080/data?from=start_time_in_ms_from_epoch&to=end_time_in_ms_from_epoch (note that from and to @RequestParam are optional, i.e., required = false)
- DELETE http://localhost:8080/data?timestamp=timestamp_in_ms_from_epoch, where timestamp is the timestamp of the data record to delete from the Datalogger

## Actions to be done
- Run (Debug) the application as Spring Boot application.
- Test the RESTful Web Service with Postman.
- Debug your code if necessary to understand the behavior of the developed Web Service.

## Additional (optional) step
Develop a Test Unit for the RESTful Web Service

## Hints
- Use the wizard "Spring Starter Project" available in Eclipse STS.
- Create the Web Service using the Spring Annotations. Use @RestController, @RequestMapping, @PathVariable, @RequestBody and @RequestParam to create the Web Service and the Web Methods.
- Create a @Configuration to tell the Framework how to initialize the @Bean defined.
- Use @Service and @Autowired to define the @Bean the framework has to manage and to tell the Framework where to inject them, respectively.
- (Optionally) Create a test case by using @WebAppConfiguration and @Autowired annotations and WebApplicationContext and MockMvc classes;

