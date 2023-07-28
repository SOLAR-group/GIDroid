
# GIDroid: A Tool for Multi-Objective GI in Android

This artefact is associated with paper Multi-Objective Improvement of Android Applications submitted to the 
Automated Software Engineering journal.

GIDroid is a [Genetic Improvement](https://en.wikipedia.org/wiki/Genetic_improvement_(computer_science)) (GI) tool. Genetic Improvement is the application of [Genetic Programming](https://en.wikipedia.org/wiki/Genetic_programming) and other [Metaheuristics](https://en.wikipedia.org/wiki/Metaheuristic) to existing software, to improve it in some way.
This repository all contains the benchmark and experimental data from the paper:

Multi-Objective Improvement of Android Applications

## Getting Started

These instructions will show you how to build GIDroid and run a local search or multiobjective search an android app.

### Prerequisites

GIDroid requires:

* JDK 1.8.x  *note: there is currently a known issue that prevents GIDroid running on JDK 9 or above*
* Gradle (tested with version 4.10.2)
* A number of dependencies, which can be downloaded manually or via Gradle (recommended)
* Android SDK installed

JDK downloads:<http://www.oracle.com/technetwork/java/javase/downloads/index.html>

Gradle can be downloaded from their website:<https://gradle.org/install>

The library dependencies can be found in the build.gradle file.

### Installing and Building gin


First clone the project and open a terminal in the directory that it is cloned too.

Build using gradle (alternatively import into your favourite IDE, such as IntelliJ). We also provide a gradle wrapper with Gradle 4.10.2.

```
gradle build
```

This will build and test GIDroid, and also create a fat jar at `build/gin.jar` containing all required dependencies.


## Running GIDroid on an app

You can run GIDroid on an app by doing the following:

First ensure your app builds and tests can be run successfully, this can be a tricky process but we recommend booting the app up in Android studio and testing from there.
Next create a config file as seen in each of the applications in our benchmark to tell gin where the application is, what is beig improved and which tests should be run.
This file should be saved as "config.properties" in the diretory where you wish to run GIDroid.
Then chose the algorithm you wish to run, in the AndroidGI file, uncomment the algorithm/algorithms that you wish to run. 
After this, build GIDroid  as described above. 
finally run GIDroid with the call:

```
java -jar build/gin.jar 
```

The results of these runs will then be outputted to a file callled log.txt


## Results

Experimental Results are available in the results directory in this project

## Benchmark

The benchmark used in our experiment is available in the benchmark directory in this project.