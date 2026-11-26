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
	
	public static final void check(final PacROMSetManifestEntry entry) {
		final String name = entry.getName();
		final int size = entry.getSize();
		System.out.println("Manifest entry name: " + name);
		System.out.println("Manifest entry size: " + size);
		assertNotNull(name);
		assertTrue(
				size >= PacROMSetManifestEntry.MIN_SIZE ||
				size <= PacROMSetManifestEntry.MAX_SIZE);
	}
	
	@Test
	public final void testGetMaxSize() {
		final int maxSize = PacROMSetManifestEntry.getMaxSize();
		System.out.println("Manifest entry max size: " + maxSize);
		assertEquals(maxSize, PacROMSetManifestEntry.MAX_SIZE);
	}
	
	@Test
	public final void testGetMinSize() {
		final int minSize = PacROMSetManifestEntry.getMinSize();
		System.out.println("Manifest entry min size: " + minSize);
		assertEquals(minSize, PacROMSetManifestEntry.MIN_SIZE);
	}
	
	@Test
	public final void testGetName() {
		final String name = manifestEntry.getName();
		System.out.println("Test manifest entry name: " + name);
		assertSame(name, TEST_NAME);
	}
	
	@Test
	public final void testGetSize() {
		final int size = manifestEntry.getSize();
		System.out.println("Test manifest entry size: " + size);
		assertEquals(size, TEST_SIZE);
	}
	
	@Test
	public final void testWithName() {
		final String newName = "testEntry2";
		final PacROMSetManifestEntry newManifestEntry =
				manifestEntry.withName(newName);
		final String name = newManifestEntry.getName();
		System.out.println("New manifest entry name: " + name);
		assertNotNull(newManifestEntry);
		assertSame(name, newName);
	}
	
	@Test
	public final void testWithSize() {
		final int newSize = 512;
		final PacROMSetManifestEntry newManifestEntry =
				manifestEntry.withSize(newSize);
		final int size = newManifestEntry.getSize();
		System.out.println("New manifest entry size: " + size);
		assertNotNull(newManifestEntry);
		assertEquals(size, newSize);
	}
}
