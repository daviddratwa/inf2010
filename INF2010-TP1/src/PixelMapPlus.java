import java.awt.PageAttributes.ColorType;

/**
 * Classe PixelMapPlus
 * Image de type noir et blanc, tons de gris ou couleurs
 * Peut lire et ecrire des fichiers PNM
 * Implemente les methodes de ImageOperations
 * @author : 
 * @date   : 
 */

public class PixelMapPlus extends PixelMap implements ImageOperations 
{
	/**
	 * Constructeur creant l'image a partir d'un fichier
	 * @param fileName : Nom du fichier image
	 */
	PixelMapPlus(String fileName)
	{
		super( fileName );
	}
	
	/**
	 * Constructeur copie
	 * @param type : type de l'image a creer (BW/Gray/Color)
	 * @param image : source
	 */
	PixelMapPlus(PixelMap image)
	{
		super(image); 
	}
	
	/**
	 * Constructeur copie (sert a changer de format)
	 * @param type : type de l'image a creer (BW/Gray/Color)
	 * @param image : source
	 */
	PixelMapPlus(ImageType type, PixelMap image)
	{
		super(type, image); 
	}
	
	/**
	 * Constructeur servant a allouer la memoire de l'image
	 * @param type : type d'image (BW/Gray/Color)
	 * @param h : hauteur (height) de l'image 
	 * @param w : largeur (width) de l'image
	 */
	PixelMapPlus(ImageType type, int h, int w)
	{
		super(type, h, w);
	}
	
	/**
	 * Genere le negatif d'une image
	 */
	public void negate()
	{
		for(int row=0; row<height; row++)
			
			for(int col=0; col<width; col++)
				
					imageData[row][col] = ( this.getPixel(row, col) ).Negative();
		
	}
	
	/**
	 * Convertit l'image vers une image en noir et blanc
	 */
	public void convertToBWImage()
	{
		for(int row=0; row<height; row++)
			
			for(int col=0; col<width; col++)
				
					imageData[row][col] = ( this.getPixel(row, col) ).toBWPixel();
		
	}
	
	/**
	 * Convertit l'image vers un format de tons de gris
	 */
	public void convertToGrayImage()
	{
		for(int row=0; row<height; row++)
			
			for(int col=0; col<width; col++)
				imageData[row][col] = ( this.getPixel(row, col) ).toGrayPixel();
		
	}
	
	/**
	 * Convertit l'image vers une image en couleurs
	 */
	public void convertToColorImage()
	{
		for(int row=0; row<height; row++)
			
			for(int col=0; col<width; col++)
				imageData[row][col] = ( this.getPixel(row, col) ).toColorPixel();
		
	}
	
	public void convertToTransparentImage()
	{
		for(int row=0; row<height; row++)
			
			for(int col=0; col<width; col++)
				imageData[row][col] = ( this.getPixel(row, col) ).toTransparentPixel();
		
	}
	
	
	/**
	 * Modifie la longueur et la largeur de l'image 
	 * @param w : nouvelle largeur
	 * @param h : nouvelle hauteur
	 */
	public void resize(int w, int h) throws IllegalArgumentException
	{
		
		AbstractPixel[][] tabTemp = new AbstractPixel[h][w]; 
		if ( w < width && h < height) { 
			int ratioH = height / h; 
			int ratioW = width / w; 
			
			int comptH = 0;
			 
			
			for (int i = 0; i < h; i++) { 
				int comptW = 0; 
				for(int j =0; j < w; j++ ) { 
					tabTemp[i][j] = imageData[comptH][comptW];
					comptW+=ratioW;
				}
				comptH+=ratioH;
			}
		}
		
		
		height = h;
		width = w; 
		imageData = tabTemp; 
		
	}
	
	/**
	 * Insert pm dans l'image a la position row0 col0
	 */
	public void insert(PixelMap pm, int row0, int col0)
	{
		for(int i=0; i<pm.height;i++)
		{
			for(int j=0; j<pm.width;j++)
			{
				if(((i+row0) < height) && ((j+col0) < width))
					
					imageData[i+row0][j+col0]=pm.getPixel(i,j);
			}
		}
		
	}
	
	/**
	 * Decoupe l'image 
	 */
	public void crop(int h, int w)
	{
		if(w < 0 || h < 0)
			throw new IllegalArgumentException();
		
		AbstractPixel[][]temp=new AbstractPixel[h][w];
		
		for(int i=0; i<h;i++)
		{
			for(int j=0; j<w;j++)
			{
				if(j<width && i<height)
					
					temp[i][j]=imageData[i][j];
				else 
					
					temp[i][j]=new BWPixel(true);
			}
		}
		
		height=h;
		width=w;
		imageData=temp;		
		
	}
	
	/**
	 * Effectue une translation de l'image 
	 */
	public void translate(int rowOffset, int colOffset)
	{
		AbstractPixel[][]temp=new AbstractPixel[height][width];	
		
	for(int i=0;i<height;i++)
	{
		for(int j=0;j<width;j++)
		{
			if((i+rowOffset>=0 && i<height) && (j+colOffset>=0 && j<width))
				
				temp[i+rowOffset][j+colOffset]=imageData[i][j];
		
			else
				
				temp[i][j]=new BWPixel(true);
		}
	}
	
	imageData=temp;
		
	}		
		
	}
	
