package com.barlinc.seafarer.client.particles;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.*;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.util.Mth;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class VolcanicSmokeParticle extends TextureSheetParticle {

    VolcanicSmokeParticle(ClientLevel level, double x, double y, double z, double motionX, double motionY, double motionZ) {
        super(level, x, y, z);
        this.setSize(0.5F, 0.5F);
        this.quadSize = 1.0F + level.random.nextFloat() * 0.3F;
        this.lifetime = this.random.nextInt(50) + 300;
        this.gravity = 3.0E-6F;
        this.xd = motionX;
        this.yd = motionY;
        this.zd = motionZ;
    }

    @Override
    public void tick() {
        this.xo = this.x;
        this.yo = this.y;
        this.zo = this.z;
        if (this.age++ < this.lifetime && !(this.alpha <= 0.0F)) {
            this.xd += this.random.nextFloat() / 5000.0F * (float) (this.random.nextBoolean() ? 1 : -1);
            this.zd += this.random.nextFloat() / 5000.0F * (float) (this.random.nextBoolean() ? 1 : -1);
            this.yd -= this.gravity;
            this.move(this.xd, this.yd, this.zd);
            if (this.age >= this.lifetime - 60 && this.alpha > 0.01F) {
                this.alpha -= 0.015F;
            }
        } else {
            this.remove();
        }
    }

    @Override
    public float getQuadSize(float scaleFactor) {
        return this.quadSize * Mth.clamp(((float) this.age + scaleFactor) / (float) this.lifetime * 4.0F, 0.0F, 3.0F);
    }

    @Override
    public ParticleRenderType getRenderType() {
        return ParticleRenderType.PARTICLE_SHEET_TRANSLUCENT;
    }

    @OnlyIn(Dist.CLIENT)
    public static class SmokeFactory implements ParticleProvider<SimpleParticleType> {

        private final SpriteSet sprites;

        public SmokeFactory(SpriteSet sprites) {
            this.sprites = sprites;
        }

        public Particle createParticle(SimpleParticleType particleType, ClientLevel level, double x, double y, double z, double motionX, double motionY, double motionZ) {
            VolcanicSmokeParticle particle = new VolcanicSmokeParticle(level, x, y, z, motionX, motionY, motionZ);
            particle.pickSprite(this.sprites);
            particle.setAlpha(0.9F);
            return particle;
        }
    }

    @OnlyIn(Dist.CLIENT)
    public static class LargeSmokeFactory implements ParticleProvider<SimpleParticleType> {

        private final SpriteSet sprites;

        public LargeSmokeFactory(SpriteSet sprites) {
            this.sprites = sprites;
        }

        public Particle createParticle(SimpleParticleType particleType, ClientLevel level, double x, double y, double z, double motionX, double motionY, double motionZ) {
            VolcanicSmokeParticle particle = new VolcanicSmokeParticle(level, x, y, z, motionX, motionY, motionZ);
            particle.pickSprite(this.sprites);
            particle.setAlpha(0.9F);
            particle.scale(2.0F);
            return particle;
        }
    }
}