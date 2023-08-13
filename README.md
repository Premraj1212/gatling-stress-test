Gatling for Stress Testing Web Application - Java
============================================

Explored features of Gatling for stress testing the Acetoys application using Java

## Stack

| Category   | Value   |
|------------|---------|
| Language   | Java    | 
| Build Tool | Maven   |
| Report     | Gatling | 

### Key Features
* Externalise data and feed test data to script through .csv, custom and .json
* Session memory to hold or track any data during execution.
* Supports Conditional logic such as DoIf
* Building abstractions of User journey
* ScenarioBuilder is used for grouping of test under common cluster and capable to provide weightage on each test
* PopulationBuilder is used for injecting the workload models
  * Closed System - where you can control the concurrent number of users
  * Open systems - where you can control the arrival rate of users
* Runtime parameters to support Continuous Integration such as Jenkins

### Run Test
Tests can be run on local and support CI.


 
