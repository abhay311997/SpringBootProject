# Spring Boot Basic Project 

## Development 

### Test API 
Made a spring boot project with the following dependencies:
- Spring Web
- Spring Boot DevTools
  which run on "springbasics/src/main/resources/application.properties:server.port"
- example: application.properties:server.port=5454

1. Made a simple controller HelloController to handle the requests,
    like  /hello/world → {http://127.0.0.1:5454/hello/world},  return "Hello World !!!"
2. Made a method to handle requests with a RequestParam
Pass a parameter to the request and return a response with the parameter value
  like /hello/person?name=John → {http://127.0.0.1:5454/hello/person?name=John}, return "Hello John !!!"
3. Made a method to handle requests with a path variable
Pass a parameter to the request and return a response with the parameter value
  like /hello/person/John → {http://127.0.0.1:5454/hello/person/John}, return "Hello Person John !!!"

There is [a postman collection](./Spring Basics.postman_collection.json) to test the API

## Assignment

### 03. Make a Student Manager (only  Controller)

#### Project Description

Make a Student Manager with the following features:

- Create a student 
  - 400(Bad Request) Error if rollNo is missing or already exist
  - 400(Bad Request) Error if name is missing
  - 400(Bad Request) Error if dateOfBirth is missing or invalid (before today)
- List all students
- Fetch a student by rollNo
  - Respond with 404(Not Found) if student with that rollNo is not exists
- Update a student (isPresent and dateOfBirth can be updated)
  - Respond with 404(Not Found) if student with rollNo is not found
  - > HINT: `@PatchMapping("/{rollNo}")` can be used to update a student by rollNo
- Delete a student
  - Respond with 404(Not Found) if student with rollNo is not found
  - > HINT: `@DeleteMapping("/{rollNo}")` can be used to delete a student by rollNo
    
#### Bonus Tasks 

1. Sort and filter functionality for list students 
   1. `GET /students?isPresent=true` should return all present students
   2. `GET /students?isPresent=false` should return all absent students
   3. `GET /students?sort=dateAsc` should return all students sorted by Ascending date of birth
   4. `GET /students?sort=dateDesc` should return all students sorted by Descending date of birth


2. Bulk Delete students which are completed to be implemented 
   1. `DELETE /students?isPresent=true` should delete all present students