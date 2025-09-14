# Java Android Grid Game (2025)

* This game was coded by me (Lawrence Cox) using Java and was completed in August 2025

## Game inspiration

* I took inspiration from the code from the "Android Game Development : Endless Runner Game in Android" course on Udemy by Sandip Bhattacharya to help complete my project
* This Udemy course game is quite different to my game:
    * The udemy course game involves a santa character that endless runs and then you tap the screen to jump to avoid the obstacles which move from left to right on the screen.
	* Everytime you jump over an obstacle you gain a point

## My game explanation

* This game involves moving a circular green player across a 6 by 4 gridded area
* Swipe left, right, up, down using your fingers to move this player within the grid
* Avoid the 5 falling box obstacles and if you hit one of these the game is over
* Within the grided area, you're not able to move into a section containing an ice obstacle
* Once you reach the right hand side of grid area:
    * You gain one point
	* Your character resets to the left
	* Then you can try to reach the right side again, and repeat

## Setting up project

### Where to run program
* I'm able to run this game on both Windows 10 and 11 using "Android Studio Jellyfish | 2023.3.1"

### How to create and run the program
* Select "Empty views activity"
    * Don't select "empty activity" or "no activity"
    * In options menu:
        * Ensure Name is "MyGame"
		* Ensure Package name is "com.lawrence123.mygame"
		* Choose a good save location
		* Ensure language is Java
		* Keep other options the same
		
* Sometimes the Agp and activity version is out of date:
    * Open the gradle/libs.versions.toml file
	* Change apg version to "8.4.0"
	* Change activity line to "1.8.0"
	
* Copy the contents from "app/src" from Github to "app/src" of your android studio project

* Build the project

* I recommend selecting a "Pixel 4 API 28" Emulator from the Device Manager menu

* Then run the project

* A phone emulator should show and the game should run
