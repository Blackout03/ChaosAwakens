package io.github.chaosawakens.client.gui.screen;

import com.mojang.blaze3d.matrix.MatrixStack;
import io.github.chaosawakens.ChaosAwakens;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.screen.MainMenuScreen;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.WorldSelectionScreen;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.util.IReorderingProcessor;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.List;

@OnlyIn(Dist.CLIENT)
public class AprilFoolsWarningScreen extends Screen {
	protected final Screen lastScreen;
	public final ITextComponent message1 = new StringTextComponent("Any worlds opened in this version of " + TextFormatting.GOLD + TextFormatting.BOLD + "Chaos Awakens" + TextFormatting.RESET + " should not be opened in other versions of " + TextFormatting.GOLD + TextFormatting.BOLD + "Chaos Awakens" + TextFormatting.RESET + "!");;
	public final ITextComponent message2 = new StringTextComponent("If this is not followed it may cause corruption to your worlds.");;
	public final ITextComponent message3 = new StringTextComponent("A lot of features in this version will not reappear.");;
	public final ITextComponent message4 = new StringTextComponent("We recommend you do not put this version of " + TextFormatting.GOLD + TextFormatting.BOLD + "Chaos Awakens" + TextFormatting.RESET + " in your modpacks.");;

	public AprilFoolsWarningScreen(Screen screen) {
		super(new TranslationTextComponent("gui." + ChaosAwakens.MODID + ".april_fools.title").withStyle(TextFormatting.DARK_RED, TextFormatting.BOLD));
		this.lastScreen = screen;
	}

	protected void init() {
		assert this.minecraft != null;
		this.addButton(new Button(this.width / 2 - 100, (this.height * 3 / 4), 200, 20, new StringTextComponent("Proceed"), (p_213056_1_) -> {
			this.minecraft.setScreen(new WorldSelectionScreen(this));
		}));
		this.addButton(new Button(this.width / 2 - 100, (this.height * 3 / 4) + 24, 200, 20, new StringTextComponent("Return to Title"), (p_213056_1_) -> {
			this.minecraft.setScreen(new MainMenuScreen());
		}));
	}

	public void render(MatrixStack matrixStack, int p_230430_2_, int p_230430_3_, float p_230430_4_) {
		FontRenderer fontRenderer = Minecraft.getInstance().font;

		this.renderBackground(matrixStack); // Render the background
		this.font.drawShadow(matrixStack, this.title, (float) (this.width / 2) - ((float) font.width(this.title) / 2), 30, -1); // Render the title

		// Calculate the height of the wrapped text for each message
		List<IReorderingProcessor> wrappedText1 = fontRenderer.split(message1, this.width - 50);
		int textHeight1 = wrappedText1.size() * this.font.lineHeight; // Add some padding between lines
		List<IReorderingProcessor> wrappedText2 = fontRenderer.split(message2, this.width - 50);
		int textHeight2 = wrappedText2.size() * this.font.lineHeight; // Add some padding between lines
		List<IReorderingProcessor> wrappedText3 = fontRenderer.split(message3, this.width - 50);
		int textHeight3 = wrappedText3.size() * this.font.lineHeight; // Add some padding between lines
		List<IReorderingProcessor> wrappedText4 = fontRenderer.split(message4, this.width - 50);

		// Calculate the y position to center the wrapped text vertically for each message
		int y1 = 70; // Start at y = 70
		int y2 = y1 + textHeight1 + this.font.lineHeight + 1; // Gap between message1 and message2
		int y3 = y2 + textHeight2 + this.font.lineHeight + 1; // Gap between message2 and message3
		int y4 = y3 + textHeight3 + this.font.lineHeight + 1; // Gap between message3 and message4

		for (IReorderingProcessor line : wrappedText1) {
			int x = (this.width - this.font.width(line)) / 2;
			this.font.drawShadow(matrixStack, line, x, y1, 0xFFFFFF);
			y1 += this.font.lineHeight + 1;
		}
		for (IReorderingProcessor line : wrappedText2) {
			int x = (this.width - this.font.width(line)) / 2;
			this.font.drawShadow(matrixStack, line, x, y2, 0xFFFFFF);
			y2 += this.font.lineHeight + 1;
		}
		for (IReorderingProcessor line : wrappedText3) {
			int x = (this.width - this.font.width(line)) / 2;
			this.font.drawShadow(matrixStack, line, x, y3, 0xFFFFFF);
			y3 += this.font.lineHeight + 1;
		}
		for (IReorderingProcessor line : wrappedText4) {
			int x = (this.width - this.font.width(line)) / 2;
			this.font.drawShadow(matrixStack, line, x, y4, 0xFFFFFF);
			y4 += this.font.lineHeight + 1;
		}

		super.render(matrixStack, p_230430_2_, p_230430_3_, p_230430_4_);
	}

	public boolean shouldCloseOnEsc() {
		return false;
	}
}
