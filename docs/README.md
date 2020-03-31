## Description

It's a rock, paper, scissors game against the computer.  As the game goes along, the computer learns your "pattern" (using TensorFlow Lite and Android Neural Network for machine learning) over the course of a defined match and will output the symbol that will beat you.  The goal is that the computer will learn enough to win at least 51% of games overall.  Can you beat the computer?  Let's play!

I chose to build a rock paper scissors game because of my son.  He has ADHD and there are not many things that can keep him still for long periods, but gaming is one of them.  When he found out that i would be taking this bootcamp and that i was going to be able to create Android apps, he asked if I could build him an app that he could play with for his birthday (which is two days after graduation), so that is how the idea came about.  I added the machine learning portion of the game to teach myself a skill that will be useful in future software development.

## Intended users

* A gamer who enjoys a simple, one player game, that they remember from their childhood and is still challenging enough that it lets them play against the computer that does machine learning.
* A gambler, who like in a casino, thinks that they have the "skill" to beat the odds and is addicted to the adrenaline rush of trying to accomplish that.
* A person who thinks that, despite many studies done on human predictability, they have the randomness and ability to beat the computer and think that the human brain is still superior to a computer.
* A kid (or kid at heart) who likes easy games that can keep them occupied for long periods of time.

* ### [User Stories](user-stories.md)

## External services

* [TensorFlow Lite](https://www.tensorflow.org/lite)
    * Used for machine learning.  The app will still be able to function without full-time access to this API because i will also have an option to choose rock, paper or scissors icons that will default if the neural network API is not working.  I will also, build into the code, a statistical algorithm for predicting the players next move in lieu of machine learning. 
* [Android Neural Network API](https://developer.android.com/ndk/guides/neuralnetworks)
    * Used along side TensorFlow to build and train the camera object detection and machine learning.  The app will still be able to function without full-time access to this API because i will also have an option to choose rock, paper or scissors icons that will default if the neural network API is not working.  I will also, build into the code, a statistical algorithm for predicting the players next move in lieu of machine learning.
* [Google sign in](https://developers.google.com/identity/sign-in/android/sign-in)
    * Used to sign in to the game and will also be used to keep the players historical game data for use in the statistical algorithm that will be used to "predict" the players next move.  You will be unable to sign into the game without a Google sign in.  

## Design Documentation

* ### [Wireframe Diagram](wireframe.md)

* ### [Entity-Relationship Diagram](erd.md)

* ### [Data Model Implementaton Page](data_model_implementation.md)

*  ### [Build Instructions](build_instructions.md)


