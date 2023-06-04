# wiki-bidet-map-android
bidet world map anyone can edit

```mermaid
graph TD;
    app-->feature-welcome;
    app-->feature-map;
    app-->feature-login;
    app-->feature-settings;
    app-->core-presentation;
    feature-welcome-->core-presentation;
    feature-map-->core-presentation;
    feature-login-->core-presentation;
    feature-settings-->core-presentation;
    feature-welcome-->core-data;
    feature-map-->core-data;
    feature-login-->core-data;
    feature-settings-->core-data;
    core-data-->core-domain;
```
