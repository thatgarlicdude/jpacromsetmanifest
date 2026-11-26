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
	
	// TODO: Perhaps these methods need to be removed someday.
	
	public static final void check(final PacROMSetManifest manifest) {
		assertNotNull(manifest);
		check(manifest.getProgramList());
		check(manifest.getGraphicList());
		check(manifest.getColorList());
		check(manifest.getPaletteList());
		check(manifest.getPaletteList());
		check(manifest.getMysteryList());
	}
	
	public static final void check(
			final List<PacROMSetManifestEntry> list) {
		assertNotNull(list);
		System.out.println("Manifest list size: " + list.size());
		for (final PacROMSetManifestEntry entry : list) {
			TestPacROMSetManifestEntry.check(entry);
		}
	}
	
	@Test
	public final void testGetMagic() {
		final String magic = PacROMSetManifest.getMagic();
		System.out.println("PacROMSetManifest Magic: " + magic);
		assertSame(magic, PacROMSetManifest.MAGIC);
	}
	
	@Test
	public final void testGetExtension() {
		final String extension = PacROMSetManifest.getExtension();
		System.out.println("PacROMSetManifest Extension: " + extension);
		assertSame(extension, PacROMSetManifest.EXTENSION);
	}
	
	@Test
	public final void testGetListSeparator() {
		final byte listSeparator = PacROMSetManifest.getListSeparator();
		System.out.println(
				"PacROMSetManifest List Separator: " + listSeparator);
		assertEquals(listSeparator, PacROMSetManifest.LIST_SEPARATOR);
	}
	
	@Test
	public final void testGetEntrySeparator() {
		final byte entrySeparator = PacROMSetManifest.getEntrySeparator();
		System.out.println(
				"PacROMSetManifest Entry Separator: " + entrySeparator);
		assertEquals(entrySeparator, PacROMSetManifest.ENTRY_SEPARATOR);
	}
	
	@Test
	public final void testGetVersion() {
		final byte version = PacROMSetManifest.getVersion();
		System.out.println("PacROMSetManifest Version: " + version);
		assertEquals(version, PacROMSetManifest.VERSION);
	}
	
	@Test
	public final void testGetProgramList() {
		final List<PacROMSetManifestEntry> programROMList =
				manifest.getProgramList();
		assertNotNull(programROMList);
	}
	
	@Test
	public final void testGetGraphicList() {
		final List<PacROMSetManifestEntry> graphicROMList =
				manifest.getGraphicList();
		assertNotNull(graphicROMList);
	}
	
	@Test
	public final void testGetColorList() {
		final List<PacROMSetManifestEntry> colorROMList =
				manifest.getColorList();
		assertNotNull(colorROMList);
	}
	
	@Test
	public final void testGetPaletteList() {
		final List<PacROMSetManifestEntry> paletteROMList =
				manifest.getPaletteList();
		assertNotNull(paletteROMList);
	}
	
	@Test
	public final void testGetSoundList() {
		final List<PacROMSetManifestEntry> soundROMList =
				manifest.getSoundList();
		assertNotNull(soundROMList);
	}
	
	@Test
	public final void testGetMysteryList() {
		final List<PacROMSetManifestEntry> mysteryROMList =
				manifest.getMysteryList();
		assertNotNull(mysteryROMList);
	}
}
