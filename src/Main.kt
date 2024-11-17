/** Object to manage tasks */
val taskManager = TaskManager()

/**
 * Main menu of Task Manager
 */
fun menu(): String? {
    println("**********************")
    println("**** Task Manager ****")

    println()
    println("1. Add Task")
    println("2. Delete Task")
    println("3. List Tasks")
    println("4. Complete Task")
    println("5. Save Tasks to a file")
    println("6. Read Tasks from a file")
    println("7. Exit")
    println()
    print("Select: ")
    return readlnOrNull()
}

/**
 * Function to add a task to the collection
 */
fun addTask() {
    println("Adding task...")
    print("Enter task description: ")
    val desc = readlnOrNull() ?: ""
    taskManager.addTask(desc)
}

/**
 * Function to delete a task from the collection
 */
fun deleteTask() {
    println("Deleting a task...")
    print("Type task ID: ")
    val id = readlnOrNull()?.toIntOrNull()
    if (id != null) {
        taskManager.removeTask(id)
    }
    else {
        println("Task not found.")
    }

}

/**
 * Function to list tasks
 */
fun listTasks() {
    println("Listing tasks...")
    taskManager.listTasks()
}

/**
 * Function to change isCompleted attribute to true
 */
fun completeTask() {
    println("Complete a task...")
    print("Type task ID: ")
    val id = readlnOrNull()?.toIntOrNull()
    if (id != null) {
        taskManager.completeTask(id)
    }
    else {
        println("Task not found.")
    }
}

/**
 * Function to save objects to a file
 */
fun savingTasks() {
    println("Saving the tasks...")
    taskManager.saveTasks()
}

/**
 * Function to read objects from a file
 */
fun readingTasks() {
    println("Reading tasks from file...")
    taskManager.readTasks()
}

/**
 * Main function to display task options
 */
fun main() {
    var selection: String?
    do {
        selection = menu()
        when (selection) {
            "1" -> addTask()
            "2" -> deleteTask()
            "3" -> listTasks()
            "4" -> completeTask()
            "5" -> savingTasks()
            "6" -> readingTasks()
            "7" -> println("Exiting...")
            else -> println("Invalid selection. Please try again.")
        }
    } while (selection != "7")
}