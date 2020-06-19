# RequestIdentifiableLogger-SpringBootAOP

This project is an example to demonstrate how to attach a uuid with all the logs being printed for one particular request.

Using: To achieve this, the ```java @IdentifiableLogging``` annotation is created which can be added on any method. All the logs then being printed throughout the execution of that method (and methods called from within that method and so on) will be appended with the same unique log id. Use the custom Logger class ```IdentifiableLogger``` for logging.

Here, the annotation has been placed on the controller method, which is the entry point for any request.

Limitations: Since the annotation is based on Spring Aspect Oriented Programming, this will not work if the method on which this annotation is placed is called from another method within the same class.
