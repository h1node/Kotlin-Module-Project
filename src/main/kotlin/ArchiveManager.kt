class ArchiveManager(
    private val navigator: Navigator
) {

    fun openArchive(archive: Archive) {

        while (true) {
            val choice = navigator.chooseOption(
                listOf("Create a note", "List notes"),
                "Archive actions:",
                "Go back"
            )

            when (choice) {
                1 -> createNoteInArchive(archive)
                2 -> listNotesInArchive(archive)
                0 -> return
            }
        }
    }

    private fun createNoteInArchive(archive: Archive) {
        while (true) {
            val noteTitle = navigator.getInput("Enter the note title:")
            if (noteTitle.isBlank()) {
                println("Note title cannot be empty. Please try again.")
                continue
            }

            val noteContent = navigator.getInput("Enter the note content:")
            if (noteContent.isBlank()) {
                println("Note content cannot be empty. Please try again.")
                continue
            }

            val note = Note(noteTitle, noteContent)
            if (!archive.notes.add(note)) {
                println("Note with the same title already exists. Please choose a different title.")
            } else {
                println("Note \"$noteTitle\" added.")
                break
            }
        }
    }

    private fun listNotesInArchive(archive: Archive) {
        if (archive.notes.isEmpty()) {
            println("The list of notes is empty.")
        } else {
            val noteTitles = archive.notes.map { it.title }
            val noteIndex = navigator.chooseOption(
                noteTitles,
                "List of notes:",
                "Go back"
            )

            if (noteIndex != 0) {
                val note = archive.notes.elementAt(noteIndex - 1)
                println("Note title: ${note.title}")
                println("Note content: ${note.content}")
            }
        }
    }
}

