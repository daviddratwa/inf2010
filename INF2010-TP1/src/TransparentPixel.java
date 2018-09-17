/**
 * Classe de pixel transparent
 * @author :
 * @date : 
 */

public class TransparentPixel extends AbstractPixel
{
	public int[] rgba; // donnees de l'image
	
	/**
	 * Constructeur par defaut (pixel blanc)
	 */
	TransparentPixel()
	{
		rgba = new int[4];
		rgba[0] = 255;
		rgba[1] = 255;
		rgba[2] = 255;
		rgba[3] = 255;
	}
	
	/**
	 * Assigne une valeur au pixel
	 * @param rgb: valeurs a assigner 
	 */
	TransparentPixel(int[] rgba)
	{
		// compléter
		this.rgba = new int[4];
		
		this.rgba[0] = rgba[0]; 
		this.rgba[1] = rgba[1]; 
		this.rgba[2] = rgba[2]; 
		this.rgba[3] = rgba[3]; 
	}
	
	/**
	 * Renvoie un pixel copie de type noir et blanc
	 */
	public BWPixel toBWPixel()
	{
		// compléter
		
		int moyenne = (rgba[0] + rgba[1] + rgba[2]) /3; 
		
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
		int moyenne = (rgba[0] + rgba[1] + rgba[2]) / 3;
		return new GrayPixel(moyenne); 
		
		
	}
	
	/**
	 * Renvoie un pixel copie de type couleurs
	 */
	public ColorPixel toColorPixel()
	{
		// compléter
		
		int[] rgb = new int[3]; 
		for (int i = 0; i < 3; i++)
			rgb[i] = rgba[i];
		return new ColorPixel(rgb); 
		
	}
	
	/**
	 * Renvoie le negatif du pixel (255-pixel)
	 */
	public TransparentPixel Negative()
	{
		// compléter
		
		int[] rgba = new int[4];
		for (int i = 0; i < 3; i++)
			rgba[i] = 255 - this.rgba[i]; 
		rgba[3] = this.rgba[3];
		
		return new TransparentPixel(rgba); 
		
	}
	
	public TransparentPixel toTransparentPixel()
	{
		// compléter
		int[] rgba = new int[4]; 
		
		for (int i =0; i < 4; i++)
			rgba[i] = this.rgba[i]; 
		return new TransparentPixel(rgba); 
		
	}
	
	public void setAlpha(int alpha)
	{
		rgba[3] = alpha;
	}
	
	/**
	 * Convertit le pixel en String (sert a ecrire dans un fichier 
	 * (avec un espace supplémentaire en fin)s
	 */
	public String toString()
	{
		return  ((Integer)rgba[0]).toString() + " " + 
				((Integer)rgba[1]).toString() + " " +
				((Integer)rgba[2]).toString() + " " +
				((Integer)rgba[3]).toString() + " ";
	}
}