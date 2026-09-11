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

import static org.junit.Assert.*;
import org.junit.Test;

/**
 * A test class for the {@link PacROMSetManifests} class.
 * 
 * @since 1.0.0
 * @author GarlicDude
 * @see PacROMSetManifests
 */
public final class TestPacROMSetManifests {
	
	/**
	 * A test method for the {@link
	 * PacROMSetManifests#newPacROMSetManifestCherry()} method.
	 * 
	 * @since 1.0.0
	 * @author GarlicDude
	 * @see PacROMSetManifests#newPacROMSetManifestCherry()
	 */
	@Test
	public final void testNewPacROMSetManifestCherry() {
		// Automatically set up the PacROMSetManifest instance.
		final PacROMSetManifest pacROMSetManifest =
				PacROMSetManifests.newPacROMSetManifestCherry();
		// Assert if it's not null.
		assertNotNull(pacROMSetManifest);
	}
}
