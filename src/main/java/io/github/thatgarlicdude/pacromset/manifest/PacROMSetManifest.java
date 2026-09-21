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
import java.util.Objects;

public final class PacROMSetManifest {
	
	public static final String MAGIC = "PACROMSETMANIFEST";
	
	public static final String EXTENSION = "pacromsetmanifest";
	
	public static final byte VERSION = 1;
	
	private final List<PacROMSetManifestEntry> programList;
	
	private final List<PacROMSetManifestEntry> graphicList;
	
	private final List<PacROMSetManifestEntry> colorList;
	
	private final List<PacROMSetManifestEntry> paletteList;
	
	private final List<PacROMSetManifestEntry> soundList;
	
	private final List<PacROMSetManifestEntry> mysteryList;
	
	public static final String getMagic() {
		// Return the magic signature used for the manifest files.
		return MAGIC;
	}
	
	public static final String getExtension() {
		// Return the file extension used to label the manifest files.
		return EXTENSION;
	}
	
	public static final byte getVersion() {
		// Return the current version of the manifest.
		return VERSION;
	}
	
	public final List<PacROMSetManifestEntry> getProgramList() {
		// Return the program list.
		return this.programList;
	}
	
	public final List<PacROMSetManifestEntry> getGraphicList() {
		// Return the graphic list.
		return this.graphicList;
	}
	
	public final List<PacROMSetManifestEntry> getColorList() {
		// Return the color list.
		return this.colorList;
	}
	
	public final List<PacROMSetManifestEntry> getPaletteList() {
		// Return the palette list.
		return this.paletteList;
	}
	
	public final List<PacROMSetManifestEntry> getSoundList() {
		// Return the sound list.
		return this.soundList;
	}
	
	public final List<PacROMSetManifestEntry> getMysteryList() {
		// Return the mystery list.
		return this.mysteryList;
	}
	
	public PacROMSetManifest(
			final List<PacROMSetManifestEntry> programList,
			final List<PacROMSetManifestEntry> graphicList,
			final List<PacROMSetManifestEntry> colorList,
			final List<PacROMSetManifestEntry> paletteList,
			final List<PacROMSetManifestEntry> soundList,
			final List<PacROMSetManifestEntry> mysteryList) {
		// Set up each of the lists that shouldn't be null.
		this.programList = Objects.requireNonNull(programList);
		this.graphicList = Objects.requireNonNull(graphicList);
		this.colorList = Objects.requireNonNull(colorList);
		this.paletteList = Objects.requireNonNull(paletteList);
		this.soundList = Objects.requireNonNull(soundList);
		this.mysteryList = Objects.requireNonNull(mysteryList);
	}
}
