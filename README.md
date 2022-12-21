# sbp-idea

Available on the [JetBrains Marketplace](https://plugins.jetbrains.com/plugin/20722-sbp)

JetBrains plugin of Swift Binary Protocol, refer to [libsbp](https://github.com/swift-nav/libsbp/tree/master/java)

Covers underlying binary file type `.sbp`, decompiling file into human readable JSON format.

Unexplored ideas:

- Override PsiFile (?)
    - Maybe editable file type, convert underlying (sbp -> json -> pri plain txt) recompilation occurs on a popup button
      or second window for live
    - Add features to search structs, different UI sbp viewer instead of json, maybe queries 

- Too bad we create a new byte[] array everytime for driver (maybe not big performance? stack kept small?),
    - maybe use FFI for interop (?) have rust -> C / C++, call with JDK19 using Project Panama
    - just call rust sbp2json

![after.png](images/after.png)
