package com.g2forge.enigma.web.html;

import org.junit.Assert;
import org.junit.Test;

import com.g2forge.alexandria.java.core.resource.HResource;
import com.g2forge.enigma.web.css.Block;
import com.g2forge.enigma.web.css.color.Color;
import com.g2forge.enigma.web.css.drawing.Fill;
import com.g2forge.enigma.web.css.drawing.Stroke;
import com.g2forge.enigma.web.css.drawing.StrokeWidth;
import com.g2forge.enigma.web.css.text.DominantBaseline;
import com.g2forge.enigma.web.css.text.TextAnchor;
import com.g2forge.enigma.web.html.convert.HTMLRenderer;
import com.g2forge.enigma.web.html.html.Body;
import com.g2forge.enigma.web.html.html.HTML;
import com.g2forge.enigma.web.html.svg.Group;
import com.g2forge.enigma.web.html.svg.Rectangle;
import com.g2forge.enigma.web.html.svg.SVG;
import com.g2forge.enigma.web.html.svg.Text;

public class TestSVG {
	@Test
	public void test() {
		final Text text = new Text(50, 10, new Block(DominantBaseline.Central, TextAnchor.Middle), "Text");
		final Rectangle rectangle = new Rectangle(0, 0, 100, 20, new Block(new Fill(new Color(255, 255, 255)), new StrokeWidth(1), new Stroke(new Color(0, 0, 0))));
		final SVG svg = new SVG(200, 200, new Group(rectangle, text));
		final String actual = new HTMLRenderer().render(new HTML(null, new Body(svg)));
		Assert.assertEquals(HResource.read(getClass(), "svg.html", true), actual);
	}
}
