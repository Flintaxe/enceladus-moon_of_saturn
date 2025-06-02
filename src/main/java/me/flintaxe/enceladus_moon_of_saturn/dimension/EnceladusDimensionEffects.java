package me.flintaxe.enceladus_moon_of_saturn.dimension;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Camera;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.DimensionSpecialEffects;
import net.minecraft.world.phys.Vec3;
import net.minecraft.client.Minecraft;
import net.neoforged.neoforge.client.extensions.IDimensionSpecialEffectsExtension;
import org.joml.Matrix4f;

public class EnceladusDimensionEffects extends DimensionSpecialEffects implements IDimensionSpecialEffectsExtension {

    public EnceladusDimensionEffects() {
        super(
                Float.NaN, // Cloud height - no clouds in space
                false,     // Has skylight
                SkyType.NONE, // No normal sky
                false,     // Force bright lighting
                false      // Constant ambient light
        );
    }

    @Override
    public Vec3 getBrightnessDependentFogColor(Vec3 biomeFogColor, float dayTime) {
        // Very dark space fog with slight blue tint
        return new Vec3(0.02, 0.02, 0.05);
    }

    @Override
    public boolean isFoggyAt(int x, int z) {
        return false; // No atmospheric fog in space
    }

    @Override
    public boolean isSunriseOrSunset(float timeOfDay) {
        return false; // No sunrise/sunset in space
    }

    @Override
    public int getSunriseOrSunsetColor(float timeOfDay) {
        return 0; // No sunrise/sunset colors in space
    }

    @Override
    public boolean renderSky(ClientLevel level, int ticks, float partialTick, Matrix4f modelViewMatrix,
                             Camera camera, Matrix4f projectionMatrix, Runnable setupFog) {
        // Custom sky rendering
        PoseStack poseStack = new PoseStack();
        poseStack.last().pose().mul(modelViewMatrix);
        renderSpaceSky(poseStack, projectionMatrix, partialTick);
        return true; // We handle sky rendering
    }

    @Override
    public boolean renderClouds(ClientLevel level, int ticks, float partialTick, double camX, double camY, double camZ,
                                Matrix4f modelViewMatrix, Matrix4f projectionMatrix) {
        return true; // No clouds in space
    }

    private void renderSpaceSky(PoseStack poseStack, Matrix4f projectionMatrix, float partialTick) {
        Minecraft mc = Minecraft.getInstance();

        // Render star field
        renderStars(poseStack);

        // Render Saturn
        renderSaturn(poseStack, partialTick);

        // Render distant sun (very small and dim)
        renderDistantSun(poseStack, partialTick);

        // Optional: Render other moons or space phenomena
        renderSpaceObjects(poseStack, partialTick);
    }

    private void renderStars(PoseStack poseStack) {
        // Implementation for rendering a dense star field
        // You'll want to create a vertex buffer with many small star points
        // positioned in a sphere around the player

        // This is a simplified version - you'd want to use proper vertex buffers
        // and shaders for performance
    }

    private void renderSaturn(PoseStack poseStack, float partialTick) {
        // Saturn should appear large in the sky since Enceladus orbits it
        poseStack.pushPose();

        // Position Saturn in the sky - it should be tidally locked
        // so Saturn would appear to stay in roughly the same position
        float saturnX = 45.0f; // Azimuth angle
        float saturnY = 30.0f; // Elevation angle

        // Rotate to position Saturn
        poseStack.mulPose(com.mojang.math.Axis.YP.rotationDegrees(saturnX));
        poseStack.mulPose(com.mojang.math.Axis.XP.rotationDegrees(saturnY));

        // Saturn should appear quite large - about 2 degrees in diameter
        // (roughly 4x the size of our moon in Earth's sky)
        float saturnSize = 2.0f;

        // Render Saturn as a textured quad with its distinctive rings
        // You'll need Saturn and ring textures for this
        renderSaturnBody(poseStack, saturnSize);
        renderSaturnRings(poseStack, saturnSize);

        poseStack.popPose();
    }

    private void renderSaturnBody(PoseStack poseStack, float size) {
        // Render Saturn's main body
        // Use a texture with Saturn's distinctive bands
        // The planet should show phases depending on sun position
    }

    private void renderSaturnRings(PoseStack poseStack, float size) {
        // Render Saturn's ring system
        // Rings should be tilted at about 27 degrees to Saturn's equator
        // They should appear edge-on or at various angles depending on viewpoint
    }

    private void renderDistantSun(PoseStack poseStack, float partialTick) {
        // The Sun appears much smaller and dimmer from Saturn's distance
        // About 1/10th the size it appears from Earth
        poseStack.pushPose();

        // Position the sun opposite to where it would be in relation to Saturn
        // This affects the lighting and phases of Saturn

        poseStack.popPose();
    }

    private void renderSpaceObjects(PoseStack poseStack, float partialTick) {
        // Optional: Render other Saturnian moons
        // Titan might be visible as a bright orange dot
        // Other moons would be points of light

        // Could also add:
        // - Occasional meteor streaks
        // - Saturn's magnetosphere effects (aurora-like)
        // - Distant Jupiter (very faint)
    }

    public boolean tickRain(ClientLevel level, int ticks, Camera camera) {
        return false; // No weather in space
    }
}
