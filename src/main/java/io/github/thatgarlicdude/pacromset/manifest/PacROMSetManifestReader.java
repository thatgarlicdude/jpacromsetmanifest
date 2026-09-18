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

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
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
		// Get the bytes from the base magic signature.
		final byte[] magicBytes1 = PacROMSetManifest.MAGIC.getBytes();
		// Create another byte array with the signature's length.
		final byte[] magicBytes2 = new byte[magicBytes1.length];
		// Read the magic signature in the file.
		final int bytesRead = inputStream.read(magicBytes2);
		// Make sure the amount of bytes read are correct.
		if (bytesRead != magicBytes2.length) {
			// Throw an error if the magic signature is incomplete.
			throw new EOFException(
					"Incomplete PacROMSetManifest signature");
		}
		// Make sure the magic signatures match.
		if (!Arrays.equals(magicBytes1, magicBytes2)) {
			// Throw an error if the magic signatures don't match.
			throw new IOException("Invalid PacROMSetManifest signature");
		}
	}
}
