import java.util.*

class Navigator(private val scanner: Scanner) {

    fun <T> chooseOption(options: List<T>, message: String, exitOption: String = "Go back"): Int {

        while (true) {
            println(message)
            options.forEachIndexed { index, option ->
                println("${index + 1}. $option")
            }
            println("0. $exitOption")

            if (scanner.hasNextInt()) {
                val choice = scanner.nextInt()
                scanner.nextLine()
                if (choice in 0..options.size) {
                    return choice
                } else {
                    println("Invalid choice, please try again.")
                }
            } else {
                println("Invalid input, please enter a number.")
                scanner.next()
            }
        }
    }

    fun getInput(message: String): String {
        println(message)
        return scanner.nextLine()
    }
}
