# The-Invitor
The Invitor is a sample project demonstrating inviting Customers Based on their locations

## Project development

The Invitor attempts to use the latest Kotlin libraries and tools. As a summary:

 * Whole code base is written in [Kotlin](https://kotlinlang.org/)
 * UnitTest Covarage 100%
 * Uses the MVVM Architecture (along with Use-Cases and Interactors for more concern seperation)
* Uses [Dagger2](https://google.github.io/dagger) for dependency injection

## Architecture
The app uses MVVM architecture which fits more with the latest libraries used (ViewModel and Room) and the app requirements.

## Run The App

Clone the project, within the project path execute from the CLI:
  ``` ./gradlew run```

and the result will be printed on the console for the customers within 100Km

### the output
```
The customers which will be invited (16 Customers):

1:- Id: 4, Name: Ian Kehoe
2:- Id: 5, Name: Nora Dempsey
3:- Id: 6, Name: Theresa Enright
4:- Id: 8, Name: Eoin Ahearn
5:- Id: 11, Name: Richard Finnegan
6:- Id: 12, Name: Christina McArdle
7:- Id: 13, Name: Olive Ahearn
8:- Id: 15, Name: Michael Ahearn
9:- Id: 17, Name: Patricia Cahill
10:- Id: 23, Name: Eoin Gallagher
11:- Id: 24, Name: Rose Enright
12:- Id: 26, Name: Stephen McArdle
13:- Id: 29, Name: Oliver Ahearn
14:- Id: 30, Name: Nick Enright
15:- Id: 31, Name: Alan Behan
16:- Id: 39, Name: Lisa Ahearn

```

### Code style
Uses the default Kotlin code style built-in IntelliJ

## License

```
                    GNU GENERAL PUBLIC LICENSE
                       Version 3, 29 June 2007

 Copyright (C) 2007 Free Software Foundation, Inc. <https://fsf.org/>
 Everyone is permitted to copy and distribute verbatim copies
 of this license document, but changing it is not allowed.

```

