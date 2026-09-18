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
		// Initialize the manifest's lists.
		initProgramList();
		initGraphicList();
		initColorList();
		initPaletteList();
		initSoundList();
		initMysteryList();
	}
	
	private final void initProgramList() {
		// Get the program list.
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
		// Set up the third program entry.
		final PacROMSetManifestEntry programEntry3 =
				new PacROMSetManifestEntry(
						"test_program3.bin", 0x1FF);
		// Set up the fourth program entry.
		final PacROMSetManifestEntry programEntry4 =
				new PacROMSetManifestEntry(
						"test_program4.bin", 0x1FF);
		// Add the entries to the list.
		programList.add(programEntry1);
		programList.add(programEntry2);
		programList.add(programEntry3);
		programList.add(programEntry4);
	}
	
	private final void initGraphicList() {
		// Get the graphic list.
		final List<PacROMSetManifestEntry> graphicList =
				pacROMSetManifest.getGraphicROMList();
		// Set up the first graphic entry.
		final PacROMSetManifestEntry graphicEntry1 =
				new PacROMSetManifestEntry(
						"test_graphic1.bin", 0x200);
		// Set up the second graphic entry.
		final PacROMSetManifestEntry graphicEntry2 =
				new PacROMSetManifestEntry(
						"test_graphic2.bin", 0x200);
		// Add the entries to the list.
		graphicList.add(graphicEntry1);
		graphicList.add(graphicEntry2);
	}
	
	private final void initColorList() {
		// Get the color list.
		final List<PacROMSetManifestEntry> colorList =
				pacROMSetManifest.getColorROMList();
		// Set up the first color entry.
		final PacROMSetManifestEntry colorEntry1 =
				new PacROMSetManifestEntry(
						"test_color1.bin", 0x40);
		// Set up the second color entry.
		final PacROMSetManifestEntry colorEntry2 =
				new PacROMSetManifestEntry(
						"test_color2.bin", 0x40);
		// Add the entries to the list.
		colorList.add(colorEntry1);
		colorList.add(colorEntry2);
	}
	
	private final void initPaletteList() {
		// Get the palette list.
		final List<PacROMSetManifestEntry> paletteList =
				pacROMSetManifest.getPaletteROMList();
		// Set up the first palette entry.
		final PacROMSetManifestEntry paletteEntry1 =
				new PacROMSetManifestEntry(
						"test_palette1.bin", 0x400);
		// Set up the second palette entry.
		final PacROMSetManifestEntry paletteEntry2 =
				new PacROMSetManifestEntry(
						"test_palette2.bin", 0x400);
		// Add the entries to the list.
		paletteList.add(paletteEntry1);
		paletteList.add(paletteEntry2);
	}
	
	private final void initSoundList() {
		// Get the sound list.
		final List<PacROMSetManifestEntry> soundList =
				pacROMSetManifest.getSoundROMList();
		// Set up the first sound entry.
		final PacROMSetManifestEntry soundEntry1 =
				new PacROMSetManifestEntry(
						"test_sound1.bin", 0x200);
		// Set up the second sound entry.
		final PacROMSetManifestEntry soundEntry2 =
				new PacROMSetManifestEntry(
						"test_sound2.bin", 0x200);
		// Add the entries to the list.
		soundList.add(soundEntry1);
		soundList.add(soundEntry2);
	}
	
	private final void initMysteryList() {
		// Get the mystery list.
		final List<PacROMSetManifestEntry> mysteryList =
				pacROMSetManifest.getMysteryROMList();
		// Set up the first mystery entry.
		final PacROMSetManifestEntry mysteryEntry1 =
				new PacROMSetManifestEntry(
						"test_mystery1.bin", 0x100);
		// Set up the second mystery entry.
		final PacROMSetManifestEntry mysteryEntry2 =
				new PacROMSetManifestEntry(
						"test_mystery2.bin", 0x100);
		// Add the entries to the list.
		mysteryList.add(mysteryEntry1);
		mysteryList.add(mysteryEntry2);
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
