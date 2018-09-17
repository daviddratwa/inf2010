/**
 * Classe de pixel en couleurs 
 * @author :
 * @date : 
 */

public class ColorPixel extends AbstractPixel
{
	public int[] rgb; // donnees de l'image
	
	/**
	 * Constructeur par defaut (pixel blanc)
	 */
	ColorPixel()
	{
		rgb = new int[3];
		rgb[0] = 255;
		rgb[1] = 255;
		rgb[2] = 255;
	}
	
	/**
	 * Assigne une valeur au pixel
	 * @param rgb: valeurs a assigner 
	 */
	ColorPixel(int[] rgb)
	{
		// compléter
		this.rgb = new int[3]; 
		this.rgb[0] = rgb[0]; 
		this.rgb[1] = rgb[1]; 
		this.rgb[2] = rgb[2];
	}
	
	/**
	 * Renvoie un pixel copie de type noir et blanc
	 */
	public BWPixel toBWPixel()
	{
		// compléter
		int moyenne = (rgb[0] + rgb[1] + rgb[2]) / 3; 
		
		if (moyenne <= 127)
			return new BWPixel(false); 
		else return new BWPixel(true); 
		
	}
	
	/**
	 * Renvoie un pixel copie de type tons de gris
	 */
	public GrayPixel toGrayPixel()
	{
		// compléter
		int moyenne = (rgb[0] + rgb[1] + rgb[2]) / 3; 
		return new GrayPixel(moyenne); 
		
	}
	
	/**
	 * Renvoie un pixel copie de type couleurs
	 */
	public ColorPixel toColorPixel()
	{
		// compléter
		return new ColorPixel(rgb); 
		
	}
	
	public TransparentPixel toTransparentPixel()
	{
		// compléter
		int[] rgba = new int[4]; 
		for (int i = 0; i < 3; i++)
			rgba[i] = rgb[i]; 
		rgba[3] = 255;
		
		return new TransparentPixel(rgba); 
			
	}
	
	/**
	 * Renvoie le negatif du pixel (255-pixel)
	 */
	public AbstractPixel Negative()
	{
		// compléter
		int[] rgbNegative = new int[3]; 
		
		rgbNegative[0] = 255 - rgb[0]; 
		rgbNegative[1] = 255 - rgb[1]; 
		rgbNegative[2] = 255 - rgb[2]; 
		
		return new ColorPixel(rgbNegative); 
	}
	
	public void setAlpha(int alpha)
	{
		//ne fait rien
	}
	
	/**
	 * Convertit le pixel en String (sert a ecrire dans un fichier 
	 * (avec un espace supplémentaire en fin)s
	 */
	public String toString()
	{
		return  ((Integer)rgb[0]).toString() + " " + 
				((Integer)rgb[1]).toString() + " " +
				((Integer)rgb[2]).toString() + " ";
	}
}