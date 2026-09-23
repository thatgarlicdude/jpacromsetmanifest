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

import java.util.List;
import java.util.Objects;

/**
 * A class that represents a <i>Pac-Man</i> ROM set manifest.
 * 
 * <p>A <i>Pac-Man</i> ROM set manifest is a type of manifest that has
 * six categorized lists that contain entries called a {@link
 * PacROMSetManifestEntry}. Those lists are <b>program</b>,
 * <b>graphic</b>, <b>color</b>, <b>palette</b>, <b>sound</b>, and
 * <b>mystery</b>. Without these lists, there's no way of telling which
 * ROM in a <i>Pac-Man</i> ROM set is considered a program ROM or a
 * graphic ROM. The entries in a list do not contain copyrighted data,
 * but they are used to find and work with specific, expected ROMs found
 * in a <i>Pac-Man</i> ROM set.</p>
 * 
 * <p>In addition, the class contains other data, like {@link #MAGIC} used
 * for reading and writing <b>.pacromsetmanifest</b> files, {@link
 * #EXTENSION} for labeling files that have the <b>.pacromsetmanifest</b>
 * file extension, and {@link #VERSION} to indicate what version the
 * manifest class is on.</p>
 * 
 * <p>A <i>Pac-Man</i> ROM set manifest can be written to disk via the
 * {@link PacROMSetManifestWriter} class, or can be read from disk via
 * the {@link PacROMSetManifestReader} class. Alternatively, they can
 * easily be saved or loaded from the {@link PacROMSetManifests} class,
 * an easy gateway for working with manifests.</p>
 * 
 * @since 1.0.0
 * @author GarlicDude
 * @see PacROMSetManifestEntry
 * @see PacROMSetManifests
 * @see PacROMSetManifestReader
 * @see PacROMSetManifestWriter
 */
public final class PacROMSetManifest {
	
	/**
	 * The magic signature found at the beginning of a
	 * <b>.pacromsetmanifest</b> file.
	 * 
	 * <p>This field is used to identify whether a file is truly a
	 * <i>Pac-Man</i> ROM set manifest file. It is written at the start
	 * of a file whenever it is being saved to disk. When the file is
	 * being loaded from disk, it must look for that signature before
	 * proceeding to the other contents. That being said, the magic
	 * signature is used to make sure whether a file is actually a
	 * <i>Pac-Man</i> ROM set manifest file.</p>
	 * 
	 * <p>Alternatively, the field can be obtained by calling the
	 * {@link #getMagic()} method, which returns this value.</p>
	 * 
	 * @since 1.0.0
	 * @author GarlicDude
	 * @see #getMagic()
	 * @see #EXTENSION
	 */
	public static final String MAGIC = "PACROMSETMANIFEST";
	
	/**
	 * The file extension for a <b>.pacromsetmanifest</b> file.
	 * 
	 * <p>This field is used to label files as <i>Pac-Man</i> ROM set
	 * manifest files, not to be confused with {@link #MAGIC}, which
	 * identifies them as one. This is especially useful for UI classes
	 * like {@code JFileChooser} and {@code JFileFilter}, since they can
	 * filter files using this file extension.</p>
	 * 
	 * <p>Alternatively, the field can be obtained by calling the
	 * {@link #getExtension()} method, which returns this value.</p>
	 * 
	 * @since 1.0.0
	 * @author GarlicDude
	 * @see #getExtension()
	 * @see #MAGIC
	 */
	public static final String EXTENSION = "pacromsetmanifest";
	
	/**
	 * The current version of the <i>Pac-Man</i> ROM set manifest.
	 * 
	 * <p>This field is used to identify what version the ROM set manifest
	 * is on. It is also written and read next to the {@link #MAGIC} when
	 * a <b>.pacromsetmanifest</b> file is being accessed from the
	 * system's disk. It is especially important because, in the future,
	 * the <i>JPacROMSetManifest</i> Java library may change or introduce
	 * things to the manifest and its entries. The system should not be
	 * confused on what type of <i>Pac-Man</i> ROM set manifest it is
	 * trying to read or write onto disk.</p>
	 * 
	 * <p>Alternatively, the field can be obtained by calling the
	 * {@link #getVersion()} method, which returns the value.</p>
	 * 
	 * @since 1.0.0
	 * @author GarlicDude
	 * @see #getVersion()
	 */
	public static final byte VERSION = 1;
	
	/**
	 * The list that can hold entries related to the <b>program</b> ROMs
	 * in the <i>Pac-Man</i> ROM set.
	 * 
	 * @since 1.0.0
	 * @author GarlicDude
	 * @see #getProgramList()
	 */
	private final List<PacROMSetManifestEntry> programList;
	
	/**
	 * The list that can hold entries related to the <b>graphic</b> ROMs
	 * in the <i>Pac-Man</i> ROM set.
	 * 
	 * @since 1.0.0
	 * @author GarlicDude
	 * @see #getGraphicList()
	 */
	private final List<PacROMSetManifestEntry> graphicList;
	
