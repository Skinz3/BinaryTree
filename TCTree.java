
public class TCTree extends TableCorrespondance
{
	private Node Node;
	
	@Override
	public void associe(String key, String value) 
	{
		if (Node == null)
		{
			Node = new Node(key,value);
		}
		else
		{
		    associe(key,value,Node);
		}
	}
    private void associe(String key,String value,Node current)
    {
    
    	if (current.Key.compareTo(key) < 0)
		{
			if (current.Left != null) 
			{
			   associe(key,value,current.Left);	
			}
			else
			{
				current.Left = new Node(key,value);
			}
		}
    	else
    	{
    		if (current.Right != null)
    		{
    			associe(key,value,current.Right);
    		}
    		else
    		{
    			current.Right = new Node(key,value);
    		}
    	}
    }
    /// https://fr.wikipedia.org/wiki/Arbre_binaire_de_recherche
	@Override
	public void supprimer(String key)
	{	
		
		
		
		Node toSupress = get(key,Node);
		
		if (toSupress == null)
		{
			return;
		}
		if (toSupress.IsLeaf()) // premier cas, le noeud est une feuille. On le supprime simplement, sans rien décaller.
		{
			SupressSingle(toSupress,Node);
		}
		else if (toSupress.GotSingleChild()) // deuxième cas, le noeud n'a qu'un enfant
		{
			Node target = toSupress.GetSingleChild(); // pn récupère le fils unique de toSupress.
			
			Node previous = getPrevious(key,Node,null);  // on récupère le noeud avant toSupress.
			
			if (previous.Right == toSupress)
			{
				previous.Right = target;
			}
			else
				previous.Left = target;
			 
		}
		else // troisième cas, le noeud a deux fils
		{
			Node = SupressThirdCase(Node,key);
		} 
	}
	private Node SupressThirdCase(Node current,String key)
	{
		
        if (current == null)  return current; 
  
        
        if (key.compareTo(current.Key) < 0) 
        	current.Left = SupressThirdCase(current.Left, key); 
        else if (key.compareTo(current.Key) >  0) 
        	current.Right = SupressThirdCase(current.Right, key); 
  
        else
        { 
        	
        	if (current.GotSingleChild() || current.IsLeaf())
        	{0        		return current.GetSingleChild();
        	}
           
        	 String last = current.Right.Key; 
             while (current.Right.Left != null) 
             { 
            	 last = current.Right.Left.Key; 
                 current.Right = current.Right.Left; 
             } 
             
        	current.Key = last;
  
          
        	current.Right = SupressThirdCase(current.Right, current.Key); 
        } 
  
        return current; 
	}
	
	private void SupressSingle(Node node,Node current)
	{
		if (current.Key.compareTo(node.Key) < 0)
		{
			if (current.Left == node)
			{
				current.Left = null;
				return;
			}
			else
			{
				SupressSingle(node,current.Left);	
			}
		
		}
    	else
    	{
    		if (current.Right == node)
			{
				current.Right = null;
				return;
			}
			else
			{
				SupressSingle(node,current.Right);	
			}
    	}
	}
	@Override
	public String get(String key) 
	{
        Node node = get(key,Node);
        
	    if (node == null) 
	    {
	    	 return null;
	    }
	    else
	    {
	    	return node.Value;
	    }
	}
	private Node get(String key,Node current)
	{
		if (key.compareTo(current.Key) == 0)
		{
			return current;
		}
		if (current.Key.compareTo(key) < 0)
		{
			 
			if (current.Left != null)
			{
				return get(key,current.Left);
			}
			else
			{
				return null;
			}
		}
		else
		{
	
			if (current.Right != null)
			{
				return get(key,current.Right);
			}
			else
			{
				return null;
			}
		}
	}
	private Node getPrevious(String key,Node current,Node previous)
	{
		if (key.compareTo(current.Key) == 0)
		{
			return previous;
		}
		if (current.Key.compareTo(key) < 0)
		{
			 
			if (current.Left != null)
			{
				return getPrevious(key,current.Left,current);
			}
			else
			{
				return null;
			}
		}
		else
		{
	
			if (current.Right != null)
			{
				return getPrevious(key,current.Right,current);
			}
			else
			{
				return null;
			}
		}
	}
	@Override
	public String toString()
	{
		return Node.toString();
	}
	

}
