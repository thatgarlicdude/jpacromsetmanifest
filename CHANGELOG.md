2026-10-12 GarlicDude <garlicdudedev@gmail.com>

	JPacROMSetManifest Version 1.0.0
	* Add PacROMSetManifest.java.
		* This class is the main class that has six categories of lists that can contain manifest entries.
	* Add PacROMSetManifestEntry.java.
		* This class is an entry class for the PacROMSetManifest class.
	* Add PacROMSetManifests.java.
		* This static class serves as an easy gateway for creating, saving, and loading PacROMSetManifest objects.
	* Add PacROMSetManifestReader.java.
		* This class is used to read .pacromsetmanifest files from disk, and loading them to memory.
	* Add PacROMSetManifestWriter.java.
		* This class is used to write .pacromsetmanifest files to disk using a PacROMSetManifest instance from memory.