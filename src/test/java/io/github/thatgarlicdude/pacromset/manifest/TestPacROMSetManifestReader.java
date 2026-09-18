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

import java.io.FileInputStream;
import java.io.IOException;

import static org.junit.Assert.*;
import org.junit.Test;

public final class TestPacROMSetManifestReader {
	
	@Test
	public final void testRead() throws IOException {
		// Initialize the file path.
		final String filePath = "./testRead1.pacromsetmanifest";
		// Get the absolute path to the testRead1.pacromsetmanifest file.
		final String testPath = TestPacROMSetManifestReader
				.class
				.getClassLoader()
				.getResource(filePath)
				.getFile();
		// Create the file input stream with the path.
		final FileInputStream fileInputStream =
				new FileInputStream(testPath);
		final PacROMSetManifestReader pacROMSetManifestReader =
				new PacROMSetManifestReader(fileInputStream);
		final PacROMSetManifest manifest =
				pacROMSetManifestReader.read();
	}
}
