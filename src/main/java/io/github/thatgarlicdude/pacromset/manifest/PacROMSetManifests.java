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

import java.lang.UnsupportedOperationException;
import java.util.ArrayList;
import java.util.List;

public final class PacROMSetManifests {
	
	public static final PacROMSetManifest newPacROMSetManifestCherry() {
		// Initialize the program ROM list.
		final List<PacROMSetManifestEntry> programROMList =
				new ArrayList<PacROMSetManifestEntry>();
		// Initialize the graphic ROM list.
		final List<PacROMSetManifestEntry> graphicROMList =
				new ArrayList<PacROMSetManifestEntry>();
		// Initialize the color ROM list.
		final List<PacROMSetManifestEntry> colorROMList =
				new ArrayList<PacROMSetManifestEntry>();
		// Initialize the palette ROM list.
		final List<PacROMSetManifestEntry> paletteROMList =
				new ArrayList<PacROMSetManifestEntry>();
		// Initialize the sound ROM list.
		final List<PacROMSetManifestEntry> soundROMList =
				new ArrayList<PacROMSetManifestEntry>();
		// Initialize the mystery ROM list.
		final List<PacROMSetManifestEntry> mysteryROMList =
				new ArrayList<PacROMSetManifestEntry>();
		// Return the newly created PacROMSetManifest instance.
		return new PacROMSetManifest(
				programROMList,
				graphicROMList,
				colorROMList,
				paletteROMList,
				soundROMList,
				mysteryROMList);
	}
	
	// TODO: Add savePacROMSetManifestCherry() and loadPacROMSetManifest().
	
	private PacROMSetManifests() {
		// Throw the error in case the constructor was actually called.
		throw new UnsupportedOperationException();
	}
}
