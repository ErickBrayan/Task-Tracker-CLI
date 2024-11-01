# Task CLI Application
This is a simple command-line interface (CLI) application for managing tasks. You can add, update, delete, mark, and list tasks directly from the terminal.

## Features

- **Add a Task:** Add a new task with a description.
- **Update a Task:** Update the description of an existing task.
- **Delete a Task:** Remove a task by its ID.
- **Mark a Task:** Mark a task as "in progress" or "done."
- **List Tasks:** List all tasks or filter them by status (e.g., `todo`, `in progress`, `done`).

## Installation

1. **Clone the repository:**

   ```bash
   git clone Task Tracker CLI
   cd task_tracker_cli

2. **Compile the source code:**
    ```bash
   javac TaskCLIApp.java Task.java TaskManager.java Status.java
3. **Run the application:**
    ```bash
   java TaskCLIApp <command> [arguments]
   ```