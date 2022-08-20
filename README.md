# CDS Minecraft plugin

Simple plugin for Minecraft, without any useful feature

## 🖥 Installation

### 🧾 Requirements

- [maven 3.0+](https://maven.apache.org/)
- [java 8+](https://www.java.com/)
- [spigot server 1.19+](https://getbukkit.org/get/b78b59a4de300d2eea0ca32566df3def)

### 🔧 Configuration

#### Copy path

After the _.jar_ has been produced, the following lines in the _pom.xml_ file will make sure it is copied it to its destination.
Make sure the path is correct for you.

```xml
<tasks>
    <copy file="target/cds-plugin-1.0-SNAPSHOT.jar" todir="../minecraft_19/plugins" />
</tasks>
```

#### Reload script

Change the _reload.sh_ file to better suit your needs.
It is called after the _.jar_ has been copied to the _plugins_ directory, and right now it reloads the server's configuration with the new version of the plugin

### Install

```sh
mvn install
```

## 🧪 Test

```sh
mvn test
```

## 📚 Reference
- [kotlin docs](https://kotlinlang.org/docs/home.html)
- [Bukkit wiki](https://bukkit.fandom.com/wiki/Plugin_Tutorial_(Eclipse))
