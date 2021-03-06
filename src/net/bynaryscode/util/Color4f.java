/* <LICENSE>
Copyright (C) 2015-2016 Louis JEAN

This file is part of BynarysCode.

BynarysCode is free software: you can redistribute it and/or modify
it under the terms of the GNU Lesser General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

BynarysCode is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU Lesser General Public License for more details.

You should have received a copy of the GNU Lesser General Public License
along with BynarysCode. If not, see <http://www.gnu.org/licenses/>.
 </LICENSE> */

package net.bynaryscode.util;

import net.bynaryscode.util.maths.MathUtil;

public class Color4f implements Cloneable {
	
	public static final Color4f BLACK = new Color4f(0, 0, 0);
	public static final Color4f WHITE = new Color4f(255, 255, 255);
	public static final Color4f GREEN = new Color4f(0, 255, 0);
	public static final Color4f RED = new Color4f(255, 0, 0);
	public static final Color4f BLUE = new Color4f(0, 0, 255);
	
	private float r;
	private float g;
	private float b;
	private float a;
	
	/** Cr�e une nouvelle couleur. Par d�faut, la couleur blanche. */
	public Color4f() {
		this(1f, 1f, 1f, 1f);
	}
	
	public Color4f(float r, float g, float b) {
		this(r, g, b, 1f);
	}
	
	public Color4f(int r, int g, int b) {
		this(r, g, b, 255);
	}
	
	public Color4f(float r, float g, float b, float a) {
		this.r = MathUtil.clampf(r, 0f, 1f);
		this.g = MathUtil.clampf(g, 0f, 1f);
		this.b = MathUtil.clampf(b, 0f, 1f);
		this.a = MathUtil.clampf(a, 0f, 1f);
	}
	
	public Color4f(int r, int g, int b, int a) {
		float ri = MathUtil.clampi(r, 0, 255);
		float gi = MathUtil.clampi(g, 0, 255);
		float bi = MathUtil.clampi(b, 0, 255);
		float ai = MathUtil.clampi(a, 0, 255);
		
		this.r = ri / 255f;
		this.g = gi / 255f;
		this.b = bi / 255f;
		this.a = ai / 255f;
	}

	public float getRedf() {
		return r;
	}
	
	public int getRed() {
		return (int) (r * 255);
	}

	public void setRedf(float r) {
		if (MathUtil.valueIn(r, 0, 1, true))
			this.r = r;
	}

	public float getGreenf() {
		return g;
	}
	
	public int getGreen() {
		return (int) (g * 255);
	}

	public void setGreenf(float g) {
		if (MathUtil.valueIn(g, 0, 1, true))
			this.g = g;
	}

	public float getBluef() {
		return b;
	}
	
	public int getBlue() {
		return (int) (b * 255);
	}

	public void setBluef(float b) {
		if (MathUtil.valueIn(b, 0, 1, true))
			this.b = b;
	}

	public float getAlphaf() {
		return a;
	}
	
	public int getAlpha() {
		return (int) (a * 255);
	}

	public void setAlphaf(float a) {
		if (MathUtil.valueIn(a, 0, 1, true))
			this.a = a;
	}
	
	public Color4f withAlphaf(float a) {
		setAlphaf(a);
		return this;
	}
	
	public Color4f multiply(Color4f color) {
		return multiply(color.r, color.g, color.b, color.a);
	}
	
	public Color4f multiply(float r, float g, float b, float a) {
		return new Color4f(this.r * r, this.g * g, this.b * b, this.a * a);
	}
	
	public Color4f multiply(float coef) {
		return new Color4f(r * coef, g * coef, b * coef,  a * coef);
	}
	
	@Override
	public Color4f clone() {
		Color4f result = null;
		try {
			result = (Color4f) super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	@Override
	public boolean equals(Object o) {
		if (o == null || !(o instanceof Color4f)) return false;
		
		Color4f c = (Color4f) o;
		if (c == this) return true;
		
		if (	this.r != c.r
				|| this.g != c.g
				|| this.b != c.b
				|| this.a != c.a)
			
			return false;
		
		
		return true;
	}
}
