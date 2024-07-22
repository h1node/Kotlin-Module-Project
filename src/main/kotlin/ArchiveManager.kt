class ArchiveManager(private val navigator: Navigator) {

    fun openArchive(archive: MutableSet<String>) {

        while (true) {
            val choice = navigator.chooseOption(
                listOf("Create a note", "List notes"),
                "Archive actions:",
                "Go back"
            )

            when (choice) {
                1 -> {
                    val noteContent = navigator.getInput("Enter the note content:")
                    if (noteContent.isBlank()) {
                        println("Note content cannot be empty. Please try again.")
                    } else {
                        archive.add(noteContent)
                        println("Note added.")
                    }
                }

                2 -> {
                    if (archive.isEmpty()) {
                        println("The list of notes is empty.")
                    } else {
                        val noteChoice = navigator.chooseOption(
                            archive.toList(),
                            "List of notes:",
                            "Go back"
                        )

                        if (noteChoice != 0) {
                            val note = archive.elementAt(noteChoice - 1)
                            println("Note content: $note")
                        }
                    }
                }

                0 -> return
            }
        }
    }
}
