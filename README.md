# clj

[Spec docs](https://clojure.org/guides/spec)
[lang cheatsheet](https://learnxinyminutes.com/clojure)

## Setup

#### Prerequisite

```sh
brew install leiningen
git clone git@github.com:codethread/clojure-spec-playground.git
```

More info at:

- https://leiningen.org/
- https://leiningen.org/tutorial.html

#### Running

```sh
cd clojure-spec-playground
lein repl
# inside repl, import the namespace with reload
# for simplicity just write code that runs in `core.clj` and re-run:
$ (use 'clj.core :reload)
```

## License

Copyright © 2025 FIXME

This program and the accompanying materials are made available under the
terms of the Eclipse Public License 2.0 which is available at
http://www.eclipse.org/legal/epl-2.0.

This Source Code may also be made available under the following Secondary
Licenses when the conditions for such availability set forth in the Eclipse
Public License, v. 2.0 are satisfied: GNU General Public License as published by
the Free Software Foundation, either version 2 of the License, or (at your
option) any later version, with the GNU Classpath Exception which is available
at https://www.gnu.org/software/classpath/license.html.
