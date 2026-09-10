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

import java.util.ArrayList;
import java.util.List;

// TODO: Elaborate more on the class description.

/**
 * A class that represents a <b><i>Pac-Man</i> ROM set manifest</b>.
 * 
 * @since 1.0.0
 * @author GarlicDude
 */
public final class PacROMSetManifest {
	
	/**
	 * The <b>magic signature</b> of a <i>Pac-Man</i> ROM set manifest
	 * file.
	 * 
	 * <p>This is used at the beginning of a .pacromsetmanifest file to
	 * verify that it's actually a <i>Pac-Man</i> ROM set manifest file.
	 * Without it, there's no way for the system to tell that a file is
	 * designed for the {@link PacROMSetManifest} class in mind, which
	 * could lead to problems down the lane. Therefore, that's why this
	 * variable exists. It is used for validity reasons.</p>
	 * 
	 * <p>This {@code String} can alternatively be obtained by calling the
	 * {@link #getMagic()} method.</p>
	 * 
	 * @since 1.0.0
	 * @author GarlicDude
	 * @see #getMagic()
	 */
	public static final String MAGIC = "PACROMSETMANIFEST";
	
	/**
	 * The <b>file extension</b> for a <i>Pac-Man</i> ROM set manifest
	 * file.
	 * 
	 * <p>This is used to label files with the <b>.pacromsetmanifest</b>
	 * extension, which is especially useful for UI tools like the {@code
	 * JFileChooser} class. Without it, there's no way of categorizing
	 * files designed for the {@link PacROMSetManifest} class in mind,
	 * which could lead to problems along the way. In that case, the
	 * variable is used for identification and categorization
	 * purposes.</p>
	 * 
	 * <p>This {@code String} can alternatively be obtained by calling the
	 * {@link #getExtension()} method.</p>
	 * 
	 * @since 1.0.0
	 * @author GarlicDude
	 * @see #getExtension()
	 */
	public static final String EXTENSION = "pacromsetmanifest";
	
	/*
	 * TODO: Instead of using a static variable, make the version number
	 * a variable of the instance. This could be used for future classes,
	 * like PacROMSetManifestCherry and PacROMSetManifestStrawberry.
	 * 
	 * PacROMSetManifestCherry = Version 1.
	 * PacROMSetManifestStrawberry = Version 2.
	 * PacROMSetManifestOrange = Version 3.
	 * 
	 * ...and so on. You get the idea.
	 */
	
	/**
	 * The current <b>version</b> of the <i>Pac-Man</i> ROM set manifest
	 * file format.
	 * 
	 * <p>This is used to identify what kind of PacROMSetManifest file the
	 * system is reading or writing. Without it, there's no way of telling
	 * whether a manifest file is a cherry version (version #1) or a
	 * strawberry version (version #2). Those kinds of manifest files are
	 * different from each other in terms of features and functionality.
	 * In that case, this variable is used for identification
	 * purposes.</p>
	 * 
	 * <p>This {@code byte} can alternatively be obtained by calling the
	 * {@link #getVersion()} method.</p>
	 * 
	 * @since 1.0.0
	 * @author GarlicDude
	 * @see #getVersion()
	 */
	public static final byte VERSION = 1;
	
	// TODO: Add Javadoc comments on the variables and methods.
	
	// TODO: Rename them to ROMList.
	
	private final List<PacROMSetManifestEntry> programROMList;
	
	private final List<PacROMSetManifestEntry> graphicROMList;
	
	private final List<PacROMSetManifestEntry> colorROMList;
	
	private final List<PacROMSetManifestEntry> paletteROMList;
	
	private final List<PacROMSetManifestEntry> soundROMList;
	
	private final List<PacROMSetManifestEntry> mysteryROMList;
	
