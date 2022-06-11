# Freelance4ALL
## Description of the Application

## Demo

## Trello link
https://trello.com/b/aCB5CLqO/mds

## Use Case Diagram

## User Stories

## Build Tools

The project is developed using Andorid Studio that has a Gradle-based building tool. 
To build our project in an APK go to Build -> Build Bundle(s)/APK(s) -> Build APK(s) 
![apk_1](https://user-images.githubusercontent.com/86727047/173198634-e38f416d-b05d-4e66-9f99-804fa0a8927d.png)

To verify, go in the folder of the project and see if the 2 files ware generated:
![apk-2-bunaa](https://user-images.githubusercontent.com/86727047/173198709-a197945f-c17f-40d7-a0ad-192c7b31f305.png)

## Code Standards

The project respects the java coding standards (link: https://google.github.io/styleguide/javaguide.html): the names are sugestive, the classes name are nouns starting with upercase letters (e.g LoginActivity, ServiceAdapter etc), methods names are verb-noun combinations or verbs starting with lowercase letters (e.g insert, checkEmailPass, getServiceById).

## Design Patterns

## Bug Reporting

***Bug 1***

As any simple insert method, register (user insert in database) accepts the same email multiple times.
![telefoane_bug1](https://user-images.githubusercontent.com/86727047/173199355-72dc9ee5-de97-405e-8809-9538094b6caa.png)

The solution si to create a method that verify if an email is already in database.
![bug1_solution_bunaaa](https://user-images.githubusercontent.com/86727047/173199414-96b24aa8-a9f5-4ad8-9cae-d3e25b2b9b99.png)

![bug1_resolved1](https://user-images.githubusercontent.com/86727047/173199660-2ed9010e-1739-433b-8868-d836dc945008.png)
![bug1_resolved2](https://user-images.githubusercontent.com/86727047/173199662-881b5185-91be-4e15-9ba9-25007c43e4d1.png)

***Presenting the method*** 
  - in Dao:
  
![bug1_solution-dao](https://user-images.githubusercontent.com/86727047/173199429-e7775eb8-f490-4d1d-b810-82f31ca0604a.png)
  - in Repository:


![bug1_solution-repo](https://user-images.githubusercontent.com/86727047/173199450-6c1dd490-aae4-4a68-90c9-f2d4678f91c6.png)
  - in View:


![bug1_solution-view](https://user-images.githubusercontent.com/86727047/173199457-2d9cca2e-44da-4f9f-b644-7c20e37e7b21.png)

**Bug 2**

Every time when I wanted to use a database method, e get the following error:
![bug2](https://user-images.githubusercontent.com/86727047/173200214-afe554a5-5fdf-477a-887d-3c8263e956f0.png)

The solution to this problem is to add .allowMainThreadQueries() to every database handling initialization 
![bug2_resolve](https://user-images.githubusercontent.com/86727047/173199826-f07927f3-5988-4ffb-a1b6-24ffc65f031e.png)

**Bug 3**

We wanted to change the project's name using the methods presented on GeeksforGeeks (link: https://www.geeksforgeeks.org/different-ways-to-change-the-project-name-in-android-studio/).

Neither the first method nor the second worked.

- First one:

![bug4_sol1_1](https://user-images.githubusercontent.com/86727047/173200011-8a1df50b-1ac4-43dd-808d-9f239f79fd1a.png)
![bug4_sol1_2](https://user-images.githubusercontent.com/86727047/173200014-788886f9-dd16-4b90-9563-a0e3a488281d.png)
- Second one:

![bug4_sol2](https://user-images.githubusercontent.com/86727047/173200069-84d74e5f-c99b-4ced-b8bb-9c7c18e1a53f.png)

The third one was a success:

![bug4_sol3](https://user-images.githubusercontent.com/86727047/173200081-75c4d989-f582-44f1-9d6a-e14d1eb3ff0d.png)

The result is seen in the top bar of the application:
![bug4_sol](https://user-images.githubusercontent.com/86727047/173200113-db961eea-e589-499e-b290-869cea62b908.png)

**Bug 4**

## Contributors:
- Postolache Andreea-Miruna:
- Predescu Denisa: predescu.denisa2001@gmail.com
- Sandu Raluca-Ioana:
- Sasu Alexandru-Cristian:
