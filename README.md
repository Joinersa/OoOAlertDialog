# OoOAlertDialog

[![platform](https://img.shields.io/badge/platform-Android-yellow.svg)](https://www.android.com)
[![API](https://img.shields.io/badge/API-16%2B-brightgreen.svg?style=plastic)](https://android-arsenal.com/api?level=14)
[![](https://jitpack.io/v/Joinersa/OoOAlertDialog.svg)](https://jitpack.io/#Joinersa/OoOAlertDialog)
[![License](https://img.shields.io/badge/license-Apache%202-4EB1BA.svg?style=flat-square)](https://www.apache.org/licenses/LICENSE-2.0.html)

<img src="https://github.com/Joinersa/OoOAlertDialog/blob/master/gif.gif">

## Pré-requisitos

* É necessário que o `compileSdkVersion` seja maior ou igual a <b>`26`</b>.

* Adicione isto em seu arquivo root `build.gradle` _(Project: name_project)_:
```gradle
allprojects {
  repositories {
    ...
    maven { url 'https://jitpack.io' }
  }
}
```
* Adicione ao `build.gradle` _(Module: app)_:

```gradle
dependencies {
        implementation 'com.github.Joinersa:OoOAlertDialog:1.0.1'
}
```

## Utilizando o OoOAlertDialog

```java
new OoOAlertDialog.Builder(MainActivity.this)
                        .setTitle("OoOAlertDialog")
                        .setMessage("Deseja fechar este OoOAlertDialog?")
                        .setImage(R.drawable.my_imagem)
                        .setAnimation(Animation.POP)
                        .setPositiveButton("Fechar", null)
                        .setNegativeButton("Mensagem", new OnClickListener() {
                            @Override
                            public void onClick() {
                                Toast.makeText(MainActivity.this, "mensagem", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .build();
```

## Scrennshots

<img src="https://github.com/Joinersa/OoOAlertDialog/blob/master/scrennshot_1.png">

<img src="https://github.com/Joinersa/OoOAlertDialog/blob/master/scrennshot_2.png">

## Funções

* <b>Animação:</b>

Existem 4 tipos de animações pré-definidas que você pode usar: `POP`,` SLIDE`, `SIDE` e `ZOOM`. A animação pode ser definida com `setAnimation(Animation animation)`.

* <b>Imagem:</b>

É possível setar uma imagem no topo da janela de diálogo com o método `setImage(int id)`.

* <b>Título e mensagem:</b>

Título e mensagem são setados respectivamente com `setTitle(String title)` e `setMessage(String message)`.

* <b>Cancelável:</b>

A janela de diálogo pode ou não ser cancelável utilizando o método `setCancelable(boolean cancelable)`.

* <b>Botões (Positivo e Negativo):</b>

Existem dois tipos de botões que podem ou não ser utilizados. Para criar os botões, com eventos de click ou não, basta utilizar os métodos, `setPositiveButton(String text, OnClickListener listener)` para o botão positivo e `setNegativeButton(String text, OnClickListener listener)` para o botão negativo.

* <b>Cor de background da janela:</b>

É possível mudar a cor da janela de diálogo com o método: `setBackgroundColor(int color)`.

* <b>Cor dos Botões:</b>

Os botões positivo e negativo podem ter suas cores alteradas através dos métodos: `setPositiveButtonColor(int color)` e `setNegativeButtonColor(int color)`.

#### Contatos

* [Facebook](https://www.facebook.com/joiner.sa)
* [WhatsApp (+55 91 92228133)](https://api.whatsapp.com/send?phone=+559192228133)
* [LinkedIn](https://www.linkedin.com/in/joiner-s%C3%A1-367342b7/)

## Licença

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

