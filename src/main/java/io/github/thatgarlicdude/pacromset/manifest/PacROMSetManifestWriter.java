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

/**
 * A class that writes <b>.pacromsetmanifest</b> files to disk.
 * 
 * @since 1.0.0
 * @author GarlicDude
 * @see PacROMSetManifest
 * @see PacROMSetManifestReader
 */
public final class PacROMSetManifestWriter implements Closeable {
	
	/**
	 * The manifest instance required to write the <i>Pac-Man</i> ROM set
	 * manifest file.
	 * 
	 * @since 1.0.0
	 * @author GarlicDude
	 */
	private final PacROMSetManifest manifest;
	
	/**
	 * The output stream required to write the <i>Pac-Man</i> ROM set
	 * manifest file.
	 * 
	 * @since 1.0.0
	 * @author GarlicDude
	 */
	private final OutputStream outputStream;
	
	/**
	 * Constructs an instance of the {@link PacROMSetManifestWriter}
	 * class.
	 * 
	 * <p>TODO: Add the paragraph explaining how errors are handled.</p>
	 * 
	 * @param manifest The <i>Pac-Man</i> ROM set manifest required to
	 * write the file.
	 * @param outputStream The output stream required to write the
	 * <b>.pacromsetmanifest</b> file.
	 * @throws NullPointerException When the manifest or output stream
	 * are null.
	 * @since 1.0.0
	 * @author GarlicDude
	 */
	public PacROMSetManifestWriter(
			final PacROMSetManifest manifest,
			final OutputStream outputStream) {
		this.manifest =
				Objects.requireNonNull(
						manifest,
						"The manifest cannot be null.");
		this.outputStream =
				Objects.requireNonNull(
						outputStream,
						"The output stream cannot be null.");
	}
	
	/**
	 * Writes all the information to the <b>.pacromsetmanifest</b> file.
	 * 
	 * <p>This will write the magic signature at the start of the file,
	 * which should be {@value PacROMSetManifest#MAGIC}. Then it will
	 * write the version number next to it, which should {@value
	 * PacROMSetManifest#VERSION}. Then it will write all the manifest's
	 * lists in order: <b>program</b>, <b>graphic</b>, <b>color</b>,
	 * <b>palette</b>, <b>sound</b>, and <b>mystery</b>. If writing the
	 * manifest file somehow fails, it will throw an error, therefore
	 * failing the writing process.</p>
	 * 
	 * @throws IOException When writing the manifest file fails.
	 * @since 1.0.0
	 * @author GarlicDude
	 */
	public final void write() throws IOException {
		writeMagic();
		writeVersion();
		writeManifestList(manifest.getProgramList());
		writeManifestList(manifest.getGraphicList());
		writeManifestList(manifest.getColorList());
		writeManifestList(manifest.getPaletteList());
		writeManifestList(manifest.getSoundList());
		writeManifestList(manifest.getMysteryList());
	}
	
	/**
	 * Writes the <b>magic signature</b> of the <i>Pac-Man</i> ROM set
	 * manifest file, which is {@value PacROMSetManifest#MAGIC}.
	 * 
	 * @throws IOException When writing the magic signature fails.
	 * @since 1.0.0
	 * @author GarlicDude
	 */
	private final void writeMagic() throws IOException {
		outputStream.write(PacROMSetManifest.MAGIC.getBytes());
	}
	
	/**
	 * Writes the <b>version number</b> of the <i>Pac-Man</i> ROM set
	 * manifest file, which is {@value PacROMSetManifest#VERSION}.
	 * 
	 * @throws IOException When writing the version number fails.
	 * @since 1.0.0
	 * @author GarlicDude
	 */
	private final void writeVersion() throws IOException {
		outputStream.write(PacROMSetManifest.getVersion());
	}
	
	/**
	 * Writes a <b>manifest list</b> and its <b>entries</b> onto the
	 * <i>Pac-Man</i> ROM set manifest file.
	 * 
	 * @param manifestList The manifest list required to write onto the
	 * file.
	 * @throws IOException When writing the manifest list fails.
	 * @since 1.0.0
	 * @author GarlicDude
	 */
	private final void writeManifestList(
			final List<PacROMSetManifestEntry> manifestList)
					throws IOException {
		final int size = manifestList.size();
		for (int index = 0; index < size; index++) {
			writeManifestEntry(manifestList.get(index));
			if (index == size - 1) {
				outputStream.write(PacROMSetManifest.LIST_SEPARATOR);
			} else {
				outputStream.write(PacROMSetManifest.ENTRY_SEPARATOR);
			}
		}
	}
	
	/**
	 * Writes a <b>manifest entry</b> onto the <i>Pac-Man</i> ROM set
	 * manifest file.
	 * 
	 * @param entry The manifest entry required to write onto the file.
	 * @throws IOException When writing the manifest entry fails.
	 * @since 1.0.0
	 * @author GarlicDude
	 */
	private final void writeManifestEntry(
			final PacROMSetManifestEntry entry) throws IOException {
		writeName(entry.getName());
		writeSize(entry.getSize());
	}
	
	/**
	 * Writes the <b>name</b> of a manifest entry.
	 * 
	 * @param name The name of the manifest entry.
	 * @throws IOException When writing the name fails.
	 * @since 1.0.0
	 * @author GarlicDude
	 */
	private final void writeName(final String name) throws IOException {
		final byte[] nameBytes = name.getBytes();
		outputStream.write(nameBytes);
		outputStream.write(PacROMSetManifestEntry.NAME_TERMINATOR);
	}
	
	/**
	 * Writes the <b>size</b> of a manifest entry.
	 * 
	 * @param size The size of the manifest entry.
	 * @throws IOException When writing the size fails.
	 * @since 1.0.0
	 * @author GarlicDude
	 */
	private final void writeSize(final int size) throws IOException {
		for (int index = 8; index > -1; index = index - 8) {
			outputStream.write(size >> index);
		}
	}
	
	/**
	 * Closes the manifest writer.
	 * 
	 * <p>This will also close the output stream that the writer is using
	 * to write the manifest file.</p>
	 * 
	 * @throws IOException When closing the writer fails.
	 * @since 1.0.0
	 * @author GarlicDude
	 */
	@Override
	public final void close() throws IOException {
		outputStream.close();
	}
}
