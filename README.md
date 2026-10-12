# ![JPacROMSetManifest](src/main/resources/logo/logo.png)

![GitHub Tag](https://img.shields.io/github/v/tag/thatgarlicdude/jpacromsetmanifest)
![GitHub License](https://img.shields.io/github/license/thatgarlicdude/jpacromsetmanifest)

## Overview

JPacROMSetManifest is a Java library used for working with *Pac-Man* ROM set manifests, as well as writing them to disk as **.pacromsetmanifest** files and reading them to memory.

## What is a Pac-Man ROM Set Manifest?

To put it simply, a *Pac-Man* ROM set manifest is a categorized list of expected ROM names found in a digital *Pac-Man* ROM set. Examples include `pacman.6e`, `pm1_prg1.6e`, and `82s123.7f`. The manifest organizes its entries into six different categories: **program**, **graphic**, **color**, **palette**, **sound**, and **mystery**. This is done to help other ROM hacking programs and utilities read and write digital *Pac-Man* ROM sets properly, and determine which ROM is considered a **program ROM** or a **graphic ROM**. It is especially useful for reverse-engineering *Pac-Man*, as well as the other games that use the same or similar hardware.

As a disclaimer, a *Pac-Man* ROM set manifest, as well as the entries, do not contain any copyrighted data. Filenames are labels, and cannot be protected by copyright.

## Install

The Java library can be installed by following the instructions in `INSTALL.md`.

## License

This project is licensed under the Apache License Version 2.0.

See `LICENSE.txt` for details.

## Disclaimer

- This is a **fan-made project** and is not affiliated with or endorsed by Bandai Namco.
- All trademarks, logos, and original designs are the property of their respective owners.