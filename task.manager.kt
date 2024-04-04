import java.util.Scanner

class TaskManager {
    private val tasks = mutableListOf<String>()

    fun addTask(task: String) {
        tasks.add(task)
        println("Task \"$task\" added.")
    }

    fun removeTask(index: Int) {
        if (index in tasks.indices) {
            val removedTask = tasks.removeAt(index)
            println("Task \"$removedTask\" removed.")
        } else {
            println("Invalid index.")
        }
    }

    fun listTasks() {
        if (tasks.isEmpty()) {
            println("No tasks found.")
        } else {
            println("Tasks:")
            tasks.forEachIndexed { index, task ->
                println("$index: $task")
            }
        }
    }
}

fun main() {
    val scanner = Scanner(System.`in`)
    val taskManager = TaskManager()

    while (true) {
        println("\nTask Manager")
        println("1. Add Task")
        println("2. Remove Task")
        println("3. List Tasks")
        println("4. Exit")
        print("Enter your choice: ")

        when (scanner.nextInt()) {
            1 -> {
                print("Enter task to add: ")
                val task = scanner.next()
                taskManager.addTask(task)
            }
            2 -> {
                print("Enter index of task to remove: ")
                val index = scanner.nextInt()
                taskManager.removeTask(index)
            }
            3 -> taskManager.listTasks()
            4 -> {
                println("Exiting...")
                return
            }
            else -> println("Invalid choice.")
        }
    }
}
