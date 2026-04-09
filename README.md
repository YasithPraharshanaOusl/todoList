# Project To‑Do List (Java)

A simple To‑Do List application built with Java.  
It allows users to add, view, update, and delete tasks with date and time validation.

---

## Features
- 📌 Add tasks with **date** (`yyyy-mm-dd`) and **time** (`hh:mm`) validation
- 📋 View tasks in a formatted table with status (`Due`, etc.)
- ✏️ Update tasks (date, time, or description)
- 🗑️ Delete tasks:
    - Single task
    - All due tasks
    - All tasks
- ℹ️ Help, Credits, and About sections
- ✅ Data persistence using `fileMananger` class (read/write/update/delete)

---

## Project Structure
- **main.java** → Entry point, handles menu and user interaction
- **dataStructure.java** → Defines task object (id, task, date, time)
- **fileMananger.java** → Handles file operations (read, write, update, delete)
- **dateCheck.java** → Validates and formats date/time, checks task status
- **info.java** → Provides Help, Credits, About, and animated printing

---

## How to Run
1. Clone or download the project.
2. Compile the Java files:
   ```bash
   javac main.java


## Usage

* Start the program and choose from the menu (1–8).
* Follow prompts to add, view, update, or delete tasks.
* Dates must follow yyyy-mm-dd format, times must follow hh:mm.

    ADD | Enter task: Finish report
    Date [yyyy-mm-dd]: 2024-04-10
    Time [hh:mm]: 14:30
    ✓ Task added!


## Example Menu

<img width="291" height="230" alt="todo_menu" src="https://github.com/user-attachments/assets/85fd9839-4bc9-4203-acf1-0621cbbb4ae9" />


