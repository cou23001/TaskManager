/**
 * Class definition to manage tasks
 * @property id - Task ID
 * @property desc - Task description
 * @property isCompleted -  Indicate if task is completed by default is false
 */
class Task (val id: Int, private var _desc: String, private var _isCompleted: Boolean = false) {

    // Custom getter for 'desc'
    var desc: String
        get() = _desc
        set(value) {
            _desc = value
        }

    // Custom getter and setter for 'isCompleted'
    var isCompleted: Boolean
        get() = _isCompleted
        set(value) {
            _isCompleted = value
        }
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
        return "Task(id=$id, description='$_desc', isCompleted=$_isCompleted)"
    }
}