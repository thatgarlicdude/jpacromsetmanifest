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

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import org.junit.Test;

public final class TestPacROMSetManifest {
	
	private final PacROMSetManifest manifest = new PacROMSetManifest(
			new ArrayList<PacROMSetManifestEntry>(),
			new ArrayList<PacROMSetManifestEntry>(),
			new ArrayList<PacROMSetManifestEntry>(),
			new ArrayList<PacROMSetManifestEntry>(),
			new ArrayList<PacROMSetManifestEntry>(),
			new ArrayList<PacROMSetManifestEntry>());
	
	public static final void check(final PacROMSetManifest manifest) {
		// Assert if the manifest is not null.
		assertNotNull(manifest);
		// Check the program list.
		check(manifest.getProgramList());
		// Check the graphic list.
		check(manifest.getGraphicList());
		// Check the color list.
		check(manifest.getColorList());
		// Check the palette list.
		check(manifest.getPaletteList());
		// Check the sound list.
		check(manifest.getPaletteList());
		// Check the mystery list.
		check(manifest.getMysteryList());
	}
	
	public static final void check(
			final List<PacROMSetManifestEntry> list) {
		// Assert if the list is not null.
		assertNotNull(list);
		// Go through each of the entries in the list.
		for (final PacROMSetManifestEntry entry : list) {
			// Check if the entry is valid.
			TestPacROMSetManifestEntry.check(entry);
		}
	}
	
	@Test
	public final void testGetVersion() {
		// Get the version of the manifest file.
		final byte version = PacROMSetManifest.getVersion();
		// Print the version.
		System.out.println("PacROMSetManifest Version: " + version);
		// Assert whether the two variables are equal to each other.
		assertEquals(version, PacROMSetManifest.VERSION);
	}
	
	@Test
	public final void testGetProgramROMList() {
		// Get the program ROM list.
		final List<PacROMSetManifestEntry> programROMList =
				manifest.getProgramList();
		// Assert whether the list is not null.
		assertNotNull(programROMList);
	}
	
	@Test
	public final void testGetGraphicROMList() {
		// Get the graphic ROM list.
		final List<PacROMSetManifestEntry> graphicROMList =
				manifest.getGraphicList();
		// Assert whether the list is not null.
		assertNotNull(graphicROMList);
	}
	
	@Test
	public final void testGetColorROMList() {
		// Get the color ROM list.
		final List<PacROMSetManifestEntry> colorROMList =
				manifest.getColorList();
		// Assert whether the list is not null.
		assertNotNull(colorROMList);
	}
	
	@Test
	public final void testGetPaletteROMList() {
		// Get the palette ROM list.
		final List<PacROMSetManifestEntry> paletteROMList =
				manifest.getPaletteList();
		// Assert whether the list is not null.
		assertNotNull(paletteROMList);
	}
	
	@Test
	public final void testGetSoundROMList() {
		// Get the sound ROM list.
		final List<PacROMSetManifestEntry> soundROMList =
				manifest.getSoundList();
		// Assert whether the list is not null.
		assertNotNull(soundROMList);
	}
	
	@Test
	public final void testGetMysteryROMList() {
		// Get the mystery ROM list.
		final List<PacROMSetManifestEntry> mysteryROMList =
				manifest.getMysteryList();
		// Assert whether the list is not null.
		assertNotNull(mysteryROMList);
	}
}
