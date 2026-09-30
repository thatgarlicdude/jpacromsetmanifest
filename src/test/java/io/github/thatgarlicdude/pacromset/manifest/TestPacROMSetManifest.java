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

/**
 * A test class for the {@link PacROMSetManifest} class.
 * 
 * @since 1.0.0
 * @author GarlicDude
 * @see PacROMSetManifest
 */
public final class TestPacROMSetManifest {
	
	/**
	 * The <i>Pac-Man</i> ROM set manifest used for testing purposes.
	 * 
	 * @since 1.0.0
	 * @author GarlicDude
	 */
	private final PacROMSetManifest manifest = new PacROMSetManifest(
			new ArrayList<PacROMSetManifestEntry>(),
			new ArrayList<PacROMSetManifestEntry>(),
			new ArrayList<PacROMSetManifestEntry>(),
			new ArrayList<PacROMSetManifestEntry>(),
			new ArrayList<PacROMSetManifestEntry>(),
			new ArrayList<PacROMSetManifestEntry>());
	
	/**
	 * Checks the entire manifest, as well as its lists and entries.
	 * 
	 * @param manifest The manifest that is used to be checked.
	 * @since 1.0.0
	 * @author GarlicDude
	 */
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
	
	/**
	 * Checks a manifest list, as well as its entries.
	 * 
	 * @param list The list that is used to be checked.
	 * @since 1.0.0
	 * @author GarlicDude
	 */
	public static final void check(
			final List<PacROMSetManifestEntry> list) {
		// Assert if the list is not null.
		assertNotNull(list);
		// Print the size of the list.
		System.out.println("Manifest list size: " + list.size());
		// Go through each of the entries in the list.
		for (final PacROMSetManifestEntry entry : list) {
			// Check if the entry is valid.
			TestPacROMSetManifestEntry.check(entry);
		}
	}
	
	/**
	 * A test method for the {@link PacROMSetManifest#getMagic()}
	 * method.
	 * 
	 * @since 1.0.0
	 * @author GarlicDude
	 * @see PacROMSetManifest#getMagic()
	 */
	@Test
	public final void testGetMagic() {
		// Get the magic signature of the manifest file.
		final String magic = PacROMSetManifest.getMagic();
		// Print the magic.
		System.out.println("PacROMSetManifest Magic: " + magic);
		// Assert whether the two variables are the same.
		assertSame(magic, PacROMSetManifest.MAGIC);
	}
	
	/**
	 * A test method for the {@link PacROMSetManifest#getExtension()}
	 * method.
	 * 
	 * @since 1.0.0
	 * @author GarlicDude
	 * @see PacROMSetManifest#getExtension()
	 */
	@Test
	public final void testGetExtension() {
		// Get the file extension of the manifest file.
		final String extension = PacROMSetManifest.getExtension();
		// Print the extension.
		System.out.println("PacROMSetManifest Extension: " + extension);
		// Assert whether the two variables are the same.
		assertSame(extension, PacROMSetManifest.EXTENSION);
	}
	
	/**
	 * A test method for the {@link PacROMSetManifest#getVersion()}
	 * method.
	 * 
	 * @since 1.0.0
	 * @author GarlicDude
	 * @see PacROMSetManifest#getVersion()
	 */
	@Test
	public final void testGetVersion() {
		// Get the version of the manifest file.
		final byte version = PacROMSetManifest.getVersion();
		// Print the version.
		System.out.println("PacROMSetManifest Version: " + version);
		// Assert whether the two variables are equal to each other.
		assertEquals(version, PacROMSetManifest.VERSION);
	}
	
	/**
	 * A test method for the {@link PacROMSetManifest#getProgramList()}
	 * method.
	 * 
	 * @since 1.0.0
	 * @author GarlicDude
	 * @see PacROMSetManifest#getProgramList()
	 */
	@Test
	public final void testGetProgramList() {
		// Get the program ROM list.
		final List<PacROMSetManifestEntry> programROMList =
				manifest.getProgramList();
		// Assert whether the list is not null.
		assertNotNull(programROMList);
	}
	
	/**
	 * A test method for the {@link PacROMSetManifest#getGraphicList()}
	 * method.
	 * 
	 * @since 1.0.0
	 * @author GarlicDude
	 * @see PacROMSetManifest#getGraphicList()
	 */
	@Test
	public final void testGetGraphicList() {
		// Get the graphic ROM list.
		final List<PacROMSetManifestEntry> graphicROMList =
				manifest.getGraphicList();
		// Assert whether the list is not null.
		assertNotNull(graphicROMList);
	}
	
	/**
	 * A test method for the {@link PacROMSetManifest#getColorList()}
	 * method.
	 * 
	 * @since 1.0.0
	 * @author GarlicDude
	 * @see PacROMSetManifest#getColorList()
	 */
	@Test
	public final void testGetColorList() {
		// Get the color ROM list.
		final List<PacROMSetManifestEntry> colorROMList =
				manifest.getColorList();
		// Assert whether the list is not null.
		assertNotNull(colorROMList);
	}
	
	/**
	 * A test method for the {@link PacROMSetManifest#getPaletteList()}
	 * method.
	 * 
	 * @since 1.0.0
	 * @author GarlicDude
	 * @see PacROMSetManifest#getPaletteList()
	 */
	@Test
	public final void testGetPaletteList() {
		// Get the palette ROM list.
		final List<PacROMSetManifestEntry> paletteROMList =
				manifest.getPaletteList();
		// Assert whether the list is not null.
		assertNotNull(paletteROMList);
	}
	
	/**
	 * A test method for the {@link PacROMSetManifest#getSoundList()}
	 * method.
	 * 
	 * @since 1.0.0
	 * @author GarlicDude
	 * @see PacROMSetManifest#getSoundList()
	 */
	@Test
	public final void testGetSoundList() {
		// Get the sound ROM list.
		final List<PacROMSetManifestEntry> soundROMList =
				manifest.getSoundList();
		// Assert whether the list is not null.
		assertNotNull(soundROMList);
	}
	
	/**
	 * A test method for the {@link PacROMSetManifest#getMysteryList()}
	 * method.
	 * 
	 * @since 1.0.0
	 * @author GarlicDude
	 * @see PacROMSetManifest#getMysteryList()
	 */
	@Test
	public final void testGetMysteryList() {
		// Get the mystery ROM list.
		final List<PacROMSetManifestEntry> mysteryROMList =
				manifest.getMysteryList();
		// Assert whether the list is not null.
		assertNotNull(mysteryROMList);
	}
}
