# Identification
![application_logo](images/application_logo.jpg)
We, Aishwarya Narayanan (B00820313),Archanaapriya Nallasivan (B00811602), Vishaali Kadambur Srikanth (B00821049)belong to ALPHA - TEAM.
Our contact e-mail address : vs255542@dal.ca.
Git repository link : https://git.cs.dal.ca/srikanth/alpha-final-project


# Project Summary
Assist ME is an informative app primarily developed for Dalhousie International Students who are new to Halifax. A prospective student will have many responsibilities to be completed before their course begins and as a student in a foreign country getting to know about their responsibilities and completing them will be overwhelming for them. Hence to help them overcome this situation our app will provide all the necessary information that the student is supposed to know and the necessary steps to attain them. The app landing page has home screen which provides a background information about Dalhousie and Halifax. A user can know about current weather details and the past climatic conditions of Halifax using weather feature of the app. We also provide list of tasks to be completed by a student like obtaining mandatory unique identifiers such as SIN, NSID and Dal ID card and respective locations to obtain them. Upon selecting the specific location, user’s current location is received and the locations to acquire necessary ID cards will be displayed using Google Maps API. The transport feature of our app will help the users with appropriate information for commuting from airport to their desired location. A user can find vacant apartments once he lands in Halifax using Accommodation functionality.


