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

import java.util.Objects;

/**
 * A class that represents an entry in a <i>Pac-Man</i> ROM set manifest.
 * 
 * <p>These can be found in a list object inside of a
 * {@link PacROMSetManifest} instance. An entry in a <i>Pac-Man</i> ROM
 * set manifest only contains the expected <b>name</b> and <b>size</b>
 * found in a <i>Pac-Man</i> ROM set. They do not contain ROM data
 * whatsoever, as it is material protected by copyright. In addition to
 * this, the class itself is <b>immutable</b>, meaning that its fields
 * cannot be changed by any means. If the class wants to have its
 * fields altered, it can create a new instance using a changed
 * variable by calling its <b>with</b> methods.</p>
 * 
 * @since 1.0.0
 * @author GarlicDude
 * @see PacROMSetManifest
 */
public final class PacROMSetManifestEntry {
	
	/**
	 * The the maximum size of a manifest entry.
	 * 
	 * <p>This field is used to ensure that, when a manifest entry is
	 * being constructed via {@link #PacROMSetManifestEntry(String, int)},
	 * the size parameter doesn't go out of bounds. It is also done
	 * because of the limitations when reading and writing <i>Pac-Man</i>
	 * ROM set manifest files from disk.</p>
	 * 
	 * @since 1.0.0
	 * @author GarlicDude
	 * @see #getMaxSize()
	 */
	public static final int MAX_SIZE = 0xFFFF;
	
	/**
	 * The the minimum size of a manifest entry.
	 * 
	 * <p>This field is used to ensure that, when a manifest entry is
	 * being constructed via {@link #PacROMSetManifestEntry(String, int)},
	 * the size parameter doesn't go out of bounds. It is also done
	 * because of the limitations when reading and writing <i>Pac-Man</i>
	 * ROM set manifest files from disk.</p>
	 * 
	 * @since 1.0.0
	 * @author GarlicDude
	 * @see #getMinSize()
	 */
	public static final int MIN_SIZE = 0x0000;
	
	/**
	 * The number that represents a terminator for a manifest entry's
	 * name.
	 * 
	 * <p>This field is used by the IO classes, {@link
	 * PacROMSetManifestReader} and {@link PacROMSetManifestWriter}. When
	 * a <i>Pac-Man</i> ROM set manifest is being written as a file to
	 * disk, this number will be written as a byte at the end of a name in
	 * a manifest entry. When the file is being read, the number is used
	 * to indicate the ending point of an entry name and proceed with
	 * other data in the file.</p>
	 * 
	 * @since 1.0.0
	 * @author GarlicDude
	 * @see #getNameTerminator()
	 */
	public static final int NAME_TERMINATOR = 0xFF;
	
	/**
	 * The <b>name</b> of the manifest entry.
	 * 
	 * @since 1.0.0
	 * @author GarlicDude
	 * @see #getName()
	 */
	private final String name;
	
	/**
	 * The <b>size</b> of the manifest entry.
	 * 
	 * @since 1.0.0
	 * @author GarlicDude
	 * @see #getSize()
	 */
	private final int size;
	
	/**
	 * Constructs an instance of the {@link PacROMSetManifestEntry} class.
	 * 
	 * <p>When constructing an instance of this class, the {@code name}
	 * cannot be null. In addition, the {@code size} must be within the
	 * range of {@value #MIN_SIZE} and {@value #MAX_SIZE}. If these
	 * parameters don't meet the requirements, it will throw an error
	 * saying that the name is null or the size is out of range.</p>
	 * 
	 * @param name The name of the manifest entry.
	 * @param size The size of the manifest entry.
	 * @throws NullPointerException When the name is null.
	 * @throws IllegalArgumentException When the size is out of range.
	 * @since 1.0.0
	 * @author GarlicDude
	 */
	public PacROMSetManifestEntry(
			final String name,
			final int size) {
		// Throw an error if the size is out of range.
		if (size < MIN_SIZE || size > MAX_SIZE) {
			throw new IllegalArgumentException(
					"The manifest entry's size is out of range."
					+"It must be within " + MIN_SIZE + " or " + MAX_SIZE
					+ ".");
		}
		// Set the variables in the instance.
		this.name = Objects.requireNonNull(
				name,
				"The manifest entry's name cannot be null.");
		this.size = size;
	}
	
	/**
	 * Gets {@link #MAX_SIZE}, which is the maximum size of a manifest
	 * entry.
	 * 
	 * @return An {@code int} that is {@value #MAX_SIZE}.
	 * @since 1.0.0
	 * @author GarlicDude
	 * @see #MAX_SIZE
	 */
	public static final int getMaxSize() {
		// Return the maximum size of a manifest entry.
		return MAX_SIZE;
	}
	
	/**
	 * Gets {@link #MIN_SIZE}, which is the minimum size of a manifest
	 * entry.
	 * 
	 * @return An {@code int} that is {@value #MIN_SIZE}.
	 * @since 1.0.0
	 * @author GarlicDude
	 * @see #MIN_SIZE
	 */
	public static final int getMinSize() {
		// Return the minimum size of a manifest entry.
		return MIN_SIZE;
	}
	
	/**
	 * Gets {@link #NAME_TERMINATOR}, which is the terminator used for
	 * a manifest entry's name.
	 * 
	 * @return An {@code int} that is {@value #NAME_TERMINATOR}.
	 * @since 1.0.0
	 * @author GarlicDude
	 * @see #NAME_TERMINATOR
	 */
	public static final int getNameTerminator() {
		// Return the terminator for a manifest entry's name.
		return NAME_TERMINATOR;
	}
	
	// TODO: Finish up the documentation of the methods.
	
	public final String getName() {
		// Return the name of the manifest entry.
		return this.name;
	}
	
	public final int getSize() {
		// Return the size of the manifest entry.
		return this.size;
	}
	
	public final PacROMSetManifestEntry withName(final String name) {
		// Return a new manifest entry with the new name.
		return new PacROMSetManifestEntry(name, this.size);
	}
	
	public final PacROMSetManifestEntry withSize(final int size) {
		// Return a new manifest entry with the new name.
		return new PacROMSetManifestEntry(this.name, size);
	}
}
