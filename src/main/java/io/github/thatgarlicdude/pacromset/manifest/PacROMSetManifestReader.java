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
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * A class that reads <b>.pacromsetmanifest</b> files from disk.
 * 
 * @since 1.0.0
 * @author GarlicDude
 * @see PacROMSetManifest
 * @see PacROMSetManifestWriter
 */
public final class PacROMSetManifestReader implements Closeable {
	
	/**
	 * The input stream required to read the <i>Pac-Man</i> ROM set
	 * manifest file.
	 * 
	 * @since 1.0.0
	 * @author GarlicDude
	 */
	private final InputStream inputStream;
	
	/**
	 * Constructs an instance of the {@link PacROMSetManifestReader}
	 * class.
	 * 
	 * <p>When constructing an instance of this class, the input stream
	 * cannot point to null. If this happens, it will throw an error
	 * saying that the said object is null.</p>
	 * 
	 * @param inputStream The input stream required to read the
	 * <b>.pacromsetmanifest</b> file from disk.
	 * @throws NullPointerException When the input stream is null.
	 * @since 1.0.0
	 * @author GarlicDude
	 */
	public PacROMSetManifestReader(
			final InputStream inputStream) {
		this.inputStream = Objects.requireNonNull(
				inputStream,
				"The input stream cannot be null.");
	}
	
	/**
	 * Reads all of the information of the <b>.pacromsetmanifest</b>
	 * file.
	 * 
	 * <p>By reading the file, it'll first check the file's signature,
	 * which should be {@value PacROMSetManifest#MAGIC}. Then it will
	 * check the version number of the manifest file, which should be
	 * {@value PacROMSetManifest#VERSION}. Then it will load all the
	 * categorized lists in order: <b>program</b>, <b>graphic</b>,
	 * <b>color</b>, <b>palette</b>, <b>sound</b>, and then
	 * <b>mystery</b>. If the signature, version number, lists, or
	 * manifest entries are invalid or incomplete, it will throw an error,
	 * therefore failing the reading process.</p>
	 * 
	 * @return A new {@link PacROMSetManifest} loaded from disk.
	 * @throws IOException When reading the manifest file fails.
	 * @since 1.0.0
	 * @author GarlicDude
	 */
	public final PacROMSetManifest read() throws IOException {
		checkMagic();
		checkVersion();
		return new PacROMSetManifest(
				readManifestList(),
				readManifestList(),
				readManifestList(),
				readManifestList(),
				readManifestList(),
				readManifestList());
	}
	
	/**
	 * Checks the <b>magic signature</b> at the start of the manifest
	 * file, which should be {@value PacROMSetManifest#MAGIC}.
	 * 
	 * @throws IOException When the signature is invalid or incomplete.
	 * @since 1.0.0
	 * @author GarlicDude
	 */
	private final void checkMagic() throws IOException {
		final byte[] magicBytes1 = PacROMSetManifest.MAGIC.getBytes();
		final byte[] magicBytes2 = new byte[magicBytes1.length];
		final int bytesRead = inputStream.read(magicBytes2);
		if (bytesRead != magicBytes2.length) {
			throw new EOFException(
					"The PacROMSetManifest signature is incomplete.");
		}
		if (!Arrays.equals(magicBytes1, magicBytes2)) {
			throw new IOException(
					"The PacROMSetManifest signature is invalid.");
		}
	}
	
	/**
	 * Checks the <b>version number</b> in the manifest file, which should
	 * be {@value PacROMSetManifest#VERSION}.
	 * 
	 * @throws IOException When the version number is invalid or cannot
	 * be found.
	 * @since 1.0.0
	 * @author GarlicDude
	 */
	private final void checkVersion() throws IOException {
		final int version = inputStream.read();
		if (version == -1) {
			throw new EOFException(
					"The PacROMSetManifest version is not found.");
		}
		if (version != PacROMSetManifest.VERSION) {
			throw new IOException(
					"The PacROMSetManifest version is invalid.");
		}
	}
	
	/**
	 * Reads a <b>manifest list</b> by loading its entries to memory.
	 * 
	 * @return A {@code List} with the loaded manifest entries.
	 * @throws IOException When the manifest size cannot be found.
	 * @since 1.0.0
	 * @author GarlicDude
	 */
	private final List<PacROMSetManifestEntry> readManifestList()
			throws IOException {
		final List<PacROMSetManifestEntry> manifestList =
				new ArrayList<PacROMSetManifestEntry>();
		int separator = 0;
		while (true) {
			final PacROMSetManifestEntry manifestEntry =
					readManifestEntry();
			manifestList.add(manifestEntry);
			separator = inputStream.read();
			if (separator == -1) {
				throw new EOFException(
						"The PacROMSetManifest list is incomplete.");
			}
			if (separator == PacROMSetManifest.LIST_SEPARATOR) {
				break;
			}
		}
		return manifestList;
	}
	
	/**
	 * Reads a <b>manifest entry</b> by loading its contents to disk.
	 * 
	 * @return A new {@link PacROMSetManifestEntry} with its loaded
	 * contents.
	 * @throws IOException When reading a manifest entry fails.
	 * @since 1.0.0
	 * @author GarlicDude
	 */
	private final PacROMSetManifestEntry readManifestEntry()
			throws IOException {
		final String name = readName();
		final int size = readSize();
		return new PacROMSetManifestEntry(name, size);
	}
	
	/**
	 * Reads the <b>name</b> in a manifest entry.
	 * 
	 * @return A {@code String} that is the loaded name.
	 * @throws IOException When the name is cut off by an EOF error.
	 * @since 1.0.0
	 * @author GarlicDude
	 */
	private final String readName() throws IOException {
		final ByteArrayOutputStream bytes = new ByteArrayOutputStream();
		int readByte = 0;
		while ((readByte = inputStream.read()) !=
				PacROMSetManifestEntry.NAME_TERMINATOR) {
			if (readByte == -1) {
				throw new EOFException(
						"The manifest entry name is incomplete.");
			}
			bytes.write(readByte);
		}
		return new String(bytes.toByteArray());
	}
	
	/**
	 * Reads the <b>size</b> in a manifest entry in big-endian.
	 * 
	 * @return A {@code int} that is the loaded size.
	 * @throws IOException When the size is cut off by an EOF error.
	 * @since 1.0.0
	 * @author GarlicDude
	 */
	private final int readSize() throws IOException {
		int size = 0;
		for (int index = 8; index > -1; index = index - 8) {
			final int sizeByte = inputStream.read();
			if (sizeByte == -1) {
				throw new EOFException(
						"The manifest entry size is incomplete.");
			}
			size |= sizeByte << index;
		}
		return size;
	}
	
	/**
	 * Closes the manifest reader.
	 * 
	 * <p>This will also close the input stream that the reader is using
	 * to read the manifest file.</p>
	 * 
	 * @throws IOException When closing the reader fails.
	 * @since 1.0.0
	 * @author GarlicDude
	 */
	@Override
	public void close() throws IOException {
		inputStream.close();
	}
}
