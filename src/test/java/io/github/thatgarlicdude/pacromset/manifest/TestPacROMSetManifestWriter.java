/*
 * Copyright 2026 GarlicDude
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * 	http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.github.thatgarlicdude.pacromset.manifest;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

/**
 * A test class for the {@link PacROMSetManifestWriter} class.
 * 
 * @since 1.0.0
 * @author GarlicDude
 * @see PacROMSetManifestWriter
 */
public final class TestPacROMSetManifestWriter {
	
	/**
	 * The test {@link PacROMSetManifest} instance used to write onto the
	 * disk.
	 * 
	 * @since 1.0.0
	 * @author GarlicDude
	 * @see #initPacROMSetManifest()
	 * @see #testWrite()
	 */
	private PacROMSetManifest pacROMSetManifest;
	
	/**
	 * Initializes the {@link #pacROMSetManifest} with all the created
	 * manifest entries.
	 * 
	 * @since 1.0.0
	 * @author GarlicDude
	 * @see #pacROMSetManifest
	 */
	@Before
	public final void initPacROMSetManifest() {
		// Automatically initialize the PacROMSetManifest.
		pacROMSetManifest =
				PacROMSetManifests.newPacROMSetManifestCherry();
		// Set up the program ROM list.
		final List<PacROMSetManifestEntry> programROMList =
				pacROMSetManifest.getProgramROMList();
		// Set up the first program ROM entry.
		final PacROMSetManifestEntry programROMEntry1 =
				new PacROMSetManifestEntry("test_prog1.bin", 256);
		// Set up the second program ROM entry.
		final PacROMSetManifestEntry programROMEntry2 =
				new PacROMSetManifestEntry("test_prog2.bin", 256);
		// Add the entries to the list.
		programROMList.add(programROMEntry1);
		programROMList.add(programROMEntry2);
	}
	
	@Test
	public final void testWrite() throws IOException {
		// Initialize the file path.
		final String filePath = "./testWrite.pacromsetmanifest";
		// Get the absolute path to the testWrite.pacromsetmanifest file.
		final String testPath = TestPacROMSetManifestWriter
				.class
				.getClassLoader()
				.getResource(filePath)
				.getFile();
		// Create the file output stream with the path.
		final FileOutputStream fileOutputStream =
				new FileOutputStream(testPath);
		// TODO: Create the PacROMSetManifestWriter instance here.
		fileOutputStream.close();
	}
}
