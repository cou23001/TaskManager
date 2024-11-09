class Task (val id: Int, val desc: String, private var isCompleted: Boolean = false) {

    fun completeTask() {
        isCompleted = true
    }

    override fun toString(): String {
        return "Task(id=$id, description='$desc', isCompleted=$isCompleted)"
    }
}