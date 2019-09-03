# AssitmMe
Assist ME is an informative app primarily developed for Dalhousie International Students who are new to Halifax. A prospective student will have many responsibilities to be completed before their course begins and as a student in a foreign country getting to know about their responsibilities and completing them will be overwhelming for them. Hence to help them overcome this situation our app will provide all the necessary information that the student is supposed to know and the necessary steps to attain them. The app landing page has home screen which provides a background information about Dalhousie and Halifax. A user can know about current weather details and the past climatic conditions of Halifax using weather feature of the app. We also provide list of tasks to be completed by a student like obtaining mandatory unique identifiers such as SIN, NSID and Dal ID card and respective locations to obtain them. Upon selecting the specific location, user’s current location is received and the locations to acquire necessary ID cards will be displayed using Google Maps API. The transport feature of our app will help the users with appropriate information for commuting from airport to their desired location. A user can find vacant apartments once he lands in Halifax using Accommodation functionality.

## Feature Section
### Weather feature
Our application will fetch the current and history of weather data (one year) of Halifax. The user will be able to see the history weather data in the form of line graph that shows the maximum and minimum temperature range over the past year.

### Accommodation
The application gives information about the vaccant apartments that are available in and around the university which can used as a reference for knowing about the lease and temporary rents charged for the aparments. The user can find this information in one of the
three website links provided which are kijijji, Airbnb and killamreit and book the available rooms/apartments for residence.

### Call Feature
User can readily call the Halifax Airport Cab service providers and book the cab for travelling from and to Halifax Standfield International Airport. It provides information about the average expected fare that shall be charged for the ride. User can pre-book the cabs and incase of immediate ride, user can also book the mobile cabs readily depending on the availability of the cabs.

### Things to do
Our application enriches the user with the list of to-do’s that must be completed during study. The significance of each unique identifiers is given along with the location where it must be obtained. The current location of the user is accessed by google maps to provide direction to the destinations like Access Nova Scotia, Service Canada and Dalhousie Office.

## Future Enhancements
- Nearby Places can be implemented using Google API.
- Forum Implementation can be done from which user can attain knowledge by interacting with other students
- List of required tasks to be completed by a student can be added as a checklist.

## Installation Notes
1. Installation - Not required
2. Get code from our repo [git clone https://github.com/VishaaliKadamburSrikanth/AssistMe.git
3. Import it into Android Studio
4. Run the application
5. Choose the android Emulator.

## Libraries
1. com.android.volley:volley:1.1.1
This is library is used in weather fragment for establishing http request and response in OpenweatherAPI. 
Source - (https://mvnrepository.com/artifact/com.android.volley/volley/
1.1.0)

2. com.github.lecho:hellocharts-library:1.5.8
This library is used in weather fragment for creating line graphs which depicts the history of temperature ranges in past year.
Source - (https://mvnrepository.com/artifact/com.github.lecho/
hellocharts-library/1.5.2)

3. com.google.android.gms:play-services-maps:11.0.2
It is used for displaying google maps in the Map activity.
Source - (https://mvnrepository.com/artifact/com.google.android.gms/play-services-maps/11.0.2)

4. com.google.android.gms:play-services-location:11.0.2
It is used for finding the current location of a user and displaying locations of the places mentioned in “Things to do” Fragment.
Source - (https://mvnrepository.com/artifact/com.google.android.gms/play-services- location/11.0.2)

5. com.android.support:cardview-v7:28.0.0
This library is used to create the card layout for the fragments in the entire application. Source- (https://mvnrepository.com/artifact/com.android.support/cardview-v7/28.0.0)

6. com.android.support:appcompat-v7:28.0.0
This is library gives the ability to edit the action and tool bar.
Source- (https://mvnrepository.com/artifact/com.android.support/appcompat-v7/28.0.0)

7. testImplementation ‘junit:junit:4.12' - This library is used to write unit test cases in our application.
Source - (https://mvnrepository.com/artifact/junit/junit/4.12)

## Reference
[1] Location and Maps | Android Developers. (2018). Retrieved from
https://developer.android.com/guide/topics/location/#maps.

[2] Maven Repository: com.google.android.gms » play-services-maps » 11.0.2&quot;, Mvnrepository.com,2018. [Online]. Available: https://mvnrepository.com/artifact/com.google.android.gms/play-
services-maps/11.0.2.

[3] Maven Repository: com.google.android.gms » play-services-location » 11.0.2&quot;,
Mvnrepository.com, 2018. [Online]. Available:
https://mvnrepository.com/artifact/com.google.android.gms/play-services-location/11.0.2.

[4] JSONObject | Android Developers&quot;, Android Developers, 2018. [Online]. Available:
https://developer.android.com/reference/org/json/JSONObject.

[5] Volley overview | Android Developers&quot;, Android Developers, 2018. [Online]. Available:https://developer.android.com/training/volley/.

[6] How to start - OpenWeatherMap&quot;, Openweathermap.org, 2018. [Online]. Available:
https://openweathermap.org/appid.

[7] Halifax Waterfront. Retrieved from https://www.novascotia.com/explore/top-25/halifax-waterfront

[8] Lecho. (2018, March 18). Lecho/hellocharts-android. Retrieved from https://github.com/lecho/hellocharts-android

[9] Your digital logo designer. Retrieved from https://hatchful.shopify.com/

[10] Planning for arrival. Retrieved from https://www.dal.ca/campus_life/international-centre/new-students/arriving-in-canada.html
