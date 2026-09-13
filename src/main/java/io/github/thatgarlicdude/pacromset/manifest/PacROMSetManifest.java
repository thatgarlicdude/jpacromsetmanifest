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
	
	private final List<PacROMSetManifestEntry> programROMList;
	
	private final List<PacROMSetManifestEntry> graphicROMList;
	
	private final List<PacROMSetManifestEntry> colorROMList;
	
	private final List<PacROMSetManifestEntry> paletteROMList;
	
	private final List<PacROMSetManifestEntry> soundROMList;
	
	private final List<PacROMSetManifestEntry> mysteryROMList;
	
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
	
	public PacROMSetManifest(
			final List<PacROMSetManifestEntry> programROMList,
			final List<PacROMSetManifestEntry> graphicROMList,
			final List<PacROMSetManifestEntry> colorROMList,
			final List<PacROMSetManifestEntry> paletteROMList,
			final List<PacROMSetManifestEntry> soundROMList,
			final List<PacROMSetManifestEntry> mysteryROMList) {
		// Set up each of the lists that shouldn't be null.
		this.programROMList = Objects.requireNonNull(programROMList);
		this.graphicROMList = Objects.requireNonNull(graphicROMList);
		this.colorROMList = Objects.requireNonNull(colorROMList);
		this.paletteROMList = Objects.requireNonNull(paletteROMList);
		this.soundROMList = Objects.requireNonNull(soundROMList);
		this.mysteryROMList = Objects.requireNonNull(mysteryROMList);
	}
}
