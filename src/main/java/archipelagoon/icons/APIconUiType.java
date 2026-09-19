package archipelagoon.icons;

import legend.core.gpu.Bpp;
import legend.core.renderer.QueuedModelStandard;
import legend.core.renderer.Texture;
import legend.game.types.RenderableMetrics14;
import legend.game.types.UiPart;
import legend.game.types.UiType;
import org.jetbrains.annotations.NotNull;

import java.nio.file.Path;

public final class APIconUiType {
  private static final float TEXTURE_WIDTH = 32.0f * 3;
  private static final float ICON_WIDTH = 32.0f;
  private static final float WIDTH_DIVIDER = ICON_WIDTH / TEXTURE_WIDTH;
  public static final UiType _ICONS = new UiType(new UiPart[] {
    new UiPart(new Metrics[] {addIcon(0)}, 1),
    new UiPart(new Metrics[] {addIcon(1)}, 1),
    new UiPart(new Metrics[] {addIcon(2)}, 1),
  });
  private static Texture TEXTURE;

  private APIconUiType() {
  }

  private static Metrics addIcon(final int index) {
    return new Metrics(index * WIDTH_DIVIDER, 0.0f, 0, 0, 16, 16, WIDTH_DIVIDER, 1.0f);
  }

  public static class Metrics extends RenderableMetrics14 {
    public Metrics(final float u, final float v, final int x, final int y, final int width, final int height, final float textureWidth, final float textureHeight) {
      super(u, v, x, y, 0, Bpp.BITS_24.ordinal() << 7, width, height, textureWidth, textureHeight);
    }

    @Override
    public void useTexture(@NotNull final QueuedModelStandard model) {
      if(TEXTURE == null) {
        TEXTURE = Texture.png("Iconsheet", Path.of("mods", "archipelagoon", "icons", "iconsheet.png"));
        TEXTURE.persistent = true;
      }

      model.texture(TEXTURE);
      model.useTextureAlpha();
    }
  }
}