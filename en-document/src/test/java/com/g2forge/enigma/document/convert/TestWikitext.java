package com.g2forge.enigma.document.convert;

import org.junit.Assert;
import org.junit.Test;

import com.g2forge.enigma.document.Block;
import com.g2forge.enigma.document.Emphasis;
import com.g2forge.enigma.document.IDocElement;
import com.g2forge.enigma.document.Section;
import com.g2forge.enigma.document.Text;
import com.g2forge.enigma.document.convert.md.MDRenderer;

public class TestWikitext {
	protected final MDRenderer renderer = new MDRenderer();

	protected final WikitextParser parser = WikitextParser.getMarkdown();

	@Test
	public void emphasis() {
		final String text = "*Text*";
		final IDocElement dom = Block.builder().type(Block.Type.Document).content(Block.builder().type(Block.Type.Paragraph).content(new Emphasis(Emphasis.Type.Emphasis, new Text("Text"))).build()).build();

		Assert.assertEquals(dom, parser.parse(text));
		Assert.assertEquals(text, renderer.render(dom));
	}

	@Test
	public void section() {
		final String text = "# Section\n\nContent";
		final IDocElement dom = Block.builder().type(Block.Type.Document).content(Section.builder().title(new Text("Section")).body(Block.builder().type(Block.Type.Paragraph).content(new Text("Content")).build()).build()).build();

		Assert.assertEquals(dom, parser.parse(text));
		Assert.assertEquals(text, renderer.render(dom));
	}

	@Test
	public void section2() {
		final String text = "# Section\n\n## Subsection\n\nContent";
		final IDocElement dom = Block.builder().type(Block.Type.Document).content(Section.builder().title(new Text("Section")).body(Section.builder().title(new Text("Subsection")).body(Block.builder().type(Block.Type.Paragraph).content(new Text("Content")).build()).build()).build()).build();

		Assert.assertEquals(dom, parser.parse(text));
		Assert.assertEquals(text, renderer.render(dom));
	}

	@Test
	public void text() {
		final String text = "Text";
		final IDocElement dom = Block.builder().type(Block.Type.Document).content(Block.builder().type(Block.Type.Paragraph).content(new Text(text)).build()).build();

		Assert.assertEquals(dom, parser.parse(text));
		Assert.assertEquals(text, renderer.render(dom));
	}
}
