package com.gxiv.mario.Tools;

import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.*;
import com.badlogic.gdx.utils.Array;
import com.gxiv.mario.MarioBros;
import com.gxiv.mario.Screen.PlayScreen;
import com.gxiv.mario.Sprites.Brick;
import com.gxiv.mario.Sprites.Coin;
import com.gxiv.mario.Sprites.Goomba;
import com.gxiv.mario.Sprites.Mario;

public class B2WorldCreator {
    private Array<Goomba> goombas;
    public B2WorldCreator(PlayScreen screen){
        BodyDef bdef = new BodyDef();
        PolygonShape shape = new PolygonShape();
        FixtureDef fdef = new FixtureDef();
        Body body;
        World world = screen.getWorld();
        TiledMap map = screen.getMap();

        //create ground fixed body
        for(RectangleMapObject object: map.getLayers().get(3).getObjects().getByType(RectangleMapObject.class)){
            Rectangle rect = object.getRectangle();
            bdef.type = BodyDef.BodyType.StaticBody;
            bdef.position.set((rect.getX() + rect.getWidth() / 2) / MarioBros.PPM, (rect.getY() + rect.getHeight() / 2) / MarioBros.PPM);
            body = world.createBody(bdef);
            shape.setAsBox((rect.getWidth() /2) / MarioBros.PPM, (rect.getHeight() /2) / MarioBros.PPM);
            fdef.shape = shape;
            body.createFixture(fdef);
        }
        //create pipe fixed body
        for(RectangleMapObject object: map.getLayers().get(4).getObjects().getByType(RectangleMapObject.class)){
            Rectangle rect = object.getRectangle();
            bdef.type = BodyDef.BodyType.StaticBody;
            bdef.position.set((rect.getX() + rect.getWidth() / 2) / MarioBros.PPM, (rect.getY() + rect.getHeight() / 2) / MarioBros.PPM);
            body = world.createBody(bdef);
            shape.setAsBox((rect.getWidth() /2) / MarioBros.PPM, (rect.getHeight() /2) / MarioBros.PPM);
            fdef.shape = shape;
            fdef.filter.categoryBits = MarioBros.OBJECT_BIT;
            body.createFixture(fdef);
        }
        //create brick fixed body
//        for(RectangleMapObject object: map.getLayers().get(2).getObjects().getByType(RectangleMapObject.class)){
//            Rectangle rect = object.getRectangle();
//
//            new Brick(screen, object);
//        }
//        //create coin fixed body
//        for(RectangleMapObject object: map.getLayers().get(3).getObjects().getByType(RectangleMapObject.class)) {
//            new Coin(screen, object);
//        }

        //goomba
//        goombas = new Array<Goomba>();
//        for(RectangleMapObject object: map.getLayers().get(6).getObjects().getByType(RectangleMapObject.class)) {
//            Rectangle rect = object.getRectangle();
//            goombas.add(new Goomba(screen, rect.getX() / MarioBros.PPM, rect.getY() / MarioBros.PPM));
//        }
    }

//    public Array<Goomba> getGoombas() {
//        return goombas;
//    }
}
