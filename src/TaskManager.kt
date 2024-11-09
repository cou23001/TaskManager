class TaskManager {
    private val tasks = mutableListOf<Task>()
    private var nextId = 1

    fun addTask(desc: String) {
        val task = Task(id = nextId++, desc = desc)
        tasks.add(task)
        println("Task added: $task")
    }

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

    fun listTasks() {
        if (tasks.isEmpty()) {
            println("No tasks found.")
        } else {
            tasks.forEach { println(it.toString())}
        }
    }
}