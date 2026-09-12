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
		// TODO: Write the contents to the file.
		// Close the file.
		close();
	}
	
	private final void writeMagic() throws IOException {
		// Write the magic signature to the beginning of the file.
		outputStream.write(PacROMSetManifest.MAGIC.getBytes());
	}
	
	private final void writeVersion() throws IOException {
		// Write the current version to the file.
		outputStream.write(pacROMSetManifest.getVersion());
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
		this.pacROMSetManifest = Objects.requireNonNull(pacROMSetManifest);
		this.outputStream = Objects.requireNonNull(outputStream);
	}
}
