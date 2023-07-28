package acr.browser.lightning.adblock.parser;

import java.lang.System;

/**
 * A single threaded parser for a hosts file.
 */
@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\b\u0002\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000b\u001a\u00020\f\u00f8\u0001\u0000J!\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\n0\u0012H\u0002\u00f8\u0001\u0000R\u0012\u0010\u0005\u001a\u00060\u0006j\u0002`\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0014"}, d2 = {"Lacr/browser/lightning/adblock/parser/HostsFileParser;", "", "logger", "Lacr/browser/lightning/log/Logger;", "(Lacr/browser/lightning/log/Logger;)V", "lineBuilder", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "parseInput", "", "Lacr/browser/lightning/database/adblock/Host;", "input", "Ljava/io/InputStreamReader;", "parseLine", "", "line", "", "parsedList", "", "Companion", "app_lightningLiteDebug"})
public final class HostsFileParser {
    private final java.lang.StringBuilder lineBuilder = null;
    private final acr.browser.lightning.log.Logger logger = null;
    private static final java.lang.String TAG = "HostsFileParser";
    private static final java.lang.String LOCAL_IP_V4 = "127.0.0.1";
    private static final java.lang.String LOCAL_IP_V4_ALT = "0.0.0.0";
    private static final java.lang.String LOCAL_IP_V6 = "::1";
    private static final java.lang.String LOCALHOST = "localhost";
    private static final char COMMENT_CHAR = '#';
    private static final char TAB_CHAR = '\t';
    private static final char SPACE_CHAR = ' ';
    private static final java.lang.String EMPTY = "";
    @org.jetbrains.annotations.NotNull()
    public static final acr.browser.lightning.adblock.parser.HostsFileParser.Companion Companion = null;
    
    /**
     * Parse the lines of the [input] from a hosts file and return the list of [String] domains held
     * in that file.
     */
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<acr.browser.lightning.database.adblock.Host> parseInput(@org.jetbrains.annotations.NotNull()
    java.io.InputStreamReader input) {
        return null;
    }
    
    /**
     * Parse a [line] from a hosts file and populate the [parsedList] with the extracted hosts.
     */
    private final void parseLine(java.lang.String line, java.util.List<acr.browser.lightning.database.adblock.Host> parsedList) {
    }
    
    @javax.inject.Inject()
    public HostsFileParser(@org.jetbrains.annotations.NotNull()
    acr.browser.lightning.log.Logger logger) {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\f\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0006X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000e"}, d2 = {"Lacr/browser/lightning/adblock/parser/HostsFileParser$Companion;", "", "()V", "COMMENT_CHAR", "", "EMPTY", "", "LOCALHOST", "LOCAL_IP_V4", "LOCAL_IP_V4_ALT", "LOCAL_IP_V6", "SPACE_CHAR", "TAB_CHAR", "TAG", "app_lightningLiteDebug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}