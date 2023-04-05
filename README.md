# wiki-bidet-map-android
bidet world map anyone can edit

```mermaid
graph TD;
    app-->feature-welcome;
    app-->feature-map;
    app-->feature-login;
    app-->feature-settings;
    app-->core-data;
    feature-welcome-->core-presentation;
    feature-map-->core-presentation;
    feature-login-->core-presentation;
    feature-settings-->core-presentation;
    core-presentation-->core-domain;
    core-data-->core-domain;
```
