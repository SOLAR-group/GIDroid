package acr.browser.lightning.html.jsoup;

import java.lang.System;

@kotlin.Suppress(names = {"NOTHING_TO_INLINE"})
@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 2, d1 = {"\u0000.\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\u001a\u0011\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0086\b\u001a\u0015\u0010\u0004\u001a\u00020\u0005*\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0003H\u0086\b\u001a&\u0010\b\u001a\u00020\u0003*\u00020\u00012\u0017\u0010\t\u001a\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00050\n\u00a2\u0006\u0002\b\u000bH\u0086\u0004\u001a)\u0010\f\u001a\u00020\u0005*\u00020\u00012\u0017\u0010\t\u001a\u0013\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00050\n\u00a2\u0006\u0002\b\u000bH\u0086\b\u00f8\u0001\u0000\u001a\u001e\u0010\r\u001a\u00020\u0005*\u00020\u00012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\u000eH\u0086\b\u00f8\u0001\u0000\u001a)\u0010\u000f\u001a\u00020\u0006*\u00020\u00062\u0017\u0010\u0010\u001a\u0013\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00050\n\u00a2\u0006\u0002\b\u000bH\u0086\b\u00f8\u0001\u0000\u001a=\u0010\u0011\u001a\u00020\u0005*\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00032\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00032\u0017\u0010\t\u001a\u0013\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00050\n\u00a2\u0006\u0002\b\u000bH\u0086\b\u00f8\u0001\u0000\u001a\u0015\u0010\u0013\u001a\u00020\u0006*\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u0003H\u0086\b\u001a1\u0010\u0013\u001a\u00020\u0006*\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u00032\u0017\u0010\t\u001a\u0013\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00050\n\u00a2\u0006\u0002\b\u000bH\u0086\b\u00f8\u0001\u0000\u001a\u0015\u0010\u0014\u001a\u00020\u0005*\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0003H\u0086\b\u001a=\u0010\u0016\u001a\u00020\u0005*\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00032\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00032\u0017\u0010\t\u001a\u0013\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00050\n\u00a2\u0006\u0002\b\u000bH\u0086\b\u00f8\u0001\u0000\u001a\r\u0010\u0017\u001a\u00020\u0006*\u00020\u0006H\u0086\b\u001a$\u0010\u0018\u001a\u00020\u0005*\u00020\u00012\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\nH\u0086\b\u00f8\u0001\u0000\u001a1\u0010\u001a\u001a\u00020\u0006*\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u00032\u0017\u0010\t\u001a\u0013\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00050\n\u00a2\u0006\u0002\b\u000bH\u0086\b\u00f8\u0001\u0000\u001a\u001e\u0010\u001b\u001a\u00020\u0005*\u00020\u00012\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00030\u000eH\u0086\b\u00f8\u0001\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001\u00a8\u0006\u001d"}, d2 = {"parse", "Lorg/jsoup/nodes/Document;", "string", "", "a", "", "Lorg/jsoup/nodes/Element;", "href", "andBuild", "build", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "body", "charset", "Lkotlin/Function0;", "clone", "edit", "div", "clazz", "id", "img", "src", "p", "removeElement", "style", "mutate", "tag", "title", "provide", "app_lightningPlusDebug"})
public final class JsoupExtensionsKt {
    
    @org.jetbrains.annotations.NotNull()
    public static final org.jsoup.nodes.Document parse(@org.jetbrains.annotations.NotNull()
    java.lang.String string) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String andBuild(@org.jetbrains.annotations.NotNull()
    org.jsoup.nodes.Document $this$andBuild, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super org.jsoup.nodes.Document, kotlin.Unit> build) {
        return null;
    }
    
    public static final void title(@org.jetbrains.annotations.NotNull()
    org.jsoup.nodes.Document $this$title, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<java.lang.String> provide) {
    }
    
    public static final void style(@org.jetbrains.annotations.NotNull()
    org.jsoup.nodes.Document $this$style, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.String, java.lang.String> mutate) {
    }
    
    public static final void body(@org.jetbrains.annotations.NotNull()
    org.jsoup.nodes.Document $this$body, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super org.jsoup.nodes.Element, kotlin.Unit> build) {
    }
    
    public static final void charset(@org.jetbrains.annotations.NotNull()
    org.jsoup.nodes.Document $this$charset, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<java.lang.String> charset) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final org.jsoup.nodes.Element tag(@org.jetbrains.annotations.NotNull()
    org.jsoup.nodes.Element $this$tag, @org.jetbrains.annotations.NotNull()
    java.lang.String tag, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super org.jsoup.nodes.Element, kotlin.Unit> build) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final org.jsoup.nodes.Element clone(@org.jetbrains.annotations.NotNull()
    org.jsoup.nodes.Element $this$clone, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super org.jsoup.nodes.Element, kotlin.Unit> edit) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final org.jsoup.nodes.Element id(@org.jetbrains.annotations.NotNull()
    org.jsoup.nodes.Element $this$id, @org.jetbrains.annotations.NotNull()
    java.lang.String string, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super org.jsoup.nodes.Element, kotlin.Unit> build) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final org.jsoup.nodes.Element id(@org.jetbrains.annotations.NotNull()
    org.jsoup.nodes.Element $this$id, @org.jetbrains.annotations.NotNull()
    java.lang.String string) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final org.jsoup.nodes.Element removeElement(@org.jetbrains.annotations.NotNull()
    org.jsoup.nodes.Element $this$removeElement) {
        return null;
    }
    
    public static final void div(@org.jetbrains.annotations.NotNull()
    org.jsoup.nodes.Element $this$div, @org.jetbrains.annotations.NotNull()
    java.lang.String clazz, @org.jetbrains.annotations.Nullable()
    java.lang.String id, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super org.jsoup.nodes.Element, kotlin.Unit> build) {
    }
    
    public static final void a(@org.jetbrains.annotations.NotNull()
    org.jsoup.nodes.Element $this$a, @org.jetbrains.annotations.NotNull()
    java.lang.String href) {
    }
    
    public static final void img(@org.jetbrains.annotations.NotNull()
    org.jsoup.nodes.Element $this$img, @org.jetbrains.annotations.NotNull()
    java.lang.String src) {
    }
    
    public static final void p(@org.jetbrains.annotations.NotNull()
    org.jsoup.nodes.Element $this$p, @org.jetbrains.annotations.NotNull()
    java.lang.String clazz, @org.jetbrains.annotations.Nullable()
    java.lang.String id, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super org.jsoup.nodes.Element, kotlin.Unit> build) {
    }
}