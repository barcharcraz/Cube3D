package com.charlie.Graphics.engine;
/**
 * Class Game represents a video game with a window and event handling logic
 * @author Charlie
 *
 */
public class Game extends GraphicsApplication {
	
	public Game() {
		super();
		addInputListener(new GameInputListener());
	}
	public Game(GraphicsPane panel) {
		super(panel);
		addInputListener(new GameInputListener());
		((GameInputListener) input).setCamera(cam);
	}
	@Override
	protected void render() {
		super.render();
		renderTarget.setViewMatrix(cam.getViewMatrix());
	}

}
