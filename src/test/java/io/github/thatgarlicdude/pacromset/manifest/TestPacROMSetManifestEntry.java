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

import static org.junit.Assert.*;
import org.junit.Test;

public final class TestPacROMSetManifestEntry {
	
	private static final String TEST_NAME = "testEntry";
	
	private static final int TEST_SIZE = 256;
	
	private final PacROMSetManifestEntry manifestEntry =
			new PacROMSetManifestEntry(TEST_NAME, TEST_SIZE);
	
	@Test
	public final void testGetMaxSize() {
		// Get the max size of the PacROMSetManifestEntry class.
		final int maxSize = PacROMSetManifestEntry.getMaxSize();
		// Print the output.
		System.out.println("Manifest entry max size: " + maxSize);
		// Assert whether the two values are equal.
		assertEquals(maxSize, PacROMSetManifestEntry.MAX_SIZE);
	}
	
	@Test
	public final void testGetMinSize() {
		// Get the min size of the PacROMSetManifestEntry class.
		final int minSize = PacROMSetManifestEntry.getMinSize();
		// Print the output.
		System.out.println("Manifest entry min size: " + minSize);
		// Assert whether the two values are equal.
		assertEquals(minSize, PacROMSetManifestEntry.MIN_SIZE);
	}
	
	@Test
	public final void testGetName() {
		// Get the name of the test PacROMSetManifestEntry instance.
		final String name = manifestEntry.getName();
		// Print the output.
		System.out.println("Test manifest entry name: " + name);
		// Assert whether the two name strings are the same.
		assertSame(name, TEST_NAME);
	}
	
	@Test
	public final void testGetSize() {
		// Get the size of the test PacROMSetManifestEntry instance.
		final int size = manifestEntry.getSize();
		// Print the output.
		System.out.println("Test manifest entry size: " + size);
		// Assert whether the two sizes are equal.
		assertEquals(size, TEST_SIZE);
	}
	
	@Test
	public final void testWithName() {
		// Initialize the new name.
		final String newName = "testEntry2";
		// Create a PacROMSetManifestEntry instance with the new name.
		final PacROMSetManifestEntry newManifestEntry =
				manifestEntry.withName(newName);
		// Get the name from the new PacROMSetManifestEntry instance.
		final String name = newManifestEntry.getName();
		// Print the output.
		System.out.println("New manifest entry name: " + name);
		// Assert these values.
		assertNotNull(newManifestEntry);
		assertSame(name, newName);
	}
	
	@Test
	public final void testWithSize() {
		// Initialize the new size.
		final int newSize = 512;
		// Create a PacROMSetManifestEntry instance with the new size.
		final PacROMSetManifestEntry newManifestEntry =
				manifestEntry.withSize(newSize);
		// Get the size from the new PacROMSetManifestEntry instance.
		final int size = newManifestEntry.getSize();
		// Print the output.
		System.out.println("New manifest entry size: " + size);
		// Assert these values.
		assertNotNull(newManifestEntry);
		assertEquals(size, newSize);
	}
}
