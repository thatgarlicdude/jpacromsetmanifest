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

import java.io.Closeable;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.Objects;

public final class PacROMSetManifestWriter implements Closeable {
	
	// TODO: Make Javadoc comments for the variables and methods.
	
	private final PacROMSetManifest pacROMSetManifest;
	
	private final OutputStream outputStream;
	
	public final void write() throws IOException {
		// Write the magic signature at the start of the file.
		writeMagic();
		// Then write the current version.
		writeVersion();
		// Write the entries an each ROM list in the manifest.
		writeROMList(pacROMSetManifest.getProgramROMList());
		// Close the file.
		close();
	}
	
	private final void writeMagic() throws IOException {
		// Write the magic signature to the beginning of the file.
		outputStream.write(PacROMSetManifest.MAGIC.getBytes());
	}
	
	private final void writeVersion() throws IOException {
		// Write the current version to the file.
		outputStream.write(PacROMSetManifest.getVersion());
	}
	
	private final void writeROMList(
			final List<PacROMSetManifestEntry> romList)
					throws IOException {
		// Get the size of the ROM list.
		final int size = romList.size();
		// Write the size of the manifest list first.
		outputStream.write(size);
		// Go through each of the entries in the ROM list.
		for (int index = 0; index < size; index++) {
			// Assign if there are more entries in the ROM list.
			final boolean isContinuous = index != size - 1;
			// Write the manifest entry.
			writeManifestEntry(romList.get(index), isContinuous);
		}
	}
	
	private final void writeManifestEntry(
			final PacROMSetManifestEntry entry,
			final boolean isContinuous) throws IOException {
		// Write the name of the manifest entry.
		writeName(entry.getName());
		// Initialize the metadata.
		int metadata = 0;
		metadata |= entry.getSize();
		metadata |= entry.isRequired() ?
				PacROMSetManifestEntry.REQUIRED_MASK : 0;
		metadata |= isContinuous ?
				PacROMSetManifestEntry.CONTINUOUS_MASK : 0;
		// Write the metadata in big-endian.
		for (int index = 8; index > -1; index = index - 8) {
			outputStream.write((metadata >> index) & 0xFF);
		}
	}
	
	private final void writeName(final String name)
			throws IOException {
		// Get the bytes from the manifest entry name.
		final byte[] nameBytes = name.getBytes();
		// Write the bytes onto the outputStream.
		outputStream.write(nameBytes);
		// Write the null terminator at the end.
		outputStream.write(0);
	}
	
	@Override
	public final void close() throws IOException {
		// Close the OutputStream.
		outputStream.close();
	}
	
	public PacROMSetManifestWriter(
			final PacROMSetManifest pacROMSetManifest,
			final OutputStream outputStream) {
		// Set up the variables that shouldn't be null.
		this.pacROMSetManifest =
				Objects.requireNonNull(pacROMSetManifest);
		this.outputStream =
				Objects.requireNonNull(outputStream);
	}
}
