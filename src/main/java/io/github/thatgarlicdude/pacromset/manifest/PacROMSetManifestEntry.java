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

public final class PacROMSetManifestEntry {
	
	private static final String ERROR_MESSAGE =
			"PacROMSetManifestEntry's size is out of range. It must be"
			+ "within 0 or 65,534.";
	
	public static final int MAX_SIZE = 0xFFFE;
	
	public static final int MIN_SIZE = 0;
	
	private final String name;
	
	private final int size;
	
	private final boolean required;
	
	public final String getName() {
		// Return the name of the manifest entry.
		return this.name;
	}
	
	public final int getSize() {
		// Return the size of the manifest entry.
		return this.size;
	}
	
	public final boolean isRequired() {
		// Return the necessity of the manifest entry.
		return this.required;
	}
	
	public PacROMSetManifestEntry(
			final String name,
			final int size,
			final boolean required) {
		// Throw an error if the size is out of range.
		if (size < MIN_SIZE || size > MAX_SIZE) {
			throw new IllegalArgumentException(ERROR_MESSAGE);
		}
		// Set the variables in the instance.
		this.name = Objects.requireNonNull(name);
		this.size = size;
		this.required = required;
	}
}
