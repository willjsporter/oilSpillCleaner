# Oil Spill Cleaner

## What am I?
This is a project to program a simple robot that, given an area and a starting point within that area, can navigate to specified positions in order to clean up oil spills.

The user specifies input by sending data as JSON to an endpoint from where the instructions can be processed.

When it has finished running it will tell the user where it has ended up (and therefore would need to be collected from) and how many patches of spilt oil it has cleaned.

The project is only to deal with the navigation side rather than the cleaning side.

## How to run me

Maven is required to build and run this project. Installation instructions can be found at `https://maven.apache.org/install.html`.

Once maven is installed, to install all external libraries and dependencies, and to build the project after getting the source code, run `mvn install` in the terminal.

To use the cleaner, type 
`mvn spring-boot:run` 
into the terminal from the home directory of the project.

##How to send instructions to the cleaner

To send instructions to the cleaner, these should be sent via an HTTP POST request with the instructions (in JSON) as the request body to the `/sendInstructions` end point.
This can be done via curl or via an application like Postman. It is necessary to specify that the content type of the post body is JSON.

If using curl, an example of how to send instructions is below:

```
curl -X POST -H "Content-Type: application/json" -d @path/to/instructions.json http://localhost:8080/sendInstructions
```

This assumes that the request is being made to a local server; replace the `http://localhost:8080` with the appropriate base url when the application has been deployed.

For the instructions file that will be sent in the request, it is necessary to structure the instructions correctly as JSON. An example of how the instructions passed in the JSON body might look is as follows:

```
{
  "areaSize" : [5, 5],
  "startingPosition" : [0,0],
  "oilPatches" : [
    [1, 0],
    [2, 0]
  ],
  "navigationInstructions" : "NESEENN"
}
```

This would indicate that there is a 5x5 area and that the cleaner will start at the bottom left corner (the south-west corner). There are patches at coordinates (1,0) and (2,0) and the navigation instructions mean that the cleaner will pass through the oil spills on move 3 and 4.

The output for this example would be as follows:
```
{
  "finalPosition" : [3, 2],
  "oilPatchesCleaned" : 2
}
```

## How to run the tests

The tests can be run through maven by inputting the command 
```
mvn clean test
```

## User Stories

The user requirements detailed when asked to build this program for the cleaner are summarised below:

1. As a user I want to be able to send instructions via JSON to an endpoint so that I have a simple way of sending instructions to the cleaner

2. As a user I want to receive a JSON response back from the cleaner so that I know where to collect it from (and this location to reflect the directions passed in the instructions)

3. As a user, if there are no directions submitted I want to see the starting coordinate as the final position so that I can verify that the cleaner has not moved.

4. As a user, I would like to see the number of oil spills cleaned up so I can see that my machine has been effective and have visibility over the quantity of oil that remains.

5. As a user, I would like to see a useful error if the cleaner goes out of bounds so I can learn from my mistakes and resend the instructions with more useful input.