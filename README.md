[![GitHub issues](https://img.shields.io/github/issues-raw/Studio-kalavati/Bandish-editor?style=for-the-badge&logo=github)](https://github.com/Studio-kalavati/Bandish-editor/issues)
[![GitHub pull requests](https://img.shields.io/github/issues-pr/Studio-kalavati/Bandish-editor?style=for-the-badge&logo=github)](https://github.com/Studio-kalavati/Bandish-editor/pulls)
[![License](https://img.shields.io/github/license/Studio-kalavati/Bandish-editor?style=for-the-badge)](license.txt)


<p>
<h1 align="center">Bhatkhande Bandish editor</h1>

A mobile friendly editor to write Indian Classical (Hindustani) music notations.

Named after VN Bhatkhande, the scholar who documented thousands of classical Bandishes and developed a notation system (now named after him).

---

# Features


## Taal aware editing

Formats the notation according to Sam/Khaali/Bhaag of the selected Taal.

![Taal aware editing](https://user-images.githubusercontent.com/89076/205581573-f8e80879-1096-44a2-8e91-e2acf182a3d6.gif)

## Multiple notes per beat (e.g dugun /tigun)

Click on the 1/2/3 buttons to enter a single note per beat or 2 (or 3) notes per beat

![Multiple notes per beat](https://user-images.githubusercontent.com/89076/205819071-527642f1-6ec0-4875-b502-a663bf77d63d.gif)

## Show Svaras for the raga selected.

Constrains the  keyboard to show Svaras in the selected Raga

![Raga selection](https://user-images.githubusercontent.com/89076/205825611-b9115d6a-82f2-4db6-ad59-bfe8b1885d61.gif)


## Open source: 

- Open source definitions for ragas and talas. [defined in a separate project](https://github.com/Studio-kalavati/sargam-spec/)


## Support for multiple languages/scripts

Supports multiple languages (English and Devnagri at the moment)

![Switch  languages easily](https://user-images.githubusercontent.com/89076/205581667-11a3d9e3-320d-4a94-884d-bd6a4fedd94c.gif)


## Lyrics assigned to each svara

Type in lyrics that are vertically aligned to each Svara. 
For each bhaag, Click on the gray box below the svaras and enter the lyrics separated by commas.

For example: Teentaal (4 beats in a Bhaag), "Pi,ya,bi,na" will align the 4 Bols to each svara in that Bhaag.


![Bandish lyrics](https://user-images.githubusercontent.com/89076/205826468-00d2b48f-56e2-4ac0-a01d-a6ed8393335a.gif)

--- 

## Get started

There are multiple ways of getting started with the editor:

1. You can use [our Hosted version](https://svaranotations.netlify.app/ "Bhatkhande Bandish Editor").  This is the simplest way to use the editor.
1. Host your own version (documentation TBD)

---

# Technical details

### Implementation 

* Languages
  - Front end is [ClojureScript](https://clojurescript.org/) with ([re-frame](https://github.com/day8/re-frame))
* Dependencies
  - UI framework: [re-frame](https://github.com/day8/re-frame)
  - Client-side routing: [bidi](https://github.com/juxt/bidi) and [pushy](https://github.com/clj-commons/pushy)
  - UI components: [re-com](https://github.com/day8/re-com)
  - Screen breakpoints tool: [BREAKING-POINT](https://github.com/gadfly361/breaking-point)
* Build tools
  - CLJS compilation, dependency management, REPL, & hot reload: [`shadow-cljs`](https://github.com/thheller/shadow-cljs)
* Development tools
  - Debugging: [CLJS DevTools](https://github.com/binaryage/cljs-devtools)
  - Emacs integration: [CIDER](https://github.com/clojure-emacs/cider)


### Environment Setup

1. Install [JDK 8 or later](https://openjdk.java.net/install/) (Java Development Kit)
2. Install [Node.js](https://nodejs.org/) (JavaScript runtime environment) which should include
   [NPM](https://docs.npmjs.com/cli/npm) or if your Node.js installation does not include NPM also install it.
5. Clone this repo and open a terminal in the `bandish-editor` project root directory

### Browser Setup

Browser caching should be disabled when developer tools are open to prevent interference with
[`shadow-cljs`](https://github.com/thheller/shadow-cljs) hot reloading.

Custom formatters must be enabled in the browser before
[CLJS DevTools](https://github.com/binaryage/cljs-devtools) can display ClojureScript data in the
console in a more readable way.

#### Chrome/Chromium

1. Open [DevTools](https://developers.google.com/web/tools/chrome-devtools/) (Linux/Windows: `F12`
or `Ctrl-Shift-I`; macOS: `⌘-Option-I`)
2. Open DevTools Settings (Linux/Windows: `?` or `F1`; macOS: `?` or `Fn+F1`)
3. Select `Preferences` in the navigation menu on the left, if it is not already selected
4. Under the `Network` heading, enable the `Disable cache (while DevTools is open)` option
5. Under the `Console` heading, enable the `Enable custom formatters` option

#### Firefox

1. Open [Developer Tools](https://developer.mozilla.org/en-US/docs/Tools) (Linux/Windows: `F12` or
`Ctrl-Shift-I`; macOS: `⌘-Option-I`)
2. Open [Developer Tools Settings](https://developer.mozilla.org/en-US/docs/Tools/Settings)
(Linux/macOS/Windows: `F1`)
3. Under the `Advanced settings` heading, enable the `Disable HTTP Cache (when toolbox is open)`
option

Unfortunately, Firefox does not yet support custom formatters in their devtools. For updates, follow
the enhancement request in their bug tracker:
[1262914 - Add support for Custom Formatters in devtools](https://bugzilla.mozilla.org/show_bug.cgi?id=1262914).

## Development

### Running the App

Start a temporary local web server, build the app with the `dev` profile, and serve the app,
browser test runner and karma test runner with hot reload:

```sh
npm install
npx shadow-cljs watch app
```

Please be patient; it may take over 20 seconds to see any output, and over 40 seconds to complete.

When `[:app] Build completed` appears in the output, browse to
[http://localhost:8280/](http://localhost:8280/).

Opening the app in your browser starts a
[ClojureScript browser REPL](https://clojurescript.org/reference/repl#using-the-browser-as-an-evaluation-environment),
to which you may now connect.

#### Connecting to the browser REPL from Emacs with CIDER

Connect to the browser REPL:
```
M-x cider-jack-in-cljs
```

See
[Shadow CLJS User's Guide: Emacs/CIDER](https://shadow-cljs.github.io/docs/UsersGuide.html#cider)
for more information. Note that the mentioned [`.dir-locals.el`](.dir-locals.el) file has already
been created for you.

#### Connecting to the browser REPL from VS Code with Calva

See the [re-frame-template README](https://github.com/day8/re-frame-template) for [Calva](https://github.com/BetterThanTomorrow/calva) instuctions. See also https://calva.io for Calva documentation.


#### Connecting to the browser REPL from other editors

See
[Shadow CLJS User's Guide: Editor Integration](https://shadow-cljs.github.io/docs/UsersGuide.html#_editor_integration).
Note that `npm run watch` runs `npx shadow-cljs watch` for you, and that this project's running build ids is
`app`, `browser-test`, `karma-test`, or the keywords `:app`, `:browser-test`, `:karma-test` in a Clojure context.

Alternatively, search the web for info on connecting to a `shadow-cljs` ClojureScript browser REPL
from your editor and configuration.

For example, in Vim / Neovim with `fireplace.vim`
1. Open a `.cljs` file in the project to activate `fireplace.vim`
2. In normal mode, execute the `Piggieback` command with this project's running build id, `:app`:
    ```vim
    :Piggieback :app
    ```

#### Connecting to the browser REPL from a terminal

1. Connect to the `shadow-cljs` nREPL:
    ```sh
    lein repl :connect localhost:8777
    ```
    The REPL prompt, `shadow.user=>`, indicates that is a Clojure REPL, not ClojureScript.

2. In the REPL, switch the session to this project's running build id, `:app`:
    ```clj
    (shadow.cljs.devtools.api/nrepl-select :app)
    ```
    The REPL prompt changes to `cljs.user=>`, indicating that this is now a ClojureScript REPL.
3. See [`user.cljs`](dev/cljs/user.cljs) for symbols that are immediately accessible in the REPL
without needing to `require`.

### Running `shadow-cljs` Actions

See a list of [`shadow-cljs CLI`](https://shadow-cljs.github.io/docs/UsersGuide.html#_command_line)
actions:
```sh
npx shadow-cljs --help
```

Please be patient; it may take over 10 seconds to see any output. Also note that some actions shown
may not actually be supported, outputting "Unknown action." when run.

Run a shadow-cljs action on this project's build id (without the colon, just `app`):
```sh
npx shadow-cljs <action> app
```
### Debug Logging

The `debug?` variable in [`config.cljs`](src/cljs/bhatkhande_svg_viewer/config.cljs) defaults to `true` in
[`dev`](#running-the-app) builds, and `false` in [`prod`](#production) builds.

Use `debug?` for logging or other tasks that should run only on `dev` builds:

```clj
(ns bhatkhande-svg-viewer.example
  (:require [bhatkhande-svg-viewer.config :as config])

(when config/debug?
  (println "This message will appear in the browser console only on dev builds."))
```

## Production

Build the app with the `prod` profile:

```sh
npm install
npm run release
```

Please be patient; it may take over 15 seconds to see any output, and over 30 seconds to complete.

The `resources/public/js/compiled` directory is created, containing the compiled `app.js` and
`manifest.edn` files.

## Cors config for storage

Allow cors request from hosts. See https://cloud.google.com/storage/docs/gsutil/commands/cors#synopsis

`gsutil cors set  cors-config gs://cloudbucket.appspot.com`


