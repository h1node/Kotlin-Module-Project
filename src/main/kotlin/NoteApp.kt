class NoteApp(
    private val navigator: Navigator,
    private val archiveManager: ArchiveManager,
    private val archiveStorage: ArchiveStorage
) {

    fun run() {

        while (true) {
            val choice = navigator.chooseOption(
                listOf("Create an archive", "List archives"),
                "Choose an action:",
                "Exit"
            )

            when (choice) {
                1 -> createArchive()
                2 -> listArchives()
                0 -> {
                    println("Exiting.")
                    break
                }
            }
        }
    }

    private fun createArchive() {
        while (true) {
            val archiveName = navigator.getInput("Enter the name of the archive:")
            if (archiveName.isBlank()) {
                println("Archive name cannot be empty. Please try again.")
            } else if (archiveStorage.findArchiveByName(archiveName) != null) {
                println("Archive name already exists. Please choose a different name.")
            } else {
                val archive = Archive(archiveName)
                archiveStorage.addArchives(archive)
                println("Archive \"$archiveName\" created.")
                break
            }
        }
    }

    private fun listArchives() {
        val archives = archiveStorage.getArchives()
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
}
