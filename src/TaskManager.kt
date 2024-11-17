import java.io.File
/**
 * Class to manage a collection of tasks
 */
class TaskManager {

    /** Collection to store task objects */
    private val tasks = mutableListOf<Task>()

    /**
     * Function to add a task object to the collection
     */
    fun addTask(desc: String) {
        var num = 0
        if (tasks.isNotEmpty()) {
            // Get the id of the latest object
            val tot = tasks.size
            num = tasks[tot - 1].id
        }
        val task = Task(id = num + 1, _desc = desc)
        tasks.add(task)
        println("Task added: $task")
    }

    /**
     * Function to remove  a task object from the collection
     */
    fun removeTask(id: Int) {
        val task = tasks.find { it.id == id }
        if (task != null) {
            tasks.remove(task)
            println("Task deleted: $task" )
        }
        else {
            println("Task not found.")
        }
    }

    /**
     * Function to save task objects to a file
     */
    fun saveTasks () {
        // First check if tasks is empty
        if (tasks.isEmpty()) {
            println("No tasks to save.")
            return
        }
        print("File name (e.g. data.csv)? ")
        val file = readlnOrNull()
        // Ensure the file name is not null or empty
        if (file.isNullOrEmpty()) {
            println("Invalid file name.")
            return
        }
        // check if file exists before creating
        val fileName = File(file)

        if (fileName.exists()) {
            // Ask the user if they want to overwrite the file
            print("The file exists! Do you want to rewrite file? (Y/N): ")
            val userResponse = readLine()

            // If user chooses to append (Y or y), add tasks to the end of the file
            if (userResponse.equals("Y", ignoreCase = true) ) {
                // Delete the old file
                fileName.delete()
            } else {
                println("No changes made to the file.")
                return
            }
        }
        // Write the objects to the file
        fileName.writeText(tasks.joinToString("\n") {
            "${it.id},${it.desc},${it.isCompleted}"
        })
        println("Tasks saved successfully.")
    }

    fun readTasks() {
        // Read tasks from provided file and create the list
        print("Type file name: ")
        val fileName = readlnOrNull()
        val file = fileName?.let { File(it) }

        if (file != null) {
            if (file.exists()) {
                file.forEachLine { line ->
                    // Split the line by commas and parse the data
                    val parts = line.split(",")
                    if (parts.size == 3) { // Ensure the line has the expected format
                        try {
                            // Convert the first and third parts to appropriate types
                            val id = parts[0].toInt()  // Convert the ID to integer
                            val desc = parts[1]        // Description is a string
                            val isCompleted = parts[2].toBoolean()  // Convert 'true' or 'false' to boolean

                            // Create a Task object and add it to the list
                            tasks.add(Task(id, desc, isCompleted))
                        } catch (e: NumberFormatException) {
                            println("Error parsing line: ${line}. Invalid number format.")
                        }
                    } else {
                        println("Skipping invalid line: $line")
                    }
                }
                println("Ojects added: ${tasks.size}")
            }
            else {
                println("The file does not exist.")
            }
        }
    }

    /**
     * Function to print list of tasks
     */
    fun listTasks() {
        if (tasks.isEmpty()) {
            println("No tasks found.")
        } else {
            tasks.forEach { println(it.toString())}
        }
    }

    /**
     * Function to find and change to true when task is completed
     */
    fun completeTask(id: Int) {
        val task = tasks.find { it.id == id }
        if (task != null) {
            task.completeTask()
            println("Task completed: $task" )
        }
        else {
            println("Task not found.")
        }
    }
}