	/**
	 * Gets {@link #MAGIC}, which is the <b>magic signature</b> for the
	 * <i>Pac-Man</i> ROM set manifest files.
	 * 
	 * <p>As stated in the description of the {@link #MAGIC} variable, the
	 * magic signature is used at the beginning of a .pacromsetmanifest
	 * file. It's used to verify whether a file is actually designed for
	 * the {@link PacROMSetManifest} class in mind. Without it, there's no
	 * way of identifying the manifest files properly, which could lead to
	 * problems down the lane. That being said, this magic signature is
	 * used for validity reasons.</p>
	 * 
	 * <p>Because {@link #MAGIC} is a public static variable, it can
	 * alternatively be obtained by simply getting it from the {@link
	 * PacROMSetManifest} class itself.</p>
	 * 
	 * @return A {@code String} that says "PACROMSETMANIFEST".
	 * @since 1.0.0
	 * @author GarlicDude
	 * @see #MAGIC
	 */
	public static final String getMagic() {
		// Return the magic signature used for the manifest files.
		return MAGIC;
	}
	
	/**
	 * Gets {@link #EXTENSION}, which is the <b>file extension</b> for the
	 * <i>Pac-Man</i> ROM set manifest files.
	 * 
	 * <p>As stated in the description of the {@link #EXTENSION} variable,
	 * the file extension is used to label files with the
	 * <b>.pacromsetmanifest</b> extension. This is useful for UI tools,
	 * such as the {@code JFileChooser} class, as they can filter and
	 * categorize the manifest files easily. Without it, there's no way of
	 * identifying the files with this label, which could lead to some
	 * problems along the way. In that case, the file extension is used
	 * for identification and categorization purposes.</p>
	 * 
	 * <p>Because {@link #EXTENSION} is a public static variable, it can
	 * alternatively be obtained by simply getting it from the {@link
	 * PacROMSetManifest} class itself.</p>
	 * 
	 * @return A {code String} that says "pacromsetmanifest".
	 * @since 1.0.0
	 * @author GarlicDude
	 * @see #EXTENSION
	 */
	public static final String getExtension() {
		// Return the file extension used to label the manifest files.
		return EXTENSION;
	}
	
	/**
	 * Gets {@link #VERSION}, which is the current <b>version</b> of the
	 * <i>Pac-Man</i> ROM set manifest file format.
	 * 
	 * <p>As stated in the {@link #VERSION} variable, the version is used
	 * to identify what kind of PacROMSetManifest file the system is
	 * reading or writing. Without it, there's no way of telling whether
	 * the manifest file is a cherry version (version #1) or a strawberry
	 * version (version #2), as these kinds of manifest work differently.
	 * In that case, the version variable is used for identification
	 * purposes.</p>
	 * 
	 * <p>Because {@link #VERSION} is a public static variable, it can
	 * alternatively be obtained by simply getting it from the {@link
	 * PacROMSetManifest} class itself.</p>
	 * 
	 * @return A {@code char} that is the current version of the
	 * manifest file format.
	 * @since 1.0.0
	 * @author GarlicDude
	 * @see #VERSION
	 */
	public static final byte getVersion() {
		// Return the current version of the class.
		return VERSION;
	}
	
	public final List<PacROMSetManifestEntry> getProgramROMList() {
		// Return the program ROM list.
		return this.programROMList;
	}
	
	public final List<PacROMSetManifestEntry> getGraphicROMList() {
		// Return the graphic ROM list.
		return this.graphicROMList;
	}
	
	public final List<PacROMSetManifestEntry> getColorROMList() {
		// Return the color ROM list.
		return this.colorROMList;
	}
	
	public final List<PacROMSetManifestEntry> getPaletteROMList() {
		// Return the palette ROM list.
		return this.paletteROMList;
	}
	
	public final List<PacROMSetManifestEntry> getSoundROMList() {
		// Return the sound ROM list.
		return this.soundROMList;
	}
	
	public final List<PacROMSetManifestEntry> getMysteryROMList() {
		// Return the mystery ROM list.
		return this.mysteryROMList;
	}
	
	/**
	 * Constructs an instance of the {@link PacROMSetManifest} class.
	 * 
	 * @since 1.0.0
	 * @author GarlicDude
	 */
	public PacROMSetManifest() {
		// Set up each of the lists.
		this.programROMList = new ArrayList<PacROMSetManifestEntry>();
		this.graphicROMList = new ArrayList<PacROMSetManifestEntry>();
		this.colorROMList = new ArrayList<PacROMSetManifestEntry>();
		this.paletteROMList = new ArrayList<PacROMSetManifestEntry>();
		this.soundROMList = new ArrayList<PacROMSetManifestEntry>();
		this.mysteryROMList = new ArrayList<PacROMSetManifestEntry>();
	}
}
