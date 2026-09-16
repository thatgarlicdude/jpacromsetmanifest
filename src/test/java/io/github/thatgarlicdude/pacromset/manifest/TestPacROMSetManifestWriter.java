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

public final class TestPacROMSetManifestWriter {
	
	private PacROMSetManifest pacROMSetManifest;
	
	@Before
	public final void initPacROMSetManifest() {
		// Automatically initialize the PacROMSetManifest.
		pacROMSetManifest =
				PacROMSetManifests.newPacROMSetManifestCherry();
		// Set up the program ROM list.
		final List<PacROMSetManifestEntry> programList =
				pacROMSetManifest.getProgramROMList();
		// Set up the first program entry.
		final PacROMSetManifestEntry programEntry1 =
				new PacROMSetManifestEntry(
						"test_program1.bin", 0x1FF);
		// Set up the second program entry.
		final PacROMSetManifestEntry programEntry2 =
				new PacROMSetManifestEntry(
						"test_program2.bin", 0x1FF);
		// Set up the second program entry.
		final PacROMSetManifestEntry programEntry3 =
				new PacROMSetManifestEntry(
						"test_program3.bin", 0x1FF);
		// Set up the second program entry.
		final PacROMSetManifestEntry programEntry4 =
				new PacROMSetManifestEntry(
						"test_program4.bin", 0x1FF);
		// Add the entries to the list.
		programList.add(programEntry1);
		programList.add(programEntry2);
		programList.add(programEntry3);
		programList.add(programEntry4);
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
		// Create the manifest writer.
		final PacROMSetManifestWriter pacROMSetManifestWriter =
				new PacROMSetManifestWriter(
						pacROMSetManifest,
						fileOutputStream);
		// Write with the writer class.
		pacROMSetManifestWriter.write();
		// Close the output classes.
		pacROMSetManifestWriter.close();
		fileOutputStream.close();
	}
}
