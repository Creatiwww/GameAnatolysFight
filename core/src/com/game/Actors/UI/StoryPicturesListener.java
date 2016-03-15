package com.game.Actors.UI;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.DragListener;

public class StoryPicturesListener extends DragListener {
    private StoryPictures draggedActor;

    public StoryPicturesListener(StoryPictures draggedActor) {
        this.draggedActor = draggedActor;
    }

    @Override
    public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
        super.touchDown(event, x, y, pointer, button);
        return true;
    }

    @Override
    public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
        super.touchUp(event, x, y, pointer, button);
        draggedActor.remove();
    }

    @Override
    public void drag (InputEvent event, float x, float y, int pointer) {
        y = y - draggedActor.getWidth() / 2;
        x = x - draggedActor.getHeight() / 2;
        draggedActor.moveBy(x, y);
    }
}
