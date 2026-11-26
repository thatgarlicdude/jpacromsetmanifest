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
		pacROMSetManifest =
				PacROMSetManifests.create();
		initProgramList();
		initGraphicList();
		initColorList();
		initPaletteList();
		initSoundList();
		initMysteryList();
	}
	
	private final void initProgramList() {
		final List<PacROMSetManifestEntry> programList =
				pacROMSetManifest.getProgramList();
		final PacROMSetManifestEntry programEntry1 =
				new PacROMSetManifestEntry(
						"test_program1.bin", 0x1FF);
		final PacROMSetManifestEntry programEntry2 =
				new PacROMSetManifestEntry(
						"test_program2.bin", 0x1FF);
		final PacROMSetManifestEntry programEntry3 =
				new PacROMSetManifestEntry(
						"test_program3.bin", 0x1FF);
		final PacROMSetManifestEntry programEntry4 =
				new PacROMSetManifestEntry(
						"test_program4.bin", 0x1FF);
		programList.add(programEntry1);
		programList.add(programEntry2);
		programList.add(programEntry3);
		programList.add(programEntry4);
	}
	
	private final void initGraphicList() {
		final List<PacROMSetManifestEntry> graphicList =
				pacROMSetManifest.getGraphicList();
		final PacROMSetManifestEntry graphicEntry1 =
				new PacROMSetManifestEntry(
						"test_graphic1.bin", 0x200);
		final PacROMSetManifestEntry graphicEntry2 =
				new PacROMSetManifestEntry(
						"test_graphic2.bin", 0x200);
		graphicList.add(graphicEntry1);
		graphicList.add(graphicEntry2);
	}
	
	private final void initColorList() {
		final List<PacROMSetManifestEntry> colorList =
				pacROMSetManifest.getColorList();
		final PacROMSetManifestEntry colorEntry1 =
				new PacROMSetManifestEntry(
						"test_color1.bin", 0x40);
		final PacROMSetManifestEntry colorEntry2 =
				new PacROMSetManifestEntry(
						"test_color2.bin", 0x40);
		colorList.add(colorEntry1);
		colorList.add(colorEntry2);
	}
	
	private final void initPaletteList() {
		final List<PacROMSetManifestEntry> paletteList =
				pacROMSetManifest.getPaletteList();
		final PacROMSetManifestEntry paletteEntry1 =
				new PacROMSetManifestEntry(
						"test_palette1.bin", 0x400);
		final PacROMSetManifestEntry paletteEntry2 =
				new PacROMSetManifestEntry(
						"test_palette2.bin", 0x400);
		paletteList.add(paletteEntry1);
		paletteList.add(paletteEntry2);
	}
	
	private final void initSoundList() {
		final List<PacROMSetManifestEntry> soundList =
				pacROMSetManifest.getSoundList();
		final PacROMSetManifestEntry soundEntry1 =
				new PacROMSetManifestEntry(
						"test_sound1.bin", 0x200);
		final PacROMSetManifestEntry soundEntry2 =
				new PacROMSetManifestEntry(
						"test_sound2.bin", 0x200);
		soundList.add(soundEntry1);
		soundList.add(soundEntry2);
	}
	
	private final void initMysteryList() {
		final List<PacROMSetManifestEntry> mysteryList =
				pacROMSetManifest.getMysteryList();
		final PacROMSetManifestEntry mysteryEntry1 =
				new PacROMSetManifestEntry(
						"test_mystery1.bin", 0x100);
		final PacROMSetManifestEntry mysteryEntry2 =
				new PacROMSetManifestEntry(
						"test_mystery2.bin", 0x100);
		mysteryList.add(mysteryEntry1);
		mysteryList.add(mysteryEntry2);
	}
	
	@Test
	public final void testWrite() throws IOException {
		final String filePath = "./testWrite1.pacromsetmanifest";
		final String testPath = TestPacROMSetManifestWriter
				.class
				.getClassLoader()
				.getResource(filePath)
				.getFile();
		final FileOutputStream fileOutputStream =
				new FileOutputStream(testPath);
		final PacROMSetManifestWriter pacROMSetManifestWriter =
				new PacROMSetManifestWriter(
						pacROMSetManifest,
						fileOutputStream);
		pacROMSetManifestWriter.write();
		pacROMSetManifestWriter.close();
		fileOutputStream.close();
	}
}
