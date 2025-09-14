# Java Android Grid Game (2025)

* This game was coded by me (Lawrence Cox) using Java and was completed in August 2025

## Game inspiration

* I took inspiration from the code from the "Android Game Development : Endless Runner Game in Android" course on Udemy by Sandip Bhattacharya to help complete my project
* This Udemy course game is quite different to my game:
    * The udemy course game involves a santa character that endlessly runs and then you tap the screen to jump to avoid the obstacles which move from left to right on the screen.
	* Everytime you jump over an obstacle you gain a point

## My game explanation

* This game involves moving a circular green player across a 6 by 4 gridded area
* Swipe left, right, up, down using your fingers to move this player within the grid
* Avoid the 5 falling box obstacles and if you hit one of these the game is over
* Within the gridded area, you're not able to move into a section containing an ice obstacle
* Once you reach the right hand side of the grid area:
    * You gain one point
	* Your character resets to the left
	* Then you can try to reach the right side again, and repeat

## Setting up project

### Where to run the program
* I'm able to run this game on both Windows 10 and 11 using "Android Studio Jellyfish | 2023.3.1"

### How to create and run the program
* On Android studio, click file, new, new project
* Click "Empty views activity"
    * In options menu:
        * Ensure Name is "MyGame"
		* Ensure Package name is "com.lawrence123.mygame"
		* Choose a good save location
		* Ensure language is Java
		* Keep other options the same
		* Click Finish
		
* Wait for the gradle process to sync up (if applicable)
		
* Sometimes the Agp and activity version is out of date:
    * Open the gradle/libs.versions.toml file
	* Change apg version to "8.4.0"
	* Change first activity line to "1.8.0"
	
* Remove the contents from app/src in your android studio project
	
* Copy the contents from "app/src" from Github to "app/src" in your android studio project

* Either restart android studio or press yes if it asks for a gradle sync

* I recommend selecting a "Pixel 4 API 28" Emulator from the Device Manager menu

* Ensure this Pixel device is selected at the top in the main Android studio window

* Then run the project

* A phone emulator should show and the game should run

### Help

* When loading program on emulator if you get "waiting for all devices to come online" message showing for a very long time:
    * On device manager, wipe data for the device you want to use
	* Then restart your computer and android studio

* Also you can use logcat to help debug errors if needed