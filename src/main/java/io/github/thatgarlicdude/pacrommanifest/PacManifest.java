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

package io.github.thatgarlicdude.pacrommanifest;

import java.util.ArrayList;
import java.util.List;

// TODO: Elaborate more on the class description.

/*
 * TODO: Change the name to PacROMManifest, since PacManifest is a name
 * that already exists.
 */

/**
 * A class that represents a <b>PacManifest</b>.
 * 
 * @since 1.0.0
 * @author GarlicDude
 */
public final class PacManifest {
	
	// TODO: Add Javadoc comments on the variables and methods.
	
	// TODO: Rename them to ROMList.
	
	private final List<PacManifestEntry> programROMs;
	
	private final List<PacManifestEntry> graphicROMs;
	
	private final List<PacManifestEntry> colorROMs;
	
	private final List<PacManifestEntry> paletteROMs;
	
	private final List<PacManifestEntry> soundROMs;
	
	private final List<PacManifestEntry> mysteryROMs;
	
	public final List<PacManifestEntry> getProgramROMs() {
		return this.programROMs;
	}
	
	public final List<PacManifestEntry> getGraphicROMs() {
		return this.graphicROMs;
	}
	
	public final List<PacManifestEntry> getColorROMs() {
		return this.colorROMs;
	}
	
	public final List<PacManifestEntry> getPaletteROMs() {
		return this.paletteROMs;
	}
	
	public final List<PacManifestEntry> getSoundROMs() {
		return this.soundROMs;
	}
	
	public final List<PacManifestEntry> getMysteryROMs() {
		return this.mysteryROMs;
	}
	
	/**
	 * Constructs an instance of the {@link PacManifest} class.
	 * 
	 * @since 1.0.0
	 * @author GarlicDude
	 */
	public PacManifest() {
		this.programROMs = new ArrayList<PacManifestEntry>();
		this.graphicROMs = new ArrayList<PacManifestEntry>();
		this.colorROMs = new ArrayList<PacManifestEntry>();
		this.paletteROMs = new ArrayList<PacManifestEntry>();
		this.soundROMs = new ArrayList<PacManifestEntry>();
		this.mysteryROMs = new ArrayList<PacManifestEntry>();
	}
}
