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

/**
 * A utility class for the {@link PacROMSetManifest} class.
 * 
 * @since 1.0.0
 * @author GarlicDude
 * @see PacROMSetManifest
 */
public final class PacROMSetManifests {
	
	/**
	 * A private constructor. The class cannot be constructed by any
	 * means.
	 * 
	 * @throws UnsupportedOperationException When the constructor has
	 * been called.
	 * @since 1.0.0
	 * @author GarlicDude
	 */
	private PacROMSetManifests() {
		throw new UnsupportedOperationException();
	}
	
	/**
	 * Creates a new {@link PacROMSetManifest} automatically without
	 * needing to assign its lists manually.
	 * 
	 * @return A new {@link PacROMSetManifest} instance with its
	 * automatically created lists.
	 * @since 1.0.0
	 * @author GarlicDude
	 */
	public static final PacROMSetManifest create() {
		return new PacROMSetManifest(
				new ArrayList<PacROMSetManifestEntry>(),
				new ArrayList<PacROMSetManifestEntry>(),
				new ArrayList<PacROMSetManifestEntry>(),
				new ArrayList<PacROMSetManifestEntry>(),
				new ArrayList<PacROMSetManifestEntry>(),
				new ArrayList<PacROMSetManifestEntry>());
	}
	
	/**
	 * Saves a {@link PacROMSetManifest} object as a
	 * <b>.pacromsetmanifest</b> file using a file path as a {@code
	 * String}.
	 * 
	 * @param manifest The {@link PacROMSetManifest} required to save
	 * the manifest file.
	 * @param path The file path to write the manifest.
	 * @throws IOException The file path to write the manifest.
	 * @since 1.0.0
	 * @author GarlicDude
	 * @see #save(PacROMSetManifest, Path)
	 */
	public static final void save(
			final PacROMSetManifest manifest,
			final String path) throws IOException {
		final FileOutputStream fos = new FileOutputStream(path);
		final PacROMSetManifestWriter writer =
				new PacROMSetManifestWriter(manifest, fos);
		writer.write();
		writer.close();
	}
	
	/**
	 * Saves a {@link PacROMSetManifest} object as a
	 * <b>.pacromsetmanifest</b> file using a file path as a {@code Path}.
	 * 
	 * @param manifest The {@link PacROMSetManifest} required to save
	 * the manifest file.
	 * @param path The file path to write the manifest.
	 * @throws IOException The file path to write the manifest.
	 * @since 1.0.0
	 * @author GarlicDude
	 * @see #save(PacROMSetManifest, String)
	 */
	public static final void save(
			final PacROMSetManifest manifest,
			final Path path) throws IOException {
		final OutputStream os = Files.newOutputStream(path);
		final PacROMSetManifestWriter writer =
				new PacROMSetManifestWriter(manifest, os);
		writer.write();
		writer.close();
	}
	
	/**
	 * Loads a {@link PacROMSetManifest} object from a
	 * <b>.pacromsetmanifest</b> file using a {@code String} as the file
	 * path.
	 * 
	 * @param path The file path to read the manifest.
	 * @return A {@link PacROMSetManifest} loaded from disk.
	 * @throws IOException When reading the manifest file fails.
	 * @since 1.0.0
	 * @author GarlicDude
	 * @see #load(Path)
	 */
	public static final PacROMSetManifest load(final String path)
			throws IOException {
		final FileInputStream fis = new FileInputStream(path);
		final PacROMSetManifestReader reader =
				new PacROMSetManifestReader(fis);
		final PacROMSetManifest manifest = reader.read();
		reader.close();
		return manifest;
	}
	
	/**
	 * Loads a {@link PacROMSetManifest} object from a
	 * <b>.pacromsetmanifest</b> file using a {@code Path} as the file
	 * path.
	 * 
	 * @param path The file path to read the manifest.
	 * @return A {@link PacROMSetManifest} loaded from disk.
	 * @throws IOException When reading the manifest file fails.
	 * @since 1.0.0
	 * @author GarlicDude
	 * @see #load(String)
	 */
	public static final PacROMSetManifest load(final Path path)
			throws IOException {
		final InputStream is = Files.newInputStream(path);
		final PacROMSetManifestReader reader =
				new PacROMSetManifestReader(is);
		final PacROMSetManifest manifest = reader.read();
		reader.close();
		return manifest;
	}
}
