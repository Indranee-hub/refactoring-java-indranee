![Architectural-Diagram](https://user-images.githubusercontent.com/66011703/170743058-3b8ab919-1d8a-4942-aa84-846b8cbf6668.JPG)
# Steps followed for Refactoring

To keep it simple, didn’t use any framework to avoid unnecessary installations of jars. Created a simple Java application.

## Problem Statement:

There can be n types of movies.
Different movies will be having different condition to generate cost.
Different movies can have different logic for bonus point calculation.
The generated statement must contain certain predefined values. (Covered with test in Main.java class)



## Approach:

As there will be different genres of movies with some common properties, I used Factory Design Pattern which allows the sub-classes to choose the type of objects to create.

Movie.java - the abstract class with the common properties.

MovieFactory.java – Factory class to create Object based on Movie Type.

ChildrenMovie.java, NewMovie.java, RegularMovie.java- extends class Movie.java and override cost calculation and bonus calculation method.

Used more meaningful variable names. 

Instead of declaring multiple strings, used StringBuilder with append method as StringBuilder is mutable and memory efficient, and the fastest in string manipulation

Removed if-else with Switch case.

Covered negative scenarios with exception handling.

Covered possible scenarios with testcases using Junit.

Used Enum for movie Types for compile-time type safety.

Tried to keep the application in align with the original code so that the test suit pass without much changes.

