package com.g2forge.enigma.stringtemplate;

import java.util.function.Function;

import com.g2forge.alexandria.adt.associative.cache.Cache;
import com.g2forge.alexandria.adt.associative.cache.LRUCacheEvictionPolicy;
import com.g2forge.alexandria.reflection.record.v2.reflection.ReflectedRecordType;

public class EmbeddedTemplateRenderer {
	public final static EmbeddedTemplateRenderer DEFAULT = new EmbeddedTemplateRenderer();

	public final static EmbeddedTemplateRenderer STRING = new EmbeddedTemplateRenderer("\n");

	public static String toString(Object object) {
		return DEFAULT.render(object);
	}

	protected final STGroupJava group;

	public EmbeddedTemplateRenderer() {
		this(System.lineSeparator());
	}

	protected EmbeddedTemplateRenderer(char delimiterStartChar, char delimiterStopChar, String lineSeparator, Function<? super Object, ? extends Object> adapter) {
		this.group = new STGroupJava("UTF-8", delimiterStartChar, delimiterStopChar, lineSeparator, adapter, new Cache<>(ReflectedRecordType::new, new LRUCacheEvictionPolicy<>(30)));
	}

	public EmbeddedTemplateRenderer(String lineSeparator) {
		this(lineSeparator, null);
	}

	public EmbeddedTemplateRenderer(String lineSeparator, Function<? super Object, ? extends Object> adapter) {
		this('<', '>', lineSeparator, adapter);
	}

	public String render(Object object) {
		return group.render(object);
	}
}
