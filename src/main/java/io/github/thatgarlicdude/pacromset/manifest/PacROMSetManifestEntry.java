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

/**
 * A class that represents an entry in a <i>Pac-Man</i> ROM set manifest.
 * 
 * <p>This class behaves as an entry class to the {@link
 * PacROMSetManifest} class, containing only the expected {@link #name}
 * found in a <i>Pac-Man</i> ROM set, as well as its {@link #size}. This
 * is used to tell what ROMs to expect in a <i>Pac-Man</i> ROM set when it
 * comes to reading and writing on disk, as well as compiling and
 * decompiling the ROM set.</p>
 * 
 * <p>Here's what an {@link PacROMSetManifestEntry} instance looks
 * like:</p>
 * 
 * <p><b><i>Pac-Man</i> ROM Set Manifest Entry:</b></p>
 * <ul>
 * 	<li>Name</li>
 * 	<li>Size</li>
 * </ul>
 * 
 * <p><b>COPYRIGHT DISCLAIMER:</b> This class does not contain or
 * distribute any ROM data. <i>Pac-Man</i> is a copyright and trademark of
 * Bandai Namco.</p>
 * 
 * @since 1.0.0
 * @author GarlicDude
 * @see PacROMSetManifest
 */
public final class PacROMSetManifestEntry {
	
	/**
	 * The error message used when the {@code size} parameter in {@link
	 * #PacROMSetManifestEntry(String, int)} is out of its expected range.
	 * 
	 * @since 1.0.0
	 * @author GarlicDude
	 * @see #PacROMSetManifestEntry(String, int)
	 */
	private static final String ERROR_MESSAGE =
			"PacROMSetManifestEntry's size is out of range. It must be"
			+ "within 0 or 65,535.";
	
	/**
	 * The maximum size for an entry in a <i>Pac-Man</i> ROM set manifest,
	 * which is a maximum value of a 16-bit number (65,535).
	 * 
	 * <p>This variable is used to make sure the {@code size} parameter
	 * in the {@link #PacROMSetManifestEntry(String, int)} constructor
	 * stays within the expected bounds, and doesn't go past the maximum
	 * value.</p>
	 * 
	 * @since 1.0.0
	 * @author GarlicDude
	 * @see #MIN_SIZE
	 * @see #size
	 * @see #PacROMSetManifestEntry(String, int)
	 */
	public static final int MAX_SIZE = 0xFFFF;
	
	/**
	 * The minimum size for an entry in a <i>Pac-Man<i> ROM set manifest,
	 * which is 0.
	 * 
	 * <p>This variable is used to make sure the {@code size} parameter
	 * in the {@link #PacROMSetManifestEntry(String, int)} constructor
	 * stays within the expected bounds, and doesn't go below the minimum
	 * value.</p>
	 * 
	 * @since 1.0.0
	 * @author GarlicDude
	 * @see #MAX_SIZE
	 * @see #size
	 * @see #PacROMSetManifestEntry(String, int)
	 */
	public static final int MIN_SIZE = 0;
	
	// TODO: Add more to these variables.
	
	/**
	 * The name of the entry in a <i>Pac-Man</i> ROM set manifest.
	 * 
	 * @since 1.0.0
	 * @author GarlicDude
	 * @see #getName()
	 */
	private final String name;
	
	/**
	 * The size of the entry in a <i>Pac-Man</i> ROM set manifest.
	 * 
	 * @since 1.0.0
	 * @author GarlicDude
	 * @see #getSize()
	 */
	private final int size;
	
	/**
	 * Gets the instance's {@link #name}, which is the name of the entry
	 * in a <i>Pac-Man</i> ROM set manifest.
	 * 
	 * @return A {@code String} that is the entry's name.
	 * @since 1.0.0
	 * @author GarlicDude
	 * @see #name
	 */
	public final String getName() {
		// Return the name of the manifest entry.
		return this.name;
	}
	
	/**
	 * Gets the instance's {@link #size}, which is the size of the entry
	 * in a <i>Pac-Man</i> ROM set manifest.
	 * 
	 * @return An {@code int} that is the entry's size.
	 * @since 1.0.0
	 * @author GarlicDude
	 * @see #size
	 */
	public final int getSize() {
		// Return the size of the manifest entry.
		return this.size;
	}
	
	/**
	 * Constructs an instance of the {@link PacROMSetManifestEntry} class.
	 * 
	 * @param name The name of the entry in a <i>Pac-Man</i> ROM set
	 * manifest.
	 * @param size The size of the entry in a <i>Pac-Man</i> ROM set
	 * manifest.
	 * @throws IllegalArgumentException When the {@code size} is out of
	 * its expected range (0 - 65,535).
	 * @since 1.0.0
	 * @author GarlicDude
	 */
	public PacROMSetManifestEntry(final String name, final int size) {
		// Throw an error if the size is out of range.
		if (size < MIN_SIZE || size > MAX_SIZE) {
			throw new IllegalArgumentException(ERROR_MESSAGE);
		}
		// Set the variables in the instance.
		this.name = name;
		this.size = size;
	}
}
