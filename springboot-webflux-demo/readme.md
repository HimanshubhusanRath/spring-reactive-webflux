## Blocking / Non-reactive mode
Use the below URLs to test the application with blocking mode where the client will wait until it gets the entire response in one shot.

* http://localhost:9091/customers/blocking (using rest controller)
* http://localhost:9091/router/customers (using router function)


## Non-Blocking / Reactive mode
Use the below URLs to test the application with non-blocking mode where the client keeps getting partial response and starts displaying the same.

* http://localhost:9091/customers/non-blocking (using rest controller)
* http://localhost:9091/router/customerstream (using router function)

 
## Combining multiple REST api calls to single response
We can combine multiple Rest api calls to a single response using reactive programming.
* http://localhost:9091/school/all - This api internally calls two Rest api (`/students` and `/teachers`) and combines the responses of these two apis.
