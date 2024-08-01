import java.util.Scanner

fun main() {

    val scanner = Scanner(System.`in`)
    val navigator = Navigator(scanner)
    val archiveStorage = ArchiveStorage()
    val archiveManager = ArchiveManager(navigator)
    val app = NoteApp(navigator, archiveManager, archiveStorage)
    app.run()

}