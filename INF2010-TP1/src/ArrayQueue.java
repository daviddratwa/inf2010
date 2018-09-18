

public class ArrayQueue<AnyType> implements Queue<AnyType>
{
	private int size = 0;		//Nombre d'elements dans la file.
	private int startindex = 0;	//Index du premier element de la file
	private AnyType[] table;
   
	@SuppressWarnings("unchecked")
	public ArrayQueue() 
	{
		//A completer
		 table = (AnyType[]) new Object[1]; 
		 
		
	}
	
	//Indique si la file est vide
	public boolean empty() 
	{ 
		return size == 0; 
	}
	
	//Retourne la taille de la file
	public int size() 
	{ 
		return size; 
	}
	
	//Retourne l'element en tete de file
	//Retourne null si la file est vide
	//complexité asymptotique: O(1)
	public AnyType peek()
	{
		//A completer
		if (size == 0) 
			return null; 
		else return table[size-1];
		
		
	}
	
	//Retire l'element en tete de file
	//complexité asymptotique: O(1)
	public void pop() throws EmptyQueueException
	{
		//A completer
		table[size]= null;
		size--; 
		
	}
	
	//Ajoute un element a la fin de la file
	//Double la taille de la file si necessaire (utiliser la fonction resize definie plus bas)
	//complexité asymptotique: O(1) ( O(N) lorsqu'un redimensionnement est necessaire )
	@SuppressWarnings("unchecked")
	public void push(AnyType item)
	{
		
		//A completer
		if (size == table.length) { 
			AnyType[] tabTemp = (AnyType[]) new Object[2*table.length];   
			for (int i = 0; i < size; i++) { 
				tabTemp[i] = table[i]; 
			}
			
			
			table = tabTemp; 
		}
		
		table[size] = item; 
		size++; 
	}
   
	//Redimensionne la file. La capacite est multipliee par un facteur de resizeFactor.
	//Replace les elements de la file au debut du tableau
	//complexité asymptotique: O(N)
	@SuppressWarnings("unchecked")
	private void resize(int resizeFactor)
	{
		//A completer
		
		AnyType[] tabTemp = (AnyType[]) new Object[table.length * resizeFactor];
		if (size < table.length * resizeFactor) { 
			for (int i = 0; i <= size; i++) { 
				tabTemp[i] = table[i]; 
			}
		}
		else { 
			for (int i = 0 ; i < tabTemp.length * resizeFactor ; i++) { 
				tabTemp[i] = table[i]; 
			}
		}
		
		size *= resizeFactor; 
		
		table = tabTemp; 
		
		
	}   
}

