# Assignment-3A

Overview

This project provides a simple student grade calculator in Java.
It allows you to add assignments with names, weights (0–100), and scores (0–100).
The program then computes the final numeric grade and letter grade (A/B/C/D/F).

The project uses three main components:

Grade – immutable record representing one assignment/component.

GradeBook – manages a list of grades and provides calculation logic.

Menu – console-based application with an interactive menu.


Features

Add, update, and remove grades interactively.

Store weights as percentages (0–100).

Normalize weights automatically if they don’t sum to exactly 100.

Compute final weighted average and corresponding letter grade.

Clear all grades or view the current list at any time.

Assumptions

Each assignment weight is in 0–100.

Scores are in 0–100.

The calculateFinal(true) method normalizes weights if they don’t sum to 100.

The calculateFinal(false) method requires that weights sum to 100 (±1e-6) and throws otherwise.

Letter grade scale:

A: 90–100

B: 80–89.9

C: 70–79.9

D: 60–69.9

F: <60

Usage:

Compile using javac.
