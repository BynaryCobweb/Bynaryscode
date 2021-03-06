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

package net.bynaryscode.util.maths.geometric;

import java.io.Serializable;

public class Vec2d extends Vec2 implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	public double x;
	public double y;
	
	public Vec2d(){
		x = 0;
		y = 0;
	}
	
	public Vec2d(double x, double y){
		this.x = x;
		this.y = y;
	}
	
	public double getDistance(Vec2 c) {
		Vec2d other = c.asDouble();
		return Math.sqrt(Math.pow(this.x - other.x, 2) + Math.pow(this.y - other.y, 2));
	}
	
	public void translate(double x, double y) {
		this.x += x;
		this.y += y;
	}
	
	@Override
	public Vec2d clone(){
		return (Vec2d) super.clone();
	}
	
	@Override
	public String toString() {
		return "(" + x + "; " + y + ")";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		long temp;
		temp = Double.doubleToLongBits(x);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(y);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == null) return false;
		if (obj.getClass() != this.getClass()) return false;
		
		Vec2d other = (Vec2d) obj;
		
		return Double.doubleToLongBits(x) == Double.doubleToLongBits(other.x) && 
				Double.doubleToLongBits(y) == Double.doubleToLongBits(other.y);
	}
	
	@Override
	public Vec2i asInteger() {
		return new Vec2i((int) x, (int) y);
	}
	
	@Override
	public Vec2f asFloat() {
		return new Vec2f((float) x, (float) y);
	}
	
	@Override
	public Vec2d asDouble() {
		return this.clone();
	}
}