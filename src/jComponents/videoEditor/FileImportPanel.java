package jComponents.videoEditor;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import interfaces.Themed;
import mainFrame.PictoralFin;
import objectBinders.Theme;
import utilities.BufferedImageUtil;
import utilities.ChainGBC;

public class FileImportPanel extends JPanel implements Themed {

	private static final long serialVersionUID = -8225882191341895849L;

	private JButton importPicture, importAudio, importVideo;
	private PictoralFin pictoralFin;
	
	public FileImportPanel(PictoralFin pictoralFin) {
		this.pictoralFin = pictoralFin;
		
		Font font = new Font(pictoralFin.getSettings().getTheme().getPrimaryFont(), Font.BOLD + Font.ITALIC, 15);
		
		importPicture = new JButton(" Import Pictures");
		importAudio   = new JButton(" Import Audio Files");
		importVideo   = new JButton(" Import Videos");
		
		importPicture.addActionListener(pictoralFin.getGlobalListenerToolKit().onAddPictureRequest);
		importAudio.addActionListener(pictoralFin.getGlobalListenerToolKit().onAddAudioRequest);
		importVideo.addActionListener(pictoralFin.getGlobalListenerToolKit().onAddVideoRequest);
		
		importPicture.setIcon(new ImageIcon(BufferedImageUtil.resizeBufferedImage(pictoralFin.getGlobalImageKit().pictureIcon, 25, 25, BufferedImage.SCALE_FAST)));
		importPicture.setFont(font);
		importAudio.setIcon(new ImageIcon(BufferedImageUtil.resizeBufferedImage(pictoralFin.getGlobalImageKit().audioIcon, 25, 25, BufferedImage.SCALE_FAST)));
		importAudio.setFont(font);
		importVideo.setIcon(new ImageIcon(BufferedImageUtil.resizeBufferedImage(pictoralFin.getGlobalImageKit().videoIcon, 25, 25, BufferedImage.SCALE_FAST)));
		importVideo.setFont(font);
		
		
		
		setLayout(new GridBagLayout());
		add(importPicture, new ChainGBC(0, 0).setFill(false).setWidthAndHeight(1, 1).setPadding(10));
		add(importAudio, new ChainGBC(1, 0).setFill(false).setWidthAndHeight(1, 1).setPadding(10));
		add(importVideo, new ChainGBC(2, 0).setFill(false).setWidthAndHeight(1, 1).setPadding(10));
		
		setBackground(pictoralFin.getSettings().getTheme().getPrimaryBaseColor());
	}
		
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		int height = importVideo.getHeight() + 10;
		
		g.setColor(pictoralFin.getSettings().getTheme().getSecondaryBaseColor());
		
		if(pictoralFin.getSettings().getTheme().isSharp())
			g.fillRect(0, (getHeight() - height) / 2, getWidth(), height);
		else
			g.fillRoundRect(0, (getHeight() - height) / 2, getWidth(), height, 40, 40);
	}
	
	public void applyTheme(Theme theme) {
		
	}	
}
