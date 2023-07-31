# Documentation
## Assignment: Junior Coding Take Home Task

### Intro
This project was written by our akquinet code monkeys©. They don't have any experience in coding and best practices. 
As one can assume, this code has some potential to be refactored. 

The main purpose of this program is to read two csv files. One is a movie database and the other one is 
a rating system for the movies. The program asks you to enter a movie id, from which it will search and calculate the 
average rating 

### Assignment
Please refactor this code to a point, where you think, this code looks good. There is no need to hold onto any parts of 
the code. You can even rewrite it in another language. 

You can check if your refactorings work by running the provided tests. The test must not be altered.

## Possible solution

### Intro
During the process of refactoring the provided code, the approach was to model it into entities represented by corresponding classes. The entities for movies and ratings have been rewritten as separate classes: ```Movie.java``` and ```Rating.java```, respectively. These classes represent either a movie or a rating from the provided files.

To handle the files, the ```FileService.java``` class was created. Its logic is to read the CSV files for movies and ratings. For a more realistic and organized approach, the list of all movies could have been split into one of the classes mentioned before, which would handle either the movie or ratings CSV files. This would have further modularized the codebase and provided a more flexible design, depending on how much this *project* could be developed further in the future.
An example of implementing this modular approach can be observed in the ```UserService.java``` class, where a single method is dedicated to handling user input. Instead of directly writing the code for this method in ```Main.java```, which is used only once, the decision to create the UserService class offers the possibility of expanding the codebase with additional user-related services in the future.

### Usage of a more efficent collection framework
The initial code writes the entries of the CSV files into a ```List<List<String>>``` Collection. As we have a clear key (the *movieID*) provided, a ```HashMap``` has been utilized to work more efficiently with the data from the files.
Using a HashMap instead of a List<List<String>> offers several advantages in this scenario. Firstly, it provides efficient lookup based on the key (the *movieID*), enabling faster access to specific values. Secondly, it simplifies code readability by allowing direct access to values using the key. Thirdly, a HashMap enforces uniqueness for keys, ensuring data integrity and preventing duplicates.

### Data consistency
To clarify the concept of data consistency, the provided code demonstrates how values read from the files are initially treated as Strings and later converted into different data types.
```java
String[] values = entry.split(COMMA_DELIMITER);
this.movieList.put(Integer.valueOf(values[0]), new Movie(Integer.parseInt(values[0]),
        values[1], new ArrayList<>(Arrays.asList(values[2].split("|")))));
```
For instance, the first value from the movie CSV file is converted into an Integer and used as the key in the HashMap. This approach considers that CSV files could be viewed as databases, where the movie ID is typically represented as an integer or long data type. Ultimately, all values read from the files are transformed into data types that are more suitable for direct usage in a backend system.

### Error handling
The error handling is implemented at the lowest level of the code, specifically where the CSV files are read, and potential ```IOExceptions``` are encountered. The primary intent behind this approach was to log the errors. At present, the *Logger* class merely writes the errors to the console, which is similar to using ```e.printStackTrace()```. Nevertheless, this serves to emphasize the importance of error logging, especially for more complex issues that may arise during the assignment, even though a dedicated logging component was not deemed necessary.

Error handling occurs directly within the method and does not involve throwing exceptions up to the main method of the project. E.g.:
```java
} catch (IOException e) {
    logger.severe(e.toString());
    System.exit(1);
}
```
If errors occur while reading either the movie or the ratings files, the program will terminate. However, it could be considered to allow the program to continue execution if errors are encountered while reading the ratings CSV. Since a movie might exist without a rating, treating errors in the ratings file as warnings, rather than critical errors, could be a viable option. Nevertheless, considering that the logic of the program expects an average rating for a movie, terminating the program upon encountering an error in reading the ratings CSV is also appropriate. This consideration is further reinforced by the fact that the test cases won't function correctly without the ratings.
