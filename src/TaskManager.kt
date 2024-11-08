class TaskManager {
    private val tasks = mutableListOf<Task>()
    private var nextId = 1

    fun addTask(desc: String) {
        val task = Task(id = nextId++, desc = desc)
        tasks.add(task)
        println("Task added: $task")
    }
}