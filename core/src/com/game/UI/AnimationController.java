package com.game.UI;

import com.badlogic.gdx.math.Interpolation;
import com.game.Actors.MyActor;
import static com.badlogic.gdx.scenes.scene2d.actions.Actions.moveTo;
import static com.badlogic.gdx.scenes.scene2d.actions.Actions.parallel;
import static com.badlogic.gdx.scenes.scene2d.actions.Actions.scaleBy;
import static com.badlogic.gdx.scenes.scene2d.actions.Actions.sequence;


public class AnimationController {

    private static MyActor attackedActor, attackingActor;

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

        float ATTACK_TIME=1.0f;
        float ATTACK_SCALE_MODIFICATOR=20.0f;

        float xTo = attackedActor.getX();
        float yTo = attackedActor.getY();
        float xFrom = attackingActor.getX();
        float yFrom = attackingActor.getY();

        attackingActor.addAction(
                sequence(
                        parallel(
                                moveTo (xTo, yTo, ATTACK_TIME, Interpolation.pow5),
                                scaleBy (ATTACK_SCALE_MODIFICATOR, ATTACK_SCALE_MODIFICATOR,ATTACK_TIME/2,Interpolation.pow5 )
                                ),
                        parallel(
                                moveTo (xFrom, yFrom, ATTACK_TIME, Interpolation.pow5),
                                scaleBy (-ATTACK_SCALE_MODIFICATOR, -ATTACK_SCALE_MODIFICATOR,ATTACK_TIME/2,Interpolation.pow5 )
                        )
                )
        );
    }
}

