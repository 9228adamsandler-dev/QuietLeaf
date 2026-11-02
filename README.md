# QuietLeaf

A small Paper/Leaf-compatible plugin that disables server-wide join, leave, death, and advancement announcements.

## Features

- Hides player join messages.
- Hides player leave messages.
- Hides player death messages.
- Disables advancement announcements using the `announceAdvancements` gamerule.
- Applies the advancement gamerule to worlds already loaded and worlds loaded later.
- Each feature can be toggled in `plugins/QuietLeaf/config.yml`.

## Build locally

Requires Java 21 and Maven.

```bash
mvn clean package
```

The plugin JAR will be at `target/QuietLeaf.jar`.

## Build with GitHub Actions

1. Create a GitHub repository, for example `QuietLeaf`.
2. Upload all files and folders from this project to the repository root. Keep `.github/workflows/build.yml` at that exact path.
3. Open the repository's **Actions** tab and enable Actions if GitHub asks.
4. Push a commit, or open **Actions → Build QuietLeaf → Run workflow**.
5. Wait for the green successful run.
6. Open that workflow run, scroll to **Artifacts**, and download **QuietLeaf**. Extract the ZIP to get `QuietLeaf.jar`.
7. Upload `QuietLeaf.jar` to your Leaf server's `plugins` folder.
8. Restart the server. Do not use `/reload`.
9. To change behavior, edit `plugins/QuietLeaf/config.yml` and restart.

## Compatibility note

This project compiles against Paper API 1.21.4 and Java 21, which is a suitable baseline for many Leaf 1.21.x servers. If your Leaf server runs a different Minecraft version, change the `paper-api` version in `pom.xml` to the matching API version before building. Use the Java version required by your specific server build.
