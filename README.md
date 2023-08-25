# Space Cadet - Game README

## Introduction

Welcome to **Space Cadet**, an exhilarating space shooting game developed as the final project for the *Software Engineering Intro* course by Nathan Bradshaw. In this game, you will pilot a powerful spaceship to defend against waves of alien invaders and obstacles in the vast cosmos. Prepare yourself for an interstellar journey filled with excitement and challenges!

## Gameplay 

https://youtu.be/3ZHuH9wxcbM

## Group Demonstration

https://youtu.be/xtlXpgx5rZQ

## Getting Started

To embark on your **Space Cadet** adventure, follow these simple steps:

1. **Installation**: Ensure you have the Greenfoot framework installed on your system. If not, you can download Greenfoot from [greenfoot.org](https://www.greenfoot.org/).

2. **Import Game**: Import the provided code files into your Greenfoot project. Organize the files in a suitable package structure for smooth navigation.

3. **Launch the Game**: Open the `TitleScreen` class and click the "Run" button in Greenfoot to initiate the game.

## Gameplay

Your mission as a **Space Cadet** is to skillfully maneuver your spaceship and obliterate hostile alien invaders and obstacles while amassing points. Here's a brief guide on how to play:

- **Controls**: Utilize the *left* and *right* arrow keys to navigate the spaceship. Press the *space* bar to unleash powerful shots.

- **Alien Threats**: Brace yourself for diverse alien foes, each with distinct behaviors:
  - `Alien1`: Advances towards your spaceship, firing projectiles to bring you down.
  - `Alien2`: Takes a diagonal trajectory across the screen, adjusting direction when reaching screen edges.
  - `Alien3`: Moves horizontally and switches movement direction periodically.

- **Avoid Obstacles**: Sidestep or obliterate incoming obstacles, symbolized by `Rock` objects.

- **Boss Confrontation**: After successfully weathering through waves, you'll confront the formidable `Boss`. This adversary launches potent fireballs, necessitating precision and skill to triumph.

- **Earning Points**: Destroy alien enemies and obstacles to accumulate points. Your current score is prominently displayed at the top of the screen.

- **Lives**: You commence with 3 lives. Colliding with adversaries or their projectiles depletes your lives. Your journey concludes upon losing all your lives.

## Classes Overview

Here's a quick overview of key classes featured in the game:

- `TitleScreen`: Initiates the game by presenting the title screen and awaiting the player to press the *space* bar.

- `Ship`: Represents your spaceship. Control its movement and engage in projectile fire.

- `Alien1`, `Alien2`, `Alien3`: Different alien types, each exhibiting unique movement patterns and behaviors.

- `Rock`: Symbolizes obstacles to be dodged or eradicated.

- `Boss`: A formidable adversary emerging after enduring multiple waves, launching potent fireballs and demanding skilled evasion.

- `Bullet`: Signifies projectiles launched by your spaceship and adversaries.

- `Explosion`: Generates explosion animations upon destruction of enemies or obstacles.

## Customization

Exercise creative control over various game elements by customizing:

- Alien behaviors and movement tactics.
- Bullet attributes, such as speed, damage, and visual presentation.
- Characteristics of the Boss entity, encompassing health and attack patterns.
- Game difficulty configurations, including spawn rates and projectile velocities.

## Credits

Developed by Nathan Bradshaw, **Space Cadet** serves as a testament to my skillset as part of my *Software Engineering Intro* course. The game utilizes the Greenfoot framework and incorporates an array of assets encompassing graphics and audio elements.

## Conclusion

Embrace the excitement of interstellar combat in **Space Cadet**! We hope you relish the immersive space odyssey and revel in the challenge of thwarting alien invaders. Should you have queries, feedback, or encounter any concerns, please don't hesitate to reach out to Nathan Bradshaw.

Prepare for liftoff, engage your thrusters, and embark on a stellar gaming journey! 🚀🌌
