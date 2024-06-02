# UOY_Carla_exercise_A

Exercise A partial solution for Carla Backend Developer role 

By Uğur Özgür Yıldız

This took much longer than 3 hours, just parsing a dataset took more than that, and it's still incomplete.

SurveyController.java is the main controller class, I didn't have time to split them into different files.

For the single record fetching timestamps seemed unique so I used them as primary key since there was no ID column in the dataset. I was unable to parse the JSON file so had to manually work on the csv file. 

Only sorting by a single field works since I couldn't figure out how to accept multiple unknown number of values from the RequestParam. 

Returns a serialized JSON file.

Worked on salary_survey-1.csv, hardcoded file location since I wasn unable to figure out how to use relative file locations in Java. 

The methods are not async since the dataset is a static file and I don't know how to write custom promise-like methods for file IO operations.

