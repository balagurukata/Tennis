# Tennis Game
This program stimulates a tennis game with below rules

* The running score of each game is described in a manner peculiar to tennis: scores from zero to three points are described as “love”, “fifteen”, “thirty”, and “forty” respectively.

* If at least three points have been scored by each player, and the scores are equal, the score is “deuce”.

* If at least three points have been scored by each side and a player has one more point than his opponent, the score of the game is “advantage” for the player in the lead.

* A game is won by the first player to have won at least four points in total and at least two points more than the opponent.

## Prerequisities:

1. Java - Version 1.6 or higher
2. Maven - Dependency management
3. JUnit - Version 4.12 
4. IDE - Eclipse or any other IDE which supports Java 

## Assumption
* Each game has only one set to decide the winner
* Minimum and Maximum number of player is 2
* Player one will always do the service, hence the game score will be always represented with respect to firstPlayer i.e. firstPlayer score - secondPlayer score
* Once game is over, User has to start next game from the beginning.

## Set up application
#### IDE
~~~
1. Clone the repository https://github.com/XXX
2. Add as Maven project
3. Select Project SDK as JDK 1.6 or higher
~~~

#### Command prompt
~~~
1. Clone repository from GIT 'git clone https://github.com/XXX'
2. Run `mvn clean install`
~~~

## Run Test Cases

**IDE**
~~~
1. Navigate to Maven Toolbar
2. Select `test` under lifecycle menu and click on play symbol
~~~

**Command Prompt**
~~~
1. Go to the directory where you have cloned the Tennis program (C:\bnpp\Workspace\TennisGame)
2. Run `mvn test`
~~~