	/**
	 * The list that can hold entries related to the <b>color</b> ROMs
	 * in the <i>Pac-Man</i> ROM set.
	 * 
	 * @since 1.0.0
	 * @author GarlicDude
	 * @see #getColorList()
	 */
	private final List<PacROMSetManifestEntry> colorList;
	
	/**
	 * The list that can hold entries related to the <b>palette</b> ROMs
	 * in the <i>Pac-Man</i> ROM set.
	 * 
	 * @since 1.0.0
	 * @author GarlicDude
	 * @see #getPaletteList()
	 */
	private final List<PacROMSetManifestEntry> paletteList;
	
	/**
	 * The list that can hold entries related to the <b>sound</b> ROMs
	 * in the <i>Pac-Man</i> ROM set.
	 * 
	 * @since 1.0.0
	 * @author GarlicDude
	 * @see #getSoundList()
	 */
	private final List<PacROMSetManifestEntry> soundList;
	
	/**
	 * The list that can hold entries related to the <b>mystery</b> ROMs
	 * in the <i>Pac-Man</i> ROM set.
	 * 
	 * @since 1.0.0
	 * @author GarlicDude
	 * @see #getMysteryList()
	 */
	private final List<PacROMSetManifestEntry> mysteryList;
	
	/**
	 * Constructs an instance of the {@link PacROMSetManifest} class.
	 * 
	 * <p>When constructing an instance of this class, the lists cannot
	 * point to null. If that happens, it will throw an error, saying that
	 * a list is null.</p>
	 * 
	 * @param programList The list that holds program ROM entries.
	 * @param graphicList The list that holds graphic ROM entries.
	 * @param colorList The list that holds color ROM entries.
	 * @param paletteList The list that holds palette ROM entries.
	 * @param soundList The list that holds sound ROM entries.
	 * @param mysteryList The list that holds mystery ROM entries.
	 * @throws NullPointerException When one of the lists are null.
	 * @since 1.0.0
	 * @author GarlicDude
	 */
	public PacROMSetManifest(
			final List<PacROMSetManifestEntry> programList,
			final List<PacROMSetManifestEntry> graphicList,
			final List<PacROMSetManifestEntry> colorList,
			final List<PacROMSetManifestEntry> paletteList,
			final List<PacROMSetManifestEntry> soundList,
			final List<PacROMSetManifestEntry> mysteryList) {
		// Set up each of the lists that shouldn't be null.
		this.programList = Objects.requireNonNull(
				programList,
				"Program list must not be null");
		this.graphicList = Objects.requireNonNull(
				graphicList,
				"Graphic list must not be null");
		this.colorList = Objects.requireNonNull(
				colorList,
				"Color list must not be null");
		this.paletteList = Objects.requireNonNull(
				paletteList,
				"Palette list must not be null");
		this.soundList = Objects.requireNonNull(
				soundList,
				"Sound list must not be null");
		this.mysteryList = Objects.requireNonNull(
				mysteryList,
				"Mystery list must not be null");
	}
	
	// TODO: Perhaps elaborate on the static getters more?
	
	/**
	 * Gets {@link #MAGIC}, which is the magic signature used at the
	 * beginning of a <b>.pacromsetmanifest</b> file.
	 * 
	 * @return A {@code String} that says {@value #MAGIC}.
	 * @since 1.0.0
	 * @author GarlicDude
	 * @see #MAGIC
	 */
	public static final String getMagic() {
		// Return the magic signature used for the manifest files.
		return MAGIC;
	}
	
	/**
	 * Gets {@link #EXTENSION}, which is the file extension that labels
	 * files as <b>.pacromsetmanifest</b> files.
	 * 
	 * @return A {@code String} that says {@value #EXTENSION}.
	 * @since 1.0.0
	 * @author GarlicDude
	 * @see #EXTENSION
	 */
	public static final String getExtension() {
		// Return the file extension used to label the manifest files.
		return EXTENSION;
	}
	
	/**
	 * Gets {@link #VERSION}, which is the current version of the
	 * <i>Pac-Man</i> ROM set manifest.
	 * 
	 * @return A {@code byte} that is {@value #VERSION}.
	 * @since 1.0.0
	 * @author GarlicDude
	 * @see #VERSION
	 */
	public static final byte getVersion() {
		// Return the current version of the manifest.
		return VERSION;
	}
	
	public final List<PacROMSetManifestEntry> getProgramList() {
		// Return the program list.
		return this.programList;
	}
	
	public final List<PacROMSetManifestEntry> getGraphicList() {
		// Return the graphic list.
		return this.graphicList;
	}
	
	public final List<PacROMSetManifestEntry> getColorList() {
		// Return the color list.
		return this.colorList;
	}
	
	public final List<PacROMSetManifestEntry> getPaletteList() {
		// Return the palette list.
		return this.paletteList;
	}
	
	public final List<PacROMSetManifestEntry> getSoundList() {
		// Return the sound list.
		return this.soundList;
	}
	
	public final List<PacROMSetManifestEntry> getMysteryList() {
		// Return the mystery list.
		return this.mysteryList;
	}
}
