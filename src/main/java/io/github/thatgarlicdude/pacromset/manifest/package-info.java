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

/**
 * The main package of the <i>JPacROMSetManifest</i> Java library.
 * 
 * <p>This package is used to work with manifests designed for the
 * <i>Pac-Man</i> ROM set. It is a home for the {@link PacROMSetManifest},
 * {@link PacROMSetManifestEntry}, and {@link PacROMSetManifests} classes.
 * The {@link PacROMSetManifest} class is the main class that has
 * categorized lists that contain entries called the
 * {@link PacROMSetManifestEntry} class. The {@link PacROMSetManifestEntry}
 * class contains data like the expected <b>name</b> and <b>size</b> of a
 * <i>Pac-Man</i> ROM, and the {@link PacROMSetManifests} serves as an
 * easy gateway for creating {@link PacROMSetManifest} instances, as well
 * as reading and writing them to this system's disk. Additionally, the
 * package has the {@link PacROMSetManifestReader} class, which reads
 * <b>.pacromsetmanifest</b> files from disk, and the
 * {@link PacROMSetManifestWriter} writes them to disk. The
 * <i>JPacROMSetManifest</i> Java library is used at its core to work with
 * <i>Pac-Man</i> ROM set manifests.</p>
 * 
 * @version 1.0.0
 * @author GarlicDude
 * @see PacROMSetManifest
 * @see PacROMSetManifestEntry
 * @see PacROMSetManifests
 * @see PacROMSetManifestReader
 * @see PacROMSetManifestWriter
 */
package io.github.thatgarlicdude.pacromset.manifest;