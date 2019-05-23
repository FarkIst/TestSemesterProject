# TestSemesterProject
Test Assignment for Group 10

## Table of Contents
1. [User-Stories](##User-stories)

2. [Discussion](##Discussion)

[Language](###Language)

[Database](###Database)

[Process](###Process)


## User-stories

#### Administration

* As an administrator I want to be able to register courses to the school, so that I can ensure they are appropriate

* As the administration I want to be able to approach a teacher about teaching an upcoming subject, so that we know that the teacher is experienced

* As an administrator I want to be able to offer teachers a teaching position in a selected course, so that they can be properly vetted

* As an administrator I want to be able to keep track of present and past teachers and their subjects, so that if a relevant teaching arises in the future I can possibly offer them a job.

* As an administrator I want to be able to ensure that all teachers have a adult pedagogical basic degree or a similar degree, to ensure that teachers all have teaching abilities that meet the schools’ ethos

* As an administrator I want to be able to keep track of time in relation to the current semester, so that semester planning can start 2 months before semester starts. 

* As an administrator I want to be able to keep track of how long a subject has been consecutively running, so that after 3 years we know that it needs to be changed. 

* As an administrator I want to be able to cleanup subjects, so that we can maintain a good variety of subjects at the school.

* As an administrator I want to keep track of how many meetings a course has had, so that we know whether a course has enough participants by the third meeting (12 participating students)

* As an administrator and teacher I want to keep track of how many courses a teacher is currently teaching, so that I can ensure that a maximum of 3 courses is maintained and teaching standards are maintained at the school

* As an administrator I want to keep track of a students payments and registration, so that I know when to enroll a student in a course

* As an administrator I want to be able to group a course into different categories so that they can be identified easier

* As an administrator I want to be able to create one or multiple courses within a subject, so that students have something to sign up for

* As an administrator I want to be able to keep track of course information from the last two years, so that demand for the courses can be figured out

* As an administrator I want to be able to distinguish between teachers and enrolled teachers, so that I can more easily handle administrative tasks and future teacher enrollment

* As an administrator I want to be able to keep track of potential teachers information, so that they can be registered in the teachers register if they are suitable

#### School Committee 

* As a member of the school-committee I want to be able to keep track of the teaching hours of teachers, so that I am sure that teachers in the school committee have all taught over 20 hours and are experienced

* As a member of the school-committee I want to be able to suggest new subjects to the school, so that the school can maintain a variety of subjects being taught. 

* As a member of the school-committee I want to be able to vote(simple majority vote) for subjects that have been suggested, so that only the most popular subjects among the school committee have a presence at the school

* As a member of the school-committee I want to ensure that subjects that are suggested are over 20 hours, so that subjects are worth the administrative effort put into them

#### Student

* As a student I want to be able to enroll in a course, so that I can hopefully participate in the class should the class become popular enough to be registered

* As a student I want to be able to see a list of available courses with their information, so that I can decide whether I wish to enroll in one of them

#### Teacher

* As a teacher I want to be able to apply for a teaching position in a course, so that I can possibly get a teaching position.

* As a teacher I want to be able to signup for a course should I be deemed as suitable by the administration, so that I can teach at the school

#### General

* As a user I want to be able to log in, so that I can perform tasks and check information that are user specific

* As a teacher, student and administrator I want to know what semester we are in(fall or spring) so that I know the teaching season and what courses there will be. 

* As a teacher and student I want to be able to keep track of the room and schedule where courses are located, so that I know where to show up. 

* As an administrator // teacher?? I want to keep track of how many students are enrolled in a specific course so that I know if there are 9 enrolled students and the course can being their meetings and whether 12 participants are enrolled by the third meeting and if the course is to be taught at the school


## Discussion

### Process

We started development of our system with a backend API with a combination of TDD with JUNIT as our supporting test tool. We first converted the assignment instructions into a list of user-stories, which could more easily be interpreted and developed into code. We then converted these user-stories into BDD Cucumber scenarios, which generated our feature step-definitions which could then be filled with JUNIT code. 

### Language

We used Java Maven for our backend API supported by Cucumber and JUNIT for testing.
For our frontend we used Javascript with a REACTJS framework supported by Jest/React-Testing-Library/Cypress for our tests. 

### Database

Database was done in MYSQL using Hibernate

![alt text](https://github.com/FarkIst/TestSemesterProject/blob/master/SYS_DB.png)

#### Some notes

* Location table is synonymous with address
* Schedule is a period of time
* There are multiple 'User' types: Student, Teacher etc.
* A course is a lesson, and a subject is the topic. (FX. Subject: Computer-science -> 
Course: classSem1B)
* Schedule is what a lot of relationships in the database are built around.
A schedule will have a relationship with a room(room has many schedules) and a schedule will have a course.

#### Reflections 

https://docs.google.com/document/d/1Y6LY2YDoqYwUT1l4rdHk4ZQ6WUH6u0lNPf2dAy2E3FI/edit?usp=sharing