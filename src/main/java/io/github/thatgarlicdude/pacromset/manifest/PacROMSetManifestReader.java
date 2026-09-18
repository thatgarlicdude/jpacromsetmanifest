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

import java.io.ByteArrayOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public final class PacROMSetManifestReader {
	
	private final InputStream inputStream;
	
	public PacROMSetManifestReader(
			final InputStream inputStream) {
		// Set up the input stream if it's not null.
		this.inputStream = Objects.requireNonNull(inputStream);
	}
	
	public final PacROMSetManifest read() throws IOException {
		// Check the magic signature from the file first.
		checkMagic();
		// Then check the version of the manifest file.
		checkVersion();
		// Read the program list in the manifest file.
		final List<PacROMSetManifestEntry> programList =
				readManifestList();
		// Read the graphic list in the manifest file.
		final List<PacROMSetManifestEntry> graphicList =
				readManifestList();
		// Read the color list in the manifest file.
		final List<PacROMSetManifestEntry> colorList =
				readManifestList();
		// Read the palette list in the manifest file.
		final List<PacROMSetManifestEntry> paletteList =
				readManifestList();
		// Read the sound list in the manifest file.
		final List<PacROMSetManifestEntry> soundList =
				readManifestList();
		// Read the mystery list in the manifest file.
		final List<PacROMSetManifestEntry> mysteryList =
				readManifestList();
		// Return the loaded manifest.
		return new PacROMSetManifest(
				programList,
				graphicList,
				colorList,
				paletteList,
				soundList,
				mysteryList);
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
	
	private final void checkVersion() throws IOException {
		// Read the version of the manifest file.
		final int version = inputStream.read();
		// Make sure there's a version number in the file.
		if (version == -1) {
			// Throw an error if there isn't a version number.
			throw new EOFException("PacROMSetManifest version not found");
		}
		// Make sure the manifest file is on a correct version.
		if (version != PacROMSetManifest.VERSION) {
			throw new IOException("Invalid PacROMSetManifest version");
		}
	}
	
	private final List<PacROMSetManifestEntry> readManifestList()
			throws IOException {
		// Initialize the manifest list first.
		final List<PacROMSetManifestEntry> manifestList =
				new ArrayList<PacROMSetManifestEntry>();
		// Read the size of the manifest list.
		final int size = inputStream.read();
		// Make sure there's a size variable in the manifest list.
		if (size == -1) {
			throw new EOFException("Manifest list size not found");
		}
		// Go through each of the manifest entries in the list.
		for (int index = 0; index < size; index++) {
			// Read the manifest entry, and add it to the list.
			final PacROMSetManifestEntry manifestEntry =
					readManifestEntry();
			manifestList.add(manifestEntry);
		}
		// Return the loaded manifest list.
		return manifestList;
	}
	
	private final PacROMSetManifestEntry readManifestEntry()
			throws IOException {
		// Read the name from the file first.
		final String name = readName();
		// Then the size.
		final int size = readSize();
		// Return a new manifest entry with the loaded name and size.
		return new PacROMSetManifestEntry(name, size);
	}
	
	private final String readName() throws IOException {
		// Initialize the byte array output stream.
		final ByteArrayOutputStream bytes = new ByteArrayOutputStream();
		// Initialize the current byte.
		int readByte = 0;
		// Read the bytes until it hits the name terminator.
		while ((readByte = inputStream.read()) !=
				PacROMSetManifestEntry.NAME_TERMINATOR) {
			// Make sure the file doesn't end midway through.
			if (readByte == -1) {
				// Throw an error if it does.
				throw new EOFException("Incomplete manifest entry name");
			}
			// Write the read byte onto the byte array output stream.
			bytes.write(readByte);
		}
		// Return the byte array as a string.
		return new String(bytes.toByteArray());
	}
	
	private final int readSize() throws IOException {
		// Initialize the size.
		int size = 0;
		// Read the manifest entry's size in big-endian.
		for (int index = 8; index > -1; index = index - 8) {
			// Read the current size byte.
			final int sizeByte = inputStream.read();
			// Make sure the file doesn't end midway through.
			if (sizeByte == -1) {
				// Throw an error if it does.
				throw new EOFException("Incomplete manifest entry size");
			}
			// Put the sizeByte in its respective position.
			size |= sizeByte << index;
		}
		// Return the size.
		return size;
	}
}
