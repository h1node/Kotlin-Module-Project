import java.util.*

fun main() {

    val scanner = Scanner(System.`in`)
    val navigator = Navigator(scanner)
    val archiveManager = ArchiveManager(navigator)
    val app = NoteApp(navigator, archiveManager)
    app.run()

}