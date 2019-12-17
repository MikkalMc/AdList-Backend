# AdList-Backend
This is the backend RestAPI server written in Java Spring. 
In this repository, you will find instances of
- authorization
- authentication
- dependency injection
- MVC patterns 
- Database scaffolding via Jakarta Persistence library

There are two models in this repository: 
  - Users
  - Posts
Both users and posts have standard CRUD operations available.
User access to these models are available through the models which are connected to HTTP endpoints found in controller files.

Steps to use application to see functionality.
  1) Press press register button to register a new user.
     - Fill out username and password  
     - Press submit
  2) Go to login component, user the same register form to login to the application
     - this should return a authorization bearer token that will be displayed on the front end for project purposes.
  3) Go to posts page, here you will be able to perform "post" creation, fetching and deleting.
