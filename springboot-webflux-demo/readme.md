Blocking / Non-reactive mode
=============================
Use the below URLs to test the application with blocking mode where the client will wait until it gets the entire response in one shot.

* http://localhost:9091/customers/blocking (using rest controller)
* http://localhost:9091/router/customers (using router function)


Non-Blocking / Reactive mode
==============================
Use the below URLs to test the application with non-blocking mode where the client keeps getting partial response and starts displaying the same.

* http://localhost:9091/customers/non-blocking (using rest controller)
* http://localhost:9091/router/customerstream (using router function)
