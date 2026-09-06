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

// TODO: Maybe give the description of this class an upgrade.

/**
 * A class that represents an entry in a PacManifest.
 * 
 * @since 1.0.0
 * @author GarlicDude
 */
public final class PacROMSetManifestEntry {
	
	/**
	 * The maximum file size for a PacManifest entry, which is a maximum
	 * value of a 16-bit number (65,535).
	 * 
	 * @since 1.0.0
	 * @author GarlicDude
	 */
	public static final int MAX_SIZE = 0xFFFF;
	
	/**
	 * The minimum file size for a PacManifest entry, which is zero.
	 * 
	 * @since 1.0.0
	 * @author GarlicDude
	 */
	public static final int MIN_SIZE = 0;
	
	// TODO: Perhaps reword that.
	
	/**
	 * The filename of the PacManifest entry.
	 * 
	 * @since 1.0.0
	 * @author GarlicDude
	 * @see #getFilename()
	 */
	private final String filename;
	
	/**
	 * The file size of the PacManifest entry.
	 * 
	 * @since 1.0.0
	 * @author GarlicDude
	 * @see #getSize()
	 */
	private final int size;
	
	/**
	 * Gets the instance's {@link #filename}, which is the name of the
	 * PacManifest entry.
	 * 
	 * @return A {@code String} that is the PacManifest entry's filename.
	 * @since 1.0.0
	 * @author GarlicDude
	 * @see #filename
	 */
	public final String getFilename() {
		return this.filename;
	}
	
	/**
	 * Gets the instance's {@link #size}, which is the file size of the
	 * PacManifest entry.
	 * 
	 * @return An {@code int} that is the PacManifest entry's file size.
	 * @since 1.0.0
	 * @author GarlicDude
	 * @see #size
	 */
	public final int getSize() {
		return this.size;
	}
	
	/**
	 * Constructs an instance of the {@link PacROMSetManifestEntry} class.
	 * 
	 * @param size The file size of the PacManifest entry.
	 * @param filename The filename of the PacManifest entry.
	 * @throws IllegalArgumentException When the {@code size} is out of
	 * its expected range (0 - 65,535).
	 * @since 1.0.0
	 * @author GarlicDude
	 */
	public PacROMSetManifestEntry(final String filename, final int size) {
		// Throw an error if the size is out of range.
		if (size < MIN_SIZE || size > MAX_SIZE) {
			throw new IllegalArgumentException(
					"PacManifestEntry size is out of range.");
		}
		// Set the variables in the instance.
		this.filename = filename;
		this.size = size;
	}
}
