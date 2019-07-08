# GildedRose-Refactoring-Kata

## Requirement
- Java 8
- Maven

## How to build the application
In the project root folder execute the following commnad:
```
mvn clean install
```

## How to run
After build the application you can run the application executing the following command:
```
java -jar target/gilded-rose-kata-0.0.1-SNAPSHOT.jar
```

This application accepts an integer number as a parameter, this parameter represent a number of days. 

e.g:
```
java -jar target/gilded-rose-kata-0.0.1-SNAPSHOT.jar 10
```

## How to add new Item
- You will need to implement the **ItemUpdateQuality** interface;
- Into the constructor, you will need to add the item's name into **ITEM_NAME** list;
- Add this new implementation into the **GildedRose** class, in the **ItemUpdateQuality** list.

## Improvements
- Added a Maven plugin to generate a runnable jar file;
- Create a Main class into a **/src/main** folder;
- Adding encoding into build process to avoid problem to run the application into different environment;