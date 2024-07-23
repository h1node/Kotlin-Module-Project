class NoteApp(private val navigator: Navigator, private val archiveManager: ArchiveManager) {

    private val archives = mutableListOf<Archive>()

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
                        archives.add(Archive(archiveName))
                        println("Archive \"$archiveName\" created.")
                    }
                }

                2 -> {
                    if (archives.isEmpty()) {
                        println("The list of archives is empty.")
                    } else {
                        val archiveChoice = navigator.chooseOption(
                            archives.map { it.name },
                            "List of archives:",
                            "Go back"
                        )

                        if (archiveChoice != 0) {
                            val archive = archives[archiveChoice - 1]
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