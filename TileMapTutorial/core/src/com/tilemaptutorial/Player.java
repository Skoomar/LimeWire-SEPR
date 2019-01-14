package com.tilemaptutorial;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.math.Vector2;

import java.awt.event.KeyEvent;

public class Player extends Sprite implements InputProcessor {

    // movement velocity
    private Vector2 velocity = new Vector2();

    private float speed = 120, speed_fast = 240, gravity = 60 * 1.8f;

    private TiledMapTileLayer collisionLayer;

    private boolean canJump = false;


    public Player(Sprite sprite, TiledMapTileLayer collisionLayer) {
        super(sprite);
        this.collisionLayer = collisionLayer;
    }

    @Override
    public void draw(Batch batch) {
        update(Gdx.graphics.getDeltaTime());
        super.draw(batch);
    }

    public void update(float delta) {
        // apply gravity
        //velocity.y -= gravity * delta;

        // limit velocity
        if (velocity.y > speed) {
            velocity.y = speed;
        } else if (velocity.y < -speed) {
            velocity.y = -speed;
        }

        // save old position
        float oldX = getX(), oldY = getY(), tileWidth = collisionLayer.getTileWidth(),
                tileHeight = collisionLayer.getTileHeight();
        boolean collisionX = false, collisionY = false;

        // move on x
        setX(getX() + velocity.x * delta);

        /*
        if (velocity.x < 0) {
            // top left

            // middle left
            collisionX = collisionLayer.getCell((int) (getX() / tileWidth), (int) ((getY() + getHeight() / 2) / tileHeight))
                    .getTile().getProperties().containsKey("Blocked");

            // bottom left

        } else if (velocity.x > 0) {
            // top right

            // middle right
            collisionX = collisionLayer.getCell((int) ((getX() + getWidth()) / tileHeight), (int) ((getY() + getWidth() / 2) / tileHeight))
                    .getTile().getProperties().containsKey("Blocked");

            // bottom right
        }
        */

        // move on y
        setY(getY() + velocity.y * delta);

        /*
        if (velocity.y < 0) {

        } else if (velocity.y > 0) {

        }
        */
    }


    @Override
    public boolean keyDown(int keycode) {

        switch (keycode) {
            case Input.Keys.W:
                //if (canJump) {
                    velocity.y = speed;
                  //  canJump = false;
                //}
                break;
            case Input.Keys.A:
                velocity.x = -speed;
                break;
            case Input.Keys.D:
                velocity.x = speed;
                break;
            case Input.Keys.S:
                velocity.y = -speed;
                break;
        }

        return true;
    }

    @Override
    public boolean keyUp(int keycode) {
       /*if (keycode == Input.Keys.LEFT || keycode == Input.Keys.RIGHT) {
           velocity.x = 0;
       }*/
        if (keycode == Input.Keys.CONTROL_LEFT) {
            speed = 120;
        }

        switch (keycode) {
            case Input.Keys.A:
            case Input.Keys.D:
                velocity.x = 0;
                break;
            case Input.Keys.W:
            case Input.Keys.S:
                velocity.y = 0;
                break;
        }

        return true;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }
}
