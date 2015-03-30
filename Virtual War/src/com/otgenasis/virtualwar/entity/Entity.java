package com.otgenasis.virtualwar.entity;

import com.otgenasis.virtualwar.plateau.Plateau;
import com.otgenasis.virtualwar.position.Position;
import com.otgenasis.virtualwar.texture.Texture;

public abstract class Entity {
	
	protected Texture texture;
	protected Position position;
	protected Plateau plateau;
	
	public Entity(Texture texture, Position position) {
		this.texture = texture;
		this.position = position;
	}

}
