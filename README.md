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

-- As any simple insert method, register (user insert in database) accepts the same email multiple times.
![telefoane_bug1](https://user-images.githubusercontent.com/86727047/173199355-72dc9ee5-de97-405e-8809-9538094b6caa.png)
-- The solution si to create a method that verify if an email is already in database.
![bug1_solution_bunaaa](https://user-images.githubusercontent.com/86727047/173199414-96b24aa8-a9f5-4ad8-9cae-d3e25b2b9b99.png)
Presenting the method 

- in Dao
![bug1_solution-dao](https://user-images.githubusercontent.com/86727047/173199429-e7775eb8-f490-4d1d-b810-82f31ca0604a.png)

- in Repository
![bug1_solution-repo](https://user-images.githubusercontent.com/86727047/173199450-6c1dd490-aae4-4a68-90c9-f2d4678f91c6.png)

- in View
![bug1_solution-view](https://user-images.githubusercontent.com/86727047/173199457-2d9cca2e-44da-4f9f-b644-7c20e37e7b21.png)



## Contributors:
- Postolache Andreea-Miruna:
- Predescu Denisa: predescu.denisa2001@gmail.com
- Sandu Raluca-Ioana:
- Sasu Alexandru-Cristian:
