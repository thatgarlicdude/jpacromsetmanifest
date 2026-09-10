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

// TODO: Elaborate more on the class description.

/**
 * A writer class that writes {@link PacROMSetManifest} classes to disk.
 * 
 * @since 1.0.0
 * @author GarlicDude
 */
public final class PacROMSetManifestWriter implements Closeable {
	
	// TODO: Make Javadoc comments for the variables and methods.
	
	private final PacROMSetManifest pacROMSetManifest;
	
	private final OutputStream outputStream;
	
	public final void write() throws IOException {
		// Write the magic signature at the start of the file.
		writeMagic();
		// TODO: Write the version number next to the magic signature.
		// Close the file.
		close();
	}
	
	/**
	 * Writes the magic signature to the <i>Pac-Man</i> ROM set manifest
	 * file.
	 * 
	 * <p>The magic signature is "PACROMSETMANIFEST".</p>
	 * 
	 * @throws IOException When writing the .pacromsetmanifest file fails.
	 * @since 1.0.0
	 * @author GarlicDude
	 * @see PacROMSetManifest#MAGIC
	 */
	private final void writeMagic() throws IOException {
		// Write the magic signature to the beginning of the file.
		outputStream.write(PacROMSetManifest.MAGIC.getBytes());
	}
	
	/**
	 * Closes the {@link #outputStream}.
	 * 
	 * @since 1.0.0
	 * @author GarlicDude
	 * @see #outputStream
	 */
	@Override
	public final void close() throws IOException {
		// Close the OutputStream.
		outputStream.close();
	}
	
	/**
	 * Constructs an instance of the {@link PacROMSetManifestWriter} class.
	 * 
	 * @param pacROMSetManifest The {@link PacROMSetManifest} instance
	 * required to write the .pacromsetmanifest file to disk.
	 * @param outputStream The {@code OutputStream} required to write the
	 * .pacromsetmanifest file to disk.
	 * @throws NullPointerException When {@code pacROMSetManifest} or
	 * {@code outputStream} are null.
	 * @since 1.0.0
	 * @author GarlicDude
	 */
	public PacROMSetManifestWriter(
			final PacROMSetManifest pacROMSetManifest,
			final OutputStream outputStream) {
		// Set up the variables that shouldn't be null.
		this.pacROMSetManifest = Objects.requireNonNull(pacROMSetManifest);
		this.outputStream = Objects.requireNonNull(outputStream);
	}
}
