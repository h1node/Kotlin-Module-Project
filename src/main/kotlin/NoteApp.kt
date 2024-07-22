class NoteApp(private val navigator: Navigator, private val archiveManager: ArchiveManager) {

    private val notes = mutableListOf<Pair<String, MutableSet<String>>>()

    fun run() {

        while (true) {
            val choice = navigator.chooseOption(
                listOf("Create an archive", "List archives"),
                "Choose an action:",
                "Exit"
            )

            when (choice) {
                1 -> {
                    val archiveName = navigator.getInput("Enter the name of the archive:")
                    if (archiveName.isBlank()) {
                        println("Archive name cannot be empty. Please try again.")
                    } else {
                        notes.add(archiveName to mutableSetOf())
                        println("Archive \"$archiveName\" created.")
                    }
                }

                2 -> {
                    if (notes.isEmpty()) {
                        println("The list of archives is empty.")
                    } else {
                        val archiveChoice = navigator.chooseOption(
                            notes.map { it.first },
                            "List of archives:",
                            "Go back"
                        )

                        if (archiveChoice != 0) {
                            val (_, archive) = notes[archiveChoice - 1]
                            archiveManager.openArchive(archive)
                        }
                    }
                }

                0 -> {
                    println("Exiting.")
                    break
                }
            }
        }
    }
}