# ${project.name} v${project.version}

[![Build Status][travis_badge]][travis_href]
[![Maven Central][central_badge]][central_href]
[![License][license_badge]][license_href]

The jpackage maven plugin lets you create a custom runtime image/installer with
the jpackage tool introduced in Java 14.

The main idea is to avoid being tied to project artifacts and allow the user
to fully control the process of creating an image/installer.

[The detailed documentation for this plugin is available here.][goals]

## Goals

This plugin has two [goals][goals]:

- [jpackage:jpackage][mojo_jpackage] create a custom runtime image.
- [jpackage:help][mojo_help] display help information on the plugin.

To create a custom runtime image manually you need only to execute:

```console
mvn jpackage:jpackage
```

To display parameter details execute:

```console
mvn jpackage:help -Ddetail=true
```

## Usage

Add the plugin to your pom:

```xml
  <project>
    ...
    <build>
      <pluginManagement>
        <plugins>
          <plugin>
            <groupId>${project.groupId}</groupId>
            <artifactId>${project.artifactId}</artifactId>
            <version>${project.version}</version>
            <configuration>
              <!-- put your configurations here -->
            </configuration>
          </plugin>
        </plugins>
      </pluginManagement>
    </build>
    ...
  </project>
```

If you want to use snapshot versions of the plugin connect the snapshot
repository in your pom.xml.

```xml
  <project>
    ...
    <pluginRepositories>
      <pluginRepository>
        <id>${project.distributionManagement.snapshotRepository.id}</id>
        <name>${project.distributionManagement.snapshotRepository.name}</name>
        <url>${project.distributionManagement.snapshotRepository.url}</url>
        <layout>default</layout>
        <snapshots>
          <enabled>true</enabled>
        </snapshots>
        <releases>
          <enabled>false</enabled>
        </releases>
      </pluginRepository>
    </pluginRepositories>
    ...
  </project>
```

## Links

[The JPackage tool official description.][jpackage]

## Pull request

Pull request template: [.github/pull_request_template.md][pull_request].

[travis_badge]: https://travis-ci.com/akman/jpackage-maven-plugin.svg?branch=v${project.version}
[travis_href]: https://travis-ci.com/akman/jpackage-maven-plugin
[central_badge]: https://img.shields.io/maven-central/v/com.github.akman/jpackage-maven-plugin
[central_href]: https://search.maven.org/artifact/com.github.akman/jpackage-maven-plugin
[license_badge]: https://img.shields.io/github/license/akman/jpackage-maven-plugin.svg
[license_href]: https://github.com/akman/jpackage-maven-plugin/blob/master/LICENSE
[goals]: https://akman.github.io/jpackage-maven-plugin/plugin-info.html
[mojo_jpackage]: https://akman.github.io/jpackage-maven-plugin/jpackage-mojo.html
[mojo_help]: https://akman.github.io/jpackage-maven-plugin/help-mojo.html
[jpackage]: https://docs.oracle.com/en/java/javase/14/docs/specs/man/jpackage.html
[pull_request]: https://github.com/akman/jpackage-maven-plugin/blob/master/.github/pull_request_template.md