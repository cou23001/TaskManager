class Task (val id: Int, val desc: String, var isDone: Boolean = false) {

    override fun toString(): String {
        return "Task(id=$id, description='$desc', isCompleted=$isDone)"
    }
}