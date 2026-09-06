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
	 * The {@link PacROMSetManifest} instance used for testing purposes.
	 * 
	 * @since 1.0.0
	 * @author GarlicDude
	 * @see #testGetProgramROMsList()
	 * @see #testGetGraphicROMList()
	 * @see #testGetColorROMList()
	 * @see #testGetPaletteROMList()
	 * @see #testGetSoundROMList()
	 * @see #testGetMysteryROMList()
	 */
	private final PacROMSetManifest manifest = new PacROMSetManifest();
	
	/**
	 * A test method for the {@link PacROMSetManifest#getProgramROMList()}
	 * method.
	 * 
	 * @since 1.0.0
	 * @author GarlicDude
	 * @see PacROMSetManifest#getProgramROMList()
	 */
	@Test
	public final void testGetProgramROMList() {
		// Get the program ROM list.
		final List<PacROMSetManifestEntry> programROMList =
				manifest.getProgramROMList();
		// Assert whether the list is not null.
		assertNotNull(programROMList);
	}
	
	/**
	 * A test method for the {@link PacROMSetManifest#getGraphicROMList()}
	 * method.
	 * 
	 * @since 1.0.0
	 * @author GarlicDude
	 * @see PacROMSetManifest#getGraphicROMList()
	 */
	@Test
	public final void testGetGraphicROMList() {
		// Get the graphic ROM list.
		final List<PacROMSetManifestEntry> graphicROMList =
				manifest.getGraphicROMList();
		// Assert whether the list is not null.
		assertNotNull(graphicROMList);
	}
	
	/**
	 * A test method for the {@link PacROMSetManifest#getColorROMList()}
	 * method.
	 * 
	 * @since 1.0.0
	 * @author GarlicDude
	 * @see PacROMSetManifest#getColorROMList()
	 */
	@Test
	public final void testGetColorROMList() {
		// Get the color ROM list.
		final List<PacROMSetManifestEntry> colorROMList =
				manifest.getColorROMList();
		// Assert whether the list is not null.
		assertNotNull(colorROMList);
	}
	
	/**
	 * A test method for the {@link PacROMSetManifest#getPaletteROMList()}
	 * method.
	 * 
	 * @since 1.0.0
	 * @author GarlicDude
	 * @see PacROMSetManifest#getPaletteROMList()
	 */
	@Test
	public final void testGetPaletteROMList() {
		// Get the palette ROM list.
		final List<PacROMSetManifestEntry> paletteROMList =
				manifest.getPaletteROMList();
		// Assert whether the list is not null.
		assertNotNull(paletteROMList);
	}
	
	/**
	 * A test method for the {@link PacROMSetManifest#getSoundROMList()}
	 * method.
	 * 
	 * @since 1.0.0
	 * @author GarlicDude
	 * @see PacROMSetManifest#getSoundROMList()
	 */
	@Test
	public final void testGetSoundROMList() {
		// Get the sound ROM list.
		final List<PacROMSetManifestEntry> soundROMList =
				manifest.getSoundROMList();
		// Assert whether the list is not null.
		assertNotNull(soundROMList);
	}
	
	/**
	 * A test method for the {@link PacROMSetManifest#getMysteryROMList()}
	 * method.
	 * 
	 * @since 1.0.0
	 * @author GarlicDude
	 * @see PacROMSetManifest#getMysteryROMList()
	 */
	@Test
	public final void testGetMysteryROMList() {
		// Get the mystery ROM list.
		final List<PacROMSetManifestEntry> mysteryROMList =
				manifest.getMysteryROMList();
		// Assert whether the list is not null.
		assertNotNull(mysteryROMList);
	}
}
