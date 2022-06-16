# Freelance4ALL
![logo](https://user-images.githubusercontent.com/79568914/173367555-244ff5c9-46ff-49c7-a53d-4a746a8b8b6d.gif)

## Application Description

Android application developed in Android Studio, at the Faculty of Mathematics and Informatics from the University of Bucharest, for freelancing purposes, bearing similarities with the [Fiverr](https://www.fiverr.com/) website.

Freelance4ALL is, as the name suggests, a freelance platform that allows people from around the world to advertise and sell personal services. Every user has a profile (containing info such as: email, profile description, phone number), and can opt between two types of roles: buyer and seller. Sellers can add any new service (consisting of: web design, music making, game development, art, etc) and modify their existent services, while buyers can purchase any service by adding it to a shopping cart and then checking out. In addition, buyers will get notified via a pop-up notification: when they log out and there are services left in their cart, and when the app notifies the sellers that the respective buyers have purchased their services. Moreover, buyers can also visualize the history of their purchases, and offer them a star-based rating.

Our app is meant to promote freelancing, as more and more people are getting tired of the corporate life and wish to have their own little business, while not having to deal with the likes of traveling long distances every day, attending a lot of meetings, dealing with grumpy bosses, and so on.

## Demo
You can see the demo for our application by clicking the link below:
https://youtu.be/06oEPp7oZdM

## Trello Link
https://trello.com/b/aCB5CLqO/mds

## Diagrams

Conceptual diagram:

![Diagrama Conceptuala (actuala)](https://user-images.githubusercontent.com/87432371/173388952-cdcfc9d1-c7f5-4060-922e-98edbbc0a543.png)

UML diagram:

![UML](https://user-images.githubusercontent.com/87432371/173207585-009364a2-3395-46fa-8fc0-26306e452179.png)

## User Stories

1. As a guest, I want to be able to navigate the app without having a profile, so that I can firstly form an impression about the displayed services.

2. As a guest, I want to be able to see the seller's contact details: e-mail, phone number; so that I can contact them.

3. As a guest, I want to be able to register, so that I can become either a seller(=provider) or a buyer.

4. As a guest, I want to be able to login, so that I can gain the privileges either of a seller or a buyer.

5.  As a seller, I want to be able to display a details list of my attributes, so that I can present my; domain of activity, experience, work schedule, working city etc.

6. As a seller, I want to be able to provide personal details about me/my team, so that the buyer can get in touch with me/us more easily.

7. As a buyer, I want to be notified via a pop-up notification: when I log out and there are services left in my cart, and when the app notifies the sellers that I have purchased their services.

8. As a buyer, I want to have a shopping cart, so that I can keep track of the services that I want to purchase.

9. As a buyer, I want to have a history of my purchases, so that I can remember the level of satisfaction that the services gave me.

10. As a logged user, I would like to be able to modify my profile data anytime.

## Build Tools

The project was developed using Andorid Studio, which has a Gradle-based building tool. 
To build the project in an APK, go to Build -> Build Bundle(s)/APK(s) -> Build APK(s):  
![apk_1](https://user-images.githubusercontent.com/86727047/173198634-e38f416d-b05d-4e66-9f99-804fa0a8927d.png)

To verify if the app has been generated properly, go in the folder of the project and see if these 2 files have been added:
![apk-2-bunaa](https://user-images.githubusercontent.com/86727047/173198709-a197945f-c17f-40d7-a0ad-192c7b31f305.png)

## Code Standards

The project respects the Java coding standards (link: https://google.github.io/styleguide/javaguide.html): the names are sugestive, the classes name are nouns starting with upercase letters (e.g. LoginActivity, ServiceAdapter etc), method names are verb-noun combinations or verbs starting with lowercase letters (e.g. insert, checkEmailPass, getServiceById).

## Design Patterns

We used a singleton approach for database handling for each class, e.g.:

![singleton](https://user-images.githubusercontent.com/86727047/173200479-0e1492fb-8e2c-4b36-8571-5fcba8c68207.png)

## Bug Reporting

***Bug 1***

As any simple insert method, register (insert user in database) accepts the same email multiple times.
![telefoane_bug1](https://user-images.githubusercontent.com/86727047/173199355-72dc9ee5-de97-405e-8809-9538094b6caa.png)

The solution was to create a method that verifies if an email is already in the database:
![bug1_solution_bunaaa](https://user-images.githubusercontent.com/86727047/173199414-96b24aa8-a9f5-4ad8-9cae-d3e25b2b9b99.png)

![bug1_resolved1](https://user-images.githubusercontent.com/86727047/173200677-c39ff8f8-3117-4fad-b1c8-6a42fe65a4ac.png)


***Presenting the method*** 
  - in Dao:
  
![bug1_solution-dao](https://user-images.githubusercontent.com/86727047/173199429-e7775eb8-f490-4d1d-b810-82f31ca0604a.png)
  - in Repository:


![bug1_solution-repo](https://user-images.githubusercontent.com/86727047/173199450-6c1dd490-aae4-4a68-90c9-f2d4678f91c6.png)
  - in View:


![bug1_solution-view](https://user-images.githubusercontent.com/86727047/173199457-2d9cca2e-44da-4f9f-b644-7c20e37e7b21.png)

**Bug 2**

Every time someone wanted to use a method involving the database, they would get the following error:
![bug2](https://user-images.githubusercontent.com/86727047/173200214-afe554a5-5fdf-477a-887d-3c8263e956f0.png)

The solution to this problem was to add .allowMainThreadQueries() to every database handling initialization:
![bug2_resolve](https://user-images.githubusercontent.com/86727047/173199826-f07927f3-5988-4ffb-a1b6-24ffc65f031e.png)

**Bug 3**

We wanted to change the project's name using the methods presented on GeeksforGeeks (link: https://www.geeksforgeeks.org/different-ways-to-change-the-project-name-in-android-studio/).

Neither the first, nor the second method worked:

- First method:

![bug4_sol1_1](https://user-images.githubusercontent.com/86727047/173200011-8a1df50b-1ac4-43dd-808d-9f239f79fd1a.png)
![bug4_sol1_2](https://user-images.githubusercontent.com/86727047/173200014-788886f9-dd16-4b90-9563-a0e3a488281d.png)
- Second method:

![bug4_sol2](https://user-images.githubusercontent.com/86727047/173200069-84d74e5f-c99b-4ced-b8bb-9c7c18e1a53f.png)

The third method was a success:

![bug4_sol3](https://user-images.githubusercontent.com/86727047/173200081-75c4d989-f582-44f1-9d6a-e14d1eb3ff0d.png)

The result is seen in the application's titlebar:
![bug4_sol](https://user-images.githubusercontent.com/86727047/173200113-db961eea-e589-499e-b290-869cea62b908.png)

**Bug 4**

At first, there could exist more than one city with the same name (ignoring case sensitivity) in the database:

![initial_name_1](https://user-images.githubusercontent.com/87432371/173207191-f8ff092a-fba6-444b-af38-27848522c7ab.png)
![final_name_1](https://user-images.githubusercontent.com/87432371/173207193-fadd4a1f-696a-4a99-9573-c00ff62303f9.png)
![initial_name_2](https://user-images.githubusercontent.com/87432371/173207194-7c2d7226-3abd-4c11-9bd9-d99df166cbbe.png)
![final_name_2](https://user-images.githubusercontent.com/87432371/173207195-a9018634-484f-423a-9a59-ba80942ce8dc.png)

The workaround we came with was to capitalize each city name right before the city's insertion into the database would take place. This way, the program wouldn't insert another city with the same name (ignoring  case sensitivity) when it would reach the function named nameExistOrNot:

![solution](https://user-images.githubusercontent.com/87432371/173206666-68f7d6fe-acaa-4235-b3a2-9a8ca1464377.jpg)

Sample insertions after the fix:

![initial_name_3](https://user-images.githubusercontent.com/87432371/173207295-bd9e0db7-9265-491c-8bf5-264cf04b9cce.png)
![final_name_3](https://user-images.githubusercontent.com/87432371/173207297-41e77225-2f95-4c83-adff-3a46e25a9201.png)
![initial_name_4](https://user-images.githubusercontent.com/87432371/173207298-ed86ca78-585e-458f-8c5e-2831e25d2680.png)
![final_name_4](https://user-images.githubusercontent.com/87432371/173207300-6d2dd953-fcec-4fd5-9e24-5ae8835639de.png)

## Automation Testing
We have also implemented automatic testing using JUnit5 in order to check whether the Getters and Setters function properly. One such example is shown below:
![teste_mds](https://user-images.githubusercontent.com/79594745/173419118-6f25a1f8-9619-4989-b2ef-1d014617f9f6.png)

## Contributors:
- Postolache Andreea-Miruna: https://github.com/postolache-andreea-miruna, mirunapami@yahoo.com
- Predescu Denisa: https://github.com/denisapredescu, predescu.denisa2001@gmail.com
- Sandu Raluca-Ioana: https://github.com/ralucsandu, ralucsandu01@gmail.com
- Sasu Alexandru-Cristian: https://github.com/alexsasu, sasualex1@gmail.com
