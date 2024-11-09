/**
 * Class to manage a collection of tasks
 */
class TaskManager {

    /** Collection to store task objects */
    private val tasks = mutableListOf<Task>()
    private var nextId = 1

    /**
     * Function to add a task object to the collection
     */
    fun addTask(desc: String) {
        val task = Task(id = nextId++, desc = desc)
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