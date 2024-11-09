/**
 * Class definition to manage tasks
 * @property id - Task ID
 * @property desc - Task description
 * @property isCompleted -  Indicate if task is completed by default is false
 */
class Task (val id: Int, val desc: String, private var isCompleted: Boolean = false) {

    /**
     * Function to change isCompleted attribute to true
     */
    fun completeTask() {
        isCompleted = true
    }

    /**
     * Task description
     * @return the object task
     */
    override fun toString(): String {
        return "Task(id=$id, description='$desc', isCompleted=$isCompleted)"
    }
}