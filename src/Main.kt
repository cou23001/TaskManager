val taskManager = TaskManager()

fun menu(): String? {
    println("**********************")
    println("**** Task Manager ****")
    println("**********************")

    println()
    println("1. Add Task")
    println("2. Delete Task")
    println("3. List Tasks")
    println("4. Complete Task")
    println("5. Exit")
    println()
    print("Select: ")
    return readlnOrNull()
}

fun addTask() {
    println("Adding task...")
    print("Enter task description: ")
    val desc = readlnOrNull() ?: ""
    taskManager.addTask(desc)
}

fun main() {
    var selection: String?
    do {
        selection = menu()
        when (selection) {
            "1" -> addTask()
            "5" -> println("Exiting...")
            else -> println("Invalid selection. Please try again.")
        }
    } while (selection != "5")
}