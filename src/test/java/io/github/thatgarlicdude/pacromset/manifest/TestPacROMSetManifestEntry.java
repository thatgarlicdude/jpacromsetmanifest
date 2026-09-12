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
	
	private static final boolean TEST_REQUIRED = true;
	
	private static final int TEST_SIZE = 256;
	
	private final PacROMSetManifestEntry manifestEntry =
			new PacROMSetManifestEntry(
					TEST_NAME,
					TEST_REQUIRED,
					TEST_SIZE);
	
	@Test
	public final void testGetName() {
		// Get the name of the test PacROMSetManifestEntry instance.
		final String name = manifestEntry.getName();
		// Print the output.
		System.out.println("Test PacManifest entry name: " + name);
		// Assert whether the two name strings are the same.
		assertSame(name, TEST_NAME);
	}
	
	@Test
	public final void testIsRequired() {
		// Get the necessity of the test PacROMSetManifestEntry instance.
		final boolean required = manifestEntry.isRequired();
		// Print the output.
		System.out.println("Test PacManifest entry required: " + required);
		// Assert whether the two necessities are equal.
		assertEquals(required, TEST_REQUIRED);
	}
	
	@Test
	public final void testGetSize() {
		// Get the size of the test PacROMSetManifestEntry instance.
		final int size = manifestEntry.getSize();
		// Print the output.
		System.out.println("Test PacManifest entry size: " + size);
		// Assert whether the two sizes are equal.
		assertEquals(size, TEST_SIZE);
	}
}
