[![](https://jitpack.io/v/psychogen-labs/spring-rest-over-ws.svg)](https://jitpack.io/#psychogen-labs/spring-rest-over-ws)

# Rest Over Websocket | Springboot starter
ROW (Rest Over Websocket) | Spring boot websocket that wrapps rest apis

## Description
As the name suggests, ROW creates a websocket endpoint and provides json based protocol that wraps springboot rest controllers. Therefore, with a simple configuration and some annotations, your application will be served on websocket alongside already defined http endpoints.

## Documentations
Everything you need to know is covered in [wiki pages](https://github.com/idioglossia/spring-rest-over-ws/wiki).

## Demo
A demo of this project is available [here](https://github.com/idioglossia/row-demo). This demo uses [Java Row Client](https://github.com/idioglossia/java-row-client) as client to contact row server.

## TODO

- [x] Filter chain for request handling (So developers can add their own filters)
- [X] Add support for spring security and `@PreAuthorize` annotations
- [X] Create row context so current user information is accessible
- [X] Add annotation support to register filters more easily
- [X] Add publisher and subscriber structure
- [X] Add a way to set order for filters
- [X] Add logs
- [X] Session heartbeat tracking
- [X] Pass request response to controller
- [X] Add request and response Headers
- [X] Update package names to new organization name
- [ ] Change to develop branch for next development processes
