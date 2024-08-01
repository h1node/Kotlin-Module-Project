class ArchiveStorage {

    private val archives = mutableListOf<Archive>()

    fun getArchives(): List<Archive> = archives.toList()

    fun addArchives(archive: Archive) {
        archives.add(archive)
    }

    fun findArchiveByName(name: String): Archive? {
        return archives.find { it.name == name }
    }
}
