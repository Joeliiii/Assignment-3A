# **Assignment-3A – Student Grade Calculator**

## **Overview**

This Java project implements a **simple student grade calculator** that manages assignments and computes a student’s overall numeric and letter grade.  
 It is composed of three main components working together:

* **Grade** – an immutable record representing one assignment or graded component.  
* **GradeBook** – manages a list of grades and handles weight normalization and grade calculations.  
* **Menu** – a console-based interactive program that allows users to enter, view, and update their grades.

The calculator supports weighted averages, optional normalization, and conversion to letter grades based on standard academic scales.

---

## **Features**

* **Add, update, or remove** grades interactively from the console.  
* **View** all grades at any time with their weights and scores.  
* **Store weights as percentages** between 0–100.  
* **Automatically normalize** weights to sum to 100 when requested.  
* **Compute final weighted averages** and map them to letter grades (A–F).  
* **Clear all entries** for a fresh start.

---

## **Assumptions**

* Each assignment **weight** is a percentage in the range **\[0, 100\]**.  
* Each **score** is also in the range **\[0, 100\]**.  
* calculateFinal(true) normalizes all weights so they sum to 100 automatically.  
* calculateFinal(false) assumes the weights already sum to 100 ± 1e-6 and throws an exception otherwise.

---

## **Letter Grade Scale**

| Letter | Range (%) |
| ----- | ----- |
| **A** | 90 – 100 |
| **B** | 80 – 89.9 |
| **C** | 70 – 79.9 |
| **D** | 60 – 69.9 |
| **F** | \< 60 |

---

## **Usage**

1. **Compile** all Java files:  
   1. javac Grade.java GradeBook.java Menu.java  
2. **Run** the console program:  
   1.  java Menu  
3. Follow the on-screen menu to add grades, update them, and compute your final result.

---

## **Example Interaction**

\--- Student Grade Calculator \---  
1\) Add grade  
2\) List grades  
3\) Calculate final (normalized)  
4\) Update weight  
5\) Update score  
6\) Remove entry  
7\) Clear all  
0\) Exit  
Choose: 1  
Assignment name: Homework 1  
Weight (0–100): 20  
Score (0–100): 85  
Added.
