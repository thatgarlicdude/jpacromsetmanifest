# Installing JPacManifest

## Requirements

- Java 8 or above.

If you are unsure about what Java version you're on, go to your terminal and type `java -version`. It should be Java 8 or above. If you meet the requirement, you're good to go!

Also, Gradle is **not** a prerequisite for this project. As a fair warning, Gradle will be automatically downloaded by running `./gradlew build` on Linux or `gradle.bat build` on Windows.

## Steps (macOS / Linux)

1. Clone the repository from GitHub by typing `git clone https://github.com/thatgarlicdude/jpacmanifest.git` onto your terminal.

2. In your terminal, change your working directory to the root of the cloned repository by typing `cd jpacmanifest`.

3. Now that you're in the repository, type `./gradlew build` to build the project.

4. To install the project to your local Maven repository, type `./gradlew publishToMavenLocal`.

5. You're good to go!

## Steps (Windows)

1. Clone the repository from GitHub by typing `git clone https://github.com/thatgarlicdude/jpacmanifest.git` onto your terminal.

2. In your terminal, change your working directory to the root of the cloned repository by typing `cd jpacmanifest`.

3. Now that you're in the repository, type `gradle.bat build` to build the project.

4. To install the project to your local Maven repository, type `gradle.bat publishToMavenLocal`.

5. You're good to go!
