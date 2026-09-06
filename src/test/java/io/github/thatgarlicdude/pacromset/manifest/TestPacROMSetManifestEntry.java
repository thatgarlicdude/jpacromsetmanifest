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

/**
 * A test class for the {@link PacROMSetManifestEntry} class.
 * 
 * @since 1.0.0
 * @author GarlicDude
 * @see PacROMSetManifestEntry
 */
public final class TestPacROMSetManifestEntry {
	
	/**
	 * The set name for the {@link #manifestEntry}, a test {@link
	 * PacROMSetManifestEntry} instance.
	 * 
	 * <p>This variable is used as an assertion in the {@link
	 * #testGetName()} method.</p>
	 * 
	 * @since 1.0.0
	 * @author GarlicDude
	 * @see #manifestEntry
	 * @see #testGetName()
	 * @see PacROMSetManifestEntry
	 */
	private static final String TEST_NAME = "testEntry";
	
	/**
	 * The set size for the {@link #manifestEntry}, a test {@link
	 * PacROMSetManifestEntry} instance.
	 * 
	 * <p>This variable is used as an assertion in the {@link
	 * #testGetSize()} method.</p>
	 * 
	 * @since 1.0.0
	 * @author GarlicDude
	 * @see #manifestEntry
	 * @see #testGetSize()
	 * @see PacROMSetManifestEntry
	 */
	private static final int TEST_SIZE = 256;
	
	/**
	 * The {@link PacROMSetManifestEntry} instance used for testing
	 * purposes.
	 * 
	 * @since 1.0.0
	 * @author GarlicDude
	 * @see #TEST_NAME
	 * @see #TEST_SIZE
	 * @see #testGetName()
	 * @see #testGetSize()
	 */
	private final PacROMSetManifestEntry manifestEntry =
			new PacROMSetManifestEntry(TEST_NAME, TEST_SIZE);
	
	
	/**
	 * A test method for the {@link PacROMSetManifestEntry#getName()}
	 * method.
	 * 
	 * @since 1.0.0
	 * @author GarlicDude
	 * @see PacROMSetManifestEntry#getName()
	 */
	@Test
	public final void testGetName() {
		// Get the name of the test PacROMSetManifestEntry instance.
		final String name = manifestEntry.getName();
		// Print the output.
		System.out.println("Test PacManifest entry name: " + name);
		// Assert whether the two name strings are the same.
		assertSame(name, TEST_NAME);
	}
	
	/**
	 * A test method for the {@link PacROMSetManifestEntry#getSize()}
	 * method.
	 * 
	 * @since 1.0.0
	 * @author GarlicDude
	 * @see PacROMSetManifestEntry#getSize()
	 */
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
