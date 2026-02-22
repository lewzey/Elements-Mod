package net.loos.elementsmod.entity.client;

import net.minecraft.client.render.entity.animation.Animation;
import net.minecraft.client.render.entity.animation.AnimationHelper;
import net.minecraft.client.render.entity.animation.Keyframe;
import net.minecraft.client.render.entity.animation.Transformation;

public class ButterflyAnimations {
    public static final Animation ANIM_BUTTERFLY_IDLE = Animation.Builder.create(1.5F)
            .addBoneAnimation("leftwing", new Transformation(Transformation.Targets.ROTATE,
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
            new Keyframe(0.5F, AnimationHelper.createRotationalVector(2.8936F, 33.7502F, 6.7944F), Transformation.Interpolations.LINEAR),
            new Keyframe(1.0F, AnimationHelper.createRotationalVector(5.4859F, -44.1523F, -30.5237F), Transformation.Interpolations.LINEAR),
            new Keyframe(1.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR)
            ))
            .addBoneAnimation("leftwing", new Transformation(Transformation.Targets.TRANSLATE,
			new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
            new Keyframe(0.5F, AnimationHelper.createTranslationalVector(0.1F, 0.0F, -0.8F), Transformation.Interpolations.LINEAR),
            new Keyframe(1.0F, AnimationHelper.createTranslationalVector(1.9F, -0.6F, -0.4F), Transformation.Interpolations.LINEAR),
            new Keyframe(1.5F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR)
            ))
            .addBoneAnimation("rightwing", new Transformation(Transformation.Targets.ROTATE,
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
            new Keyframe(0.5F, AnimationHelper.createRotationalVector(18.8656F, -47.9572F, -23.5054F), Transformation.Interpolations.LINEAR),
            new Keyframe(1.0F, AnimationHelper.createRotationalVector(5.3948F, 31.4217F, 23.8259F), Transformation.Interpolations.LINEAR),
            new Keyframe(1.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR)
            ))
            .addBoneAnimation("rightwing", new Transformation(Transformation.Targets.TRANSLATE,
			new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
            new Keyframe(0.5F, AnimationHelper.createTranslationalVector(0.4F, -0.3F, -0.3F), Transformation.Interpolations.LINEAR),
            new Keyframe(1.0F, AnimationHelper.createTranslationalVector(-1.4F, -0.3F, 0.9F), Transformation.Interpolations.LINEAR),
            new Keyframe(1.5F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR)
            ))
            .addBoneAnimation("bone", new Transformation(Transformation.Targets.ROTATE,
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
            new Keyframe(0.5F, AnimationHelper.createRotationalVector(7.5F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
            new Keyframe(1.0F, AnimationHelper.createRotationalVector(1.5F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
            new Keyframe(1.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR)
            ))
            .addBoneAnimation("bone", new Transformation(Transformation.Targets.TRANSLATE,
			new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
            new Keyframe(0.5F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 1.0F), Transformation.Interpolations.LINEAR),
            new Keyframe(1.0F, AnimationHelper.createTranslationalVector(0.0F, -1.5F, 0.2F), Transformation.Interpolations.LINEAR),
            new Keyframe(1.5F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR)
            ))
            .build();

    public static final Animation ANIM_BUTTERFLY_FLY = Animation.Builder.create(1.2931F)
            .addBoneAnimation("leftwing", new Transformation(Transformation.Targets.ROTATE,
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
            new Keyframe(0.2155F, AnimationHelper.createRotationalVector(12.6986F, 11.5062F, 14.4922F), Transformation.Interpolations.LINEAR),
            new Keyframe(0.431F, AnimationHelper.createRotationalVector(29.5859F, 15.4562F, 39.2055F), Transformation.Interpolations.LINEAR),
            new Keyframe(0.5747F, AnimationHelper.createRotationalVector(13.2885F, 5.5169F, 14.9167F), Transformation.Interpolations.LINEAR),
            new Keyframe(0.6825F, AnimationHelper.createRotationalVector(8.4271F, -10.2076F, 1.286F), Transformation.Interpolations.LINEAR),
            new Keyframe(0.8621F, AnimationHelper.createRotationalVector(31.7085F, -46.3741F, -39.3927F), Transformation.Interpolations.LINEAR),
            new Keyframe(1.2931F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR)
            ))
            .addBoneAnimation("leftwing", new Transformation(Transformation.Targets.TRANSLATE,
			new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
            new Keyframe(0.431F, AnimationHelper.createTranslationalVector(-1.4F, 0.0F, 2.3F), Transformation.Interpolations.LINEAR),
            new Keyframe(0.6825F, AnimationHelper.createTranslationalVector(-0.2F, -0.35F, 0.72F), Transformation.Interpolations.LINEAR),
            new Keyframe(0.8621F, AnimationHelper.createTranslationalVector(-0.2F, -0.6F, -0.4F), Transformation.Interpolations.LINEAR),
            new Keyframe(1.2931F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR)
            ))
            .addBoneAnimation("rightwing", new Transformation(Transformation.Targets.ROTATE,
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
            new Keyframe(0.2155F, AnimationHelper.createRotationalVector(11.1368F, -7.5505F, -11.7891F), Transformation.Interpolations.LINEAR),
            new Keyframe(0.431F, AnimationHelper.createRotationalVector(27.6925F, -3.8495F, -36.1817F), Transformation.Interpolations.LINEAR),
            new Keyframe(0.5747F, AnimationHelper.createRotationalVector(7.3035F, 10.0404F, -9.39F), Transformation.Interpolations.LINEAR),
            new Keyframe(0.6825F, AnimationHelper.createRotationalVector(-4.9501F, 28.3891F, 3.1808F), Transformation.Interpolations.LINEAR),
            new Keyframe(0.8621F, AnimationHelper.createRotationalVector(12.8767F, 51.4167F, 31.2969F), Transformation.Interpolations.LINEAR),
            new Keyframe(1.2931F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR)
            ))
            .addBoneAnimation("rightwing", new Transformation(Transformation.Targets.TRANSLATE,
			new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
            new Keyframe(0.431F, AnimationHelper.createTranslationalVector(1.4F, -0.3F, 2.5F), Transformation.Interpolations.LINEAR),
            new Keyframe(0.8621F, AnimationHelper.createTranslationalVector(0.6F, -0.6F, -0.7F), Transformation.Interpolations.LINEAR),
            new Keyframe(1.2931F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR)
            ))
            .addBoneAnimation("bone", new Transformation(Transformation.Targets.ROTATE,
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
            new Keyframe(0.431F, AnimationHelper.createRotationalVector(7.5F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
            new Keyframe(0.8621F, AnimationHelper.createRotationalVector(1.5F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
            new Keyframe(1.2931F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR)
            ))
            .addBoneAnimation("bone", new Transformation(Transformation.Targets.TRANSLATE,
			new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
            new Keyframe(0.431F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 1.0F), Transformation.Interpolations.LINEAR),
            new Keyframe(0.8621F, AnimationHelper.createTranslationalVector(0.0F, -1.5F, 0.2F), Transformation.Interpolations.LINEAR),
            new Keyframe(1.2931F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR)
            ))
            .build();
}
