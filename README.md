<h1 align="center">Wiki Bidet Map(Work in progress)</h1>

Bidet world map anyone can edit  
- features
    - apply, like, dislike bidet map
    - multi language
    - dark theme
    - login

## Tech stack & Open-source libraries
- Minimum SDK level 24, Target SDK level 33
- Kotlin based, Coroutines + Flow for asynchronous.
- Modularization
- Material3
- Firebase Realtime Database
- Jetpack
    - Compose
    - Lifecycle
    - ViewModel
    - Room
    - Hilt
    - Navigation
- Architecture
    - MVVM Architecture
    - Repository Pattern

## Dependency graph

```mermaid
graph TD;
    :app-->:feature:welcome;
    :app-->:feature:map;
    :app-->:feature:login;
    :app-->:feature:settings;
    :app-->:core:presentation;
    :feature:welcome-->:core:presentation;
    :feature:map-->:core:presentation;
    :feature:login-->:core:presentation;
    :feature:settings-->:core:presentation;
    :feature:welcome-->:core:domain;
    :feature:map-->:core:domain;
    :feature:login-->:core:domain;
    :feature:settings-->:core:domain;
    :core:domain-->:core:data;
```