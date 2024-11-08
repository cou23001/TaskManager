class Task (val id: Int, val desc: String, private var isCompleted: Boolean = false) {

    override fun toString(): String {
        return "Task(id=$id, description='$desc', isCompleted=$isCompleted)"
    }
}