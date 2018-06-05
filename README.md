# OoOAlertDialog

[![platform](https://img.shields.io/badge/platform-Android-yellow.svg)](https://www.android.com)
[![API](https://img.shields.io/badge/API-16%2B-brightgreen.svg?style=plastic)](https://android-arsenal.com/api?level=14)
[![](https://jitpack.io/v/Joinersa/OoOAlertDialog.svg)](https://jitpack.io/#Joinersa/OoOAlertDialog)
[![License](https://img.shields.io/badge/license-Apache%202-4EB1BA.svg?style=flat-square)](https://www.apache.org/licenses/LICENSE-2.0.html)

## Pré-requisitos

Adicione isto em seu arquivo root `build.gradle` _(Project: name_project)_:
```gradle
allprojects {
  repositories {
    ...
    maven { url 'https://jitpack.io' }
  }
}
```
Adicione ao `build.gradle` _(Module: app)_:

```gradle
dependencies {
        implementation 'com.github.Joinersa:OoOAlertDialog:v1.1'
}
```

<h2>Usando o OoOAlertDialog</h2>

```java
new OoOAlertDialog.Builder(MainActivity.this)
                        .setTitle("OoOAlertDialog")
                        .setMessage("Deseja fechar este OoOAlertDialog?")
                        .setAnimation(Animation.POP)
                        .setPositiveButton("Fechar", null)
                        .build();
```

#### Animation

Existem 3 tipos de animações pré-definidas que você pode usar: `POP`,` SLIDE` e `SIDE`

#### Contatos
 Joiner Sá
* [Facebook](https://www.facebook.com/joiner.sa)
* [WhatsApp (+55 91 92228133)](https://api.whatsapp.com/send?phone=+559192228133)
* [LinkedIn](https://www.linkedin.com/in/joiner-s%C3%A1-367342b7/)

## License

* [Apache Version 2.0](http://www.apache.org/licenses/LICENSE-2.0.html)

```
Copyright 2018 Joiner Sá

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

 http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
