
TaskAndroid

Application to display a list of tweet, selecting a search criteria from: a user name and a hashtag, the list will be refreshed each time a defined (between 1 second and 5 minutes).
Twitter APIs (Fabric) was used to display the list of tweet, https://docs.fabric.io/android/index.html, using TweetUi kit, provide rich Twitter UI components for our app.
Minimum version of Android: 4.0.3 (IceCreamSandwich)
Build version of Android: 6.0 (MarshMallow)

When you start the application, this sample default tweets from Moto-GP Champion Marc Márquez (marcmarquez93)


The list shows the toolbar the user name or hashtag being displayed and allows, through the refresh button, forcing the cool of this.

The application has a list of side menu, which allows:
- Define the time to refresh the list information.
- Specify the search criteria.
- Information about the author.

Refresh Time
A screen using a SeekBar where you can specify the refresh time between 0 seconds and 300 seconds is displayed. By default, the initial value is 60 seconds.

Search Criteria
This option displays a screen is selected by a radiobutton, if you are going to perform a search by username or hashtag, the defaults when starting the application are marcmarquez93 and #motogp respectively, these values can be modified. In defining the new search criteria and close the screen, you return to the list, which is refreshed with new tweets or displays the information that there are no tweets, should not be effective search for the specified criteria.

About the Author
Displays information about the author of the application


