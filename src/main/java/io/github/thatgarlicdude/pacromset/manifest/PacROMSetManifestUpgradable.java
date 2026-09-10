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

/**
 * An interface used for {@link PacROMSetManifest} classes that can be
 * upgraded to the next version.
 * 
 * @param <T> A generic {@link PacROMSetManifest} used for converting to
 * the next version.
 * @since 1.0.0
 * @author GarlicDude
 */
public interface PacROMSetManifestUpgradable<T extends PacROMSetManifest> {
	
	/**
	 * Upgrades the manifest class to the next version.
	 * 
	 * @return A new <i>Pac-Man</i> ROM set manifest class that represents
	 * the next version of the previous class.
	 * @since 1.0.0
	 * @author GarlicDude
	 */
	public abstract T upgrade();
}
