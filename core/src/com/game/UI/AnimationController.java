package com.game.UI;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Interpolation;
import com.game.Actors.MyActor;
import com.game.Main.AssetLoader;
import static com.badlogic.gdx.scenes.scene2d.actions.Actions.moveTo;
import static com.badlogic.gdx.scenes.scene2d.actions.Actions.parallel;
import static com.badlogic.gdx.scenes.scene2d.actions.Actions.sequence;

public class AnimationController {

    private static MyActor attackedActor, attackingActor;
    public final static float ATTACK_TIME = 0.3f;

    public static boolean isAttackAnimationPlanned(){
        return (attackedActor!=null);
    }

    public static void setAttackedActor (MyActor atkedActor){
        attackedActor = atkedActor;
    }

    public static void setAttackingActor (MyActor atkingActor){
        attackingActor = atkingActor;
    }

    public static void playAttackAnimation () {

        float xTo = attackedActor.getX();
        float yTo = attackedActor.getY();
        float xFrom = attackingActor.getX();
        float yFrom = attackingActor.getY();
        // cell with calculation
        final int FIELD_SIZE_X = 5;
        float paddingsXWidth = (Gdx.graphics.getWidth()/16);
        float cellWidth = (Gdx.graphics.getWidth()-2*paddingsXWidth)/FIELD_SIZE_X;
        float xCenterTo = attackedActor.getX()+ cellWidth/2;
        float yCenterTo = attackedActor.getY()+ cellWidth/2;
        attackingActor.addAction(
                sequence(
                        parallel(
                                moveTo(xTo, yTo, ATTACK_TIME, Interpolation.pow5)
                                //scaleBy (ATTACK_SCALE_MODIFICATOR, ATTACK_SCALE_MODIFICATOR,ATTACK_TIME/2,Interpolation.pow5 )
                        ),
                        parallel(
                                moveTo(xFrom, yFrom, ATTACK_TIME, Interpolation.pow5)
                                //scaleBy (-ATTACK_SCALE_MODIFICATOR, -ATTACK_SCALE_MODIFICATOR,ATTACK_TIME/2,Interpolation.pow5 )
                        )
                )
        );
        AssetLoader.startAttackEffect(xCenterTo, yCenterTo);

    }
}

