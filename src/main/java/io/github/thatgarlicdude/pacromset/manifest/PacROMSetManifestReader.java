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

import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;

public final class PacROMSetManifestReader {
	
	private final InputStream inputStream;
	
	public PacROMSetManifestReader(
			final InputStream inputStream) {
		// Set up the input stream if it's not null.
		this.inputStream = Objects.requireNonNull(inputStream);
	}
	
	public final PacROMSetManifest read() throws IOException {
		// Create the manifest to memory.
		final PacROMSetManifest manifest = null;
		// Check the magic signature from the file first.
		checkMagic();
		// Return the loaded manifest.
		return manifest;
	}
	
	private final void checkMagic() throws IOException {
		// Initialize the variables regarding the magic signature.
		final String originalMagic = PacROMSetManifest.MAGIC;
		final byte[] originalMagicBytes = originalMagic.getBytes();
		final int originalMagicSize = originalMagicBytes.length;
		// Go through each of the bytes in the original magic signature.
		for (int index = 0; index < originalMagicSize; index++) {
			System.out.println("Magic index #" + index + ": "
					+ (char) originalMagicBytes[index]);
		}
	}
}
