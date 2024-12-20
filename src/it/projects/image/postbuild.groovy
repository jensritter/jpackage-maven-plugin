/*
  Copyright (C) 2020 - 2024 Alexander Kapitman

  Licensed under the Apache License, Version 2.0 (the "License");
  you may not use this file except in compliance with the License.
  You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

  Unless required by applicable law or agreed to in writing, software
  distributed under the License is distributed on an "AS IS" BASIS,
  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
  See the License for the specific language governing permissions and
  limitations under the License.
*/

def getArchName() {
    return System.properties['os.arch'].toLowerCase()
}

def getPlatformName() {
    String name = System.properties['os.name'].toLowerCase()
    if (name.contains('windows')) {
        return 'windows'
    } else if (name.contains('linux')) {
        return 'linux'
    } else if (name.contains('mac')) {
        return 'mac'
    }
    assert false : "ERROR: Unknown platform: '${name}'!"
}

String platformName = getPlatformName()
String archName = getArchName()
String pathPrefix = "target/jpackage/${platformName}"

String imageDirName = ""

switch (platformName) {
    case 'windows':
        imageDirName = "Launcher"
        imageDirName = "${pathPrefix}/${imageDirName}"
        break
    case 'linux':
        imageDirName = "Launcher"
        imageDirName = "${pathPrefix}/${imageDirName}"
        break
    case 'mac':
        imageDirName = "Launcher"
        imageDirName = "${pathPrefix}/${imageDirName}"
        break
    default:
        assert false : "ERROR: Unknown platform: '${platformName}' [${archName}]!"
        break
}

File imageDir = new File(basedir, imageDirName)
assert imageDir.isDirectory()
