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
	 * A test method for the {@link PacROMSetManifest#getProgramROMs()}
	 * method.
	 * 
	 * @since 1.0.0
	 * @author GarlicDude
	 * @see PacROMSetManifest#getProgramROMs()
	 */
	@Test
	public final void testGetProgramROMList() {
		// Get the program ROM list.
		final List<PacROMSetManifestEntry> programROMList =
				manifest.getProgramROMs();
		// Assert whether the list is not null.
		assertNotNull(programROMList);
	}
	
	/**
	 * A test method for the {@link PacROMSetManifest#getGraphicROMs()}
	 * method.
	 * 
	 * @since 1.0.0
	 * @author GarlicDude
	 * @see PacROMSetManifest#getGraphicROMs()
	 */
	@Test
	public final void testGetGraphicROMList() {
		// Get the graphic ROM list.
		final List<PacROMSetManifestEntry> graphicROMList =
				manifest.getGraphicROMs();
		// Assert whether the list is not null.
		assertNotNull(graphicROMList);
	}
	
	/**
	 * A test method for the {@link PacROMSetManifest#getColorROMs()}
	 * method.
	 * 
	 * @since 1.0.0
	 * @author GarlicDude
	 * @see PacROMSetManifest#getColorROMs()
	 */
	@Test
	public final void testGetColorROMList() {
		// Get the color ROM list.
		final List<PacROMSetManifestEntry> colorROMList =
				manifest.getColorROMs();
		// Assert whether the list is not null.
		assertNotNull(colorROMList);
	}
	
	/**
	 * A test method for the {@link PacROMSetManifest#getPaletteROMs()}
	 * method.
	 * 
	 * @since 1.0.0
	 * @author GarlicDude
	 * @see PacROMSetManifest#getPaletteROMs()
	 */
	@Test
	public final void testGetPaletteROMList() {
		// Get the palette ROM list.
		final List<PacROMSetManifestEntry> paletteROMList =
				manifest.getPaletteROMs();
		// Assert whether the list is not null.
		assertNotNull(paletteROMList);
	}
	
	/**
	 * A test method for the {@link PacROMSetManifest#getSoundROMs()}
	 * method.
	 * 
	 * @since 1.0.0
	 * @author GarlicDude
	 * @see PacROMSetManifest#getSoundROMs()
	 */
	@Test
	public final void testGetSoundROMList() {
		// Get the sound ROM list.
		final List<PacROMSetManifestEntry> soundROMList =
				manifest.getSoundROMs();
		// Assert whether the list is not null.
		assertNotNull(soundROMList);
	}
	
	/**
	 * A test method for the {@link PacROMSetManifest#getMysteryROMs()}
	 * method.
	 * 
	 * @since 1.0.0
	 * @author GarlicDude
	 * @see PacROMSetManifest#getMysteryROMs()
	 */
	@Test
	public final void testGetMysteryROMList() {
		// Get the mystery ROM list.
		final List<PacROMSetManifestEntry> mysteryROMList =
				manifest.getMysteryROMs();
		// Assert whether the list is not null.
		assertNotNull(mysteryROMList);
	}
}