## Libraries
We  have implemented two Application programming interface in our project . One is Open weather API and the other Google maps API.
1. com.android.volley:volley:1.1.1
This is library is used in weather fragment for establishing http request and response in OpenweatherAPI.
Source - (https://mvnrepository.com/artifact/com.android.volley/volley/1.1.0)
2.com.github.lecho:hellocharts-library:1.5.8
This library is used in weather fragment for creating line graphs which depicts the history of temperature ranges in past year.
Source - (https://mvnrepository.com/artifact/com.github.lecho/hellocharts-library/1.5.2)
3. com.google.android.gms:play-services-maps:11.0.2: - Used for displaying google maps in the Map activity.
Source - (https://mvnrepository.com/artifact/com.google.android.gms/play-services-maps/11.0.2)
4. com.google.android.gms:play-services-location:11.0.2: - Used for finding the current location of a user and displaying locations of the places mentioned in “Things to do” Fragment.
Source - (https://mvnrepository.com/artifact/com.google.android.gms/play-services- location/11.0.2)
5. com.android.support:cardview-v7:28.0.0: This library is used to create the card layout for the fragments in the entire application. Source- (https://mvnrepository.com/artifact/com.android.support/cardview-v7/28.0.0)
6. com.android.support:appcompat-v7:28.0.0: This is library is used for our application.It gives the ability to edit the action and tool bar.
Source- (https://mvnrepository.com/artifact/com.android.support/appcompat-v7/28.0.0)
7.testImplementation ‘junit:junit:4.12' - This library is used to write tests.
Source - ( https://mvnrepository.com/artifact/junit/junit/4.12)

## Installation Notes
1. Installation - Not required
2. Get code from our repo [GitRepo]
(Note- Link given above)
3. Import it into Android Studio
4. Run the application
5. Choose the android Emulator.


## Code Examples

**Problem 1**:
Showing past year weather data of Halifax dynamically
We were not able to show the history of weather data dynamically fetching from API as such API was available only in paid versions. Hence, we displayed the past year data as static information and showed it in the form of line graph using hellocharts library.

// Populate x axis
Axis Xaxis = new Axis();
Xaxis.setValues(months);
Xaxis.setTextColor(Color.parseColor(&quot;#000000&quot;));
chartData.setAxisXBottom(Xaxis);
// Populate y axis
Axis Yaxis = new Axis();
Yaxis.setName(&quot;Temperature&quot;);
Yaxis.setTextColor(Color.parseColor(&quot;#000000&quot;));
chartData.setAxisYLeft(Yaxis);
// Render chart View
chartView.setLineChartData(chartData);

**Problem 2**:
Usage of onCreate method does not enable call feature .
We needed a setOnClickListener method to enable call feature.We have used the below code to enable call feature in the transport fragment:
    call.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent callIntent = new Intent(Intent.ACTION_DIAL);
        callIntent.setData(Uri.parse("tel: 902_410_7415"));
        startActivity(callIntent);


**Problem 3**:
It was difficult to open a map activity in a new activity on click of a specific button from a parent Activity. By using the “putExtra” method while passing the intent name, button id was retrieved in child activity from parent activity.

//retrieving the button id's and passing it to maps activity class
        Button ns= (Button)getActivity().findViewById(R.id.nsidButton);
        ns.setOnClickListener(new View.OnClickListener()
        {   public void onClick(View v)
        {
            Intent intent = new Intent(getActivity(), MapsActivity.class);
            intent.putExtra("intVariableName", v.getId());
            startActivity(intent);

        }
        });

**Problem 4**:
Initially the app name was displayed on each fragment on the action bar. But On click of each option in the navigation drawer, each fragment should contain the appropriate fragment name and a back button on the action bar. This was achieved by setting the value as “true” in setDisplayHomeAsEnabled

		 //adding back button in the action bar
        ActionBar actionBar = ((AppCompatActivity)getActivity()).getSupportActionBar();
        actionBar.setTitle("Weather");
        Toolbar toolbar = (Toolbar) getActivity().findViewById(R.id.toolbar);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
        drawLayout = (DrawerLayout)getActivity().findViewById(R.id.drawer_layout);
        drawToggle = new ActionBarDrawerToggle(getActivity(), drawLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawLayout.setDrawerListener(drawToggle);
        drawToggle.syncState();
        drawToggle.setDrawerIndicatorEnabled(false);
        actionBar.setDisplayHomeAsUpEnabled(true);
        drawToggle.setToolbarNavigationClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawLayout.openDrawer(GravityCompat.START);
            }
        });

## Feature Section

###Weather feature:
Our application will fetch the current and history of weather data (one year) of Halifax. The user will be able to see the history weather data in the form of line graph that shows the maximum and minimum temperature range over the past year.
![weather](images/weather.jpg)

###Accommodation:
The application gives information about the vaccant apartments that are available in and around the university which can used as a reference for knowing about the lease and temporary rents charged for the aparments. The user can find this information in one of the
three website links provided which are kijijji, Airbnb and killamreit and book the available rooms/apartments for residence.
![Accommodation](images/Accommodation.jpg)

###Call Feature:
User can readily call the Halifax Airport Cab service providers and book the cab for travelling from and to Halifax Standfield International Airport. It provides information about the average expected fare that shall be charged for the ride. User can pre-book the cabs and incase of immediate ride, user can also book the mobile cabs readily depending on the availability of the cabs.
![Transport](images/Transport.jpg)


### Things_to_do
Our application enriches the user with the list of to-do’s that must be completed during study. The significance of each unique identifiers is given along with the location where it must be obtained. The current location of the user is accessed by google maps to provide direction to the destinations like Access Nova Scotia, Service Canada and Dalhousie Office.
![Things_to_do](images/Things_to_do.jpg)


## Final Project Status
We have completed the minimum functionality and the expected functionality in our application . We are unable to implement the bus route feature which was kept under bonus functionality. Below are the list of completed, partially completed and not completed features in our application- Assist ME.

## Future Enhancements:
1.  Nearby Places can be implemented using Google API.
2. Forum Implementation can be done from which user can attain knowledge by interacting with other students
3.  List of required tasks to be completed by a student can be added as a checklist.

#### Minimum Functionality
Minimum Functionality: (Completed)
Feature 1- Home page and Menu
Feature 2- Accommodation
Feature 3- Help
 a)About
 b)FAQ’s

#### Expected Functionality
Expected Functionality: (Completed)
Feature 1- Weather (Weather API)
Feature 2- Transport
                      a)Cab details (Call Feature)
                      b)Bus route feature(Scaled down due to the drop-out of team-members from the course)
Feature 3- Things-to-do (GPS Feature)

#### Bonus Functionality
Bonus Functionality: (Not completed)
Feature 1- Locations near-by
Feature 2- User Sign-Up
Feature 3- Help- Discussions
Feature 4- Additional Languages

## Sources

Location and Maps | Android Developers. (2018). Retrieved from
https://developer.android.com/guide/topics/location/#maps.

Maven Repository: com.google.android.gms » play-services-maps » 11.0.2&quot;, Mvnrepository.com,2018. [Online]. Available: https://mvnrepository.com/artifact/com.google.android.gms/play-
services-maps/11.0.2.

Maven Repository: com.google.android.gms » play-services-location » 11.0.2&quot;,
Mvnrepository.com, 2018. [Online]. Available:
https://mvnrepository.com/artifact/com.google.android.gms/play-services-location/11.0.2.

JSONObject | Android Developers&quot;, Android Developers, 2018. [Online]. Available:
https://developer.android.com/reference/org/json/JSONObject.

Volley overview | Android Developers&quot;, Android Developers, 2018. [Online]. Available:https://developer.android.com/training/volley/.

How to start - OpenWeatherMap&quot;, Openweathermap.org, 2018. [Online]. Available:
https://openweathermap.org/appid.

Halifax Waterfront. Retrieved from https://www.novascotia.com/explore/top-25/halifax-waterfront

Lecho. (2018, March 18). Lecho/hellocharts-android. Retrieved from https://github.com/lecho/hellocharts-android

Your digital logo designer. Retrieved from https://hatchful.shopify.com/

Planning for arrival. Retrieved from https://www.dal.ca/campus_life/international-centre/new-students/arriving-in-canada.html
