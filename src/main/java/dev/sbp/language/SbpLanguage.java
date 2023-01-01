package dev.sbp.language;

import com.intellij.lang.Language;

public class SbpLanguage extends Language {

    public static final SbpLanguage INSTANCE = new SbpLanguage();

    public SbpLanguage() {
        super("sbp");
    }
}
