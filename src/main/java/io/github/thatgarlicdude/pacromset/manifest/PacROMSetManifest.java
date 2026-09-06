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

// TODO: Elaborate more on the class description.

/**
 * A class that represents a <b><i>Pac-Man</i> ROM set manifest</b>.
 * 
 * @since 1.0.0
 * @author GarlicDude
 */
public final class PacROMSetManifest {
	
	// TODO: Add Javadoc comments on the variables and methods.
	
	// TODO: Rename them to ROMList.
	
	private final List<PacROMSetManifestEntry> programROMs;
	
	private final List<PacROMSetManifestEntry> graphicROMs;
	
	private final List<PacROMSetManifestEntry> colorROMs;
	
	private final List<PacROMSetManifestEntry> paletteROMs;
	
	private final List<PacROMSetManifestEntry> soundROMs;
	
	private final List<PacROMSetManifestEntry> mysteryROMs;
	
	public final List<PacROMSetManifestEntry> getProgramROMs() {
		// Return the program ROM list.
		return this.programROMs;
	}
	
	public final List<PacROMSetManifestEntry> getGraphicROMs() {
		// Return the graphic ROM list.
		return this.graphicROMs;
	}
	
	public final List<PacROMSetManifestEntry> getColorROMs() {
		// Return the color ROM list.
		return this.colorROMs;
	}
	
	public final List<PacROMSetManifestEntry> getPaletteROMs() {
		// Return the palette ROM list.
		return this.paletteROMs;
	}
	
	public final List<PacROMSetManifestEntry> getSoundROMs() {
		// Return the sound ROM list.
		return this.soundROMs;
	}
	
	public final List<PacROMSetManifestEntry> getMysteryROMs() {
		// Return the mystery ROM list.
		return this.mysteryROMs;
	}
	
	/**
	 * Constructs an instance of the {@link PacROMSetManifest} class.
	 * 
	 * @since 1.0.0
	 * @author GarlicDude
	 */
	public PacROMSetManifest() {
		// Set up each of the lists.
		this.programROMs = new ArrayList<PacROMSetManifestEntry>();
		this.graphicROMs = new ArrayList<PacROMSetManifestEntry>();
		this.colorROMs = new ArrayList<PacROMSetManifestEntry>();
		this.paletteROMs = new ArrayList<PacROMSetManifestEntry>();
		this.soundROMs = new ArrayList<PacROMSetManifestEntry>();
		this.mysteryROMs = new ArrayList<PacROMSetManifestEntry>();
	}
}
