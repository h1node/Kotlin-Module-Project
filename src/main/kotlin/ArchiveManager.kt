class ArchiveManager(private val navigator: Navigator) {

    fun openArchive(archive: Archive) {

        while (true) {
            val choice = navigator.chooseOption(
                listOf("Create a note", "List notes"),
                "Archive actions:",
                "Go back"
            )

            when (choice) {
                1 -> {
                    val noteTitle = navigator.getInput("Enter the note title:")
                    if (noteTitle.isBlank()) {
                        println("Note title cannot be empty. Please try again.")
                    }

                    val noteContent = navigator.getInput("Enter the note content:")
                    if (noteContent.isBlank()) {
                        println("Note content cannot be empty. Please try again.")
                    }
                    archive.notes.add(Note(noteTitle, noteContent))
                    println("Note \"$noteTitle\" added.")
                }

                2 -> {
                    if (archive.notes.isEmpty()) {
                        println("The list of notes is empty.")
                    } else {
                        val noteTitle = archive.notes.map { it.title }
                        val noteContent = navigator.chooseOption(
                            noteTitle,
                            "List of notes:",
                            "Go back"
                        )

                        if (noteContent != 0) {
                            val note = archive.notes.elementAt(noteContent - 1)
                            println("Note title: ${note.title}")
                            println("Note content: ${note.content}")
                        }
                    }
                }

                0 -> return
            }
        }
    }
}

