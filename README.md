# Task CLI Application
This is a simple command-line interface (CLI) application for managing tasks. You can add, update, delete, mark, and list tasks directly from the terminal.

## Features

- **Add a Task:** Add a new task with a description.
- **Update a Task:** Update the description of an existing task.
- **Delete a Task:** Remove a task by its ID.
- **Mark a Task:** Mark a task as "in progress" or "done."
- **List Tasks:** List all tasks or filter them by status (e.g., `todo`, `in progress`, `done`).
- **Help:** Show all command available

## Installation

1. **Clone the repository:**
   ```bash
   git clone https://github.com/ErickBrayan/Task-Tracker-CLI.git

2. **Change Directory:**
   ```bash
   cd Task-Tracker-Cli/src
   
3. **Compile the source code:**
    ```bash
   javac taskcli.java
4. **Run the application:**
    ```bash
   java taskcli <command> [arguments]
   ```

## Usage
```bash
# Adding a new task
java taskcli add "Buy groceries"
# Output: Task added successfully (ID: 1)

# Updating a task
java taskcli update 1 "Buy groceries and cook dinner"
# Output: Task updated successfully (ID: 1)

# Deleting a task
java taskcli delete 1
# Output: Task deleted successfully (ID: 1)

# Marking a task as in progress
java taskcli mark-in-progress 1
# Output: Task marked as in progress (ID: 1)

# Marking a task as done
java taskcli mark-done 1
# Output: Task marked as done (ID: 1)

# Listing all tasks
java taskcli list
# Output: List of all tasks

# Listing tasks by status
java taskcli list todo
java taskcli list in-progress
java taskcli list done

# Listing tasks by status
java taskcli help
```