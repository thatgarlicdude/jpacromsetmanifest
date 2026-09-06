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
	
	private final List<PacROMSetManifestEntry> programROMList;
	
	private final List<PacROMSetManifestEntry> graphicROMList;
	
	private final List<PacROMSetManifestEntry> colorROMList;
	
	private final List<PacROMSetManifestEntry> paletteROMList;
	
	private final List<PacROMSetManifestEntry> soundROMList;
	
	private final List<PacROMSetManifestEntry> mysteryROMList;
	
	public final List<PacROMSetManifestEntry> getProgramROMList() {
		// Return the program ROM list.
		return this.programROMList;
	}
	
	public final List<PacROMSetManifestEntry> getGraphicROMList() {
		// Return the graphic ROM list.
		return this.graphicROMList;
	}
	
	public final List<PacROMSetManifestEntry> getColorROMList() {
		// Return the color ROM list.
		return this.colorROMList;
	}
	
	public final List<PacROMSetManifestEntry> getPaletteROMList() {
		// Return the palette ROM list.
		return this.paletteROMList;
	}
	
	public final List<PacROMSetManifestEntry> getSoundROMList() {
		// Return the sound ROM list.
		return this.soundROMList;
	}
	
	public final List<PacROMSetManifestEntry> getMysteryROMList() {
		// Return the mystery ROM list.
		return this.mysteryROMList;
	}
	
	/**
	 * Constructs an instance of the {@link PacROMSetManifest} class.
	 * 
	 * @since 1.0.0
	 * @author GarlicDude
	 */
	public PacROMSetManifest() {
		// Set up each of the lists.
		this.programROMList = new ArrayList<PacROMSetManifestEntry>();
		this.graphicROMList = new ArrayList<PacROMSetManifestEntry>();
		this.colorROMList = new ArrayList<PacROMSetManifestEntry>();
		this.paletteROMList = new ArrayList<PacROMSetManifestEntry>();
		this.soundROMList = new ArrayList<PacROMSetManifestEntry>();
		this.mysteryROMList = new ArrayList<PacROMSetManifestEntry>();
	}
}
