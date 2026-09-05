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

import static org.junit.Assert.*;
import org.junit.Test;

import io.github.thatgarlicdude.pacrommanifest.PacManifestEntry;

/**
 * A test class for the {@link PacManifestEntry} class.
 * 
 * @since 1.0.0
 * @author GarlicDude
 * @see PacManifestEntry
 */
public final class TestPacManifestEntry {
	
	// TODO: Reword the descriptions for both TEST_SIZE and TEST_NAME.
	
	/**
	 * The set name for the {@link #pacManifestEntry}, a test {@link
	 * PacManifestEntry} instance.
	 * 
	 * @since 1.0.0
	 * @author GarlicDude
	 * @see #pacManifestEntry
	 * @see PacManifestEntry
	 */
	private static final String TEST_NAME = "testEntry";
	
	/**
	 * The set size for the {@link #pacManifestEntry}, a test {@link
	 * PacManifestEntry} instance.
	 * 
	 * @since 1.0.0
	 * @author GarlicDude
	 * @see #pacManifestEntry
	 * @see PacManifestEntry
	 */
	private static final int TEST_SIZE = 256;
	
	/**
	 * The {@link PacManifestEntry} instance used for testing purposes.
	 * 
	 * @since 1.0.0
	 * @author GarlicDude
	 * @see #TEST_NAME
	 * @see #TEST_SIZE
	 * @see #testGetFilename()
	 * @see #testGetSize()
	 */
	private final PacManifestEntry pacManifestEntry =
			new PacManifestEntry(TEST_NAME, TEST_SIZE);
	
	
	/**
	 * A test method for the {@link PacManifestEntry#getFilename()}
	 * method.
	 * 
	 * @since 1.0.0
	 * @author GarlicDude
	 * @see PacManifestEntry#getFilename()
	 */
	@Test
	public final void testGetFilename() {
		// Get the filename of the test PacManifestEntry instance.
		final String filename = pacManifestEntry.getFilename();
		// Print the output.
		System.out.println("Test PacManifest entry name: " + filename);
		// Assert whether the two filename strings are the same.
		assertSame(filename, TEST_NAME);
	}
	
	/**
	 * A test method for the {@link PacManifestEntry#getSize()} method.
	 * 
	 * @since 1.0.0
	 * @author GarlicDude
	 * @see PacManifestEntry#getSize()
	 */
	@Test
	public final void testGetSize() {
		// Get the size of the test PacManifestEntry instance.
		final int size = pacManifestEntry.getSize();
		// Print the output.
		System.out.println("Test PacManifest entry size: " + size);
		// Assert whether the two sizes are equal.
		assertEquals(size, TEST_SIZE);
	}
}
