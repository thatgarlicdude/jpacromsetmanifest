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
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.UnsupportedOperationException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public final class PacROMSetManifests {
	
	public static final PacROMSetManifest create() {
		// Initialize the program ROM list.
		final List<PacROMSetManifestEntry> programROMList =
				new ArrayList<PacROMSetManifestEntry>();
		// Initialize the graphic ROM list.
		final List<PacROMSetManifestEntry> graphicROMList =
				new ArrayList<PacROMSetManifestEntry>();
		// Initialize the color ROM list.
		final List<PacROMSetManifestEntry> colorROMList =
				new ArrayList<PacROMSetManifestEntry>();
		// Initialize the palette ROM list.
		final List<PacROMSetManifestEntry> paletteROMList =
				new ArrayList<PacROMSetManifestEntry>();
		// Initialize the sound ROM list.
		final List<PacROMSetManifestEntry> soundROMList =
				new ArrayList<PacROMSetManifestEntry>();
		// Initialize the mystery ROM list.
		final List<PacROMSetManifestEntry> mysteryROMList =
				new ArrayList<PacROMSetManifestEntry>();
		// Return the newly created PacROMSetManifest instance.
		return new PacROMSetManifest(
				programROMList,
				graphicROMList,
				colorROMList,
				paletteROMList,
				soundROMList,
				mysteryROMList);
	}
	
	public static final void save(
			final PacROMSetManifest manifest,
			final String path) throws IOException {
		// Initialize the file output stream.
		final FileOutputStream fos = new FileOutputStream(path);
		// Initialize the manifest writer.
		final PacROMSetManifestWriter writer =
				new PacROMSetManifestWriter(manifest, fos);
		// Simply write the file to disk.
		writer.write();
		// Close the writer.
		writer.close();
	}
	
	public static final void save(
			final PacROMSetManifest manifest,
			final Path path) throws IOException {
		// Initialize the output stream with the file path.
		final OutputStream os = Files.newOutputStream(path);
		// Initialize the manifest writer.
		final PacROMSetManifestWriter writer =
				new PacROMSetManifestWriter(manifest, os);
		// Simply write the file to disk.
		writer.write();
		// Close the writer.
		writer.close();
	}
	
	public static final PacROMSetManifest load(final String path)
			throws IOException {
		// Initialize the file input stream.
		final FileInputStream fis = new FileInputStream(path);
		// Initialize the manifest reader.
		final PacROMSetManifestReader reader =
				new PacROMSetManifestReader(fis);
		// Simply read the file from disk.
		final PacROMSetManifest manifest = reader.read();
		// Close the reader.
		reader.close();
		// Return the newly loaded manifest.
		return manifest;
	}
	
	public static final PacROMSetManifest load(final Path path)
			throws IOException {
		// Initialize the input stream with the file path.
		final InputStream is = Files.newInputStream(path);
		// Initialize the manifest reader.
		final PacROMSetManifestReader reader =
				new PacROMSetManifestReader(is);
		// Simply read the file from disk.
		final PacROMSetManifest manifest = reader.read();
		// Close the reader.
		reader.close();
		// Return the newly loaded manifest.
		return manifest;
	}
	
	private PacROMSetManifests() {
		// Throw the error in case the constructor was actually called.
		throw new UnsupportedOperationException();
	}
}
